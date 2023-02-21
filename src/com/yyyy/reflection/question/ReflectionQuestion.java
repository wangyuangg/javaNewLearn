package com.yyyy.reflection.question;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Properties properties = new Properties();
        properties.load(new FileReader("src\\re.properties"));
        String classpath = properties.get("classpath").toString();
        String method = properties.get("method").toString();
        System.out.println("classpath:"+classpath);
        System.out.println("method:"+method);
        Class<?> aClass = Class.forName(classpath);
        Object o = aClass.newInstance();
        Method method1 = aClass.getMethod(method);//方法对象调用类的对象
        method1.invoke(o) ;
    }
}
