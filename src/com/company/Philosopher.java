package com.company;

import java.util.Random;

public class Philosopher {

    private final int id;
    private final ForkPool fp;
    private final String name;

    public Philosopher(String name, int id, ForkPool fp) {
        this.name = name;
        this.id = id;
        this.fp = fp;
    }

    public void startEating() {
        Thread t = new Thread(new Eat());
        t.start();
    }
    private class Eat implements Runnable {
        int count = 0;
        Random r = new Random();

        @Override
        public void run() {
            do {
                try {
                    int forkId = fp.getFork(id);
                    Thread.sleep(0, r.nextInt(100));
                    fp.returnFork(forkId);
                    Thread.sleep(0, r.nextInt(100));
                    count++;
                    //System.out.println("Eat = " + count);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                    return;
                }
            } while(count < 10000);

            System.out.printf("%s has finished eating\n", name);
        }
    }
}
