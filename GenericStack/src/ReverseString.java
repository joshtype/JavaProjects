// Name:        Joshua Gregory
// Class:       CS3305/W03
// Term:        Summer 2025
// Instructor:  Prof. Wang
// Assignment:  #3 (Part 2)
// IDE Name:    IntelliJ
// File:        Class for using generic LIFO stack object to reverse input strings.

import java.util.Scanner;
public class ReverseString {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = """
                \n-----------------MAIN MENU---------------
                1 – Read input string of words
                2 – Reverse string and display outputs
                3 - Exit program
                \nEnter option number:\s""";
        int choice;
        String inputStr = "";

        do {
            choice = getValidMenuInput(1, 3, menu);

            switch (choice) {
                case 1:  // read in a new string input
                    System.out.println("\n-------READ INPUT STRING OF WORDS-------");
                    inputStr = getStringInput();
                    break;

                case 2:  // reverse string & display original & reversed
                    System.out.println("\n---REVERSE STRING AND DISPLAY OUTPUTS---");
                    reverseString(inputStr);
                    break;

                case 3:  // exit program
                    System.out.println("\nExiting program");
                    scanner.close();
                    break;
            }
        } while (choice != 3);
    }

    // Helper method to read & validate menu choice input
    private static int getValidMenuInput(int first, int last, String prompt) {
        int choice;
        System.out.print(prompt);

        while (!scanner.hasNextInt()) {
            scanner.nextLine();  // clear bad input
            System.out.println("Invalid input. Enter a valid menu number.");
            System.out.print(prompt);
        }

        choice = scanner.nextInt();
        while (choice < first || choice > last) {
            scanner.nextLine();
            System.out.println("Invalid input. Enter a number between " + first + " and " + last + ".");
            System.out.print(prompt);

            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Invalid input. Enter a valid number.");
                System.out.print(prompt);
            }
            choice = scanner.nextInt();
        }
        return choice;
    }

    // Helper method to read in a new input string
    private static String getStringInput() {  // method name unspecified in A3 requirements
        System.out.print("Enter a string of words to reverse: ");  // wording unspecified in A3 requirements
        scanner.nextLine();         // consume remaining line
        return scanner.nextLine();  // return input
    }

    // Helper method to add string to stack then reverse & display
    private static void reverseString(String inputStr) {  // method name unspecified in A3 requirements
        MyStack<String> strStack = new MyStack<>();  // create a new stack & define as a String type

        // separate input string into char array
        for (char c : inputStr.toCharArray()) {
            strStack.push(String.valueOf(c));  // push char to stack, each becomes top node
        }

        StringBuilder reversedStr = new StringBuilder();  // append popped chars

        // until next char is null, pop chars via LIFO principle
        while (!strStack.isEmpty()) {
            reversedStr.append(strStack.pop());  // append popped chars to end, reversing string
        }

        System.out.println("Entered string:\t\t" + inputStr);    // print original string, wording from A3 requirements
        System.out.println("Reversed string:\t" + reversedStr);  // print reversed string, wording from A3 requirements
    }
}
