package utils;

import org.junit.Test;

import java.sql.*;

public class Demo01 {
    public static void main(String[] args) {
        testDml();
    }

    public static void testDml() {
        Connection connection = null;
        String sql = "update  actor set name = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "梁非凡");
            preparedStatement.setInt(2, 3);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }

    }
    @Test
    public  void testselect() {
        Connection connection = null;
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            set = preparedStatement.executeQuery();
            //遍历
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");

                String sex = set.getString("sex");

                Date borndate = set.getDate("borndate");
                System.out.println("=====================================");
                System.out.println(name + "\t" + id + "\t" + sex + "\t" + borndate);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }


}
