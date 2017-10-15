package notusingconcurrentpackage;

public class Bank {

    private int maxMoney;
    private int moneyAmount;

    public Bank(int money) {
        maxMoney = money;
        this.moneyAmount = money;
    }

    void getMoney(int amount) throws NotEnoughMoneyException {
        if (amount > moneyAmount)
            throw new NotEnoughMoneyException();
        this.moneyAmount -= amount;
        if (moneyAmount == 0) moneyAmount = 16;
    }

    boolean hasMoney(int amount) {
        return amount <= moneyAmount;
    }
}
