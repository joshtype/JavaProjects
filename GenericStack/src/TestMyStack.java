// Name:        Joshua Gregory
// Class:       CS3305/W03
// Term:        Summer 2025
// Instructor:  Prof. Wang
// Assignment:  #3 (Part 1)
// IDE Name:    IntelliJ
// File:        Driver file for MyStack.java.

import java.util.Scanner;
public class TestMyStack {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = """
                \n--------MAIN MENU-------
                1 – Push element
                2 – Pop element
                3 – Get top element
                4 – Get stack size
                5 – Is empty stack?
                6 - Print stack
                7 - Exit program
                \nEnter option number:\s""";
        int choice;

        MyStack<Integer> intStack = new MyStack<>();  // requirements specify <int> but must be <Integer>

        do {
            choice = getValidMenuInput(1, 7, menu);

            switch (choice) {
                case 1:  // push new element to top of stack (LIFO)
                    System.out.println("\n---------PUSH ELEMENT---------");  // using same submenu format as in A1 (100%)
                    helperMenu1(intStack);
                    break;

                case 2:  // pop new element from top of stack (LIFO)
                    System.out.println("\n----------POP ELEMENT----------");
                    helperMenu2(intStack);
                    break;

                case 3:  // return element value at top of stack
                    System.out.println("\n--------GET TOP ELEMENT--------");
                    helperMenu3(intStack);
                    break;

                case 4:  // count & return number of elements in stack
                    System.out.println("\n--------GET STACK SIZE--------");
                    helperMenu4(intStack);
                    break;

                case 5:  // return true if the stack is empty, else false
                    System.out.println("\n--------IS EMPTY STACK?-------");
                    helperMenu5(intStack);
                    break;

                case 6:  // traverse stack, printing each element
                    System.out.println("\n---------PRINT STACK---------");
                    helperMenu6(intStack);
                    break;

                case 7:  // exit program
                    System.out.println("\nExiting program");
                    scanner.close();
                    break;
            }
        } while (choice != 7);
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

    // Helper method to read & validate integer input
    private static int getValidIntInput(String prompt) {
        System.out.print(prompt);

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter a valid integer."); // print error
            scanner.nextLine();       // consume remaining line of invalid input
            System.out.print(prompt); // re-prompt user once after invalid input
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    // Helper method for menu option 1 (push element to top of stack)
    private static void helperMenu1(MyStack<Integer> stack) {
        int data = getValidIntInput("Enter a value to push to top of stack: ");  // prompt wording unspecified
        System.out.println("Pushing value " + data + " to top of stack.");  // wording based on A2 & A3 inferred conventions

        System.out.print("\nStack contents before pushing " + data + " is:\t");  // wording based on inferred A2 & A3 conventions
        stack.printStack();  // requirements specify to print contents before & after method calls for options 1, 2, 3
                             // but output format is unspecified if stack was empty, tried to do most logical output

        stack.push(data);    // call method to push value

        System.out.print("Stack contents after pushing " + data +  " to top of stack is:\t");  // wording based on inferred A2 & A3 conventions
        stack.printStack();  // print updated nodes after method call per requirements
    }

    // Helper method for menu option 2 (pop element from top of stack)
    private static void helperMenu2(MyStack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.printStack();  // prints "Stack is Empty", wording unspecified in A3 requirements, adapted from A2
            return;  // exit per A2 convention
        }

        System.out.println("\nPopping " + stack.top() + " from top of stack.");  // organized & wording based on A2 conventions

        System.out.print("Stack contents before popping " + stack.top() + " from top of stack is:\t");  // organized per A2 demo
        stack.printStack();  // requirements specify to print contents before & after method call for options 1, 2, 3

        int poppedValue = stack.pop();  // output organized based on A2 demo

        System.out.print("Stack contents after popping " + poppedValue + " from top of stack is:\t");  // organized per A2 demo
        stack.printStack();  // requirements specify to print contents before & after method calls for options 1, 2, 3
                             // but output format is unspecified if stack becomes empty, tried to do most logical output
    }

    // Helper method for menu option 3 (return element at top of stack)
    private static void helperMenu3(MyStack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.printStack();  // empty stack output unspecified in A3, wording adapted from A2
            return;  // exit per A2 demo
        }

        System.out.print("\nStack content is: ");  // wording based on inferred conventions in A2 & A3
        stack.printStack();  // requirements specify to print stack contents before method calls for options 1, 2, 3

        int topElement = stack.top();
        System.out.println("Top element of stack is: " + topElement + ".");  // no demo for output organization, assumed this is most logical

        System.out.print("Stack content is: ");  // wording based on inferred conventions in A2 & A3
        stack.printStack();  // requirements specify to print stack contents after calling methods for options 1, 2, 3
    }

    // Helper method for menu option 4 (return size of stack)
    private static void helperMenu4(MyStack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.printStack();  // empty stack output unspecified in A3, wording adapted from A2
            return;  // exit method per A2 convention
        }

        System.out.print("\nStack content is: ");  // wording based on inferred A2 & A3 conventions
        stack.printStack();  // requirements specify to print contents before method call for options 4 & 5

        int stackSize = stack.size();
        System.out.println("Stack size is: " + stackSize + ".");  // wording based on inferred conventions in A2 & A3
    }

    // Helper method for menu option 5 (test if stack is empty)
    private static void helperMenu5(MyStack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.printStack();  // empty stack output unspecified in A3, wording adapted from A2
            return;  // exit method per A2 convention
        }

        System.out.print("\nStack content is: ");  // wording based on inferred conventions in A2 & A3
        stack.printStack();  // requirements specify to print stack content before method call for options 4 & 5

        if (stack.isEmpty())
            System.out.println("Stack is empty.");  // wording based on inferred conventions in A2 & A3
        else
            System.out.println("Stack is not empty.");  // wording based on inferred conventions in A2 & A3
    }

    // Helper method for menu option 6 (print each element in stack)
    private static void helperMenu6(MyStack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.printStack();  //
            return;  // exit per A2 demo
        }
        System.out.print("Stack content is: ");  // exact wording unspecified, adapted from A2 conventions
        stack.printStack();
        System.out.println();  // add spacing between output & menu for readability
    }
}
