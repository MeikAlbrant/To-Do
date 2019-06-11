
public class ToDoListe {

    public static void main(String[] args) {
        
/*
        //Zum Eintrag von Daten in die Datenbank
        // Hier wird der Benutzer aufgefordert, die Aufgabe und ie Deadline festzulegen
        System.out.println("Name der Aufgabe (max. 50 Zeichen)");
        String aufgabe = SystemInReader.readString();

        // das Beschreibt die Anzahl der restlichen erlaubten Zeichen
        int restChar = 50 - aufgabe.length();

        // Die IF-Abfrage zur Begrenzung der Zeichen für den Namen der Aufgabe
        if (aufgabe.length() <= 50) {
            System.out.println("Noch " + restChar + " Zeichen übrig.");
            System.out.println("Deadline der Aufgabe (im Format DD.MM.YYYY). Bei keiner Deadline keine Eingabe.");
            String deadline = SystemInReader.readString();

            DBEintrag neueAufgabe = new DBEintrag();
            neueAufgabe.Eingabe(aufgabe, deadline);
        } else {

            System.out.println("Die Zeichenkette ist zu lang, sie darf nur 50 Zeichen haben.");
        }*/

        /*GUIGesamt Fenster = new GUIGesamt();
        Fenster.betrieb();*/
        
        
        
        // Zur Ausgabe der Liste aus der Datenbank
        DBAusgabe aktuelleListe = new DBAusgabe();
        aktuelleListe.Ausgabe();

    }

}
