package com.qiao.memoryleaks.innerclass;

public class InnerClassWrapper {
    private BulkyObject bulkyObject = new BulkyObject();

    public class SimpleInnerClass {
        public void loopBulky() {
            System.out.println(bulkyObject);
        }
    }

}
