// Name:        Joshua Gregory
// Class:       CS3305/W03
// Term:        Summer 2025
// Instructor:  Prof. Wang
// Assignment:  #5
// IDE Name:    IntelliJ
// File:        Driver for testing user-defined generic priority-queue heaps from PQ_heap.java.

import java.util.Scanner;
public class TestPQH {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = """
                \n----------------MAIN MENU---------------
                0. Enter Queue Type (integer or string)
                1. Enqueue Element
                2. Dequeue Element
                3. Check is_full
                4. Check is_empty
                5. Print PQueue Size
                6. Display Front Element
                7. Print PQueue Elements
                8. Exit Program
                \nEnter option number:\s""";  // edited spelling of #3 & #4 to match method spelling in PQ_heap.java
        int choice;

        PQ_heap<?> pqHeap = new PQ_heap<>(); // create wildcard Heap object

        boolean typeSelected = false;  // flag for flow control forcing user to use option 0 before other options
        boolean isString = false;      // flag to ensure type-safe casting of PQ_heap object

        do {
            choice = getValidMenuInput(0, 8, menu);

            switch (choice) {
                case 0:  // enter queue type
                    System.out.println("Testing method 'Enter Queue Type (integer or string) (Option 0)'");
                    isString = getTypeInput();  // read & validate input for priority queue type

                    if (isString) {
                        pqHeap = new PQ_heap<String>();  // define heap as String priority queue
                    }
                    else {
                        pqHeap = new PQ_heap<Integer>();  // define heap as Integer priority queue
                    }
                    typeSelected = true; // set flag to true to allow further options
                    break;

                case 1:  // enqueue element
                    System.out.println("Testing method 'Enqueue Element' (Option 1)");

                    if (!typeSelected) {  // if flag = false then option 0 hasn't been used
                        System.out.println("ERROR: Queue type must first be selected using option 0.");
                        break;  // exit without executing option
                    }

                    enqueueValue(pqHeap, isString);  // read & validate input & add to queue
                    break;

                case 2:
                    System.out.println("Testing method 'Dequeue Element' (Option 2)");

                    if (!typeSelected) {
                        System.out.println("ERROR: Queue type must first be selected using option 0.");
                        break;
                    }

                    dequeueValue(pqHeap);
                    break;

                case 3:
                    System.out.println("Testing method 'Check is_full' (Option 3)");  // edited spelling of is_full to match PQ_heap.java method name

                    if (!typeSelected) {
                        System.out.println("ERROR: Queue type must first be selected using option 0.");
                        break;
                    }

                    checkIsFull(pqHeap);  // invokes PQ_heap.is_full()
                    break;

                case 4:
                    System.out.println("Testing method 'Check is_empty' (Option 4)");  // edited spelling of is_empty to match PQ_heap.java method name

                    if (!typeSelected) {
                        System.out.println("ERROR: Queue type must first be selected using option 0.");
                        break;
                    }

                    checkIsEmpty(pqHeap);  // invokes PQ_heap.is_empty()
                    break;

                case 5:
                    System.out.println("Testing method 'Print PQueue Size' (Option 5)");

                    if (!typeSelected) {
                        System.out.println("ERROR: Queue type must first be selected using option 0.");
                        break;
                    }

                    printHeapSize(pqHeap);  // invokes PQ_heap.size()
                    break;

                case 6:
                    System.out.println("Testing method 'Display Front Element' (Option 6)");

                    if (!typeSelected) {
                        System.out.println("ERROR: Queue type must first be selected using option 0.");
                        break;
                    }

                    printHeapFront(pqHeap);  // invokes PQ_heap.front()
                    break;

                case 7:
                    System.out.println("Testing method 'Print Queue Elements' (Option 7)");

                    if (!typeSelected) {
                        System.out.println("ERROR: Queue type must first be selected using option 0.");
                        break;
                    }

                    pqHeap.pqToString();  // invokes Heap.printHeap()
                    break;

                case 8:
                    System.out.println("Exiting program... Goodbye.");
                    scanner.close();
                    break;

                default:
                    System.out.println("INVALID INPUT ERROR: Acceptable input is an integer between 0 & 8.");
                    break;
            }
        } while (choice != 8);
    }

    /** Utility method for menu option 0. Prompts, reads, and validates string input to define queue type */
    private static boolean getTypeInput() {
        boolean isString = false;  // boolean flag to track queue type

        while (true) {  // prompt, validate input, confirm choice, define heap type
            System.out.print("\nEnter 'i' for an integer queue. Enter 's' for a string queue. Queue type: ");
            String type = scanner.nextLine().toLowerCase().trim();  // read string input as lower case & trimmed

            if (type.equals("i") || type.equals("integer")) {  // in case user enters full word
                System.out.println("Created integer queue.");
                break;
            }
            else if (type.equals("s") || type.equals("string")) {
                System.out.println("Created string queue.");
                isString = true;  // set flag to true
                break;
            }
            else {
                scanner.nextLine();  // clear newline & re-loop prompt
                System.out.println("INVALID INPUT ERROR: Acceptable input is 'i', 's', 'integer', or 'string'.");
            }
        }
        return isString;
    }

    /** Utility method for menu option 1 for either type priority queues. Invokes Heap.add() via PQ_heap.enqueue(). */
    private static void enqueueValue(PQ_heap<?> pqh, boolean isString) {
        if (isString) {
            PQ_heap<String> pqStr = (PQ_heap<String>) pqh;  // cast argument heap to string type

            while (true) {  // validate string input
                System.out.print("\nEnter string element to enqueue to priority queue: ");
                String element = scanner.nextLine().trim();

                if (!element.isEmpty()) {
                    pqStr.enqueue(element);  // add input to queue or prints "Priority Queue is Full"
                    break;
                }
                else  // re-loop prompt
                    System.out.println("INVALID INPUT ERROR: Cannot enqueue empty string.");
            }
        }
        else {
            PQ_heap<Integer> pqInt = (PQ_heap<Integer>) pqh;  // cast to Integer type

            while (true) {  // validate int input
                try {
                    System.out.print("\nEnter integer element to enqueue to priority queue: ");
                    int element = Integer.parseInt(scanner.nextLine().trim());  // cast to int
                    pqInt.enqueue(element);  // add to queue
                    break;
                } catch (NumberFormatException ex) {  // prevent crash & re-loop prompt
                    System.out.println("INVALID INPUT ERROR: Acceptable input is any integer.");
                }
            }
        }
    }

    /** Utility method for menu option 2. Invokes Heap.remove() via PQ_heap.dequeue(). */
    private static void dequeueValue(PQ_heap<?> pqh) {
        System.out.println("Dequeueing highest priority element " + pqh.front() + " from queue.");

        System.out.print("\nPriority queue content before dequeueing highest priority element " + pqh.front() + " is:\t");
        pqh.pqToString();  // original queue or "Priority Queue is Empty"

        System.out.print("\nPriority queue content after dequeueing highest priority element " + pqh.dequeue() + " is:\t");
        pqh.pqToString();  // updated queue
    }

    /** Utility method for menu option 3. Checks Heap.getSize() via invoking PQ_heap.is_full() on argument wildcard heap. */
    private static void checkIsFull(PQ_heap<?> pqh) {
        System.out.print("\nPriority queue content is:\t");
        pqh.pqToString();  // print queue before per A3 & A4 conventions

        if (pqh.is_full()) {
            System.out.println("\nPriority queue is full:\tTRUE");
        }
        else
            System.out.println("\nPriority queue is full:\tFALSE");
    }

    /** Utility method for menu option 4. Checks Heap.getSize() via invoking PQ_heap.is_empty() on argument wildcard heap. */
    private static void checkIsEmpty(PQ_heap<?> pqh) {
        System.out.print("\nPriority queue content is:\t");
        pqh.pqToString();  // print queue after per A3 & A4 conventions

        if (pqh.is_empty())
            System.out.println("\nPriority queue is empty:\tTRUE");
        else
            System.out.println("\nPriority queue is empty:\tFALSE");
    }

    /** Utility method for menu option 5. Invokes Heap.getSize() via PQ_heap.size() on argument wildcard heap. */
    private static void printHeapSize(PQ_heap<?> pqh) {
        System.out.println("PQueue size:\t" + pqh.size());  // does not match conventions well but is only explicit output provided
    }

    /** Utility method for menu option 6. Invokes Heap.list.getFront() via PQ_heap.front() on argument wildcard heap. */
    private static void printHeapFront(PQ_heap<?> pqh) {
        System.out.println("Priority Queue front element is:\t" + pqh.front());
    }


    /** Reusable utility method for reading, validating, and returning an integer input for menu choice */
    private static int getValidMenuInput(int first, int last, String prompt) {
        System.out.print(prompt);

        while (!scanner.hasNextInt()) {   // validate input is an integer
            scanner.nextLine();
            System.out.println("INVALID INPUT ERROR: Acceptable input is an integer between " + first + " & " + last + ".");
            System.out.print(prompt);
        }
        int choice = scanner.nextInt();

        while (choice < first || choice > last) {  // validate integer is in range
            scanner.nextLine();
            System.out.println("INVALID INPUT ERROR: Acceptable input is an integer between " + first + " & " + last + ".");
            System.out.print(prompt);

            while (!scanner.hasNextInt()) {  // re-validate new input
                scanner.nextLine();
                System.out.println("INVALID INPUT ERROR: Acceptable input is an integer between " + first + " & " + last + ".");
                System.out.print("\n" + prompt);
            }
            choice = scanner.nextInt();  // input is an int in range
        }
        return choice;  // fully validated
    }
}
