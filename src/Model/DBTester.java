package Model;

import java.sql.SQLException;

public class DBTester {
    public static void main(String[] args){
        try {
            System.out.println(DBConnect.getPhoneManufactures());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
