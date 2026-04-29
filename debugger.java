public class debugger {

    public static void main(String[] args) {

        int input = 3;

        if ((input >= 2) && (input <= 6)) {

            int zaehler = 0;

            for (int i = -5; i < 5; i++) {
                zaehler = zaehler + i + input;
                System.out.println(zaehler);
            }

        } else {
            System.err.println("Achtung, falsche Eingabe!");
        }
    }
}