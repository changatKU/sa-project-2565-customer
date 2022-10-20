package ku.cs.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
    private static final DBConnection dbConnection = new DBConnection();
    private static final Connection connectDB = dbConnection.getConnection();

    private static final Statement statement;

    static {
        try {
            statement = connectDB.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DBConnector() throws SQLException {

    }

    public static ResultSet query(String command) throws SQLException {
        ResultSet output = statement.executeQuery(command);
        return output;
    }

    public static void insert(String command) throws SQLException {
        statement.executeUpdate(command);
    }

}
