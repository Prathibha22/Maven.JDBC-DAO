package daos;

import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    static String userName="prathibha";
    static String password="prathibha";
    static String url="jdbc:mysql://localhost:3306/zipcode?autoReconnect=true&useSSL=false";
    public static java.sql.Connection getConnection1(){
        //Connection conn=null;
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(url,userName, password);
            //return conn;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            java.sql.Connection connection = getConnection1();
//            connection.close();
//        }
//        catch (ClassNotFoundException e) {
//            System.out.println("MySQL JDBC Driver not found !!");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
}