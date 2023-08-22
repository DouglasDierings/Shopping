package databaseDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/store"; // Database URL
    private static final String DB_USER = "root"; // Database username
    private static final String DB_PASSWORD = ""; // Database password

    /**
     * Establishes a connection to the database
     *
     * @return the connection object
     * @throws SQLException if a database access error occurs
     */
    public Connection connectToDB() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException error) {
            throw error;
        }
        return conn;
    }
}
