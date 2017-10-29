package com.mycompany;

import com.mycompany.bank_and_users.Bank;
import com.mycompany.bank_and_users.BankUserJavaSync;

public class BankUsingJavaSync {

    static private final int NUMBER_OF_USERS = 2;
    static private final int MONEY_TAKEN_BY_USER = 2;
    static private final int MONEY_OF_BANK = 16;

    static private void testingOfGettingCredits() {
        Bank bank = new Bank(MONEY_OF_BANK);

        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            BankUserJavaSync bankUser = new BankUserJavaSync(bank, MONEY_TAKEN_BY_USER);
            Thread thread = new Thread(bankUser);
            thread.start();
        }
    }

    public static void main(String[] args) {
        testingOfGettingCredits();
    }
}
