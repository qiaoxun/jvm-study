package com.qiao.classloader.interview;

public class App {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getSingleTon();
        System.out.println(SingleTon.count0);
        System.out.println(SingleTon.count1);
    }
}
