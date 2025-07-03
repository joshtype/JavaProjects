// Name:        Joshua Gregory
// Class:       CS3305/W03
// Term:        Summer 2025
// Instructor:  Prof. Wang
// Assignment:  #3 (Part 1)
// IDE Name:    IntelliJ
// File:        Generic class for LIFO stack with inner Node class.

import java.util.Optional;

public class MyStack<E> {
    private Node<E> top;  // top = last value added
    private int size;     // dynamic size counter

    public MyStack() {
        this.top = null;  // set defaults for new nodes
        this.size = 0;
    }

    public void push(E data) {
      Node<E> newNode = new Node<>(data);  // create new node
      newNode.next = top;  // link new node to current top node
      top = newNode;       // define new node as new top
      size++;              // increment size
    }

    public E pop() {
        if (top == null) return null;  // prevent crashing

        E data = top.data;  // get top node data
        top = top.next;     // move top to next node
        size--;             // decrement size

        return data;        // return popped value
    }

    public E top() {  // named peek() in Ch. 20 slides but specified as top() in requirements
        if (top == null) return null;  // prevent crashing
        else return top.data;          // return top value
    }

    public int size() { // named getSize() in Ch. 20 slides, but specified as size() in requiremerents
        return size;    // return current size value
    }

    public boolean isEmpty() {
        return (size == 0);  // T if size is 0, else F
    }

    public void printStack() {  // name not specified in requirements, used printStack() after A2 printList()
        if (top == null) {
            System.out.println("Stack is Empty");  // wording unspecified in A3 requirements, based on A2 convention
            return;  // exit per A2 convention
        }

        Node<E> current = top;  // start at top of stack

        while (current != null) {
            System.out.print(current.data + " ");  // print each element
            current = current.next;                // move to the next node
        }

        System.out.println();  // move to next line
    }

    // Inner generic class for Node objects.
    private class Node<E> {  // Generic type to ensure Node & MyStack are the same type
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;  // set field to argument
            this.next = null;  // set pointer to null
        }
    }
}
