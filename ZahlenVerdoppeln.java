import java.util.Scanner;

public class ZahlenVerdoppeln {

    public static void main(String[] args) {

        int zahl = eingabe();
        int result = verarbeitung(zahl);
        ausgabe(result);
    }

    // Eingabe vom Benutzer
    public static int eingabe() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Gib eine Zahl ein: ");
        int zahl = sc.nextInt();
        return zahl;
    }

    // Verarbeitung (Zahl verdoppeln)
    public static int verarbeitung(int zahl) {
        return zahl * 2;
    }

    // Ausgabe vom Resultat
    public static void ausgabe(int result) {
        System.out.println("Resultat: " + result);
    }
}