/**
 * Simple Bank App Checking subclass.
 * Rules: account starts at $0, has unlimited deposits, has free
 * withdrawals, earns no interest, and can incur overdraft fees,
 * if balance < 0 then a $20 fee is charged per withdrawal.
 * @author Joshua Gregory (Feb 2025)
 */
public class Checking extends Account {
    // Inherits nextNumber, accountNumber, accountBalance, getters

    // Subclass constructor
    public Checking(double balance) {
        super(balance);  // pass arg to super constructor
    }

    // Subclass methods (inherits deposit() as is)
    @Override
    public double withdraw(double amount) {
        double newBalance = super.withdraw(amount);
        if (newBalance < 0.0) {
            // check for overdraft fee
            System.out.println("Charging $20 overdraft fee because balance has fallen below $0.00");
            newBalance = super.withdraw(20.0);
        }
        return newBalance;
    }

    @Override
    public String toString() {
        return "Checking account #" + this.getAccountNumber() + " current balance is $" + this.getAccountBalance() + ".";
    }

}
