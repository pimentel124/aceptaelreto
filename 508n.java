import java.util.Scanner;

public class Comp {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int aux = s.nextInt();
        int x;
        int y;

        while (aux != 0) {
            int miny = 1000, maxx = 0, arboles = 0, maxarb = 0;

            int[][] arb = new int[aux][2];

            for (int i = aux; --i >= 0;) {

                x = s.nextInt();
                y = s.nextInt();
                arb[i][0] = x;
                arb[i][1] = y;

                if (x > maxx) {
                    maxx = x;
                }
                if (y < miny) {
                    miny = y;
                }

            }

            for (int L = miny; L < maxx-miny; L++) {
                for (int j = aux; --j >= 0;) {

                    if (arb[j][0] <= (L + arb[j][1])) {
                        if (arb[j][0] >= (L - arb[j][1])) {
                            arboles++;
                        }                   
                    }

                    if (arboles > maxarb) {
                        maxarb = arboles;
                    }
                }
                arboles = 0;
            }
            System.out.println(maxarb);
            aux = s.nextInt();
            }
            
        }

    }


