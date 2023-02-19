package com.learn.new_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class properties02 {
    public static void main(String[] args) throws IOException {
        Properties pp = new Properties();
        pp.load(new FileReader("src\\mysql.properties"));
        pp.list(System.out);
        System.out.println("ip值：" + pp.getProperty("ip"));
    }
}
