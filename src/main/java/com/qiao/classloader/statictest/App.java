package com.qiao.classloader.statictest;

public class App {
    public static void main(String[] args) {
//        System.out.println(new Child().getM());
//        HasStaticFields.class.getClassLoader();
        System.out.println(Child.m);
    }
}
