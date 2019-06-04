package com.qiao.memoryleaks.staticfield;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class NoneStaticListTest {
    public List<Object> list = new ArrayList<>();

    public void populateList() {
        for (int i = 0; i < 1000000; i++) {
            Object o = new Object();
            list.add(o);
        }
        System.out.println("Debug Point 2");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Debug Point 1");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                NoneStaticListTest noneStaticListTest = new NoneStaticListTest();
                noneStaticListTest.populateList();
            }
        });

        thread.start();

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
