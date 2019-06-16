package com.qiao.classloader.statictest;

public class Child extends Father /*implements IFather*/ {
//    public static int m = 11;
    static {
        System.out.println("this is child");
//        System.out.println(str0);
        str0 = "bbb";
    }
    public static String str0 = "ssss";

    public int getM() {
        return this.m;
    }
}
