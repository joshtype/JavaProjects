/**
 * Simple Bank App Account superclass.
 * @author Joshua Gregory (Feb 2025)
 */
public class Account {
    private static int nextNumber = 10001;
    private int accountNumber;
    private double accountBalance;

    // Overloaded constructors
    public Account() {
        this.accountNumber = nextNumber;
        nextNumber++;
        this.accountBalance = 0.0;
    }
    public Account(double balance) {
        this.accountNumber = nextNumber;
        nextNumber++;
        this.accountBalance = balance;
    }

    // Getters (no setters)
    public int getAccountNumber() {
        return this.accountNumber;
    }
    public double getAccountBalance() {
        return this.accountBalance;
    }

    // Superclass methods
    public double withdraw(double amount) {
        this.accountBalance -= amount;
        return this.getAccountBalance();
    }
    public double deposit(double amount) {
        this.accountBalance += amount;
        return this.getAccountBalance();
    }

    @Override
    public String toString() {
        return "Account #" + this.getAccountNumber() + " current balance is $" + this.getAccountBalance() + ".";
    }

}
