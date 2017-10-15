package notusingconcurrentpackage;

public class TesterWithoutConcurrentPackage {

    static final int numberOfThreads = 2;
    static int moneyTakenByUses = 2;
    static int moneyOfBank = 16;

    static void testingOfGettingCredits() {
        Bank bank = new Bank(moneyOfBank);

        BankUser[] bankUsers = new BankUser[numberOfThreads];

        for (int i = 0; i < bankUsers.length; i++) {
            bankUsers[i] = new BankUser(i+1,bank, moneyTakenByUses);
        }

        Thread[] threads = new Thread[bankUsers.length];

        for (int i = 0; i < bankUsers.length; i++) {
            threads[i] = new Thread(bankUsers[i]);
            threads[i].start();
        }
    }

    public static void main(String[] args) {
        testingOfGettingCredits();
    }
}
