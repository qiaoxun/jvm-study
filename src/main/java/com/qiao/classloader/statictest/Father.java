package com.qiao.classloader.statictest;

public class Father extends Super {
//    public static int m = 11;
    public int noneStaticField = 11;
    static {
        System.out.println("this is father");
    }
}
