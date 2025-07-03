/**
 * @Author Joshua Gregory
 * @Date June 2025
 * @Description Radix sorts arrays of integers using FIFO queue object from GenericQueue class.
 */

import java.util.Arrays;
import java.util.Scanner;
public class RadixSorter {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = """
                \n---------------------------------
                |       RADIX SORTER MENU       |
                ---------------------------------
                | 1) Set Array Size             |
                | 2) Enter Array Values         |
                | 3) Radix Sort & Print Results |
                | 4) Exit program               |
                ---------------------------------
                Enter option number:\s""";
        int choice;

        int inputSize = 0;
        boolean valuesEntered = false;  // ensure values added to int[] vs sorting array of 0s
        int[] inputs = null;  // array of integer inputs

        GenericQueue<Integer>[] buckets = new GenericQueue[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new GenericQueue<>();  // create array of 10 queue objects
        }

        do {
            choice = getValidMenuInput(1, 4, menu);
            scanner.nextLine();

            switch (choice) {
                case 1:  // read array size
                    System.out.println("\nSET ARRAY SIZE");
                    System.out.println("--------------");

                    inputSize = readArraySize();  // read, validate, and set size (length)
                    inputs = new int[inputSize];  // instantiate int[]
                    break;

                case 2:  // read array values (no output)
                    System.out.println("\nENTER ARRAY VALUES");
                    System.out.println("------------------");

                    if (inputs == null)  // validate size is set
                        System.out.println("ERROR: Array size must be set first.");
                    else {
                        readArrayValues(inputs);  // read values, pass single int[]
                        valuesEntered = true;     // set flag to true to allow radix sort
                    }
                    break;

                case 3:  // radix sort & print results
                    System.out.println("\nRADIX SORT & PRINT RESULTS");
                    System.out.println("--------------------------");

                    if (inputSize == 0)       // validate size was set
                        System.out.println("ERROR: Array size must be set first.");
                    else if (!valuesEntered)  // validate values were added
                        System.out.println("ERROR: Array values must be added first.");
                    else
                        radixSort(inputs, buckets);  // sort, pass int[] & Queue object
                    break;

                case 4:
                    System.out.println("Closing scanner & exiting program... Goodbye.");
                    scanner.close();
                    break;
            }
        } while (choice != 4);
    }

    // SET ARRAY SIZE WITH VALIDATED INTEGER INPUT
    private static int readArraySize() {
        return getValidSizeInput("Enter array size: ");
    }

    // UTILITY METHOD TO READ & VALIDATE INPUT FOR ARRAY SIZE
    private static int getValidSizeInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("INVALID INPUT ERROR: Array size must be a positive, nonzero integer.");
            System.out.print("\n" + prompt);
        }
        int size = scanner.nextInt();

        while (size <= 0) {
            scanner.nextLine();
            System.out.println("INVALID INPUT ERROR: Array size must be a positive, nonzero integer.");
            System.out.print("\n" + prompt);

            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("INVALID INPUT ERROR: Array size must be a positive, nonzero integer.");
                System.out.print("\n" + prompt);
            }
            size = scanner.nextInt();
        }
        System.out.println("Array created for " + size + " integers.");
        return size;
    }

    // FILL ARRAY WITH VALIDATED INPUT INTEGERS
    private static void readArrayValues(int[] inputsArr) {
        for (int i = 0; i < inputsArr.length; i++) {
            inputsArr[i] = getValidArrInput("Enter value " + (i + 1) + " of " + inputsArr.length + ": ");
        }
    }

    // UTILITY METHOD TO READ & VALIDATE INPUT FOR INTEGER ARRAY VALUES
    private static int getValidArrInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("INVALID INPUT ERROR: Value must be a non-negative integer.");
            System.out.print("\n" + prompt);
        }
        int value = scanner.nextInt();

        while (value < 0) {
            scanner.nextLine();
            System.out.println("INVALID INPUT ERROR: Value must be a non-negative integer.");
            System.out.print("\n" + prompt);

            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("INVALID INPUT ERROR: Value must be a non-negative integer.");
                System.out.print("\n" + prompt);
            }
            value = scanner.nextInt();
        }
        return value;
    }

    // PERFORM RADIX SORT BY REPEATEDLY BUCKET SORTING AN ARRAY OF 10 QUEUE OBJECTS, RATHER THAN COMPARING KEYS
    private static void radixSort(int[] inputsArr, GenericQueue<Integer>[] buckets) {
        int[] inputsOriginal = Arrays.copyOf(inputsArr, inputsArr.length);  // create array to store unsorted int[]

        int maxDigits = countDigits(findMax(inputsArr)); // get max number of digits to determine number of loops
        int divisor = 1;  // start divisor at 1 for radix position 0 (rightmost digit)

        for (int d = 0; d < maxDigits; d++) {            // traverse digits, bucket sort loops = maxDigits
            for (int key : inputsArr) {                  // for each key (integer value) in arr
                int digit = extractDigit(key, divisor);  // extract the digit
                buckets[digit].enqueue(key);             // add to back of queue
            }

            int idx = 0;
            for (GenericQueue<Integer> bucket : buckets)
                while (!bucket.isEmpty())                 // until queue is empty
                    inputsArr[idx++] = bucket.dequeue();  // dequeue all keys from buckets
            divisor *= 10;                                // bucket sort next radix position
        }

        System.out.print("\nUnsorted array:\t\t");
        System.out.print(arrayToString(inputsOriginal));  // print unsorted array

        System.out.print("\nRadix Sort results:\t");
        System.out.print(arrayToString(inputsArr));  // print sorted array

        System.out.println();  // formatting
    }

    // UTILITY METHOD TO EXTRACT DIGITS OF ARRAY ELEMENT KEY
    private static int extractDigit(int value, int div) {
        return (value / div) % 10;  // results in rightmost digit
    }

    // UTILITY METHOD TO COUNT NUMBER OF DIGITS IN AN ARRAY ELEMENT KEY
    private static int countDigits(int key) {
        if (key == 0) return 1;  // base case

        int count = 0;          // init digit counter
        while (key > 0) {
            count++;            // increment counter
            key /= 10;          // continue dividing by 10 until 0
        }
        return count;           // number of digits of key
    }

    // UTILITY METHOD TO GET MAX NUMBER OF DIGITS FROM EACH KEY IN ARGUMENT int[]
    private static int findMax(int[] arr) {
        int max = arr[0];          // set max to 0th index to start
        for (int n: arr)           // for each int in arr
            if (n > max) max = n;  // update max if greater
        return max;
    }

    // UTILITY METHOD TO PRINT ARRAY VALUES
    private static String arrayToString(int[] inputsArr) {
        StringBuilder sb = new StringBuilder();  // create sb object to format string

        for (int i = 0; i < inputsArr.length; i++) {
            sb.append(inputsArr[i]);             // append ith value to sb object

            if (i != inputsArr.length - 1)
                sb.append(", ");                 // add comma between values
        }
        return sb.toString();
    }

    // UTILITY METHOD TO READ & VALIDATE USER MENU INPUT
    private static int getValidMenuInput(int first, int last, String prompt) {
        System.out.print(prompt);        // prompt user for menu selection

        while (!scanner.hasNextInt()) {  // loop until input is a valid integer
            scanner.nextLine();          // clear new line
            System.out.println("INVALID INPUT ERROR: Enter a valid menu number.");
            System.out.print(prompt);    // redisplay prompt
        }
        int choice = scanner.nextInt();  // input validated as int

        while (choice < first || choice > last) {  // loop until int is in valid range
            scanner.nextLine();
            System.out.println("INVALID INPUT ERROR: Enter a valid menu number between " + first + " and " + last + ".");
            System.out.print(prompt);

            while (!scanner.hasNextInt()) {  // loop until new input is an int
                scanner.nextLine();
                System.out.println("INVALID INPUT ERROR: Enter a valid menu number.");
                System.out.print(prompt);
            }
            choice = scanner.nextInt();  // set to validated integer in range
        }
        return choice;  // return fully validated input
    }
}
