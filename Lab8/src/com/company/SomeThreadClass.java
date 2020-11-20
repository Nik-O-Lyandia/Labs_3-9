package com.company;

public class SomeThreadClass extends Thread{
    public volatile double pi = 0;

    @Override
    public void run() {
        int count = 0;
        double localPi = 0;


        for(int i = 0; i < 1_000_000; i++) { // 1 billion
            double x = Math.random();
            double y = Math.random();

            if(x*x + y*y <= 1) {
                count++;
            }
        }
        pi += count / 1_000_000.;

    }

}
