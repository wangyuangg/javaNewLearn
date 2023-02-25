package com.yyyy.reflection.question;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflecAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> ac = Class.forName("com.yyyy.reflection.question.Boss");
        Object o = ac.newInstance();
        //Method say = ac.getMethod("hi");
        Method hi = ac.getDeclaredMethod("hi", String.class);
        hi.invoke(o, "张三");
        System.out.println("==================================");
        Method say = ac.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        Object invoke01 = say.invoke(o, 1, "张三", '男');//非静态方法对象不能为null
        System.out.println(invoke01);
        Object invoke02 = say.invoke(null, 2, "李四", '女');//静态方法对象可以为null
        System.out.println(invoke02);

    }
}

class Boss {
    public int age;
    private static String name;

    public Boss() {
    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi" + s);
    }
}