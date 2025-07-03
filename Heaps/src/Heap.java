// Name:        Joshua Gregory
// Class:       CS3305/W03
// Term:        Sprint 2025
// Instructor:  Prof. Wang
// Assignment:  #5
// IDE Name:    IntelliJ
// File:        Primary class defining Heap objects.

// Class Heap.java
// Textbook - Listing 23.9, Page 878
public class Heap<E extends Comparable<E>> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
  private static final int CAPACITY = 100;  // Added per requirements

  /** Create a default heap */
  public Heap() {
  }

  /** Create a heap from an array of objects */
  public Heap(E[] objects) {
    // Edited to restrict heap size to value of CAPACITY
    for (int i = 0; i < objects.length && i < CAPACITY; i++)
      add(objects[i]);  // fills 0th - 99th indices (up to 100 elements)

    if (objects.length > CAPACITY)  // E[] is > 100
      System.out.println("Heap capacity reached. First " + CAPACITY + " objects added.");
  }

  /** Add a new object into the heap */
  public void add(E newObject) {
    list.add(newObject); // Append to the heap
    int currentIndex = list.size() - 1; // The index of the last node

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;
      // Swap if the current object is greater than its parent
      if (list.get(currentIndex).compareTo(
          list.get(parentIndex)) > 0) {
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
      }
      else
        break; // the tree is a heap now

      currentIndex = parentIndex;
    }
  }

  /** Remove the root from the heap */
  public E remove() {
    E removedObject = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);

    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int leftChildIndex = 2 * currentIndex + 1;
      int rightChildIndex = 2 * currentIndex + 2;

      // Find the maximum between two children
      if (leftChildIndex >= list.size()) break; // The tree is a heap
      int maxIndex = leftChildIndex;
      if (rightChildIndex < list.size()) {
        if (list.get(maxIndex).compareTo(
            list.get(rightChildIndex)) < 0) {
          maxIndex = rightChildIndex;
        }
      }

      // Swap if the current node is less than the maximum
      if (list.get(currentIndex).compareTo(
          list.get(maxIndex)) < 0) {
        E temp = list.get(maxIndex);
        list.set(maxIndex, list.get(currentIndex));
        list.set(currentIndex, temp);
        currentIndex = maxIndex;
      }
      else
        break; // The tree is a heap
    }

    return removedObject;
  }

  /** Get the number of nodes in the tree */
  public int getSize() {
    return list.size();
  }

  /** Added method to get value of CAPACITY */
  public int getCapacity() {
    return CAPACITY;
  }

  /** Added method to get front element */
  public E getFront() {
    return list.getFirst();
  }

  /** Added method to print heap elements */
  public void printHeap() {
      for (E e : list)          // enhanced for loop
          System.out.print(e);  // print ith index
  }
}
