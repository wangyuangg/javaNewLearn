package com.learn.new_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class properties_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line= "";
        while ((line = bfr.readLine()) != null){
            String[] split = line.split("=");
            if ("ip".equals(split[0])){
                System.out.println(split[0]+"值："+split[1]);
            }

        }
        bfr.close();
    }
}
