package com.qiao.dispatch;

public class StaticDispatch {
    static class Human{}
    static class Man extends Human {}
    static class Women extends Human {}

    public void sayHello(Human guy) {
        System.out.println("Human");
    }

    public void sayHello(Man guy) {
        System.out.println("Man");
    }

    public void sayHello(Women guy) {
        System.out.println("Women");
    }

    public static void main(String[] args) {
//        Human human = new Human();
        Human man = new Man();
        Human women = new Women();

        StaticDispatch staticDispatch = new StaticDispatch();
//        staticDispatch.sayHello(human);
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(women);
    }
}
