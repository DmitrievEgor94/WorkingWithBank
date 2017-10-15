package notusingconcurrentpackage;

public class NotEnoughMoneyException extends Exception {
    @Override
    public String toString() {
        return "Not enough money in bank.";
    }
}
