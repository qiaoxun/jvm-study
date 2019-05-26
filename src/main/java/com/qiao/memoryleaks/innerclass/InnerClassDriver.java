package com.qiao.memoryleaks.innerclass;

public class InnerClassDriver {

    public static void main(String args[]) {
//        new InnerClassWrapper().new SimpleInnerClass();
//        InnerClassWrapper.SimpleInnerClass simpleInnerClass = new InnerClassWrapper().new SimpleInnerClass();
        new InnerClassWrapper().new SimpleInnerClass().loopBulky();
        System.out.println("over");
        while (true) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * static inner class test, cause static inner class do not need create a instance of wrapper class,
     * @param args
     */
    public static void main2(String args[]) {
//        StaticInnerClassWrapper.SimpleInnerClass simpleInnerClass = new StaticInnerClassWrapper.SimpleInnerClass();

        StaticInnerClassWrapper staticInnerClassWrapper = new StaticInnerClassWrapper();
        StaticInnerClassWrapper.SimpleInnerClass simpleInnerClass = new StaticInnerClassWrapper.SimpleInnerClass(staticInnerClassWrapper);
        simpleInnerClass.loopBulky();
        System.out.println("over");
        simpleInnerClass = null;
        while (true) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
