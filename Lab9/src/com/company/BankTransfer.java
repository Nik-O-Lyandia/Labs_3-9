package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTransfer extends Thread{
    BankAccount from;
    BankAccount to;
    int count;
    Lock lock = new ReentrantLock();

    public BankTransfer(BankAccount from, BankAccount to, int count) {
        this.from = from;
        this.to = to;
        this.count = count;
    }

    @Override
    public void run() {
        transfer(from, to, count);
    }

    public void transfer(BankAccount from, BankAccount to, int count) {
        int moneyOnFrom = from.getMoney();
        if(count > moneyOnFrom) {
            count = moneyOnFrom;
        }
        moneyOnFrom -= count;
        from.setMoney(moneyOnFrom);
        to.setMoney(to.getMoney() + count);
    }

}
