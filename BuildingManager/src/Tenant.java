/**
 * Building Management System Tenant class.
 * @author  Joshua Gregory (Feb 2025)
 */
public class Tenant {
    public String name;
    public int age;
    public double rent;

    // CONSTRUCTOR
    public Tenant(String newName, int newAge, double newRent) {
        this.name = newName;
        this.age = newAge;
        this.rent = newRent;
    }

    // GETTERS & SETTERS
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public double getRent() {
        return this.rent;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setRent(double rent) {
        this.rent = rent;
    }

    // toString() to print tenant data
    @Override
    public String toString() {
        String x = this.name;
        String y = Integer.toString(this.age);
        String z = String.format("%.2f", this.rent);

        return x + " (" + y + ") | $" + z + "/mo";
    }
}
