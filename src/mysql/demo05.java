package mysql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class demo05 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, pwd);
        System.out.println(connection);
        connection.close();
    }
}
