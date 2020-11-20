package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        CircleBuffer cb1 = new CircleBuffer(4);
        CircleBuffer cb2 = new CircleBuffer(100);
        Prod_Cons pc = new Prod_Cons(cb1, cb2);

        Runnable runProducer = new Runnable() {
            @Override
            public void run() {
                while (true)
                    pc.producer();
            }
        };
        Runnable runConsumer = new Runnable() {
            @Override
            public void run() {
                while (true)
                    pc.consumer();
            }
        };
        Thread prod1 = new Thread(runProducer);
        Thread prod2 = new Thread(runProducer);
        Thread prod3 = new Thread(runProducer);
        Thread prod4 = new Thread(runProducer);
        Thread prod5 = new Thread(runProducer);

        Thread cons1 = new Thread(runConsumer);
        Thread cons2 = new Thread(runConsumer);

        prod1.setDaemon(true);
        prod2.setDaemon(true);
        prod3.setDaemon(true);
        prod4.setDaemon(true);
        prod5.setDaemon(true);

        cons1.setDaemon(true);
        cons2.setDaemon(true);

        prod1.start();
        prod2.start();
        prod3.start();
        prod4.start();
        prod5.start();

        cons1.start();
        cons2.start();


        int count = 0;
        try {
            while (count++ != 100)
                System.out.println(count + ") " + cb2.take());
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
