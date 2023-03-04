package mysql;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class demo02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver o = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/good";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "admin");
        Connection connect = o.connect(url, properties);
        System.out.println("methodTwo" + connect);
        connect.close();


    }
}
