package com.qiao.dispatch;

public class Verload {
//    public static void sayHello(char arg) {
//        System.out.println("Hello Char");
//    }

    public static void sayHello(Object arg) {
        System.out.println("Hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("Hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("Hello long");
    }

    public static void main(String[] args) {
        sayHello('c');
    }
}
