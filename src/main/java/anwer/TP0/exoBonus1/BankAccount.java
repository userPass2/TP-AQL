package anwer.TP0.exoBonus1;

public class BankAccount {

    private double balance;
    private double interestRate;

    public BankAccount(double balance, double interestRate) {
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance must be positive");
        }
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate must be positive");
        }
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > Double.MAX_VALUE - balance) {
            throw new ArithmeticException("Deposit would cause balance overflow");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
    }

    public void transfer(double amount, BankAccount other) {
        if (other == null) {
            throw new NullPointerException("Other account must not be null");
        }
        withdraw(amount);
        try {
            other.deposit(amount);
        } catch (Exception e) {
            // Rollback the withdrawal if deposit fails
            balance += amount;
            throw e;
        }
    }

    public void addInterest() {
        if (interestRate > Double.MAX_VALUE / balance - 1) {
            throw new ArithmeticException("Interest calculation would cause overflow");
        }
        balance = balance * (1 + interestRate);
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }
}