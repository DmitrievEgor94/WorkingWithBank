package usingconcurrentpackage;

import java.util.concurrent.Semaphore;

public class BankUser implements Runnable {

    private int id;
    private Bank bank;
    private int moneyToTake;
    private static final Semaphore SEMAPHORE = new Semaphore(1, true);

    public void run() {
        try {
            for (; ; ) {
                SEMAPHORE.acquire();
                if (bank.hasMoney(moneyToTake)) {
                    bank.getMoney(moneyToTake);
                  //  System.out.println(Thread.currentThread().getId()+" got money!");
                }
                SEMAPHORE.release();
            }
        } catch (NotEnoughMoneyException e) {
            System.out.println(e);
            System.exit(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    public BankUser(int id, Bank bank, int moneyToTake) {
        this.id = id;
        this.bank = bank;
        this.moneyToTake = moneyToTake;
    }
}
