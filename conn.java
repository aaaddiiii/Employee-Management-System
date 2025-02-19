import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection connection;
    Statement statement;
    public conn(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeemngmnt","root","9860270234");
            statement = connection.createStatement();

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }

}
