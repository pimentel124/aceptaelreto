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





    public static void main(String[] args) throws IOException{
        
        Reader s = new Reader();
        
        int x = s.nextInt();
        int y = s.nextInt();
        
        //while x and y are different from 0
        while(x != 0 && y != 0){

            int[][] matriz = new int[x][y];
            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    matriz[i][j] = s.nextInt();
                }
            }

            /*
            Los puntos de silla de una matriz son aquellos elementos de la matriz que cumplen que son menores o iguales que el resto de elementos de su fila y mayores o iguales que el resto de elementos de su columna, o al revés, mayores o iguales que el resto de elementos de su fila y menores o iguales que el resto de elementos de su columna.
            */
            //mirar si hay puntos de silla en la matriz
            boolean flag = false;
            for(int i = 1; i < x-1; i++){
                for(int j = 1; j < y-1; j++){
                    
                    //get the lowest value of the row
                    int indx = 0;
                    int min = matriz[i][j];
                    for(int k = 1; k < y; k++){
                        if(matriz[i][k] < min){
                            min = matriz[i][k];
                            indx = k;
                        
                        }
                    }
                    //check if matiz[i][indx] is higher or equal to the rest of the column
                    for(int k = 0; k < x; k++){
                        if(matriz[i][indx] > matriz[k][indx]){
                            flag = true;
                            break;
                        }
                    }

                    //get the highest value of the row
                    indx = 0;
                    int max = matriz[i][j];
                    for(int k = 1; k < y; k++){
                        if(matriz[i][k] > max){
                            max = matriz[i][k];
                            indx = k;
                        
                        }
                    }
                    //check if matiz[i][indx] is lower or equal to the rest of the column
                    for(int k = 0; k < x; k++){
                        if(matriz[i][indx] < matriz[k][indx]){
                            flag = true;
                            break;
                        }
                    }

                    //get the lowest value of the column
                    indx = 0;
                    min = matriz[i][j];
                    for(int k = 1; k < x; k++){
                        if(matriz[k][j] < min){
                            min = matriz[k][j];
                            indx = k;
                        
                        }
                    }
                    //check if matiz[indx][j] is higher or equal to the rest of the row
                    for(int k = 0; k < y; k++){
                        if(matriz[indx][j] > matriz[indx][k]){
                            flag = true;
                            break;
                        }
                    }

                    //get the highest value of the column
                    indx = 0;
                    max = matriz[i][j];
                    for(int k = 1; k < x; k++){
                        if(matriz[k][j] > max){
                            max = matriz[k][j];
                            indx = k;
                        
                        }
                    }
                    //check if matiz[indx][j] is lower or equal to the rest of the row
                    for(int k = 0; k < y; k++){
                        if(matriz[indx][j] < matriz[indx][k]){
                            flag = true;
                            break;
                        }
                    }
                    
                }
                if (flag){
                    break;
                }
            }

            if(flag){
                System.out.println("SI");
            }
            else{
                System.out.println("NO");
            }

            x = s.nextInt();
            y = s.nextInt();
        }
        
        
    }
}


