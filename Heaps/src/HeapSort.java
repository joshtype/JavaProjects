// Name:        Joshua Gregory
// Class:       CS3305/W03
// Term:        Sprint 2025
// Instructor:  Prof. Wang
// Assignment:  #5
// IDE Name:    IntelliJ
// File:        Class for sorting generic heap objects.

// Class Heap.java
// Textbook - Listing 23.9, Page 878
public class HeapSort {
   /** Heap sort method */
   public static <E extends Comparable<E>> void heapSort(E[] list) {
      // Create a Heap of integers
      Heap<E> heap = new Heap<E>();
   
      // Add elements to the heap
      for (int i = 0; i < list.length; i++)
         heap.add(list[i]);
   
      // Remove elements from the heap
      for (int i = list.length - 1; i >= 0; i--)
         list[i] = heap.remove();
   }
}
