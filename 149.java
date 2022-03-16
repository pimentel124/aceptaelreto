import java.util.Scanner;

public class Comp {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            int c = s.nextInt();
            int max = 0;
            int aux;
            for (int i = 0; i < c; i++) {
                aux = s.nextInt();
                if (max < aux) {
                    max = aux;
                }
            }
            System.out.println(max);
        }

    }
}
