package work;

import java.io.*;
import java.nio.Buffer;

public class work01 {
    public static void main(String[] args) throws IOException {
        String directPath ="d:\\mytemp";
        File file = new File(directPath);
        if (!file.exists()){
            //创建
            if (file.mkdirs()){
                System.out.println("succeed！");
            }else {
                System.out.println("fail！");
            }
        }

        String filePath1 = directPath + "\\hello.txt";
        File file1 = new File(filePath1);
        if (!file1.exists()){
            if (file1.createNewFile()){
                System.out.println("succeed!");
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath1));
                bufferedWriter.write("hello,world!");
                bufferedWriter.close();
            }else{
                System.out.println("fail!");
            }
        }else {
            System.out.println("exist!");
        }
    }
}
