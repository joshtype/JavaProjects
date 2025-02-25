/**
 * Building Management System Building class.
 * @author  Joshua Gregory (Feb 2025)
 */
public class Building {
    private Tenant[] apartments;    // for apt num & tenant data
    private static double balance;  // funds for building
    private static int nextId = 1;  // to update building ids
    private int id;                 // to assign to buildings


    // CONSTRUCTOR
    public Building(int aptCount) {
        this.apartments = new Tenant[aptCount];  // num apts in building
        this.id = nextId;  // assign to current building
        nextId++;          // increment for next building
    }

    // NEEDED GETTERS
    public static double getBalance() {
        return balance;
    }
    public int getId() {
        return this.id;
    }
    public Tenant getTenant(int aptNum) {
        if (aptNum >= 0 && aptNum < this.apartments.length) {
            return this.apartments[aptNum];
        }
        return null;
    }

    // HELPER METHODS
    public int countTenants() {
        int numTenants = 0;
        for (int i = 0; i < this.apartments.length; i++) {
            if (apartments[i] != null) {
                numTenants++;
            }
        }
        return numTenants;
    }

    public boolean addTenant(Tenant tenant, int aptNum) {
        if (aptNum >= 0 && aptNum < this.apartments.length &&
                this.apartments[aptNum] == null) {
            this.apartments[aptNum] = tenant;  // set idx to tenant
            return true;
        }
        return false;
    }

    public boolean removeTenant(int aptNum) {
        if (aptNum >= 0 && aptNum < this.apartments.length &&
                this.apartments[aptNum] != null) {
            this.apartments[aptNum] = null;  // set apt to empty
            return true;
        }
        return false;
    }

    public String listTenants() {
        String aptInfo = "";
        for (int i = 0; i < this.apartments.length; i++) {
            if (this.apartments[i] != null) {
                aptInfo += "Apartment " + i + ": " + this.apartments[i].toString() + "\n";
            } else {
                aptInfo += "Apartment " + i + ": empty\n";
            }
        }
        return aptInfo;
    }

    public static void collectRent(Tenant tenant) {
        balance += tenant.rent;
    }

    public static void payForService(double bill) {
        balance -= bill;
    }
}
