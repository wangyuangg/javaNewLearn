package com.yyyy.reflection.question;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@SuppressWarnings("all")
public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src\\re.properties")));
        String classpath = properties.get("classpath").toString();
        String method = properties.get("method").toString();
        Class aClass = Class.forName(classpath);
        Object o = aClass.newInstance();
        Method method1 = aClass.getMethod(method);//方法对象调用类的对象
        method1.invoke(o);
        Field name = aClass.getField("age");//获取属性
        System.out.println(name.get(o));
        Constructor constructor = aClass.getConstructor();//获取构造器,()里面可以写参数
        System.out.println(constructor);
        Constructor constructor1 = aClass.getConstructor(String.class);//
        System.out.println(constructor1);
    }

}
