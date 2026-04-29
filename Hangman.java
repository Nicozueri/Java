import java.util.Scanner;
import java.util.Random;

public class Hangman implements Game {
    // Punkt 5 & 6: Wortliste und Konstanten
    private static final String[] WORDS = {"JAVA", "PYTHON", "COMPUTER", "INFORMATIK"};
    private static final int START_LIVES = 3;

    public int play() {
        String word = WORDS[new Random().nextInt(WORDS.length)];
        char[] hidden = new char[word.length()];
        for(int i=0; i<hidden.length; i++) hidden[i] = '_';

        int lives = START_LIVES;
        Scanner sc = new Scanner(System.in);

        while (lives > 0) {
            System.out.println(String.valueOf(hidden) + " (Leben: " + lives + ")");

            if (String.valueOf(hidden).equals(word)) return 1;

            System.out.print("Buchstabe: ");
            String input = sc.next().toUpperCase();

            // Punkt 5: Prüfen, ob nur ein Buchstabe
            if (input.length() != 1) {
                System.out.println("Bitte nur einen Buchstaben eingeben!");
                continue;
            }
            char c = input.charAt(0);

            boolean gefunden = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    hidden[i] = c;
                    gefunden = true;
                }
            }

            if (!gefunden) {
                lives--;
            }
        }
        System.out.println("Das Wort war: " + word);
        return 0;
    }
}