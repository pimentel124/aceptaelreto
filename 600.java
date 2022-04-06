import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		int c = sc.nextInt();
		while (f != 0 || c != 0) {
			int[][] m = new int[f][c];
			Set<Integer>[] colsMax = new HashSet[f];
			Set<Integer>[] colsMin = new HashSet[f];
			for (int i = 0; i < f; ++i) {
				for (int j = 0; j < c; ++j) {
					m[i][j] = sc.nextInt();
				}
				colsMax[i] = posMaximos(m[i]);
				colsMin[i] = posMinimos(m[i]);
			}
			boolean puntoSilla = false;
			for (int j = 0; j < c && !puntoSilla; ++j) {
				int[] col = columna(m, j);
				for (int filaMin : posMinimos(col)) {
					if (colsMax[filaMin].contains(j)) {
						puntoSilla = true;
						break;
					}
				}
				for (int filaMax : posMaximos(col)) {
					if (colsMin[filaMax].contains(j)) {
						puntoSilla = true;
						break;
					}
				}
			}
			if (puntoSilla) System.out.println("SI");
			else System.out.println("NO");
			f = sc.nextInt();
			c = sc.nextInt();
		}
		sc.close();
	}

	private static Set<Integer> posMaximos(int[] v) {
		Set<Integer> posMaximos = new HashSet<>();
		posMaximos.add(0);
		int maximo = v[0];
		for (int i = 1; i < v.length; ++i) {
			if (v[i] == maximo) posMaximos.add(i);
			else if (v[i] > maximo) {
				maximo = v[i];
				posMaximos.clear();
				posMaximos.add(i);
			}
		}
		return posMaximos;
	}

	private static Set<Integer> posMinimos(int[] v) {
		Set<Integer> posMinimos = new HashSet<>();
		posMinimos.add(0);
		int minimo = v[0];
		for (int i = 1; i < v.length; ++i) {
			if (v[i] == minimo) posMinimos.add(i);
			else if (v[i] < minimo) {
				minimo = v[i];
				posMinimos.clear();
				posMinimos.add(i);
			}
		}
		return posMinimos;
	}

	private static int[] columna(int[][] m, int j) {
		int[] col = new int[m.length];
		for (int i = 0; i < m.length; ++i) {
			col[i] = m[i][j];
		}
		return col;
	}

}