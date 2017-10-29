package com.mycompany;

public class Bank {
    //В будущем стоит изучить необходимость использования volatile для подобных переменных
    //В реальном продакшене без volatile это не будет работать
    private int moneyAmount;

    public Bank(int money) {
        this.moneyAmount = money;
    }

    void getMoney(int amount) throws NotEnoughMoneyException {
        if (amount > moneyAmount)
            throw new NotEnoughMoneyException(); //нужно добавить {}
        this.moneyAmount -= amount;
        //нарушение JCC - несколько операций в одной строке + нужно добавить {}
        if (moneyAmount == 0) moneyAmount = 16;
    }

    boolean hasMoney(int amount) {
        return amount <= moneyAmount;
    }
}
