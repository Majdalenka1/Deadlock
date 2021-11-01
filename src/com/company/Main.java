package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ForkPool fp = new ForkPool();

        List<Philosopher> philosophers = new ArrayList<>();
        philosophers.add(new Philosopher("A", 0, fp)); //1
        philosophers.add(new Philosopher("B", 1, fp)); //2
        philosophers.add(new Philosopher("C", 2, fp)); //3
        philosophers.add(new Philosopher("D", 3, fp)); //4
        philosophers.add(new Philosopher("E", 4, fp)); //5
        philosophers.add(new Philosopher("F", 5, fp)); //6
        philosophers.add(new Philosopher("G", 6, fp)); //7
        philosophers.add(new Philosopher("H", 7, fp)); //8
        philosophers.add(new Philosopher("J", 8, fp)); //9
        philosophers.add(new Philosopher("K", 9, fp)); //10

        for(Philosopher p: philosophers) {
            p.startEating();
        }

        // write your code here
    }
}
