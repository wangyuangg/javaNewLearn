package mysql;

import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class demo06 {
    @Test
    public void noTransaction()  {
        Connection connection = null;
        String sql1 = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();//在默认情况下，每个连接都是自动提交事务的
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();//执行sql1语句
            int i = 1 / 0;
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();//执行sql2语句

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }



    }
    @Test
    public void Transaction() {
        Connection connection = null;
        String sql1 = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();//在默认情况下，每个连接都是自动提交事务的
            //将 connection 的自动提交事务设置为 false
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();//执行sql1语句

            //int i = 1 / 0;
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();//执行sql2语句
            connection.commit();//提交事务
        } catch (SQLException e) {
            //在这里我们需要回滚事务
            System.out.println("执行发生了异常开始事务回滚");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }



    }

}
