package com.yyyy;

public class Cat {
    private String name = "招财猫";
    public int age = 2;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi() {
        System.out.println("hi" + name);
    }
    public void cry() {
        System.out.println("喵喵喵");
    }


}
