import java.io.*;
import java.util.*;
import java.time.LocalDateTime;

public class GameCenter { // Klassennamen groß
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name eingeben: ");
        String name = sc.next();

        while (true) {
            System.out.println("\nAUSWAHL");
            System.out.println("1: ZahlErraten | 2: Hangman | 3: TicTacToe | 4: Score | 5: Beenden");

            // Punkt 3: Eingabe validieren
            while (!sc.hasNextInt()) {
                System.out.println("Bitte eine Zahl eingeben!");
                sc.next();
            }
            int wahl = sc.nextInt();

            if (wahl == 5) {
                System.out.println("Programm beendet.");
                break;
            }

            if (wahl == 4) {
                showScores();
                continue;
            }

            int win = 0;
            String gName = "";
            Game game = null; // Punkt 7: Interface nutzen

            if (wahl == 1) {
                game = new NumberGuessing();
                gName = "ZahlErraten";
            }
            else if (wahl == 2) {
                game = new Hangman();
                gName = "Hangman";
            }
            else if (wahl == 3) {
                game = new TicTacToe();
                gName = "TicTacToe";
            }
            else { continue; }

            if (game != null) {
                win = game.play();
            }

            String timestamp = LocalDateTime.now().toString().substring(0, 16);
            String result = (win == 1) ? "Sieg" : "Niederlage";

            FileWriter fw = new FileWriter("scores.txt", true);
            fw.write(name + "," + gName + "," + result + "," + timestamp + "\n");
            fw.close();

            System.out.println("Ergebnis: " + result);
        }
    }

    private static void showScores() throws Exception {
        File f = new File("scores.txt");
        if (!f.exists()) {
            System.out.println("Keine Daten vorhanden.");
            return;
        }

        System.out.println("\nRANGLLISTE (Protokoll)");
        Scanner fs = new Scanner(f);

        while (fs.hasNextLine()) {
            String[] p = fs.nextLine().split(",");
            System.out.printf("%-10s | %-12s | %-10s | %s\n", p[0], p[1], p[2], p[3]);
        }
        fs.close();
    }
}