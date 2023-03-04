package mysql;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demo04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/good";
        Connection connection = DriverManager.getConnection(url, "root", "admin");
        System.out.println(connection);
        connection.close();

    }
}
