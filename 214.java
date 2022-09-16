package comp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Comp {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int reyes = s.nextInt();
        while (reyes != 0) {

            Map<String, Integer> mapa = new HashMap<>();
            String nombre;
            int aux;

            for (int i = 0; i < reyes; i++) {
                nombre = s.next();
                if (mapa.containsKey(nombre)) {
                    aux = mapa.get(nombre) + 1;
                    mapa.put(nombre, aux);
                } else {
                    mapa.put(nombre, 1);
                }
            }

            reyes = s.nextInt();
            for (int i = 0; i < reyes; i++) {
                nombre = s.next();
                if (mapa.containsKey(nombre)) {
                    aux = mapa.get(nombre) + 1;
                    System.out.println(aux);
                    mapa.put(nombre, aux);
                } else {
                    mapa.put(nombre, 1);
                    System.out.println(1);
                }

            }
            System.out.println("");
            reyes = s.nextInt();
        }
    }

}
