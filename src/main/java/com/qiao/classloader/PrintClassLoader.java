package com.qiao.classloader;

import com.sun.javafx.util.Logging;

import java.util.ArrayList;

public class PrintClassLoader {
    public static void main(String args[]) {
        System.out.println("ClassLoader of this class is " + PrintClassLoader.class.getClassLoader());
        System.out.println("ClassLoader of Logging is " + Logging.class.getClassLoader());
        System.out.println("ClassLoader of ArrayList is " + ArrayList.class.getClassLoader());
        try {
            Class.forName("com.qiao.classloader.NoClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
