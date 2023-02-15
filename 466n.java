
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.Math.min;


public class Main {

    static class Reader {

        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) {
                return;
            }
            din.close();
        }
    }


    public static void main(String[] args) throws IOException {

        Reader s = new Reader();
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            String input = s.readLine();

            String[] temp = input.split(" ");

            int len = max(temp[0].length(), temp[1].length());

            int[] numbers1 = getNumbers(temp[0], len);
            int[] numbers2 = getNumbers(temp[1], len);

            int[] result = new int[len];


            for (int j = len - 1; j >= 0; j--) {

                result[j] += numbers1[j] * numbers2[j];

                if (result[j] > 9) {
                    int[] aux = getNumbers(Integer.toString(result[j]), 2);
                    result[j] = aux[1];
                    result[j - 1] += aux[0];
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int k : result) {
                sb.append(k);
            }
            System.out.println(sb);
        }

    }

    private static int[] getNumbers(String input, int len) {
        int[] numbers = new int[len];
        int fill = len - input.length();

        for (int i = fill; i < len; i++) {
            numbers[i] = input.charAt(i - fill) - '0';
        }
        return numbers;
    }
}
