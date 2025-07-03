/**
 * Fruit Stand Inventory Manager tracks prices & on-hands of apples & oranges.
 * @author Joshua Gregory (Jan. 2025)
 */
import java.util.Scanner;
public class FruitStandInventoryManager {
    private double applePrice, orangePrice, balance;
    private int appleOnHand, orangeOnHand;

    public FruitStandInventoryManager() {
        this.applePrice = 0.0;  // instantiate all fields at 0
        this.orangePrice = 0.0;
        this.balance = 0.0;
        this.appleOnHand = 0;
        this.orangeOnHand = 0;
    }

    public double getApplePrice() { return this.applePrice; }
    public double getOrangePrice() { return this.orangePrice; }
    public double getBalance() { return this.balance; }
    public int getAppleOnHand() {
        if (this.appleOnHand < 0)
            this.appleOnHand = 0;
        return this.appleOnHand;
    }
    public int getOrangeOnHand() {
        if (this.orangeOnHand < 0)
            this.orangeOnHand = 0;
        return this.orangeOnHand;
    }

    public void setApplePrice(double p) {
        this.applePrice = p;
        if (this.applePrice < 0)
            this.applePrice = 0.0;
    }
    public void setOrangePrice(double p) {
        this.orangePrice = p;
        if (this.orangePrice < 0)
            this.orangePrice = 0.0;
    }

    // SELL INVENTORY
    public String sellApple(int qty) {
        double total = (qty * this.applePrice);
        total = Math.round(total * 100.0 / 100.0);

        if (this.appleOnHand == 0)
            return "0 apples on-hand. Transaction canceled.";
        if (this.appleOnHand < qty) {
            int numSold = this.appleOnHand;
            this.appleOnHand -= qty;
            this.balance += total;
            return "Not enough apples on-hand. Sold " + numSold + ", earning $" + total + ". [Remaining apples on-hand: " + this.appleOnHand + ".]";
        }
        if (this.appleOnHand == qty) {
            this.appleOnHand -= qty;
            this.balance += total;
            return "Sold remaining " + qty + " apples, earning $" + total + ". [Remaining apples on-hand: " + this.appleOnHand + ".]";
        }
        this.appleOnHand -= qty;
        this.balance += total;
        return "Sold " + qty + " apples, earning $" + total + ". [Remaining apples on-hand: " + this.appleOnHand + ".]";
    }
    public String sellOrange(int qty) {
        double total = (qty * this.orangePrice);
        total = Math.round(total * 100.0 / 100.0);

        if (this.orangeOnHand == 0)
            return "0 oranges on-hand. Transaction canceled.";
        if (this.orangeOnHand < qty) {
            int numSold = this.orangeOnHand;
            this.orangeOnHand -= qty;
            this.balance += total;
            return "Not enough oranges on-hand. Sold " + numSold + " oranges, earning $" + total + ". [Remaining oranges on-hand: " + this.orangeOnHand + ".]";
        }
        if (this.orangeOnHand == qty) {
            this.orangeOnHand -= qty;
            this.balance += total;
            return "Sold remaining " + qty + " oranges, earning $" + total + ". [Remaining oranges on-hand: " + this.orangeOnHand + ".]";
        }
        this.orangeOnHand -= qty;
        this.balance += total;
        return "Sold " + qty + " oranges, earning $" + total + ". [Remaining oranges on-hand: " + this.orangeOnHand + ".]";
    }

    // BUY INVENTORY
    public String buyApple(int qty, double price) {
        double total = (qty * price);
        total = Math.round(total * 100.0) / 100.0;

        this.appleOnHand += qty;
        this.balance -= total;
        return "Bought " + qty + " apples for $" + price + " each, totalling $" + total + ". [Updated apples on-hand: " + this.appleOnHand + ".]";
    }
    public String buyOrange(int qty, double price) {
        double total = (qty * price);
        total = Math.round(total * 100.0) / 100.0;

        this.orangeOnHand += qty;
        this.balance -= total;
        return "Bought " + qty + " oranges for $" + price + " each, totalling $" + total + ". [Updated oranges on-hand: " + this.orangeOnHand + ".]";
    }
}
