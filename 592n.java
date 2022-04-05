package comp;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Comp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int presupuesto, personas, maximo, resultado;
        while (true) {
            presupuesto = sc.nextInt();
            personas = sc.nextInt();
            int sueldos[] = new int[personas];
            maximo = 0;
            for (int indicePersonas = 0, aux; indicePersonas < personas; indicePersonas++) {
                aux = sc.nextInt();
                sueldos[indicePersonas] = aux;
                maximo = Math.max(maximo, aux);
            }
            resultado = ((calcularGasto(sueldos, maximo, personas) <= presupuesto) ? maximo
                    : umbralMaximo(sueldos, 0, maximo, presupuesto, personas));
            System.out.println(resultado);
        }
    }

    public static long calcularGasto(int sueldos[], int umbral, int personas) {
        long acumulador = 0;
        for (int indice = 0; indice < personas; indice++) {
            acumulador += Math.min(umbral, sueldos[indice]);
        }
        return acumulador;
    }

    public static int umbralMaximo(int sueldos[], int minimo, int maximo, int presupuesto, int personas) {
        if (maximo - minimo > 1) {
            int puntoMedio = (maximo + minimo) / 2;

            long gastoMedio = calcularGasto(sueldos, puntoMedio, personas);
            if (gastoMedio >= presupuesto) {
                return umbralMaximo(sueldos, minimo, puntoMedio, presupuesto, personas);
            } else {
                return umbralMaximo(sueldos, puntoMedio, maximo, presupuesto, personas);
            }
        } else {
            long gastoMaximo = calcularGasto(sueldos, maximo, personas);
            if (gastoMaximo > presupuesto) {
                return minimo;
            } else {
                return maximo;
            }
        }

    }
}
