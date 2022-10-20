package ku.cs;

import ku.cs.services.DBConnection;
import ku.cs.services.DBConnector;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ResultSet output = DBConnector.query("SELECT Username FROM Customer");
        while (output.next()){
            System.out.println(output.getString("Username"));
        }

        DBConnector.insert("INSERT INTO Customer(Username, Password, Tax_ID, C_Name, C_Phone, Address)" +
                "VALUES(\"Feen\", \"123456\", \"0000000000002\", \"Napat\", \"0000000002\", \"Kasetsart\")");

        output = DBConnector.query("SELECT Username FROM Customer");
        while (output.next()){
            System.out.println(output.getString("Username"));
        }
    }
}
