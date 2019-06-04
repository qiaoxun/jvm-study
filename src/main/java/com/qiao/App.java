package com.qiao;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( tableSizeFor(1024) );
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        String str = "12";
        System.out.println(str.hashCode());
        System.out.println(str.hashCode() & 15);
        System.out.println(str.hashCode() & 31);
    }


    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }
}
