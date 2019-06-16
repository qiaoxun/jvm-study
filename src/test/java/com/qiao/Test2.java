package com.qiao;

import com.qiao.classloader.CustomClassLoader;

public class Test2 {
    public static void main(String[] args) {
        final String a = "aa";
        String b = a + "bb";
        String c = "aabb";
        System.out.println(a == b);
        System.out.println(System.getProperty("sun.boot.class.path"));

        ClassLoader classLoader = new CustomClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
        System.out.println(classLoader);
        System.out.println("Over");
    }
}
