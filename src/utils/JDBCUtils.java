package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String user;
    private static String pwd;
    private static String url;
    private static String driver;

    //在static代码块去初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\mysql.properties"));
            user = properties.getProperty("user");
            pwd = properties.getProperty("pwd");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //实际开发中
            throw new RuntimeException(e);
        }
    }

    //连接数据库，返回一个connection对象
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            //编译时异常转换为运行时异常
            throw new RuntimeException(e);
        }
    }

    //关闭相关资源
    /*
        1.ResultSet
        2.Statement
        3.Connection
     */
    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {

                statement.close();

            }
            if (connection != null) {

                connection.close();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}