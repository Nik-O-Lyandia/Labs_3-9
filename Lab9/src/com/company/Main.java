package com.company;

import java.util.ArrayList;

public class Main {

    private static int AccCount = 300;

    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        for(int i = 0; i < AccCount; i++) {
            bankAccounts.add(new BankAccount((int)(Math.random() * 1000)));
        }

        int allMoney = 0;
        for(int i = 0; i < AccCount; i++) {
            allMoney += bankAccounts.get(i).getMoney();
        }
        System.out.println("allMoney BEFORE transactions = " + allMoney);

        long tStart = System.nanoTime();    // getting start time

        ArrayList<Thread> tArr = new ArrayList<>();
        tArr.add(new Thread(new BankTransfer(bankAccounts.get((int)(Math.random() * AccCount)), bankAccounts.get((int)(Math.random() * AccCount)), (int)(Math.random() * 500))));

        tArr.get(0).start();
        for(int i = 1; i < 100000; i++) {
            tArr.add(new Thread(new BankTransfer(bankAccounts.get((int)(Math.random() * AccCount)), bankAccounts.get((int)(Math.random() * AccCount)), (int)(Math.random() * 500))));
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

        allMoney = 0;
        int getAll = 0;
        int setAll = 0;
        for(int i = 0; i < AccCount; i++) {
            allMoney += bankAccounts.get(i).getMoney();
//            getAll += bankAccounts.get(i).countGet;;
//            setAll += bankAccounts.get(i).countSet;
        }
//        System.out.println("getCount - " + getAll);
//        System.out.println("setCount - " + setAll);
        System.out.println("allMoney AFTER transactions = " + allMoney);
        System.out.println("TIME  = " + ((tEnd - tStart) / 1_000_000_000.) + " s");
        System.out.println("Main thread is ended...");
    }
}
