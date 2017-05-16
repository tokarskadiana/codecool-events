package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SqliteJDSCConnector {
    public static Connection makeConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:sqlite:src/main/resources/database.sqlite");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void createTables() throws SQLException {
        Statement statement = makeConnection().createStatement();
        statement.execute("CREATE TABLE events\n" +
                "(\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    name VARCHAR(255) NOT NULL,\n" +
                "    description VARCHAR(255) NOT NULL,\n" +
                "    category VARCHAR(255) NOT NULL,\n" +
                "    date DATE NOT NULL\n" +
                ")");
    }
}
