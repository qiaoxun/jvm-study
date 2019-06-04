package com.qiao.memoryleaks.threadlocal;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalMemoryLeak {
    private static ThreadLocal<List> threadLocal = new ThreadLocal<>();

    public void putValueToThreadLocal() {
        List<String> list = new ArrayList<>();
        String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 1000000; i++) {
            list.add(threadName + " - " + i);
        }
        threadLocal.set(list);
    }

    public List<String> getValueFromThreadLocal() {
        return threadLocal.get();
    }

    public void removeValueFromThreadLocal() {
        threadLocal.remove();
    }

    public void setValueNull() {
        threadLocal.set(null);
    }

    public static void main(String args[]) {
        Thread thread1 = new Thread(() -> {
            ThreadLocalMemoryLeak threadLocalMemoryLeak = new ThreadLocalMemoryLeak();
            threadLocalMemoryLeak.putValueToThreadLocal();
            List<String> list = threadLocalMemoryLeak.getValueFromThreadLocal();
            System.out.println(list.get(0));
            System.out.println(Thread.currentThread().getName());
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            ThreadLocalMemoryLeak threadLocalMemoryLeak = new ThreadLocalMemoryLeak();
            threadLocalMemoryLeak.putValueToThreadLocal();
            List<String> list = threadLocalMemoryLeak.getValueFromThreadLocal();
            System.out.println(list.get(0));
            System.out.println(Thread.currentThread().getName());
            threadLocalMemoryLeak.removeValueFromThreadLocal();
//            threadLocalMemoryLeak.setValueNull();
            list = null;

            while (true) {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();

        while (true) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
