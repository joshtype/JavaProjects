/**
 * Building Management System Driver file.
 * @author Joshua Gregory (Feb 2025)
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Driver {
    private static ArrayList<Building> buildings = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int choice;

    public static void main(String[] args){
        String menu = ("""
                \n1. Add New Building
                2. Remove Building
                3. List Buildings
                4. List Building Tenants
                5. Add New Tenant
                6. Remove Tenant
                7. Update Tenant
                8. Charge Rent
                9. Pay for Service(s)
                0. Quit AMS
                Enter menu selection: \s""");

        System.out.println("\n[ARM - Apartment Records Manager]");
        do {
            System.out.print(menu);
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("\nAdd New Building:");
                    addNewBuilding();
                    break;
                case 2:
                    System.out.println("\nRemove Building:");
                    removeBuilding();
                    break;
                case 3:
                    System.out.println("\nList Buildings: ");
                    listAllBuildings();
                    break;
                case 4:
                    System.out.println("\nList Building Tenants:");
                    listBuildingTenants();
                    break;
                case 5:
                    System.out.println("\nAdd New Tenant:");
                    addNewTenant();
                    break;
                case 6:
                    System.out.println("\nRemove Tenant:");
                    removeTenant();
                    break;
                case 7:
                    System.out.println("\nUpdate Tenant:");
                    updateTenantDetails();
                    break;
                case 8:
                    System.out.println("\nCharge Rent:");
                    chargeRent();
                    break;
                case 9:
                    System.out.println("\nPay for Service(s):");
                    payService();
                    break;
                case 0:
                    System.out.println("\nThanks for using AMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 0);
    }

    // HELPER METHODS
    public static void addNewBuilding() {
        // prompt for number of apartments in building to add
        System.out.print("Enter the number of apartments: ");
        int aptCount = scanner.nextInt();
        scanner.nextLine();  // clear line for next input

        // instantiate new building & add to arraylist
        Building building = new Building(aptCount);
        buildings.add(building);
    }
    public static void removeBuilding() {
        System.out.print("Enter the building id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // search arraylist for building with building.id == id
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id) {
                buildings.remove(i);  // remove ith building
                return;               // exit method
            }
        }
        System.out.println("No building exists with that ID.");
    }

    // CASE 3: list buildings with id & tenants count in arraylist
    public static void listAllBuildings() {
        for (int i = 0; i < buildings.size(); i++) {
            int buildingId = buildings.get(i).getId();
            int tenantCount = buildings.get(i).countTenants();
            System.out.println("Building " + buildingId + " currently has " + tenantCount + " tenants.");
        }
    }

    // CASE 4: list all tenants in a building
    public static void listBuildingTenants() {
        System.out.print("Enter the building id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id) {
                System.out.println(buildings.get(i).listTenants());
                return;
            }
        }
        System.out.println("No building exists with that ID.");
    }

    // CASE 5: add a new tenant to a building
    public static void addNewTenant() {
        System.out.print("Enter the building id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id) {
                System.out.println(buildings.get(i).listTenants());

                // prompt for tenant data
                System.out.print("Enter the tenant's name: ");
                String name = scanner.nextLine();

                System.out.print("Enter the tenant's age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter the tenant's rent: ");
                double rent = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Enter the apartment number: ");
                int aptNum = scanner.nextInt();
                scanner.nextLine();

                // create new tenant, call addTenant()
                Tenant tenant = new Tenant(name, age, rent);
                boolean added = buildings.get(i).addTenant(tenant, aptNum);  // call addTenant
                if (added) {
                    System.out.println("Tenant added.");
                } else {
                    System.out.println("Failed to add tenant. The apartment number is empty or invalid.");
                }
                return;
            }
        }
        System.out.println("No building exists with that ID.");
    }

    // CASE 6: remove tenant from an apt in a building
    public static void removeTenant() {
        System.out.print("Enter the building id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id) {
                System.out.println(buildings.get(i).listTenants());

                // prompt for apt number from which to remove tenant
                System.out.print("Enter the apartment number: ");
                int aptNum = scanner.nextInt();
                scanner.nextLine();

                // determine if removal was successful
                boolean removed = buildings.get(i).removeTenant(aptNum);
                if (removed) {
                    System.out.println("Tenant removed.");
                } else {
                    System.out.println("Failed to remove tenant. The apartment number is empty or invalid.");
                }
                return;
            }
        }
        // If no building with the specified ID is found, print a message
        System.out.println("No building exists with that ID.");
    }

    // CASE 7: update tenant's fields
    public static void updateTenantDetails() {
        System.out.print("Enter the building id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id) {
                System.out.println(buildings.get(i).listTenants());

                System.out.print("Enter the apartment number: ");
                int aptNum = scanner.nextInt();
                scanner.nextLine();

                // get existing tenant, prompt for & set new values
                Tenant currTenant = buildings.get(i).getTenant(aptNum);
                if (currTenant != null) {
                    System.out.print("Enter the tenant's new name: ");
                    String name = scanner.nextLine();
                    currTenant.setName(name);

                    System.out.print("Enter the tenant's new age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    currTenant.setAge(age);

                    System.out.print("Enter the tenant's new rent: ");
                    double rent = scanner.nextDouble();
                    scanner.nextLine();
                    currTenant.setRent(rent);

                    System.out.println("Tenant updated.");
                } else {
                    // apt is empty or apt number is invalid
                    System.out.println("Tenant not found. The apartment number is empty or invalid.");
                }
                return;
            }
        }
        System.out.println("No building exists with that ID.");
    }

    // CASE 8: charge rent
    public static void chargeRent() {
        System.out.print("Enter the building id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getId() == id) {
                System.out.println(buildings.get(i).listTenants());

                System.out.print("Enter the apartment number: ");
                int aptNum = scanner.nextInt();
                scanner.nextLine();

                // get tenant from apt num, call collectRent()
                Tenant currTenant = buildings.get(i).getTenant(aptNum);
                if (currTenant != null) {
                    Building.collectRent(currTenant);  // add rent to balance
                    System.out.println("Tenant charge. New balance is " + Building.getBalance());
                } else {
                    System.out.println("Tenant not found. The apartment number is empty or invalid.");
                }
                return;
            }
        }
        System.out.println("No building exists with that ID.");
    }

    // CASE 9: pay for service
    public static void payService() {
        System.out.println(Building.getBalance());  // current balance

        System.out.print("Enter the invoice amount for the service(s) performed. Example: '35.75' (do not include dollar sign): ");
        double bill = scanner.nextDouble();
        scanner.nextLine();

        Building.payForService(bill);
        System.out.println("Amount charged to balance. New balance: " + Building.getBalance());
    }
}
