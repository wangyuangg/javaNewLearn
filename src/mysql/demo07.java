package mysql;

import mysql.druid.Actor;
import mysql.druid.JDBCbyDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class demo07 {
    public static void main(String[] args) throws SQLException {
        testQuerryMany();
    }
    public static void  testQuerryMany() throws SQLException {//返回结果是多行
        //1.获取连接
        String sql = "select * from actor where id >= ?";
        Connection connection = JDBCbyDruid.getConnection();
        //2.创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //(1)query方法执行sql查询，得到resultSet 封装到List集合中
        //(2)new BeanListHandler<>(Actor.class)：把结果集中的每一行数据封装到Actor对象中，再把Actor对象放到List集合中
        //(3)Actor.class：指定封装数据的JavaBean类型,底层是通过反射来创建对象
        List<Actor> query = queryRunner.query(connection,
                sql,
                new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合信息");
        for (Actor actor : query) {
            System.out.println(actor);
        }
        System.out.println(query.size());

        //3.关闭连接
        JDBCbyDruid.close(null, null, connection);


    }
}
