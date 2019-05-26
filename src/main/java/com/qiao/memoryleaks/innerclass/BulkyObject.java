package com.qiao.memoryleaks.innerclass;

import java.nio.charset.Charset;
import java.util.Random;

public class BulkyObject {
    private String data[];
    public BulkyObject() {
        data = new String[1000000];
        for (int i= 0; i < 100000; i++) {
            data[i] = getRandomString();
        }
    }

    private String getRandomString() {
        byte[] array = new byte[1000];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}
