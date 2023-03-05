package mysql.druid;

import java.sql.*;

public class JDBCshixian {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        //4.获取连接池对象
        //5.获取连接
        //6.释放资源

        Connection connect = null;
        String sql = "select * from actor where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            //获取连接
            connect = JDBCbyDruid.getConnection();//运行类型为Connection
            //获取预编译对象
            preparedStatement = connect.prepareStatement(sql);
            //设置参数
            preparedStatement.setInt(1, 2);
            //执行sql,获取结果集
            set = preparedStatement.executeQuery();
            //遍历结果集
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println("=====================================");
                //System.out.println(id + "\t" + name + "\t"+sex+"\t"+borndate+"\t"+phone);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            JDBCbyDruid.close(set, preparedStatement, connect);
        }

    }
}
