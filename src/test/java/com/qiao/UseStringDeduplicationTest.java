package com.qiao;

import java.util.ArrayList;
import java.util.List;

public class UseStringDeduplicationTest {
    private static List<String> list = new ArrayList<>();
    // -XX:+UseG1GC -XX:+UseStringDeduplication -XX:+PrintStringDeduplicationStatistics
    public static void main(String[] args) throws InterruptedException {
        int iteration = 0;
        while (iteration < 5) {
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    list.add(new String("String " + j));
                }
            }
            iteration++;
            System.out.println("Survived Iteration: " + iteration);
            Thread.sleep(100);
        }

        while (true) {
            Thread.sleep(10000);
        }
    }
}
