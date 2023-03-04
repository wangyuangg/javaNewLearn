package mysql;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class demo01 {
    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/good";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "admin");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
        //String sql ="insert into actor values(null,'刘德华','男','1970-11-11','110')";
        String sql = "delete from actor where id = 1";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "Sql succeed!" : "Sql fail!");
        statement.close();
        connect.close();
    }
}
