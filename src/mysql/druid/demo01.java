package mysql.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class demo01 {
    @Test
   public  void testDruid() throws Exception {
    //1.导入jar包
    //2.定义配置文件
    //3.加载配置文件
    //4.获取连接池对象
    //5.获取连接
    //6.释放资源
       Properties properties = new Properties();
       properties.load(new FileInputStream("src\\druid.properties"));

       DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

       Connection connection = dataSource.getConnection();
       System.out.println("success!");
       connection.close();

   }
}
