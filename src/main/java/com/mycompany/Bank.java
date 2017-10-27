package com.mycompany;

public class Bank {

    private int moneyAmount;

    public Bank(int money) {
        this.moneyAmount = money;
    }

    void getMoney(int amount) throws NotEnoughMoneyException {
        if (amount > moneyAmount)
            throw new NotEnoughMoneyException();
        this.moneyAmount -= amount;
        if (moneyAmount == 0) moneyAmount = 16;
    }

    boolean hasMoney(int amount) {
        return amount <= moneyAmount;
    }
}
