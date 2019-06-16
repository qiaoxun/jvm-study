package com.qiao.dao;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakTestDao {
    private static List<String> staticTestList = new ArrayList<>(100000);

    public void addDataToList() {
        List<String> testList = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            testList.add("test Str" + i);
        }
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStaticTestList() {
        for (int i = 0; i < 100000; i++) {
            staticTestList.add("test Str" + i);
        }

    }
}
