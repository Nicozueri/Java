/** Passwortgenerator
 * Erstellt von: Nico, Delio und Nevio
 * Beschreibung: Dieses Programm generiert sichere Passwörter basierend auf den Benutzereinstellungen. (Was beim Code gemacht wird steht direkt hinter der Zeile)
 * Version: 1.0
 * Datum: 2026-03-30
 * Änderungen: - 2026-03-23: Code angefangen zu schreiben
 *            - 2026-03-30: Code beendet und kommentiert
 */



import java.util.Random; // Für Zufallszahlen
import java.util.Scanner; // Für Benutzereingaben

public class passwortgenerator { // Klassenname

    public static void main(String[] args) { // Startpunkt des Programms

        Scanner sc = new Scanner(System.in); // Scanner für Eingaben
        Random random = new Random(); // Zufallsobjekt

        boolean weiter = true; // Steuert die Schleife

        while (weiter) { // Wiederholt Programm solange weiter = true

            System.out.println("=== Passwort Generator ==="); // Überschrift

            int laenge = leseInt(sc, "Passwort Länge: "); // Länge sicher einlesen

            boolean gross = leseBoolean(sc, "Grossbuchstaben (true/false): "); // Grossbuchstaben?
            boolean klein = leseBoolean(sc, "Kleinbuchstaben (true/false): "); // Kleinbuchstaben?
            boolean zahlen = leseBoolean(sc, "Zahlen (true/false): "); // Zahlen?
            boolean sonder = leseBoolean(sc, "Sonderzeichen (true/false): "); // Sonderzeichen?

            if (!(gross || klein || zahlen || sonder)) { // Prüft: keine Auswahl getroffen?
                System.out.println("Fehler: Keine Zeichentypen gewählt!"); // Fehlermeldung
                continue; // Springt zurück zum Anfang der Schleife
            }

            String pool = ""; // String für erlaubte Zeichen

            if (gross) pool += "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Grossbuchstaben hinzufügen
            if (klein) pool += "abcdefghijklmnopqrstuvwxyz"; // Kleinbuchstaben hinzufügen
            if (zahlen) pool += "0123456789"; // Zahlen hinzufügen
            if (sonder) pool += "!@#$%&*"; // Sonderzeichen hinzufügen

            String passwort = ""; // Ergebnis-String

            for (int i = 0; i < laenge; i++) { // Schleife läuft so oft wie Länge
                int index = random.nextInt(pool.length()); // Zufälliger Index im Pool
                passwort += pool.charAt(index); // Zeichen anhängen
            }

            System.out.println("Passwort: " + passwort); // Ausgabe

            weiter = frageNeustart(sc); // Fragt ob neu starten
        }

        System.out.println("Programm beendet."); // Abschlussmeldung
        sc.close(); // Scanner schliessen
    }

    public static int leseInt(Scanner sc, String message) { // Methode für sichere Integer-Eingabe
        int zahl; // Variable für Zahl

        while (true) { // Endlosschleife bis gültige Eingabe
            System.out.print(message); // Nachricht anzeigen

            if (sc.hasNextInt()) { // Prüft ob nächste Eingabe Zahl ist
                zahl = sc.nextInt(); // Zahl einlesen
                sc.nextLine(); // Buffer leeren

                if (zahl > 0) { // Prüft ob Zahl > 0
                    return zahl; // Gibt gültige Zahl zurück
                } else {
                    System.out.println("Fehler: Bitte eine Zahl größer als 0 eingeben!"); // Fehlermeldung
                }

            } else {
                System.out.println("Fehler: Bitte eine gültige Zahl eingeben!"); // Fehlermeldung
                sc.nextLine(); // Falsche Eingabe entfernen
            }
        }
    }

    public static boolean leseBoolean(Scanner sc, String message) { // Methode für Boolean-Eingabe
        while (true) { // Endlosschleife bis gültig
            System.out.print(message); // Nachricht anzeigen
            String input = sc.nextLine().trim().toLowerCase(); // Eingabe lesen + bereinigen

            if (input.equals("true")) { // Wenn "true"
                return true; // true zurückgeben
            } else if (input.equals("false")) { // Wenn "false"
                return false; // false zurückgeben
            } else {
                System.out.println("Fehler: Bitte nur 'true' oder 'false' eingeben!"); // Fehlermeldung
            }
        }
    }

    public static boolean frageNeustart(Scanner sc) { // Methode für Neustart-Abfrage
        while (true) { // Endlosschleife
            System.out.print("Möchtest du das Programm neu starten? (ja/nein): "); // Frage
            String input = sc.nextLine().trim().toLowerCase(); // Eingabe lesen

            if (input.equals("ja")) { // Wenn ja
                return true; // Programm wiederholen
            } else if (input.equals("nein")) { // Wenn nein
                return false; // Programm beenden
            } else {
                System.out.println("Fehler: Bitte 'ja' oder 'nein' eingeben!"); // Fehlermeldung
            }
        }
    }
}