package com.mycompany;

public class BankUsing {

    //Все три поля должны быть private
    static final int numberOfThreads = 2;
    static int moneyTakenByUses = 2;
    static int moneyOfBank = 16;

    //Метод должен быть private
    static void testingOfGettingCredits() {
        Bank bank = new Bank(moneyOfBank);

        BankUser[] bankUsers = new BankUser[numberOfThreads];

        //Вместо этой устаревшей синтаксической конструкции предпочтительно использова for each для массивов
        for (int i = 0; i < bankUsers.length; i++) {
            //нехватает пробелов
            bankUsers[i] = new BankUser(i+1,bank, moneyTakenByUses);
        }

        Thread[] threads = new Thread[bankUsers.length];

        //Вместо этой устаревшей синтаксической конструкции предпочтительно использова for each для массивов
        for (int i = 0; i < bankUsers.length; i++) {
            threads[i] = new Thread(bankUsers[i]);
            threads[i].start();
        }
    }

    public static void main(String[] args) {
        testingOfGettingCredits();
    }
}
