package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

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
        } 
        return conn;
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
    public static void close(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        preparedStatement.close();
        connection.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(getConnection());
    }

    public static DefaultTableModel resultSetToDefaultTableModel(ResultSet source) {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            ResultSetMetaData meta = source.getMetaData();
            for (int i = 0; i < meta.getColumnCount(); i++) {
                modelo.addColumn(meta.getColumnLabel(i + 1));
            }
            while (source.next()) {
                Object[] fila = new Object[meta.getColumnCount()];
                for (int i = 0; i < meta.getColumnCount(); i++) {
                    fila[i] = source.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            source.close();
            return modelo;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }
}
