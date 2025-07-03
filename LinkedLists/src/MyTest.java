/**
 * @author Joshua Gregory
 * @version June 2025
 * LinkedList.java driver file for integer linked list CRUD methods.
 */

import java.util.Scanner;
public class MyTest {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {
        LinkedList intLinkedList = new LinkedList();
        String menu = """
                \n---------MAIN-MENU---------
                  1 - Add first node
                  2 - Add last node
                  3 - Add at index
                  4 - Remove first node
                  5 - Remove last node
                  6 - Remove at index
                  7 - Print list size
                  8 - Print list forwards
                  9 - Print list reversed
                  10 - Exit program
                ---------------------------
                Enter option number:\s""";
        int choice;

        do {
            choice = getValidMenuChoice(menu);

            switch (choice) {
                case 1:  // add node to front of stack
                    helperAddFirst(intLinkedList);  // editing in-place via helpers for cleaner code
                    break;

                case 2:  // add node to end of stack
                    helperAddLast(intLinkedList);
                    break;

                case 3:  // add node at a user-defined index
                    helperAddAtIndex(intLinkedList);
                    break;

                case 4:  // remove node from front of stack
                    helperRemoveFirst(intLinkedList);
                    break;

                case 5:  // remove node from end of stack
                    helperRemoveLast(intLinkedList);
                    break;

                case 6:  // remove node from user input index
                    helperRemoveAtIndex(intLinkedList);
                    break;

                case 7:  // count & print size of linked list
                    helperPrintSize(intLinkedList);
                    break;

                case 8:  // print list starting at front node
                    helperPrintListForwards(intLinkedList);
                    break;

                case 9:  // recursively print list starting at end
                    helperReversePrintList(intLinkedList);
                    break;

                case 10:  // exit program
                    System.out.println("\nExiting program...");
                    scanner.close();
                    break;

                default: // if invalid input not handled by validation methods
                    System.out.println("ERROR: invalid input!");
                    scanner.nextLine();
            }
        } while (choice != 10);
    }

    // Helper method for menu option 1: add node to front of stack
    private static void helperAddFirst(LinkedList linkedList) {
        System.out.println("\n----ADD-FIRST-NODE----");

        // read & validate input for new node
        int newNode = validateNodeInput("Enter value of new first node: ");

        System.out.println("Adding value " + newNode + " as first node...");

        if (linkedList.getSize() == 0)  // if list was empty before adding
            System.out.print("List content before adding " + newNode + " is: empty");

        if (linkedList.getSize() > 0) {  // if list was nonempty before adding
            System.out.print("List content before adding value " + newNode + " is: ");
            linkedList.printList();
        }

        linkedList.addFirstNode(newNode);  // add node & print updated list

        System.out.print("\nList content after adding " + newNode + " is: ");
        linkedList.printList();
        System.out.print("\n");
    }

    // Helper method for menu option 2: add node to end of stack
    private static void helperAddLast(LinkedList linkedList) {
        System.out.println("\n----ADD-LAST-NODE----");

        int newNode = validateNodeInput("Enter value of new last node: ");

        System.out.println("Adding value " + newNode + " as last node...");

        if (linkedList.getSize() == 0)
            System.out.print("List content before adding " + newNode + " is: empty");

        if (linkedList.getSize() > 0) {
            System.out.print("List content before adding " + newNode + " is: ");
            linkedList.printList();
        }

        linkedList.addLastNode(newNode);

        System.out.print("\nList content after adding " + newNode + " is: ");
        linkedList.printList();
        System.out.print("\n");
    }

    // Helper method for menu option 3: add node at index
    private static void helperAddAtIndex(LinkedList linkedList) {
        System.out.println("\n----ADD-NODE-AT-INDEX----");

        int newNode = validateNodeInput("Enter value of new last node: ");
        int index = validateIndexInput("Enter index at which to add " + newNode + ": ", linkedList);

        System.out.println("Adding value " + newNode + " at index " + index + "...");

        if (linkedList.getSize() == 0)
            System.out.print("List content before adding " + newNode + " at index " + index + " is: empty");
        if (linkedList.getSize() > 0)
            System.out.print("List content before adding " + newNode + " at index " + index + " is: ");

        linkedList.addAtIndex(newNode, index);

        System.out.print("List content after adding " + newNode + " at index " + index + " is: ");
        linkedList.printList();
        System.out.print("\n");
    }

    // Helper method for menu option 4: remove first node
    private static void helperRemoveFirst(LinkedList linkedList) {
        System.out.println("\n----REMOVE-FIRST-NODE----");
        System.out.println("Removing first node...");

        if (linkedList.getSize() == 0)      // if list is empty
            linkedList.removeFirstNode();   // method handles output

        if (linkedList.getSize() > 0) {     // starting list is nonempty
            System.out.print("List content before removing first node is: ");
            linkedList.printList();         // print list

            linkedList.removeFirstNode();   // call class method

            if (linkedList.getSize() == 0)  // if updated list is empty
                System.out.println("List content after removing first node is: empty");

            if (linkedList.getSize() > 0) {  // if updated list is nonempty
                System.out.print("List content after removing first node is: ");
                linkedList.printList();
            }
        }
        System.out.print("\n");
    }

    // Helper method for menu option 5: remove last node
    private static void helperRemoveLast(LinkedList linkedList) {
        System.out.println("\n----REMOVE-LAST-NODE----");
        System.out.println("Removing last node...");

        if (linkedList.getSize() == 0)
            linkedList.removeLastNode();  // method includes check for empty lists

        if (linkedList.getSize() > 0) {
            System.out.print("List content before removing last node is: ");
            linkedList.printList();

            linkedList.removeLastNode();

            if (linkedList.getSize() == 0)
                System.out.println("List content after removing the last node is: empty");

            if (linkedList.getSize() > 0) {
                System.out.print("List content after removing last node is: ");
                linkedList.printList();
            }
        }
        System.out.print("\n");
    }

    // Helper method for menu option 6: remove node at index
    private static void helperRemoveAtIndex(LinkedList linkedList) {
        System.out.println("----REMOVE-NODE-AT-INDEX----");

        int index = validateIndexInput("Enter index from which to remove node: ", linkedList);
        System.out.println("Removing node from index " + index + "...");

        if (linkedList.getSize() == 0)
            linkedList.removeNodeAtIndex(index);

        if (linkedList.getSize() > 0) {
            System.out.print("List content before removing node at index " + index + " is: ");
            linkedList.printList();

            linkedList.removeNodeAtIndex(index);

            if (linkedList.getSize() == 0)
                System.out.println("List content after removing node at index " + index + " is: empty");
            else {
                System.out.print("List content after removing node at index " + index + " is: ");
                linkedList.printList();
            }
        }
        System.out.print("\n");
    }

    // Helper method for menu option 7: printing list size
    private static void helperPrintSize(LinkedList linkedList) {
        System.out.println("\n----PRINT-LIST-SIZE----");
        System.out.println("Linked list contains " + linkedList.getSize() + " value(s)");
    }

    // Helper method for menu option 8: printing list front to back
    private static void helperPrintListForwards(LinkedList linkedList) {
        System.out.println("\n----PRINT-LIST-FORWARDS----");

        System.out.print("List contains the following value(s), from first index to last: ");
        linkedList.printList();

        System.out.print("\n");
    }

    // Helper method for menu option 9: recursively printing list back to front
    private static void helperReversePrintList(LinkedList linkedList) {
        System.out.println("\n----PRINT-LIST-IN-REVERSE----");

        System.out.print("List contains the following value(s), from last index to first: ");
        linkedList.printReverse();

        System.out.print("\n");
    }

    // Helper method to validate inputs for menu choices
    private static int getValidMenuChoice(String prompt) {
        int choice;

        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume remaining line

                if (choice >= 1 && choice <= 10)
                    return choice;
                else
                    System.out.println("ERROR: Menu choice must be between 1 and 10!");

            } else {
                System.out.println("ERROR: Menu choice must be a number!");
                scanner.nextLine();
            }
        }
    }

    // Helper method to read & validate inputs for new nodes
    private static int validateNodeInput(String prompt) {
        int newNode;

        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                newNode = scanner.nextInt();
                scanner.nextLine();
                return newNode;

            } else {
                System.out.println("ERROR: Node values must be an integer!\n");
                scanner.nextLine();
            }
        }
    }

    // Helper method to read & validate inputs for linked list indices
    private static int validateIndexInput(String prompt, LinkedList linkedList) {
        int index;

        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                scanner.nextLine();

                if (index >= 0 && index < linkedList.getSize())
                    return index;
                else
                    System.out.println("ERROR: Index out of range! Please enter a valid index.");

            } else {
                System.out.println("ERROR: Index must be an integer!");
                scanner.nextLine();
            }
        }
    }
}
