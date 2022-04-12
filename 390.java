package comp;

import java.util.Scanner;

public class Comp {


    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {

            int magenta = s.nextInt();
            int amarillo = s.nextInt();
            int cyan = s.nextInt();
            //magenta (M), amarillo (A), cian (C), rojo (R), negro (N), verde (V), violeta (L) y blanco (B)
            char[] colores = s.next().toCharArray();

            for (int j = 0; j < colores.length; j++) {
                switch (colores[j]) {
                    case 'M':
                        magenta--;
                        break;
                    case 'A':
                        amarillo--;
                        break;
                    case 'C':
                        cyan--;
                        break;
                    case 'R':
                        magenta--;
                        amarillo--;
                        break;
                    case 'N':
                        magenta--;
                        cyan--;
                        amarillo--;
                        break;
                    case 'V':
                        cyan--;
                        amarillo--;
                        break;
                    case 'L':
                        cyan--;
                        magenta--;
                        break;

                }

                if (cyan < 0 || amarillo < 0 || magenta < 0) {
                    break;
                }

            }
            if (cyan < 0 || amarillo < 0 || magenta < 0) {
                System.out.println("NO");
            } else {
                System.out.println("SI " + magenta + " " + amarillo + " " + cyan);
            }

        }

    }
}
