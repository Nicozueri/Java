public class Pendenz { // Punkt 3: Klassennamen groß
    // Die Eigenschaften einer Aufgabe
    String id;
    String text;
    String status;

    // Setzt die Startwerte beim Erstellen von neuer Pendenz
    public Pendenz(String id, String text, String status) {
        this.id = id;
        this.text = text;
        this.status = status;
    }

    // Wandelt die Aufgabe in eine Textzeile um
    public String toString() {
        return id + ";" + text + ";" + status;
    }
}