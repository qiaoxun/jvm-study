package com.qiao;

import static org.junit.Assert.assertTrue;

import com.qiao.service.MemoryLeakTestService;
import jdk.nashorn.internal.ir.WhileNode;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static void main(String[] args) {
        AppTest appTest = new AppTest();
//        appTest.testMemoryLeak();
        appTest.testStaticList();
        while (true) {
            try {
                Thread.sleep(10000);
                System.gc();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testMemoryLeak() {
        MemoryLeakTestService memoryLeakTestService = new MemoryLeakTestService();
        memoryLeakTestService.testMemoryLeak();
    }

    public void testStaticList() {
        MemoryLeakTestService memoryLeakTestService = new MemoryLeakTestService();
        memoryLeakTestService.testStaticList();
    }
}
