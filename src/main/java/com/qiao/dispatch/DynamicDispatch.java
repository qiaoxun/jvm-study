package com.qiao.dispatch;

public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human{
        @Override
        protected void sayHello() {
            System.out.println("Man");
        }
    }

    static class Women extends Human{
        @Override
        protected void sayHello() {
            System.out.println("Women");
        }
    }

    public static void main(String args[]) {
        Human man = new Man();
        man.sayHello();

        Human women = new Women();
        women.sayHello();
    }
}
