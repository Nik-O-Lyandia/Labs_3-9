package com.company;

public class Prod_Cons {
    volatile CircleBuffer cb1 ;
    volatile CircleBuffer cb2 ;
    volatile int rowCount = 0;

    public Prod_Cons(CircleBuffer buffer1, CircleBuffer buffer2) {
        cb1 = buffer1;
        cb2 = buffer2;
    }

    public synchronized void producer() {

        try {
            rowCount++;

            cb1.put("Потік № " + Thread.currentThread().getName() + " згенерував повідомлення '" + Integer.toString(rowCount) + "'");

        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    public void consumer() {
        String str = "";
        try {
            str = "Потік № " + Thread.currentThread().getName() + " переклав повідомлення '" + cb1.take() + "'";
            cb2.put(str);

        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
