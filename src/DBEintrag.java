
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBEintrag {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Informatik";
    private static final String CONN_STRING
            = "jdbc:mysql://localhost/todo";

    private String aufgabe;
    private String deadline;

    public void eingabe() {

        Connection con = null;
        PreparedStatement stmt = null;
        try {

            // Das wird benutzt, um eine Verbidung mit der DBEintrag aufzubauen
            con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Verbindung zu Datenbank erfolgreich!");
            // Das wird benutzt um eingabe in SQL zu machen
            String sql = "INSERT INTO liste (Aufgabe, Deadline) VALUES (?, ?)";
            // Das wird benutzt, um jetzt ein Statement zu machen
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aufgabe);
            stmt.setString(2, deadline);

            // Das stmt.executeUpdate() deint dazu, dass die Tabelle entsprechend der Eingabe aktualisiert wird
            stmt.executeUpdate();
            // hiermit wird die Verbidung zur DatenBank beendet
            

        } catch (SQLException e) {
            System.err.println(e); // Das ist unsere Exception bezogen auf SQL, sollte etwas nicht mit der SQL Syntax passen
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }

        }

    }

    public String getAufgabe() {
        return aufgabe;
    }

    public void setAufgabe(String aufgabe) {
        this.aufgabe = aufgabe;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
