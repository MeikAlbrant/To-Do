import java.sql.*;
public class DB {
    public static void main(String[] args) {
        try{
            //Verbidnug zur Datenbank aufbauen
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","Informatik");
            // Ein Statement erstellen
            Statement stmt =conn.createStatement();
            // Die SQL Abfrage (Query) ausführen
            ResultSet rs = stmt.executeQuery("select * from liste");
            // Die Ergebnisse verarbeiten
            while (rs.next()){
                System.out.println(rs.getString("Aufgabe") + ","+ rs.getString("Deadline"));
            }
        }
        catch (Exception e){ 
            System.out.println(e);
        }
    }
}
