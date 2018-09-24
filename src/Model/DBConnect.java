package Model;

import java.security.KeyStore;
import java.sql.*;
import java.util.ArrayList;

public class DBConnect {
    private static String user="root";
    private static String password="";
    public static ArrayList<String> getPhoneManufactures() throws SQLException {
     ArrayList<String> manufacturers =new ArrayList<>();
     Connection conn=null;
     Statement statement=null;
     ResultSet resultSet=null;
     try{
         //connect to the database
         conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/phones?userSSL=false", user, password);
        //create a statement object
         statement=conn.createStatement();
         //create the sql query
         resultSet =statement.executeQuery("SELECT * FROM manufactures");
        //loop over the result and add it to the arraylist
         while(resultSet.next()){
             manufacturers.add(resultSet.getString("manufacture"));
         }
     }catch (SQLException e){
         System.out.println(e);
         System.out.println("here");
     }
     finally {
         if (conn!=null)
             conn.close();
         if (statement!=null)
             statement.close();
         if (resultSet!=null)
             resultSet.close();
     }
     return  manufacturers;
    }
    public static String getOSWithManufacture(String manufacture) throws SQLException {
        String os=null;
        Connection conn=null;
        PreparedStatement pr=null;
        ResultSet resultSet=null;
            try {
                conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/phones?userSSL=false", user, password);
                String sql="SELECT os FROM manufactures WHERE manufacture=?";
                pr=conn.prepareStatement(sql);
                pr.setString(1,manufacture );
                resultSet=pr.executeQuery();
                while (resultSet.next()){
                    os=resultSet.getString("os");
                }
           } catch (SQLException e) {
                System.out.println(e);
        }
        finally {
                if(conn!=null)
                    conn.close();
                if(pr!=null)
                    pr.close();
                if (resultSet!=null)
                    resultSet.close();
            }
        return os;
    }
}
