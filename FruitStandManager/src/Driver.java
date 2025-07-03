/**
 * Driver file for FuitStandInventoryManager.java.
 * @author Joshua Gregory (Jan. 2025)
 */
import java.util.Scanner;
public class Driver {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FruitStandInventoryManager inventoryManager = new FruitStandInventoryManager();
        String menu = """
                \n[Apples & Oranges Inventory System]
                1. Buy apples
                2. Buy oranges
                3. Sell apples
                4. Sell oranges
                5. Set apple price
                6. Set orange price
                7. Inventory report
                8. Balance report
                9. Exit
                Enter a menu option: \s""";
        int choice;

        do {
            System.out.print(menu);

            // validate input for choice
            while (!scanner.hasNextInt()) {
                System.out.println("\nInvalid input. Enter a valid menu option.");
                scanner.nextLine();
                System.out.print(menu);
            }
            choice = scanner.nextInt();

            while (choice < 1 || choice > 9) {
                System.out.println("\nInvalid input. Enter a valid menu option.");
                scanner.nextLine();
                System.out.print(menu);

                while (!scanner.hasNextInt()) {
                    System.out.println("\nInvalid input. Please enter a valid menu option.");
                    scanner.nextLine();
                    System.out.print(menu);
                }
                choice = scanner.nextInt();
            }

            switch (choice) {
                case 1:
                    System.out.println("\n[Buy Apples]");
                    inventoryManager = buyApplesCase1(inventoryManager);
                    break;

                case 2:
                    System.out.println("\n[Buy Oranges]");
                    inventoryManager = buyOrangesCase2(inventoryManager);
                    break;

                case 3:
                    System.out.println("\n[Sell Apples]");

                    break;

                case 4:
                    System.out.println("\n[Sell Oranges]");

                    break;

                case 5:
                    System.out.println("\n[Set Apple Price]");

                    break;

                case 6:
                    System.out.println("\n[Set Orange Price]");

                    break;

                case 7:
                    System.out.println("\n[Inventory Report]");

                    break;

                case 8:
                    System.out.println("\n[Balance Report]");

                    break;

                case 9:
                    System.out.println("\nShutting down...");
                    break;

                default:
                    System.out.println("\nInvaid input. Enter a valid menu option.");
                    break;
            }

        } while (choice != 9);
    }

    // HELPER METHODS
    public static FruitStandInventoryManager buyApplesCase1(FruitStandInventoryManager invMgr) {
        System.out.println("Enter the quantity being purchased or 0 for the menu:");

        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a positive integer: ");
            scanner.nextLine();
        }

        int qty = scanner.nextInt();
        if (qty < 0) {
            System.out.print("Invalid input. Enter a postive integer: ");
            scanner.nextLine();
            qty = scanner.nextInt();
        }
        if (qty == 0) {
            System.out.println("Buying no apples.");
        }
        if (qty > 0) {
            System.out.print("Enter the price per apple: ");

            // buy price can be any number
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. Enter a postive number (eg, 0.99): ");
                scanner.nextLine();
            }
            double buyPrice = scanner.nextDouble();
            invMgr.buyApple(qty, buyPrice);
        }
        return invMgr;
    }

    public static FruitStandInventoryManager buyOrangesCase2(FruitStandInventoryManager invMgr) {
        System.out.println("Enter the quantity being purchased or 0 for the menu:");

        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a positive integer: ");
            scanner.nextLine();
        }

        int qty = scanner.nextInt();
        if (qty < 0) {
            System.out.print("Invalid input. Enter a postive integer: ");
            scanner.nextLine();
            qty = scanner.nextInt();
        }
        if (qty == 0) {
            System.out.println("Buying no oranges.");
        }
        if (qty > 0) {
            System.out.print("Enter the price per orange: ");

            // buy price can be any number
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. Enter a postive number (eg, 0.99): ");
                scanner.nextLine();
            }
            double buyPrice = scanner.nextDouble();
            invMgr.buyOrange(qty, buyPrice);
        }
        return invMgr;
    }

    public static FruitStandInventoryManager sellOrangesCase4(FruitStandInventoryManager invMgr) {
        System.out.println("Enter the quantity being sold or 0 for the menu:");

        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a positive integer: ");
            scanner.nextLine();
        }

        int qty = scanner.nextInt();
        if (qty < 0) {
            System.out.print("Invalid input. Enter a postive integer: ");
            scanner.nextLine();
            qty = scanner.nextInt();
        }

        if (qty == 0)
            System.out.println("Selling no oranges.");

        if (qty > 0) {
            System.out.print("Enter the selling price per orange: ");
            invMgr.sellOrange(qty);
        }
        return invMgr;
    }
}
