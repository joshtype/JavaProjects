// Name:        Joshua Gregory
// Class:       CS3305/W03
// Term:        Sprint 2025
// Instructor:  Prof. Wang
// Assignment:  #5
// IDE Name:    IntelliJ
// File:        Class for creating & manipulating generics-type priority queue Heap objects.

// Generic code for class PQ_heap for Assignment [5]
public class PQ_heap <E extends Comparable<E>>
{
    // Only data member needed is a Heap object, per requirements
    private Heap<E> heap = new Heap<>();  // String = lexi priority, Int = value priority

    // Constructor method
    PQ_heap() {};  // no arg-constructor

    // Return true if priority queue is empty; otherwise return false
    public boolean is_empty() {
       return this.heap.getSize() == 0;  // true if size == 0
    };
	
	// Return true if priority queue is full; otherwise return false
    public boolean is_full() {
        return this.heap.getSize() >= this.heap.getCapacity();  // true if size >= 100
    };

	// Return (don't remove) the front element from the priority queue
	// Precondition: priority queue is not empty.
    public E front() {
        if (this.is_empty()) {
            return null;  // prevent crash & exit if empty
        }
        return this.heap.getFront();
    };

	// return number of elements in the queue
    public int size() {
        return this.heap.getSize();
    };
   
	// Remove the largest value from this priority queue and return it.
	// Precondition: priority queue is not empty.
    public E dequeue() {
        if (this.is_empty()) {
            return null;  // prevent crash & exit if empty
        }
        return this.heap.remove();  // return removed element
    };

	// Inserts the 'value' into the priority queue.
	// Precondition: priority queue is not full
    public void enqueue(E value) {
        if (this.is_full()) {
            System.out.print("Priority Queue is Full.");  // wording based on A2, A3, A4 conventions
            return;  // exit if full
        }
        this.heap.add(value);  // invoke Heap.add() otherwise
    };

    // Added method to print priority queue heap elements using Heap.printHeap()
    public void pqToString() {
        if (this.is_empty()) {
            System.out.print("Priority Queue is Empty");  // per A2, A3, A4 requirements
            return;  // exit if empty
        }
        this.heap.printHeap();  // invoke printHeap() otherwise
    }
};
