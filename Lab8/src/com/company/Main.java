package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SomeThreadClass stc = new SomeThreadClass();
        Scanner scanner = new Scanner(System.in);
        String s;
        int threadCount = 0;


        do {
            System.out.print("Write number of threads (more then 1): ");
            s = scanner.nextLine();
            threadCount = Integer.valueOf(s);
        } while(threadCount < 1);

        long tStart = System.nanoTime();    // getting start time

        ArrayList<Thread> tArr = new ArrayList<>();
        tArr.add(new Thread(stc));
        tArr.get(0).start();
        for(int i = 1; i < threadCount; i++) {
            tArr.add(new Thread(stc));
            tArr.get(i).start();
        }


        try {
            for(Thread t : tArr) {
                t.join();
            }
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        long tEnd = System.nanoTime();  // getting end time

        System.out.println("PI = " + stc.pi / threadCount * 4);     // 3,14 159 265 358
        System.out.println("THREADS = " + threadCount);
        System.out.println("ITERATIONS  = " + 1_000_000 * threadCount);
        System.out.println("TIME  = " + ((tEnd - tStart) / 1_000_000_000.) + " s");
        System.out.println("Main thread is ended...");

    }
}
