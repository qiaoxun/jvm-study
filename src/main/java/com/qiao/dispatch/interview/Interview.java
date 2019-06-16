package com.qiao.dispatch.interview;

public class Interview {
    public static void main(String[] args) {
        Human man = new Man();
        System.out.println(man.age);
        System.out.println(man.getAge());
    }
}

class Human {
    public int age = 30;

    int getAge() {
        return age;
    }
}

class Man extends Human {
    public int age = 40;

    int getAge() {
        return age;
    }
}