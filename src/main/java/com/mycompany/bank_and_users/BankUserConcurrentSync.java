package com.mycompany.bank_and_users;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankUserConcurrentSync implements Runnable {
    private final Bank bank;
    private int moneyToTake;
    private final static Lock lock = new ReentrantLock();

    public BankUserConcurrentSync(Bank bank, int moneyToTake) {
        this.bank = bank;
        this.moneyToTake = moneyToTake;
    }

    public void run() {
        try {
            while (true) {
                lock.lock();
                try {
                    if (bank.hasMoney(moneyToTake)) {
                        bank.getMoney(moneyToTake);
                    }
                } finally {
                    lock.unlock();
                }
            }
        } catch (NotEnoughMoneyException e) {
            System.out.println(e);
        }
    }
}
