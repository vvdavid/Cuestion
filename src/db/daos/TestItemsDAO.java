
/*
 * Data Access Object Code Generator 1.0
 * Author: David Vazquez
 */
package db.daos;

import db.pojos.TestItemsPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class TestItemsDAO {

    private static final String TABLE = "TestItems";
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "(correct, idItem, IdTest) VALUES (?, ?, ?)";
    private static final String SQL_QUERY_ALL = "SELECT * FROM " + TABLE;
    private static final String SQL_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE " + TABLE + " set correct = ?, idItem = ?, IdTest = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM " + TABLE + " WHERE id = ?";

    public static int insertTestItems(boolean correct, int idItem, int IdTest) {
        Connection con;
        PreparedStatement st;
        ResultSet resultSet;
        int id = 0;
        try {
            con = db.DBConnection.getConnection();
            st = con.prepareStatement(SQL_INSERT);
            st.setBoolean(1, correct);
            st.setInt(2, idItem);
            st.setInt(3, IdTest);
            st.executeUpdate();
            resultSet = st.getGeneratedKeys();
            resultSet.next();
            id = resultSet.getInt(1);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return id;
    }

    public static TestItemsPOJO query(String id) {
        Connection con;
        PreparedStatement st;
        TestItemsPOJO pojo = new TestItemsPOJO();
        try {
            con = db.DBConnection.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                pojo.setId(rs.getInt(1));
                pojo.setCorrect(rs.getBoolean(2));
                pojo.setIdItem(rs.getInt(3));
                pojo.setIdTest(rs.getInt(4));
            }
            db.DBConnection.close(rs, st, con);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return pojo;
    }

    public static DefaultTableModel loadTable() {
        Connection con;
        PreparedStatement st;
        DefaultTableModel dt = null;
        try {
            con = db.DBConnection.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            dt = new DefaultTableModel();
            ResultSet rs = st.executeQuery();
            dt = db.DBConnection.resultSetToDefaultTableModel(rs);
            db.DBConnection.close(rs, st, con);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return dt;
    }

    public static boolean deleteTestItems(String id) {
        int num = 0;
        try {
            Connection con = db.DBConnection.getConnection();
            PreparedStatement st = con.prepareStatement(SQL_DELETE);
            st.setString(1, id);
            num = st.executeUpdate();
            db.DBConnection.close(st, con);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return num == 1;
    }

    public static boolean updateTestItems(TestItemsPOJO pojo) {
        Connection con;
        PreparedStatement st;
        int num = 0;
        try {
            con = db.DBConnection.getConnection();
            st = con.prepareStatement(SQL_UPDATE);
            st.setBoolean(1, pojo.isCorrect());
            st.setInt(2, pojo.getIdItem());
            st.setInt(3, pojo.getIdTest());
            st.setInt(4, pojo.getId());
            num = st.executeUpdate();
            db.DBConnection.close(st, con);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return num == 1;
    }
}
