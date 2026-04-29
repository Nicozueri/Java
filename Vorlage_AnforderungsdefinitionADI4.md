für Teilnehmer/innen des Teams:

| Klasse: PE | Team: Nico Jäger |
|-----------------------|-------------|

# Anforderungsdefinition für A4 → D4 & I4

| „System Monitor“       |  |
|-----|-----|
| **Fachlicher Inhalt:** <br> (Allgemeine Beschreibung)                 | **Nutzen**: Mit dem Programm sollen Systemdaten simuliert und dargestellt werden, um Abläufe und Log-Verarbeitung zu verstehen. <br> **Funktionalität:** Das Programm generiert Logs und verwaltet diese (anzeigen, speichern). <br> **Details:** Konfiguration: im Code <br>Integration: lokal <br>Administration: über Konsolenmenü <br>Sicherheitsaspekte: nur simulierte Daten <br> **Erkenntnisse aus der Machbarkeitsabklärung:** Die Umsetzung mit Python und Datei-Speicherung ist möglich und sinnvoll strukturiert umsetzbar. |
| **MUSS** **Kriterien:** <br>(Konkrete Features, die umzusetzen sind) | **Folgende Features sollen implementiert werden, um einen produktiven Ablauf sicherzustellen:**  <br><ul><li>Das Konsolenprogramm ist nach dem EVA-Prinzip aufgebaut. <br> Komplexe Datentypen werden für das Speichern der globalen Werte verwendet. <br> Funktionen haben Parameter und Rückgabewerte. (D4)</li><li>Menü zur Steuerung des Programms</li><li>Logs werden generiert</li><li>Daten können gespeichert werden</li><li>Daten können angezeigt werden</li></ul> |
| **SOLL** **Kriterien:** <br>(Konkrete Features, die optional sind)                  | **Folgende Features sollen bei Bedarf implementiert werden: (Future Release)**    <br><ul><li>Farbige Ausgabe in der Konsole</li><li>Einfache Log-Auswertung</li><li>Export als JSON oder TXT</li><li>Automatischer Live-Modus</li> |
| **KANN** **Kriterien:** <br>(Zusätzliche Features die gewünscht sind)               | **Folgende Features können zusätzlich implementiert werden: (Varianten, Kreativität)**  <br><ul><li>Passwortschutz für Zugriff</li><li>Benutzerverwaltung</li><li>Grafische Oberfläche (GUI)</li> |
| **Nicht-funktionale** **Kriterien:** <br>(Qualität, Geschwindigkeit, Benutzbarkeit) | **Folgende nicht-funktionale Kriterien sollen umgesetzt werden:** <br><ul><li>Einfache und klare Benutzerführung</li><li>Schnelle Ausführung ohne Verzögerung</li><li>Übersichtliche und saubere Code-Struktur</li> |

# Chatgpt wurde für die Idee und für die Formatvorlage gebraucht