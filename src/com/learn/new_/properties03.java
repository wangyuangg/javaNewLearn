package com.learn.new_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class properties03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("charset","utf8");
        properties.setProperty("user","汤姆");
        properties.setProperty("pwd","abccc");
        properties.store(new FileOutputStream("src\\mysql2.properties"),null);
        System.out.println("store ok!");
    }
}
