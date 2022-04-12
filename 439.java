package comp;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Comp {

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
            String aux = s.readLine();

            String[] str = aux.split(" ");

            String[] op1 = str[0].split("=");
            String[] op2 = str[1].split("=");

            if (op1[0].equals("D")) {
                if (op2[0].equals("T")) {
                    System.out.println("V=" + (Integer.parseInt(op1[1]) / Integer.parseInt(op2[1])));
                } else {
                    System.out.println("T=" + (Integer.parseInt(op1[1]) / Integer.parseInt(op2[1])));
                }
            }
            if (op1[0].equals("T")) {
                if (op2[0].equals("D")) {
                    System.out.println("V=" + (Integer.parseInt(op2[1]) / Integer.parseInt(op1[1])));

                } else {
                    System.out.println("D=" + (Integer.parseInt(op2[1]) * Integer.parseInt(op1[1])));
                }
            }
            if (op1[0].equals("V")) {
                if (op2[0].equals("T")) {
                    System.out.println("D=" + (Integer.parseInt(op2[1]) * Integer.parseInt(op1[1])));
                } else {
                    System.out.println("T=" + (Integer.parseInt(op2[1]) / Integer.parseInt(op1[1])));
                }
            }
        }
    }
}
