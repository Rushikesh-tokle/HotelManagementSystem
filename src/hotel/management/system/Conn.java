package hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection cs;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cs= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","Rushi@20022020");
            s=cs.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
