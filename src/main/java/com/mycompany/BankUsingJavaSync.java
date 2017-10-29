package com.mycompany;

import com.mycompany.bank_and_users.Bank;
import com.mycompany.bank_and_users.BankUserJavaSync;

public class BankUsingJavaSync {

    static private final int NUMBER_OF_USERS = 2;
    static private final int MONEY_TAKEN_BY_USES = 2;
    static private final int MONEY_OF_BANK = 16;

    static private void testingOfGettingCredits() {
        Bank bank = new Bank(MONEY_OF_BANK);

        Thread[] threads = new Thread[NUMBER_OF_USERS];

        for (Thread thread : threads) {
            thread = new Thread(new BankUserJavaSync(bank, MONEY_TAKEN_BY_USES));
            thread.start();
        }
    }

    public static void main(String[] args) {
        testingOfGettingCredits();
    }
}
