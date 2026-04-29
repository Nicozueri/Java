import java.util.*;                         // Importiert Scanner, ArrayList, Collections

public class MatrixStatistik {              // Definiert die Klasse
    public static void main(String[] args) { // Startpunkt des Programms

        Scanner sc = new Scanner(System.in); // Erstellt Scanner für Eingaben

        int n;                              // Variable für Matrixgröße
        do {                                // Start der Eingabeschleife
            System.out.print("n (2-8): ");   // Fragt nach Eingabe
            n = sc.nextInt();               // Liest Zahl ein
        } while (n < 2 || n > 8);           // Wiederholt wenn Zahl ungültig ist

        int[][] m = new int[n][n];          // Erstellt nxn Matrix
        ArrayList<Integer> list = new ArrayList<>(); // Liste für alle Werte

        for (int i = 0; i < n; i++)         // Schleife für Zeilen
            for (int j = 0; j < n; j++) {   // Schleife für Spalten
                System.out.print("[" + i + "][" + j + "]: "); // Zeigt Position
                m[i][j] = sc.nextInt();    // Speichert Eingabe in Matrix
                list.add(m[i][j]);         // Fügt Wert zur Liste hinzu
            }

        double sum = 0;                     // Speichert Gesamtsumme
        int[] z = new int[n], s = new int[n]; // Arrays für Zeilen- und Spaltensummen
        int hd = 0, nd = 0;                // Variablen für Diagonalen

        System.out.println("\nMatrix:");    // Überschrift

        for (int i = 0; i < n; i++) {      // Schleife über Zeilen
            System.out.print("[ ");        // Start der Zeile
            for (int j = 0; j < n; j++) {  // Schleife über Spalten
                int v = m[i][j];           // Speichert aktuellen Wert
                System.out.print(v + " "); // Gibt Wert aus

                sum += v;                  // Addiert Wert zur Gesamtsumme
                z[i] += v;                 // Addiert zur Zeilensumme
                s[j] += v;                 // Addiert zur Spaltensumme

                if (i == j) hd += v;       // Wenn Hauptdiagonale → addieren
                if (i + j == n - 1) nd += v; // Wenn Nebendiagonale → addieren
            }
            System.out.println("]");       // Beendet die Zeile
        }

        System.out.println("\nZeilen:");   // Überschrift Zeilen
        for (int i = 0; i < n; i++)        // Schleife über Zeilen
            System.out.println(i + ": " + z[i]); // Gibt Zeilensumme aus

        System.out.println("\nSpalten:");  // Überschrift Spalten
        for (int j = 0; j < n; j++)        // Schleife über Spalten
            System.out.println(j + ": " + s[j]); // Gibt Spaltensumme aus

        System.out.println("\nHauptdiag: " + hd); // Gibt Hauptdiagonale aus
        System.out.println("Nebendiag: " + nd);   // Gibt Nebendiagonale aus
        System.out.println("Ø: " + (sum / (n * n))); // Berechnet Durchschnitt

        for (int i = 0; i < n; i++)        // Schleife über Zeilen
            for (int j = 0; j < n; j++)    // Schleife über Spalten
                if (m[i][j] < 0)           // Prüft ob Wert negativ ist
                    m[i][j] = 0;           // Setzt negative Werte auf 0

        System.out.println("\nMatrix neu:"); // Überschrift neue Matrix

        for (int[] row : m) {              // Durchläuft jede Zeile
            System.out.print("[ ");        // Start der Zeile
            for (int v : row)              // Durchläuft Werte der Zeile
                System.out.print(v + " "); // Gibt Wert aus
            System.out.println("]");       // Beendet Zeile
        }

        Collections.sort(list);            // Sortiert die Liste

        System.out.println("\nListe: " + list); // Gibt sortierte Liste aus
        System.out.println("Min: " + list.get(0)); // Erstes Element = Minimum
        System.out.println("Max: " + list.get(list.size() - 1)); // Letztes = Maximum

        sc.close();                        // Schließt den Scanner
    }
}