/**
 * Phonebook Simulator Driver file.
 * @author Josh Gregory (Jan. 2025)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Phonebook {
    private static final Scanner scanner = new Scanner(System.in);
    private final ArrayList<String[]> phonebook;  // to hold contact arrays

    public Phonebook() {
        this.phonebook = new ArrayList<>();
    }

    // Store input name & number in contact array, store array in phonebook arraylist
    public void addContact() {
        System.out.println("\nAdd a contact...");
        String[] contact = new String[2];

        System.out.print("Enter the new contact's name (eg: 'Jane' or 'J. Smith'): ");
        contact[0] = scanner.nextLine();

        System.out.print("Enter the new contact's phone number with dashes (eg: '123-456-7890): ");
        contact[1] = scanner.next();

        this.phonebook.add(contact);
        System.out.println("Contact added.\n");
    }

    // Searches arrays in phonebook for input name & removes first occurrence found
    public void removeContact() {
        System.out.println("\nRemove a contact...");
        System.out.print("Enter the name of the contact to remove (eg: 'Jane' or 'J. Smith'): ");
        String name = scanner.nextLine();

        for (String[] contact : this.phonebook) {
            // check if each contact[0] matches input
            if (contact[0].equals(name)) {
                this.phonebook.remove(contact);  // remove 1st occurrence
                System.out.println("Contact deleted.\n");
                return;
            }
            System.out.println("No contact with that name.\n");
        }
    }

    // Prints each contact index in phonebook arraylist
    public void printPhonebook() {
        if (this.phonebook.isEmpty()) {
            // if phonebook is empty
            System.out.println("Your phonebook is empty.\n");
            return;  // exit method
        }

        for (String[] contact : this.phonebook) {
            // display each name & number, one per line
            System.out.println("Name: " + contact[0] + " | Phone: " + contact[1]);
        }
        System.out.println("Done listing all contacts.\n");
    }

    // Searches phonebook for input keyword, prints contacts that contain keyword
    public void searchPhonebook() {
        System.out.print("\nEnter a keyword to search for (eg: 'J' or '123-4'): ");
        String keyword = scanner.next();  // keyword implies a single token
        System.out.println("Searching all contacts for keyword...");

        if (this.phonebook.isEmpty()) {
            // if phonebook is empty
            System.out.println("No contacts contain the keyword because your phonebook is empty.\n");
            return;
        }

        ArrayList<String[]> contactsFound = new ArrayList<>();
        for (String[] contact : this.phonebook) {
            // add array to temp arraylist if either index contains keyword
            if (contact[0].contains(keyword) || contact[1].contains(keyword)) {
                contactsFound.add(contact);
            }
        }

        if (contactsFound.isEmpty()) {
            // if temp arraylist is empty, no keyword matches found
            System.out.println("No contacts contain the keyword.\n");
        } else {
            for (String[] eaContact : contactsFound) {
                // if not empty, print name | number of each contact
                System.out.println("Name: " + eaContact[0] + " | Phone: " + eaContact[1]);
            }
        }
        System.out.println("Done searching for keyword.\n");
    }

    // Driver
    public static void main(String[] args) {
        Phonebook myPhonebook = new Phonebook();
        String menu = ("""
                1. Add contact to phonebook
                2. Remove contact from phonebook
                3. List all contacts in phonebook
                4. Search phonebook by keyword
                5. Quit
                Enter an option:\s""");
        int choice;

        System.out.println("[Phonebook]");
        do {
            System.out.print(menu);

            while (!scanner.hasNextInt()) {
                scanner.next();  // consume input
                System.out.print("\nInvalid input. Must enter a number from the menu.\n" + menu);
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            while (choice < 1 || choice > 5) {
                System.out.print("\nInvalid input. Please choose a valid menu number to enter.\n" + menu);
                while(!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.print("\nInvalid input. Must enter a number from the menu.\n" + menu);
                }
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            switch (choice) {
                case 1:
                    // ADD A NEW CONTACT
                    myPhonebook.addContact();
                    break;
                case 2:
                    // REMOVE A CONTACT
                    myPhonebook.removeContact();
                    break;
                case 3:
                    // PRINT ALL CONTACTS
                    System.out.println("\nListing all contacts...");
                    myPhonebook.printPhonebook();
                    break;
                case 4:
                    // SEARCH PHONEBOOK BY KEYWORD
                    myPhonebook.searchPhonebook();
                    break;
                case 5:
                    // EXIT
                    System.out.println("\nShutting off...");
                    break;
            }
        } while (choice != 5);
    }
}
