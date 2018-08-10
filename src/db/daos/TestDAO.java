
/*
 * Data Access Object Code Generator 1.0
 * Author: David Vazquez
 */
package db.daos;

import db.pojos.TestPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class TestDAO {

    private static final String TABLE = "Test";
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "(corrects, incorrects, score, timestamp) VALUES (?, ?, ?, ?)";
    private static final String SQL_QUERY_ALL = "SELECT * FROM " + TABLE;
    private static final String SQL_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE " + TABLE + " set corrects = ?, incorrects = ?, score = ?, timestamp = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM " + TABLE + " WHERE id = ?";

    public static int insertTest(int corrects, int incorrects, int score, Timestamp timestamp) {
        Connection con;
        PreparedStatement st;
        ResultSet resultSet;
        int id = 0;
        try {
            con = db.DBConnection.getConnection();
            st = con.prepareStatement(SQL_INSERT);
            st.setInt(1, corrects);
            st.setInt(2, incorrects);
            st.setInt(3, score);
            st.setTimestamp(4, timestamp);
            st.executeUpdate();
            resultSet = st.getGeneratedKeys();
            resultSet.next();
            id = resultSet.getInt(1);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return id;
    }

    public static TestPOJO query(String id) {
        Connection con;
        PreparedStatement st;
        TestPOJO pojo = new TestPOJO();
        try {
            con = db.DBConnection.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                pojo.setId(rs.getInt(1));
                pojo.setCorrects(rs.getInt(2));
                pojo.setIncorrects(rs.getInt(3));
                pojo.setScore(rs.getInt(4));
                pojo.setTimestamp(rs.getTimestamp(5));
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

    public static boolean deleteTest(String id) {
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

    public static boolean updateTest(TestPOJO pojo) {
        Connection con;
        PreparedStatement st;
        int num = 0;
        try {
            con = db.DBConnection.getConnection();
            st = con.prepareStatement(SQL_UPDATE);
            st.setInt(1, pojo.getCorrects());
            st.setInt(2, pojo.getIncorrects());
            st.setInt(3, pojo.getScore());
            st.setTimestamp(4, pojo.getTimestamp());
            st.setInt(5, pojo.getId());
            num = st.executeUpdate();
            db.DBConnection.close(st, con);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return num == 1;
    }
}
