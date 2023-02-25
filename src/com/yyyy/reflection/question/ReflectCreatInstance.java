package com.yyyy.reflection.question;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectCreatInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class aClass = Class.forName("com.yyyy.reflection.question.User");
        Object o = aClass.newInstance();
        System.out.println(o);
        //
        Constructor<?> constructor = aClass.getConstructor(String.class);
        //创建实例
        Object o1 = constructor.newInstance("李四");
        //输出
        //System.out.println(o1);
        Constructor df = aClass.getDeclaredConstructor(int.class, String.class);//获取私有构造器
        df.setAccessible(true);
        Object o2 = df.newInstance(20, "张三");

        System.out.println(o2);
    }

}
class User{
    private int age = 10;
    private String name = "张三";
    public User() {
    }
    private User(int age, String name) {//公有构造器
        this.age = age;
        this.name = name;
    }
    public User(String name) {//私有构造器
        this.name = name;
    }

    @Override
    public String toString() {//重写toString方法
        return "User [age=" + age + ", name=" + name + "]";
    }
}