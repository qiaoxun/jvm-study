package com.qiao.classloader.statictest;

public class Super {
    public static int m = 10;
    public int noneStaticField = 10;
    static {
        System.out.println("this is super");
    }
}
