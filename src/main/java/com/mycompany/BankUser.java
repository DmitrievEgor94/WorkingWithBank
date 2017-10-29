package com.mycompany;

public class BankUser implements Runnable {
    //Неиспользуемое поле
    private int id;
    //Критическая ошибка - поле должно быть final
    private Bank bank;
    private int moneyToTake;

    public void run() {
        try {
            //в таких случаях нужно использовать while(true)
            //нарушение code style - добавить {}
            for (; ; )
                synchronized (bank) {
                    if (bank.hasMoney(moneyToTake)) {
                        bank.getMoney(moneyToTake);
                    }
                }
        } catch (NotEnoughMoneyException e) {
            System.out.println(e);
            //Критическая ошибка - Нужно всеми силами избегать использования System.exit в коде.
            System.exit(1);
        }

    }

    //Нарушение JCC - конструктор должен находиться выше объявления методов
    public BankUser(int id, Bank bank, int moneyToTake) {
        this.id = id;
        this.bank = bank;
        this.moneyToTake = moneyToTake;
    }
}
