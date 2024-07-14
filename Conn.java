import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn(){

        try{

            //REGISTER A DRIVERS = library k aandhar h yee...uske aandhar drivers class h
            Class.forName("com.mysql.cj.jdbc.Driver");

            // CREATING CONNECTION STRING
            c = DriverManager.getConnection("jdbc:mysql:///airlinesystem", "root","Viky@009");

            // CREATING A STATEMENT jisse ki hum hamari mqsql ki queries ko execute kr skte
            s = c.createStatement();

        }                                           
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String...vr){

    }
    
}
