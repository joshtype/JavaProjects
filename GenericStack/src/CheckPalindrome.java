// Name:        Joshua Gregory
// Class:       CS3305/W03
// Term:        Summer 2025
// Instructor:  Prof. Wang
// Assignment:  #3 (Part 3)
// IDE Name:    IntelliJ
// File:        Class for using generic LIFO stack object for testing if input strings are palindromes.

import java.util.Scanner;
public class CheckPalindrome {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = """
                \n-----------------MAIN MENU----------------
                1 - Read input string
                2 - Check palindrome and display output
                3 - Exit program
                \nEnter option number:\s""";
        int choice;
        String inputStr = "";

        do {
            choice = getValidMenuInput(1, 3, menu);

            switch (choice) {
                case 1:  // read in a new string input
                    System.out.println("\n------------READ INPUT STRING-----------");
                    inputStr = getStringInput();
                    break;

                case 2:  // reverse string & display original & reversed
                    System.out.println("\n--CHECK PALINDROME AND DISPLAY OUTPUT---");
                    checkPalindrome(inputStr);
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
        System.out.print("Enter a string to check if it is a palindrome: ");  // wording unspecified in A3 requirements
        scanner.nextLine();         // consume remaining line
        return scanner.nextLine();  // return input
    }

    // Class method for testing if input string is a palindrome (method name not defined in requirements)
    private static void checkPalindrome(String inputStr) {  // method name unspecified in A3 requirements
        MyStack<String> strStack = new MyStack<>();  // create MyStack<String> object

        for (char c : inputStr.toCharArray()) {  // separate string into an array of chars
            strStack.push(String.valueOf(c));    // push each char onto stack, each char becomes top node
        }

        StringBuilder reversed = new StringBuilder();  // for appending popped chars
        while (!strStack.isEmpty()) {         // until next char points to null, pop chars
            reversed.append(strStack.pop());  // append popped chars to end, reversing string
        }

        System.out.println("Entered string:\t\t" + inputStr);  // print original string, wording from A3 demo

        if (inputStr.equalsIgnoreCase(reversed.toString()))
            System.out.println("Judgement:\t\t\tPalindrome");  // if input == reversed, wording from A3 demo
        else
            System.out.println("Judgement:\t\t\tNot Palindrome");  // if input != reversed, wording from A3 demo
    }
}

