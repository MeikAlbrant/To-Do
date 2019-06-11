
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBAusgabe {
    
    public static void Ausgabe(){

        try {
            //Verbindung zur Datenbank aufbauen
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "Informatik");
            // Ein Statement erstellen
            Statement stmt = conn.createStatement();
            // Die SQL Abfrage (Query) ausführen
            ResultSet rs = stmt.executeQuery("select * from liste");
            // Die Ergebnisse ausgeben Lassen
            while (rs.next()) {
               String Aufgabe = rs.getString("Aufgabe");
               String Deadline = rs.getString ("Deadline");
               //rs.getString gibt uns die Werte in den Spalten aus
               
            } conn.close(); // um die Verbindung anschließend wieder zu beenden
        } catch (Exception e) {
            System.out.println(e); // unsere Ausnahme, falls die Verbindung nicht aufgebaut werden konnte
        }
    }
}

    
            

