package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author David Vazquez
 */
public class DBConnection {

    public static final String DB_NAME = "db.db";
    public static final String DB_URL = "jdbc:sqlite:" + DB_NAME;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return conn;
    }

    private static void closeStuff(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
