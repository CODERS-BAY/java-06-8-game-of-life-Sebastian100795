import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[][] feld = new int[15][30];


        System.out.println("Wieviel Generationen sollen es sein?");
        int generations = scanner.nextInt();

        arrayBefuellen(random, feld);

        int[][] ergebnisfeld = new int[15][30];

        for (int k = 0; k < generations; k++) {

            arrayKopieren(feld, ergebnisfeld);

            zellenPruefen(feld, ergebnisfeld);

            arrayKopieren(ergebnisfeld, feld);

            feldAusgabe(feld);
        }

    }


    public static void feldAusgabe(int[][] feld) {

        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.print(feld[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void zellenPruefen(int[][] feld, int[][] ergebnisfeld) {
        for (int i = 0; i < feld.length; i++) {

            for (int j = 0; j < 30; j++) {

                if (feld[i][j] == 0 || feld[i][j] == 1) {
                    int nachbar = getNachbar(feld, i, j);
                    if (feld[i][j] == 0 && nachbar == 3) {
                        ergebnisfeld[i][j] = 1;
                    }
                    if (feld[i][j] == 1 && (nachbar <= 1 || nachbar > 4)) {
                        ergebnisfeld[i][j] = 0;
                    }


                }
            }
        }

    }

    private static int getNachbar(int[][] feld, int i, int j) {
        int nachbar = 0;
        if (feld[(i - 1 + 15) % 15][(j - 1 + 30) % 30] == 1) {
            nachbar = nachbar + 1;
        }
        if (feld[(i - 1 + 15) % 15][j] == 1) {
            nachbar = nachbar + 1;
        }
        if (feld[(i - 1 + 15) % 15][(j + 1) % 30] == 1) {
            nachbar = nachbar + 1;
        }
        if (feld[i][(j - 1 + 30) % 30] == 1) {
            nachbar = nachbar + 1;
        }
        if (feld[i][(j + 1) % 30] == 1) {
            nachbar = nachbar + 1;
        }
        if (feld[(i + 1) % 15][(j - 1 + 30) % 30] == 1) {
            nachbar = nachbar + 1;
        }
        if (feld[(i + 1) % 15][j] == 1) {
            nachbar = nachbar + 1;
        }
        if (feld[(i + 1) % 15][(j + 1) % 30] == 1) {
            nachbar = nachbar + 1;
        }
        return nachbar;
    }

    public static void arrayKopieren(int[][] source, int[][] destination) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < 30; j++) {
                destination[i][j] = source[i][j];
            }
        }
    }

    public static void arrayBefuellen(Random random, int[][] feld) {
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < 30; j++) {
                feld[i][j] = random.nextInt(2);
            }
        }
    }
}

