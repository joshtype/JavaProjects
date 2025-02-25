/**
 * Simple Bank App Saving subclass.
 * Rules: account starts at $500, earns 1.5% interest annually,
 * if balance < 500 then a $10 fee is charged per withdrawal,
 * and a $10 fee is charged per deposit after the first five.
 * @author Joshua Gregory (Feb 2025)
 */
public class Saving extends Account {
    // Inherits nextNumber, accountNumber, accountBalance
    private int numberOfDeposits = 0;

    // Subclass constructor
    public Saving(double balance) {
        super(balance);  // pass arg to super constructor
    }

    // Getters & Setters (inherits Account getters)
    public int getNumberOfDeposits() {
        return this.numberOfDeposits;
    }
    public void setNumberOfDeposits(int numberOfDeposits) {
        this.numberOfDeposits = numberOfDeposits;
    }

    // Subclass override methods
    @Override
    public double withdraw(double amount) {
        double newBalance = super.withdraw(amount);

        if (newBalance < 500.0) {
            // charge $20 fee if new balance < 500
            System.out.println("Charging $10 fee because balance has fallen below $500.");
            newBalance = super.withdraw(10.0);
        }
        return newBalance;
    }

    @Override
    public double deposit(double amount) {
        double newBalance = super.deposit(amount);
        this.numberOfDeposits++;
        System.out.println("This is deposit number " + this.numberOfDeposits + " to this account.");

        if (this.numberOfDeposits > 5) {
            // charge $10 fee if updated deposit number > 5
            System.out.println("Charging $10 fee because you have exceeded five deposits.");
            newBalance = super.deposit(10.0);
        }
        return newBalance;
    }

    @Override
    public String toString() {
        return "Saving account #" + this.getAccountNumber() + " current balance is $" + this.getAccountBalance() + ".";
    }

    // Subclass methods
    public double addInterest() {
        double interest = 0.015 * this.getAccountBalance();
        double newBalance = super.deposit(interest);
        System.out.println("Customer earned $" + interest + " in interest.");
        return newBalance;
    }
}
