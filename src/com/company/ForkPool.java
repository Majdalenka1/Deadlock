package com.company;

import java.util.ArrayList;
import java.util.List;

public class ForkPool {
    private List<Integer> forks = new ArrayList<>();

    public ForkPool() {
        for(int i = 0; i < 10; i++){
            this.forks.add(i);
        }
    }

    public int getFork(int forkId) throws InterruptedException {
        synchronized (forks) {
            int leftHandId = forkId != 0 ? forkId-1 : forks.size() - 1;
            //my right hand fork is mine id, left is id-1, I need both
            if (forks.get(forkId) == null && forks.get(leftHandId) == null) {
                forks.wait();
            }
            forks.set(forkId, null);
            forks.set(leftHandId, null);
            //System.out.println("get " + forkId);
            return forkId;
        }
    }

    public void returnFork(int forkId) {
        synchronized (forks) {
            //System.out.println("return " + forkId);
            forks.set(forkId, forkId);
            int leftHandId = forkId != 0 ? forkId-1 : forks.size() - 1;
            forks.set(leftHandId, leftHandId);
            forks.notifyAll();
        }
    }
}
