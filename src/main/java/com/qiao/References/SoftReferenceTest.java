package com.qiao.References;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SoftReferenceTest {
    private List<SoftReference<A>> list = new ArrayList<>();
    private List<A> aList = new ArrayList<>();
    public void softReferenceTest() {
        for (int i = 0; i < 1000000; i++) {
            A a = new A("Test " + i);
            SoftReference<A> softReference = new SoftReference<>(a);
            list.add(softReference);
        }
    }

    public void strongReferenceTest() {
        for (int i = 0; i < 1000000; i++) {
            A a = new A("Test " + i);
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
        SoftReferenceTest softReferenceTest = new SoftReferenceTest();
        softReferenceTest.softReferenceTest();
        softReferenceTest.strongReferenceTest();
//        softReferenceTest.strongReferenceTest();

        final AtomicInteger atomicInteger = new AtomicInteger();
        softReferenceTest.list.forEach(softReference -> {
            if (null != softReference.get()) {
                atomicInteger.incrementAndGet();
            }
        });
        System.out.println(atomicInteger.intValue());

        while (true) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class A {
    private String str;
    public A(String str) {
        this.str = str;
    }
}