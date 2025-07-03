/**
 * @author Joshua Gregory
 * @Date: June 2025
 * @Description: Driver file for testing GenericQueue.java with user input.
 */

import java.util.Scanner;
public class GenericQueueDriver {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = """
                \n[ MAIN MENU ]
                  1) Enqueue node
                  2) Dequeue node
                  3) Get front value
                  4) Get queue size
                  5) Is queue empty
                  6) Print queue
                  7) Exit program
                \nEnter option number:\s""";
        int choice;

        GenericQueue<Integer> integerQueue = new GenericQueue<>();
        do {
            choice = getValidMenuInput(1, 7, menu);

            switch (choice) {
                case 1:  // add value to back node of queue (FIFO)
                    System.out.println("\n[ ENQUEUE NODE ]");
                    menu1(integerQueue);
                    break;

                case 2:  // remove value from front of queue (FIFO)
                    System.out.println("\n[ DEQUEUE NODE ]");
                    menu2(integerQueue);
                    break;

                case 3:  // return value at front of queue
                    System.out.println("\n[ GET FRONT VALUE ]");
                    menu3(integerQueue);
                    break;

                case 4: // count & return number of queued nodes
                    System.out.println("\n[ GET QUEUE SIZE ]");
                    menu4(integerQueue);
                    break;

                case 5: // return true if the queue is empty
                    System.out.println("\n[ IS QUEUE EMPTY ]");
                    menu5(integerQueue);
                    break;

                case 6:  // traverse queued nodes & print each value
                    System.out.println("\n[ PRINT QUEUE ]");
                    menu6(integerQueue);
                    break;

                case 7:  // exit program
                    System.out.println("Closing scanner & exiting... Goodbye.");
                    scanner.close();
                    break;
            }
        } while (choice != 7);
    }

    // MENU 1: READ INPUT, CREATE NODE, ADD TO BACK OF QUEUE
    private static void menu1(GenericQueue<Integer> queue) {
        int data = getValidInt("Enter the integer value to enqueue: ");  // store validated int
        System.out.println("\nEnqueueing " + data + " to back of queue...");

        System.out.print("Contents of queue before enqueueing " + data + " to back:\t");
        queue.printQueue();   // print original queue

        queue.enqueue(data);  // call method, pass argument for Node.data

        System.out.print("Contents of queue after enqueueing " + data + " to back:\t");
        queue.printQueue();   // print updated queue
    }

    // MENU 2: REMOVE NODE FROM FRONT OF QUEUE
    private static void menu2(GenericQueue<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("ERROR: Queue is currently empty. No value to dequeue.");
            return;  // exit method if isEmpty() == true
        }
        System.out.println("Dequeueing " + queue.front() + " from front of queue...");

        System.out.print("Contents of queue before dequeueing " + queue.front() + " from front:\t");
        queue.printQueue();  // print original queue

        System.out.print("Contents of queue after dequeueing " + queue.dequeue() + " from front:\t");
        queue.printQueue();    // print updated queue
    }

    // MENU 3: RETURN VALUE OF NODE AT QUEUE FRONT
    private static void menu3(GenericQueue<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("ERROR: Queue is currently empty. No value at front of queue.");
            return;  // exit method if isEmpty() == true
        }
        int front = queue.front();  // store method return
        System.out.println("Current value at front of queue:\t" + front);

        System.out.print("Current contents of queue:\t\t\t");
        queue.printQueue();    // print queue values
    }

    // MENU 4: RETURN NUMBER OF NODES IN QUEUE
    private static void menu4(GenericQueue<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("ERROR: Queue is currently empty. Size is 0.");
            return;  // exit method if isEmpty() == true
        }
        System.out.println("Size of queue =\t" + queue.size());

        System.out.print("Current contents of queue:\t\t\t");
        queue.printQueue();    // print queue values
    }

    // MENU 5: TEST IF QUEUE IS EMPTY
    private static void menu5(GenericQueue<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("Is queue empty?\tTRUE");
            return;  // exiit method if isEmpty() == true
        }
        System.out.println("Is queue empty?\tFALSE");

        System.out.print("Current contents of queue:\t\t\t");
        queue.printQueue();    // print queue values
    }

    // MENU 6: TRAVERSE QUEUE LINKED LIST & PRINT VALUES OF EACH NODE
    private static void menu6(GenericQueue<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("ERROR: Queue is currently empty. No values to print.");
            return;  // exit method if isEmpty() == true
        }
        System.out.print("Current contents of queue:\t");
        queue.printQueue();    // print queue values
    }

    // UTILITY METHOD TO READ & VALIDATE MENU CHOICE INPUT
    private static int getValidMenuInput(int first, int last, String prompt) {
        System.out.print(prompt);        // prompt user for menu selection

        while (!scanner.hasNextInt()) {  // loop until input is a valid integer
            scanner.nextLine();          // clear new line
            System.out.println("Invalid input. Enter a valid menu number.");
            System.out.print(prompt);    // redisplay prompt
        }
        int choice = scanner.nextInt();  // input validated as int

        while (choice < first || choice > last) {  // loop until int is in valid range
            scanner.nextLine();
            System.out.println("Invalid input. Enter a valid menu number between " + first + " and " + last + ".");
            System.out.print(prompt);

            while (!scanner.hasNextInt()) {        // loop until new input is an int
                scanner.nextLine();
                System.out.println("Invalid input. Enter a valid menu number.");
                System.out.print("\n" + prompt);
            }
            choice = scanner.nextInt();  // set to validated integer in range
        }
        return choice;  // return fully validated input
    }

    // UTILITY METHOD TO READ & VALIDATE INTEGER INPUT
    private static int getValidInt(String prompt) {
        scanner.nextLine();
        System.out.print(prompt);

        while (!scanner.hasNextInt()) {  // loop until input is a valid integer
            scanner.nextLine();          // clear new line
            System.out.println("Invalid input. Enter a valid integer (whole number).");
            System.out.print("\n" + prompt);    // redisplay prompt
        }
        return scanner.nextInt();  // input validated as int
    }
}
