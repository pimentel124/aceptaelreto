/*
Entrada
La entrada estará compuesta por distintos casos de prueba.

Cada caso comienza con una línea indicando el número N de estados del país (1 ≤ N ≤ 100). A continuación vendrán N líneas describiendo cada estado con cuatro números: número de delegados que aporta (al menos uno), cantidad de gente que sabemos que votará a Donald, cantidad de gente que votará al otro aspirante y, por último, número de indecisos.

El número total de delegados que van a la convención nacional no supera los 5.000, y el número de votantes por estado nunca será mayor de diez millones.

Salida
Por cada caso de prueba se escribirá una única línea indicando a cuántos indecisos debe convencer como mínimo Donald para asegurarse ser el candidato a la presidencia. Si los datos reflejan que no podrá ser el candidato por mucho que invierta, se escribirá IMPOSIBLE.

Entrada de ejemplo

3
8 1000 500 0
8 500 1000 0
1 100 100 25
1
8 500 1000 500
1
8 0 0 100

Salida de ejemplo
13
IMPOSIBLE
51
*/

package comp;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

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

        while(true){
            int totaldelegados = s.nextInt();
            int totalvotosDonald = s.nextInt();
            int totalvotosOther = s.nextInt();
            int totalindecisos = s.nextInt();
            if(n>1){
                
            
            

        }

            if((totalvotosDonald + totalindecisos) <= totalvotosOther){
                System.out.println("IMPOSIBLE");
            }else{







            }



            n  = s.nextInt();
        }

    }
}
