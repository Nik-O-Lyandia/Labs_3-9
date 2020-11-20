package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int money;
    Lock lock = new ReentrantLock();
    int countGet = 0;
    int countSet = 0;

    public BankAccount() {};

    public BankAccount(int money) {
        this.money = money;
    }

    public void setMoney(int money) {
        lock.lock();
        this.money = money;
        countSet++;
        lock.unlock();
    }

    public int getMoney() {
        lock.lock();
        try {
            countGet++;
            return money;
        } finally {
            lock.unlock();
        }
    }
}
