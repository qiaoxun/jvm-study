package com.qiao.memoryleaks.threadlocal;

public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void setValue(String value) {
        threadLocal.set(value);
    }

    public void getValue() {
        System.out.println(threadLocal.get());
    }

    public static void main(String args[]) {
        Thread thread = new Thread(() -> {
            ThreadLocalTest threadLocalTest = new ThreadLocalTest();
            threadLocalTest.setValue("aaa");
            threadLocalTest.getValue();
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.setValue("bbb");
        threadLocalTest.getValue();
    }
}
