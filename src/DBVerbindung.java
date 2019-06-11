import java.sql.*;

public class DBVerbindung {
    Connection connection;
    
    public DBVerbindung(){
        
    }
    
    public boolean connectToMysql (String host, String database, String user, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionCommand = "jdbc:mysql://"+host+"/"+database+"?user="+user+"&password="+password;
            connection = DriverManager.getConnection(connectionCommand);
            return true;
        } catch (Exception ex){
            System.out.println("false");
            return false;
        }
    }
 
}
