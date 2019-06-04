package com.qiao.References;

        import java.lang.ref.PhantomReference;
        import java.lang.ref.ReferenceQueue;
        import java.lang.ref.WeakReference;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.concurrent.atomic.AtomicInteger;

public class PhantomReferenceTest {
    List<WeakReference<C>> weakReferenceList = new ArrayList<>();
    List<PhantomReference<C>> phantomReferencesList = new ArrayList<>();

    public void weakReferenceTest() {
        for (int i = 0; i < 1000000; i++) {
            C c = new C("Test " + i);
            WeakReference<C> weakReference = new WeakReference<>(c);
            weakReferenceList.add(weakReference);
        }
    }

    public void phantomReferenceTest() {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        for (int i = 0; i < 1000000; i++) {
            C c = new C("Test " + i);
            PhantomReference<C> phantomReferenceC = new PhantomReference<>(c, referenceQueue);
            phantomReferencesList.add(phantomReferenceC);
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

        PhantomReferenceTest phantomReferenceTest = new PhantomReferenceTest();
        phantomReferenceTest.phantomReferenceTest();
        phantomReferenceTest.weakReferenceTest();

        final AtomicInteger weakReferenceCount = new AtomicInteger();
        phantomReferenceTest.weakReferenceList.forEach(weakReference -> {
            if (null != weakReference.get()) {
                weakReferenceCount.incrementAndGet();
            }
        });
        System.out.println("weakReferenceCount = " + weakReferenceCount.intValue());

        final AtomicInteger phantomReferencesCount = new AtomicInteger();
        phantomReferenceTest.phantomReferencesList.forEach(phantomReference -> {
            if (null != phantomReference.get()) {
                phantomReferencesCount.incrementAndGet();
            }
        });
        System.out.println("phantomReferencesCount = " + phantomReferencesCount.intValue());


        while (true) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



class C {
    private String str;
    public C(String str) {
        this.str = str;
    }
}