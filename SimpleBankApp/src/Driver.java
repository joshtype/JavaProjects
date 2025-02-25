/**
 * Simple Bank App Driver file.
 * @author Joshua Gregory (Feb 2025)
 */
import java.util.Scanner;
public class Driver {
    private static Checking checking = new Checking(0.0);
    private static Saving saving = new Saving(500.0);
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;

    // ui
    public static void main(String[] args) {
        String menu = ("""
                \n[Simple Bank Main Menu]
                1. Withdraw from Checking Account
                2. Withdraw from Saving Account
                3. Deposit to Checking Account
                4. Deposit to Saving Account
                5. Balance of Checking Account
                6. Balance of Saving Account
                7. Award Interest to Saving Account
                8. Quit
                Enter a menu option:\s""");

        do {
            System.out.print(menu);

            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("\nInvalid input. Please enter a valid menu option.");
                System.out.print(menu);
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    withdrawChecking();
                    break;
                case 2:
                    withdrawSaving();
                    break;
                case 3:
                    depositChecking();
                    break;
                case 4:
                    depositSaving();
                    break;
                case 5:
                    balanceChecking();
                    break;
                case 6:
                    balanceSaving();
                    break;
                case 7:
                    awardInterest();
                    break;
                case 8:
                    System.out.println("\nExiting Simple Bank...");
                    break;
                default:
                    System.out.println("\nInvalid input. Please enter a valid menu option.");
                    break;
            }
        } while (choice != 8);
    }

    // CASE 1
    public static void withdrawChecking() {
        System.out.println("\n[Withdraw from Checking Account]");
        System.out.print("How much would you like to withdraw from your Checking account? $");

        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Current Checking account balance is $" + checking.withdraw(amount));
    }

    // CASE 2
    public static void withdrawSaving() {
        System.out.println("\n[Withdraw from Saving Account]");
        System.out.print("How much would you like to withdraw from your Saving account? $");

        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Current Saving account balance is $" + saving.withdraw(amount));
    }

    // CASE 3
    public static void depositChecking() {
        System.out.println("\n[Deposit to Checking Account]");
        System.out.print("How much would you like to deposit to your Checking account? $");

        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Current Checking account balance is $" + checking.deposit(amount));
    }

    // CASE 4
    public static void depositSaving() {
        System.out.println("\n[Deposit to Saving Account]");
        System.out.print("How much would you like to deposit to your Saving account? $");

        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Current Saving account balance is $" + saving.deposit(amount));
    }

    // CASE 5
    public static void balanceChecking() {
        System.out.println("\n[Balance of Checking Account]");
        System.out.println(checking.toString());
    }

    // CASE 6
    public static void balanceSaving() {
        System.out.println("\n[Balance of Saving Account]");
        System.out.println(saving.toString());
    }

    // CASE 7
    public static void awardInterest() {
        System.out.println("\n[Award Interest to Saving Account]");
        System.out.println("Current saving balance is $" + saving.addInterest());
    }
}
