

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class TestAusgabe {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void dbAuslesen() throws Exception {
        try {
            
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/todo", "root", "Informatik");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from Liste Order by id desc limit 1 ");
            writeResultSet(resultSet);
            

            

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    

    private void writeResultSet(ResultSet resultSet) throws SQLException, Exception {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String dbNameAufgabe = resultSet.getString("Aufgabe");
            String dbNameDeadline = resultSet.getString("Deadline");
            
            GUIAufgabe neueAufgabe = new GUIAufgabe();
            neueAufgabe.setAufgabenLabel(dbNameAufgabe);
            neueAufgabe.setDeadlineLabel(dbNameDeadline);
            
    }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}

