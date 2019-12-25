import java.util.Random;
import java.util.Scanner;

public class Matrica {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite dimenziju kvadratne matrice (n): ");
		int n = sc.nextInt();

		int[][] matrica = new int[n][n];
		generisiElementeMatrice(matrica, 100);
		System.out.println("Matrica izgleda ovako: ");
		ispisiMatricu(matrica);
		System.out.println();

		int[] elementiNaglavnoj = elementiNaGlavnojDijagonali(matrica);
		System.out.println("Elementi na glavnoj dijagonali su: ");
		if (elementiNaglavnoj != null)
			ispisiNiz(elementiNaglavnoj);
		else
			System.out.println("Greska u funkciji elementiNaGlavnojDijagonali");
		System.out.println();

		System.out.println("Elementi na sporednoj dijagonali su: ");
		int[] elementiNaSporednoj = elementiNaSporednojDijagonali(matrica);
		if (elementiNaSporednoj != null)
			ispisiNiz(elementiNaSporednoj);
		else
			System.out.println("Greska u funkciji elementiNaSporednojDijagonali");
		System.out.println();

		System.out.println("Elementi iznad glavne dijagonale su: ");
		ispisiElementeIznadGlavneDijagonale(matrica);
		System.out.println();

		System.out.println("Elementi ispod glavne dijagonale su: ");
		ispisiElementeIspodGlavneDijagonale(matrica);
		System.out.println();

		int[][] transponovanaMatrica = transponujMatricu(matrica);
		System.out.println("Transponovana matrica izgleda ovako: ");
		if (transponovanaMatrica != null)
			ispisiMatricu(transponovanaMatrica);
		else
			System.out.println("Greska u funkciji transponujMatricu.");
		System.out.println();

		System.out.println("Pre uklanjanja duplih elemenata niz izgleda ovako: ");
		ispisiNiz(elementiNaglavnoj);
		System.out.println();

		elementiNaglavnoj = ukloniElementeKojiSePonavljajuUnizu(elementiNaglavnoj);
		System.out.println("Nakon uklanjanja duplih elemenata niz izlgeda ovako: ");
		if (elementiNaglavnoj != null)
			ispisiNiz(elementiNaglavnoj);
		else
			System.out.println("Greska u funkcji ukloniElementeKojiSePonavljajuUnizu");

	}

	public static void generisiElementeMatrice(int[][] matrica, int gornjaGranica) {
		// TODO
		Random r = new Random();
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				matrica[i][j] = r.nextInt(gornjaGranica);
			}
		}
	}

	public static int[] elementiNaGlavnojDijagonali(int[][] matrica) {
		// TODO
		int[] elementiNaGlavnojDijagonali = new int[matrica.length];
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica.length; j++) {
				if (i == j) {
					elementiNaGlavnojDijagonali[i] = matrica[i][j];
				}
			}
		}
		return elementiNaGlavnojDijagonali;
	}

	public static int[] elementiNaSporednojDijagonali(int[][] matrica) {
		int[] elementiNaSporednojDijagonali = new int[matrica.length];
		for (int i = matrica.length - 1, j = 0; i >= 0; i--, j++) {
			elementiNaSporednojDijagonali[j] = matrica[i][j];
		}
		return elementiNaSporednojDijagonali;
	}

	public static int[][] transponujMatricu(int[][] matrica) {
		int[][] transponovanaMatrica = new int[matrica[0].length][matrica.length];
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				transponovanaMatrica[j][i] = matrica[i][j];
			}
		}
		return transponovanaMatrica;
	}

	public static void ispisiElementeIznadGlavneDijagonale(int[][] matrica) {
		int n = matrica[0].length - 1;
		;
		for (int i = 0; i < matrica.length; i++) {
			for (int k = 0; k < matrica[i].length - n; k++) {
				System.out.print("   ");
			}
			for (int j = i + 1; j < matrica[i].length; j++) {
				if (matrica[i][j] < 10) {
					System.out.print("0" + matrica[i][j] + " ");
				} else
					System.out.print(matrica[i][j] + " ");
			}
			n--;
			System.out.println();
		}
	}

	public static void ispisiElementeIspodGlavneDijagonale(int[][] matrica) {
		int n = matrica[0].length;
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica.length - n; j++) {
				if (matrica[i][j] < 10) {
					System.out.print("0" + matrica[i][j] + " ");
				} else
					System.out.print(matrica[i][j] + " ");
			}
			n--;
			System.out.println();
		}
	}

	public static void ispisiMatricu(int[][] matrica) {
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				if (matrica[i][j] < 10) {
					System.out.print("0" + matrica[i][j] + " ");
					continue;
				}
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void ispisiNiz(int[] niz) {
		for (int i = 0; i < niz.length; i++) {
			System.out.print(niz[i] + " ");
		}
	}

	public static int[] ukloniElementeKojiSePonavljajuUnizu(int[] niz) {
		int brojacUnikata = 0;
		int[] nizBezElemenataKojiSePonavljaju = new int[niz.length];
		for (int i = 0; i < nizBezElemenataKojiSePonavljaju.length; i++) {
			nizBezElemenataKojiSePonavljaju[i] = -1;
		}
		for (int i = 0; i < niz.length; i++) {
			boolean nijePonovljen = true;
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[i] == niz[j]) {
					nijePonovljen = false;
				}
			}
			if (nijePonovljen) {
				nizBezElemenataKojiSePonavljaju[i] = niz[i];
				brojacUnikata++;
			}
		}
		int[] nizJedinstvenihElemenata = new int[brojacUnikata];
		for (int i = 0, j = 0; i < nizJedinstvenihElemenata.length; i++) {
			if (nizBezElemenataKojiSePonavljaju[i] != -1) {
				nizJedinstvenihElemenata[j] = nizBezElemenataKojiSePonavljaju[i];
				j++;
			}
		}
		return nizJedinstvenihElemenata;
	}

}
