package com.company;

import java.math.BigInteger;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;

public class Lab1{

    public static void Zad1(){
        long startTime;
        long estTime;

        startTime = System.nanoTime();
        int[] tab1 = new int[1000000];
        for(int i=0;i<1000000;i++){
            tab1[i]=i;
        }
        estTime = System.nanoTime() - startTime;
        System.out.println("a: " + estTime);

        startTime = System.nanoTime();
        ArrayList<Integer> tab2 = new ArrayList<>();
        for(int i=0;i<1000000;i++){
            tab2.add(i);
        }
        estTime = System.nanoTime() - startTime;
        System.out.println("b: " + estTime);

        startTime = System.nanoTime();
        ArrayList<Integer> tab3 = new ArrayList<>(1000000);
        for(int i=0;i<1000000;i++){
            tab3.add(i);
        }
        estTime = System.nanoTime() - startTime;
        System.out.println("c: " + estTime);

        startTime = System.nanoTime();
        LinkedList<Integer> tab4 = new LinkedList<>();
        for(int i=0;i<1000000;i++){
            tab3.add(i);
        }
        estTime = System.nanoTime() - startTime;
        System.out.println("d: " + estTime);
    }

    public static void Zad2(){
        long startTime;
        long estTime;


        startTime = System.nanoTime();
        BigInteger n = BigInteger.valueOf(5);
        BigInteger s = BigInteger.valueOf(1);
        for(BigInteger i = BigInteger.valueOf(1); i.compareTo(n)<=0; i=i.add(BigInteger.valueOf(1))){
            s=s.multiply(i);
        }
        estTime = System.nanoTime() - startTime;
        System.out.println(s);
    }

    public static void Zad3(){

    }


}
