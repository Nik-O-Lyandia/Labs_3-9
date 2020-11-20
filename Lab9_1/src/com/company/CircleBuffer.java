package com.company;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CircleBuffer {
    private volatile LinkedList<String> ll = new LinkedList<>();
    private int capacity;
    private int count = 0;
    private int takeElementIndex = 0;  //where peek next element
    private int putElementIndex = 0;   //where put next element
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    public CircleBuffer(int capacity) {
        this.capacity = capacity;
    }

    public void put(String str) throws InterruptedException {
        lock.lock();
        try {
            while (count == capacity)
                notFull.await();
            if (ll.size() < capacity) {
                ll.add(str);
            } else {
                ll.set(putElementIndex, str);
            }
            if (++putElementIndex == capacity) {
                putElementIndex = 0;
            }
            count++;
            notEmpty.signal();
        } finally { lock.unlock(); }
    }

    public String take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            String x = ll.get(takeElementIndex);
            if (++takeElementIndex == capacity) takeElementIndex = 0;
            --count;
            notFull.signal();
            return x;
        } finally { lock.unlock(); }
    }

    public int getSize() {
        return ll.size();
    }
}
