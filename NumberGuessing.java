import java.util.*;

public class NumberGuessing implements Game {
    // Punkt 6: Magic Numbers vermeiden
    private static final int MAX_TRIES = 3;
    private static final int RANGE = 10;

    public int play() {
        int target = new Random().nextInt(RANGE) + 1, guess = 0, tries = MAX_TRIES;
        Scanner sc = new Scanner(System.in);

        while (tries > 0 && guess != target) {
            System.out.print("Zahl (1-" + RANGE + "): ");
            // Validierung
            if (!sc.hasNextInt()) {
                System.out.println("Nur Zahlen erlaubt!");
                sc.next();
                continue;
            }
            guess = sc.nextInt();
            tries--;
        }

        return guess == target ? 1 : 0;
    }
}