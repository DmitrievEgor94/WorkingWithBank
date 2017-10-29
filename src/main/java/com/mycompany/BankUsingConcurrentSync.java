package com.mycompany;

import com.mycompany.bank_and_users.Bank;
import com.mycompany.bank_and_users.BankUserConcurrentSync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankUsingConcurrentSync {
    static private final int NUMBER_OF_USERS = 2;
    static private final int MONEY_TAKEN_BY_USES = 2;
    static private final int MONEY_OF_BANK = 16;

    static private void testingOfGettingCredits() {
        Bank bank = new Bank(MONEY_OF_BANK);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            executor.submit(new BankUserConcurrentSync(bank, MONEY_TAKEN_BY_USES));
        }
    }

    public static void main(String[] args) {
        testingOfGettingCredits();
    }
}
