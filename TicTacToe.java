import java.util.Scanner;
import java.util.Random;

public class TicTacToe implements Game {
    private static final int MAX_MOVES = 9; // Punkt 6

    public int play() {
        char[] b = "123456789".toCharArray();
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Punkt 4: Spiel geht bis zu 9 Züge
        for (int i = 0; i < MAX_MOVES; i++) {
            System.out.println(b[0]+"|"+b[1]+"|"+b[2]+"\n"+b[3]+"|"+b[4]+"|"+b[5]+"\n"+b[6]+"|"+b[7]+"|"+b[8]);

            // Zug Spieler (X)
            if (i % 2 == 0) {
                System.out.print("Feld (1-9): ");
                if (!sc.hasNextInt()) { sc.next(); i--; continue; }
                int pos = sc.nextInt() - 1;

                if (pos < 0 || pos > 8 || b[pos] > '9') {
                    System.out.println("Ungültig!");
                    i--; continue;
                }
                b[pos] = 'X';
            }
            // Zug Bot (O) - Punkt 4: Bot setzt nicht immer erstes Feld
            else {
                int pos;
                do { pos = rand.nextInt(9); } while (b[pos] > '9');
                b[pos] = 'O';
            }

            // Punkt 4: Alle 8 Gewinnkombinationen prüfen
            if (checkWin(b, 'X')) return 1;
            if (checkWin(b, 'O')) return 0;
        }
        return 0;
    }

    private boolean checkWin(char[] b, char p) {
        return (b[0]==p && b[1]==p && b[2]==p) || (b[3]==p && b[4]==p && b[5]==p) || (b[6]==p && b[7]==p && b[8]==p) ||
                (b[0]==p && b[3]==p && b[6]==p) || (b[1]==p && b[4]==p && b[7]==p) || (b[2]==p && b[5]==p && b[8]==p) ||
                (b[0]==p && b[4]==p && b[8]==p) || (b[2]==p && b[4]==p && b[6]==p);
    }
}