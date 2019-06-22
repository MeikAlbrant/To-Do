
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAusgabe {

    public static void Ausgabe() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //Verbindung zur Datenbank aufbauen
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "Informatik");
            // Ein Statement erstellen
            stmt = con.createStatement();
            // Die SQL Abfrage (Query) ausführen
            rs = stmt.executeQuery("select * from Liste Order by id desc limit 1 ");
            // Die Ergebnisse ausgeben Lassen
            while (rs.next()) {
                String dbNameAufgabe = rs.getString("Aufgabe"); //rs.getString gibt uns die Werte in den Spalten aus
                String dbNameDeadline = rs.getString("Deadline");

                System.out.println(dbNameAufgabe);

                // Die Daten aus der DAtenbank jetzt über Set für die Ausgabe festelegen
                GUIAufgabe neueAufgabe = new GUIAufgabe();
                neueAufgabe.setAufgabenLabel(dbNameAufgabe);
                neueAufgabe.setDeadlineLabel(dbNameDeadline);

            }

        } catch (Exception e) {
            System.out.println(e); // unsere Ausnahme, falls die Verbindung nicht aufgebaut werden konnte
        } finally { //zur beendeung der Verbindungen
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    }
}
