package com.qiao;

import java.util.concurrent.atomic.AtomicInteger;

public class InnerClassTest {
    private static final String str = "Str";
    private final String str1 = "String1";

    static class InnerTest{
        public void getPrivateFieldOfOutterClass() {
            System.out.println(str);
        }
    }
}
