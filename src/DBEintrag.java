
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBEintrag {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Informatik";
    private static final String CONN_STRING
            = "jdbc:mysql://localhost:3306/?user=root";
    
    private String Aufgabe;
    private String Deadline;

    public void Eingabe() {

        Connection con;
        PreparedStatement stmt;
        try {
            // Das wird benutzt, um eine Verbidung mit der DBEintrag aufzubauen
            con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Verbindung zu Datenbank erfolgreich!");
            // Das wird benutzt um eingabe in SQL zu machen
            String sql = "INSERT INTO liste (Aufgabe, Deadline) VALUES (?, ?)";
            // Das wird benutzt, um jetzt ein Statement zu machen
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "test");
            stmt.setString(2, "test");

            // Das stmt.executeUpdate() deint dazu, dass die Tabelle entsprechend der Eingabe aktualisiert wird
            stmt.executeUpdate();
            // hiermit wird die Verbidung zur DatenBank beendet
            con.close();

        } catch (SQLException e) {
            System.err.println(e); // Das ist unsere Exception bezogen auf SQL, sollte etwas nicht mit der SQL Syntax passen
        }
    }

    public void setAufgabe(String aufgabe) {
        this.Aufgabe = aufgabe;
    }

    public void setDeadline(String deadline) {
        this.Deadline = deadline;
    }

}
