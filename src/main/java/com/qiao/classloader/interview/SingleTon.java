package com.qiao.classloader.interview;

public class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count0 = 0;
    public static int count1;

//    private static SingleTon singleTon = new SingleTon();

    private SingleTon() {
        count0++;
        System.out.println("Constructor count0 = " + count0);
        count1++;
    }

    public static SingleTon getSingleTon() {
        return  singleTon;
    }
}
