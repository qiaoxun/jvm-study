package com.qiao.References;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class WeakReferenceTest {
    public List<WeakReference<B>> list = new ArrayList<>();
    public List<SoftReference<B>> softList = new ArrayList<>();
    public List<B> aList = new ArrayList<>();

    public void weakReferenceTest() {
        for (int i = 0; i < 1000000; i++) {
            B a = new B("Test " + i);
            WeakReference<B> weakReference = new WeakReference<>(a);
            list.add(weakReference);
        }
    }

    public void softReferenceTest() {
        for (int i = 0; i < 1000000; i++) {
            B a = new B("Test " + i);
            SoftReference<B> softReference = new SoftReference<>(a);
            softList.add(softReference);
        }
    }

    public void strongReferenceTest() {
        for (int i = 0; i < 1000000; i++) {
            B a = new B("Test " + i);
            aList.add(a);
        }
    }

    // set max heap size to 180M to do the test
    // -Xmx180M
    public static void main(String args[]) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WeakReferenceTest weakReferenceTest = new WeakReferenceTest();
        weakReferenceTest.weakReferenceTest();
        weakReferenceTest.softReferenceTest();
//        weakReferenceTest.strongReferenceTest();

        final AtomicInteger weakReferenceCount = new AtomicInteger();
        weakReferenceTest.list.forEach(weakReference -> {
            if (null != weakReference.get()) {
                weakReferenceCount.incrementAndGet();
            }
        });
        System.out.println("weakReferenceCount = " + weakReferenceCount.intValue());


        final AtomicInteger softReferenceCount = new AtomicInteger();
        weakReferenceTest.softList.forEach(softReference -> {
            if (null != softReference.get()) {
                softReferenceCount.incrementAndGet();
            }
        });
        System.out.println("softReferenceCount = " + softReferenceCount.intValue());

        while (true) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B {
    private String str;
    public B(String str) {
        this.str = str;
    }
}
