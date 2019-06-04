package com.qiao.memoryleaks.staticfield;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaticListTest {
    public static List<Object> list = new ArrayList<>();

    public void populateList() {
        for (int i = 0; i < 1000000; i++) {
            Object o = new Object();
            list.add(o);
        }
        System.out.println("Debug Point 2");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Debug Point 1");
        new Thread(() -> {
            new StaticListTest().populateList();
        }).start();
        System.out.println("Debug Point 3");
        while (true) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
