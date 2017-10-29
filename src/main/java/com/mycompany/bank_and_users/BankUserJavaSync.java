package com.mycompany.bank_and_users;

public class BankUserJavaSync implements Runnable {

    private final Bank bank;
    private int moneyToTake;

    public BankUserJavaSync(Bank bank, int moneyToTake) {
        this.bank = bank;
        this.moneyToTake = moneyToTake;
    }

    public void run() {
        try {
            while (true) {
                synchronized (bank) {
                    if (bank.hasMoney(moneyToTake)) {
                        bank.getMoney(moneyToTake);
                    }
                }
            }
        } catch (NotEnoughMoneyException e) {
            System.out.println(e);
        }
    }
}
