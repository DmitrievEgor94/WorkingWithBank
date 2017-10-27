package com.mycompany;

public class NotEnoughMoneyException extends Exception {
   public NotEnoughMoneyException(){
       super("Not enough money in bank!");
   }
}
