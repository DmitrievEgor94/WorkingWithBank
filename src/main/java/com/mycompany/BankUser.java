package com.mycompany;

public class BankUser implements Runnable {

    private int id;
    private Bank bank;
    private int moneyToTake;

    public void run() {
        try {
            for (; ; )
                synchronized (bank) {
                    if (bank.hasMoney(moneyToTake)) {
                        bank.getMoney(moneyToTake);
                    }
                }
        } catch (NotEnoughMoneyException e) {
            System.out.println(e);
            System.exit(1);
        }

    }

    public BankUser(int id, Bank bank, int moneyToTake) {
        this.id = id;
        this.bank = bank;
        this.moneyToTake = moneyToTake;
    }
}
