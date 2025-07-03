/**
 * @author Joshua Gregory
 * @Date: June 2025
 * @Description: Creates generics type FIFO queue objects using linked list via inner class Node.
 */

public class GenericQueue<E> {
    private Node front, back;  // front & back of linked list FIFO queue
    private int size;          // tracks number of linked nodes

    public GenericQueue() {
        this.front = this.back = null;  // constructor sets fields to defaults
        this.size = 0;
    }

    // CREATE NEW NODE USING ARGUMENT DATA & ADD NODE TO BACK OF QUEUE
    public void enqueue(E data) {
        Node newNode = new Node(data);  // create new node

        if (this.back == null)                 // if queue is empty
            this.front = this.back = newNode;  // new node = front & back
        else {
            this.back.next = newNode;  // update current back pointer to new node
            this.back = newNode;       // update back node to new node
        }
        this.size++;  // increment number of nodes
    }

    // REMOVE FIRST-IN NODE & RETURN VALUE IN Node.data
    public E dequeue() {
        if (this.front == null) return null;  // queue is empty

        E value = this.front.data;  // store current front value
        this.front = front.next;    // update front to next in line

        if (this.front == null) this.back = null;  // updated queue is empty

        this.size--;   // decrement number of nodes
        return value;  // return dequeued value
    }

    // RETURN VALUE IN FIRST-IN NODE AT FRONT OF QUEUE
    public E front() {
        if (this.front == null) return null;  // queue is empty
        return this.front.data;               // return data field
    }

    // RETURN VALUE OF size DATA FIELD FOR NUMBER OF NODES IN QUEUE
    public int size() { return this.size; }

    // RETURN TRUE IF QUEUE IS EMPTY, ELSE FALSE
    public boolean isEmpty() { return (front == null); }

    // TRAVERSE QUEUE & PRINT VALUE OF EACH Node.data
    public void printQueue() {
        if (this.front == null) {
            System.out.print("Queue is empty\n");  // empty queue
            return;
        }

        Node current = this.front;  // store current front node
        while (current != null) {
            System.out.print(current.data + " ~> ");  // indicate pointer
            current = current.next;                   // move to next node
        }
        System.out.println();  // formatting
    }

    // INNER CLASS Node TO CREATE LINKED LIST FOR QUEUE INFRASTRUCTURE
    private class Node {
        E data;     // stores value of type declared in GenericQueue constructor
        Node next;  // points to next node in linked list

        Node(E data) {
            this.data = data;  // store argument
            this.next = null;  // --> null on init
        }
    }
}
