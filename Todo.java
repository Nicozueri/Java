/*
Programm: todoliste
Autoren: Nico Jäger 
Datum: 29.04.2026
Beschreibung:
To do Liste mit Pendenzen mit Status loeschen und speichern in csv
 */

import java.io.*;
import java.util.*;

public class Todo { // Punkt 3: Klassennamen groß

    private static final String FILE = "pendenzen.csv"; // in pendenzen.csv Aufgaben speichern
    private static List<Pendenz> liste = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        laden(); // Aufgaben laden
        Scanner sc = new Scanner(System.in);

        while (true) { // Endlosschleife
            System.out.println("\nPENDENZEN");

            // Schleife durch alle Einträge in der Liste zur Anzeige
            for (int i = 0; i < liste.size(); i++) {
                Pendenz p = liste.get(i);
                System.out.println((i + 1) + ". [" + p.status + "] " + p.text); // i + 1, damit die Liste bei 1 beginnt
            }

            System.out.println("\nMenue: 1 Neu | 2 Status aendern | 3 Loeschen | 4 Ende");
            String wahl = sc.nextLine(); // Programm wartet hier auf Eingabe und Enter

            if (wahl.equals("1")) { // Wenn 1. geklickt
                System.out.print("Was musst du tun? ");
                String aufgabe = sc.nextLine();
                // Punkt 2: Semikolons im Text entfernen, um CSV-Struktur zu schützen
                aufgabe = aufgabe.replace(";", ",");
                liste.add(new Pendenz("0", aufgabe, "GEPLANT"));

            } else if (wahl.equals("2")) { // wenn 2. geklickt
                System.out.print("Welche Nummer? ");
                // Punkt 1: Absturz verhindern durch Validierung
                try {
                    int index = Integer.parseInt(sc.nextLine()) - 1;

                    // Prüfen, ob die Nummer überhaupt gültig ist
                    if (index >= 0 && index < liste.size()) {
                        System.out.print("Status (1. GEPLANT, 2. IN_ARBEIT, 3. ERLEDIGT): ");
                        String s = sc.nextLine();
                        // Setzt den Status basierend auf der Eingabe
                        liste.get(index).status = s.equals("2") ? "IN_ARBEIT" : s.equals("3") ? "ERLEDIGT" : "GEPLANT";
                    } else {
                        System.out.println("Nummer existiert nicht!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Fehler: Bitte eine Zahl eingeben!");
                }

            } else if (wahl.equals("3")) { // wenn 3 geklickt
                System.out.print("Welche Nummer loeschen? ");
                // Punkt 1: Absturz verhindern
                try {
                    int index = Integer.parseInt(sc.nextLine()) - 1;
                    if (index >= 0 && index < liste.size()) {
                        liste.remove(index);
                    } else {
                        System.out.println("Nummer existiert nicht!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Fehler: Bitte eine Zahl eingeben!");
                }

            } else if (wahl.equals("4")) { // Wenn 4 geklickt
                // Punkt 4: Speichern hier entfernt, da es unten sowieso passiert
                System.out.println("Speichern und Beenden...");
                speichern();
                break; // Bricht die while Schleife ab Programm endet
            }

            speichern(); // Speichert die Liste nach jeder Aktion in die Datei
        }
    }

    // Methode zum Einlesen der Datei
    private static void laden() throws IOException {
        File f = new File(FILE);
        if (!f.exists()) return;

        BufferedReader br = new BufferedReader(new FileReader(f));
        String zeile;
        // Liest die Datei Zeile für Zeile, bis nichts mehr kommt (null)
        while ((zeile = br.readLine()) != null) {
            String[] teile = zeile.split(";"); // Trennt den Text beim Strichpunkt CSV Format
            // Wenn die Zeile 3 Teile hat, füge sie als Aufgabe zur Liste hinzu
            if (teile.length >= 3) liste.add(new Pendenz("0", teile[1], teile[2]));
        }
        br.close();
    }

    // Methode zum Schreiben in die Datei
    private static void speichern() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(FILE));
        // Geht durch jedes Element in der Liste
        for (Pendenz p : liste) {
            // Punkt 2: Sicherheitshalber auch hier nochmal Text säubern
            String saubererText = p.text.replace(";", ",");
            // Schreibt es in die Datei im Format: ID;Text;Status
            pw.println("0;" + saubererText + ";" + p.status);
        }
        pw.close();
    }
}