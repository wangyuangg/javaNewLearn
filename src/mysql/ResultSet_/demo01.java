package mysql.ResultSet_;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
    @SuppressWarnings("all")
    public class demo01 {
        public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src\\mysql.properties")));
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, pwd);
        Statement statement = connection.createStatement();
        String sql = "select id ,name,sex,borndate from actor";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);

            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }
        System.out.println();
        resultSet.close();
        statement.close();
        connection.close();
    }
}
