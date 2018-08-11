
/*
 * Data Access Object Code Generator 1.0
 * Author: David Vazquez
 */
package db.daos;

import db.pojos.CategoryPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class CategoryDAO {

    private static final String TABLE = "Category";
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "(name) VALUES (?)";
    private static final String SQL_QUERY_ALL = "SELECT * FROM " + TABLE;
    private static final String SQL_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE " + TABLE + " set name = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM " + TABLE + " WHERE id = ?";

    public static int insertCategory(String name) {
        Connection con;
        PreparedStatement st;
        ResultSet resultSet;
        int id = 0;
        try {
            con = db.DBConnection.getConnection();
            st = con.prepareStatement(SQL_INSERT);
            st.setString(1, name);
            st.executeUpdate();
            resultSet = st.getGeneratedKeys();
            resultSet.next();
            id = resultSet.getInt(1);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return id;
    }

    public static CategoryPOJO query(String id) {
        Connection con = db.DBConnection.getConnection();
        PreparedStatement st = null;
        CategoryPOJO pojo = new CategoryPOJO();
        try {
            con = db.DBConnection.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                pojo.setId(rs.getInt(1));
                pojo.setName(rs.getString(2));
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

    public static boolean deleteCategory(String id) {
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

    public static boolean updateCategory(CategoryPOJO pojo) {
        Connection con;
        PreparedStatement st;
        int num = 0;
        try {
            con = db.DBConnection.getConnection();
            st = con.prepareStatement(SQL_UPDATE);
            st.setString(1, pojo.getName());
            st.setInt(2, pojo.getId());
            num = st.executeUpdate();
            db.DBConnection.close(st, con);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return num == 1;
    }

    public static int count() {
        int count = 0;
        ResultSet rs;
        try {
            Connection con = db.DBConnection.getConnection();
            PreparedStatement st = con.prepareStatement("select COUNT(id) FROM CATEGORY");
            rs = st.executeQuery();
            rs.next();
            count = rs.getInt(1);
            db.DBConnection.close(st, con);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return count;
    }
}
