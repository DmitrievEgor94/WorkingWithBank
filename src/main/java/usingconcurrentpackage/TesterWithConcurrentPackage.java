package usingconcurrentpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TesterWithConcurrentPackage {
    static int numberOfThreads = 2;
    static int moneyTakenByUses = 1;
    static int moneyOfBank = 16;

    static void testingOfGettingCredits() {
        Bank bank = new Bank(moneyOfBank);

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executor.submit(new BankUser(i+1,bank, moneyTakenByUses));
        }
    }

    public static void main(String[] args) {
        testingOfGettingCredits();
    }
}
