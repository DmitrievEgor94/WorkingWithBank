package com.mycompany.bank_and_users;

class NotEnoughMoneyException extends Exception {
    NotEnoughMoneyException() {
        super("Not enough money in bank!");
    }
}
