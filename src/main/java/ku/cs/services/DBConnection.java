package ku.cs.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public Connection dbLink;

    public Connection getConnection(){
        String dbName = "sa_project";
        String dbUser = "root";
        String dbPassword = "";
        String url = "jdbc:mysql://localhost/" + dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbLink = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return dbLink;
    }
}
