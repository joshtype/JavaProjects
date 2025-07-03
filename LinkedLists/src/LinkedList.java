/**
 * @author Joshua Gregory
 * @version June 2025
 * Class file defining linked list nodes and methods.
 */

public class LinkedList {
    // FOLLOWING CODE WRITTEN BY DR. LIANG:
    public Node head, tail;

    //constructor method to create a list of object with head, tail, and size.
    public LinkedList()
    {
        head = null;
        tail = null;
    }

    //method to print out the list
    public void printList()
    {
        Node temp;
        temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
    }

    //method add node to end of list
    public void addLastNode(int data)
    {
        if (tail == null)
            head = tail = new Node(data); //empty list
        else
        {
            tail.next = new Node(data); //link new node as last node
            tail = tail.next; //make tail pointer points to last node
        }
    }

    // FOLLOWING CODE WRITTEN BY JOSHUA GREGORY:
    // Class method to add node to front of stack
    public void addFirstNode(int data) {
        Node newNode = new Node(data);  // create new node
        newNode.next = head;            // point to head (null or non-null)
        head = newNode;                 // update head
    }

    // Class method to add node at argument index
    public void addAtIndex(int data, int index) {
        Node newNode = new Node(data);

        if (index == 0) {         // insert at 0th = add to front
            newNode.next = head;  // point new node to head
            head = newNode;       // update head node
            return;
        }

        Node curr = head;                    // set head to temp var
        for (int i = 0; i < index - 1; i++)  // traverse to ith-1 index
            curr = curr.next;                // update ith+1 index

        newNode.next = curr.next;  // update new node's pointer
        curr.next = newNode;       // point current to new node
    }

    // Class method to remove node from front of stack
    public void removeFirstNode() {
        if (head == null) {
            System.out.println("List is empty");  // no nodes to remove
            return;
        }
        head = head.next;  // set head to next node that it was pointing to
    }

    // Class method to remove node from back of stack
    public void removeLastNode() {
        if (head == null) {
            System.out.println("List is empty");  // no nodes to remove
            return;
        }
        if (head.next == null) {
            head = null;   // one node exists so head points to null
            return;
        }

        Node curr = head;               // store head in a temp var
        while (curr.next.next != null)  // until node after next points to null
            curr = curr.next;           // set temp var to next node

        curr.next = null;               // set last node with null
    }

    // Class method to remove node from argument index
    public void removeNodeAtIndex(int index) {
        if (head == null) {
            System.out.println("List is empty");  // no nodes to remove
            return;
        }
        if (index == 0) {
            head = head.next;  // 0th index = head node
            return;            // if only 1 node, head becomes null
        }

        Node curr = head;      // set temp var to head node
        for (int i = 0; i < index-1; i++) {  // traverse to ith-1 index
            curr = curr.next;                // update to ith+1 node
        }

        curr.next = curr.next.next;          // point to node after next
    }

    // Class method to count nodes & print size of linked list
    public int getSize() {
        int count = 0;
        Node curr = head;      // set current node to front

        while (curr != null) {
            count++;           // until curr points to null, increment count
            curr = curr.next;  // set curr to next node
        }
        return count;
    }

    // Class methods to recursively print each node from back to front
    public void printReverse() {
        if (head == null) {
            System.out.println("List is empty");  // base case
            return;
        }
        helperPrintReverse(head);       // recur method calls
        System.out.println("null");
    }
    private void helperPrintReverse(Node node) {
        if (node == null) return;       // base case
        helperPrintReverse(node.next);  // recur to last node
        System.out.print(node.data + ", ");    // print node after recurring
    }


    // FOLLOWING CODE WRITTEN BY DR. LIANG:
    //class to create nodes as objects
    private class Node
    {
        private int data;  //data field
        private Node next; //link field

        public Node(int item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}
