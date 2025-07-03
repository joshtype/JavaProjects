// Name:        Joshua Gregory
// Class:       CS3305/W03
// Term:        Sprint 2025
// Instructor:  Prof. Wang
// Assignment:  #5
// IDE Name:    IntelliJ
// File:        Driver for testing HeapSort.java using hardcoded lists.

// Class Heap.java
// Textbook - Listing 23.9, Page 878
public class TestHeapSort {
   /** A test method */
   public static void main(String[] args) {
      // Provided HeapSort.java extended to accept generics

      // PROVIDED HARDCODED INT[] SORT TEST
      Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};

      System.out.print("Original Integer List:\t");  //print [unsorted] list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");
         
      HeapSort.heapSort(list);  //sort the list
      
      System.out.print("\nSorted Integer List:\t");  //print [sorted] list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");


      // ADD HARDCODED CHAR[] SORT TEST
      Character[] list2 = {'w','f','A','X','T','Q','k','s','8','L','3','b','A','w','s','H','j','K','L'};

      System.out.print("\n\nOriginal Character List:\t");  // print unsorted char[]
      for (int i = 0; i < list2.length; i++)
         System.out.print(list2[i] + " ");

      HeapSort.heapSort(list2);  // sort char[]

      System.out.print("\nSorted Character List:\t\t");  // print sorted char[]
      for (int i = 0; i < list2.length; i++)
         System.out.print(list2[i] + " ");


      // ADD HARDCODED STR[] SORT TEST
      String[] list3 = {"Data", "Structure", "Is", "Hard", "Computing", "Class", "To Pass"};

      System.out.print("\n\nOriginal String List:\t");  // print unsorted str[]
      for (int i = 0; i < list3.length; i++)
         System.out.print(list3[i] + " ");

      HeapSort.heapSort(list3);  // sort str[]

      System.out.print("\nSorted String List:\t\t");  // print sorted str[]
      for (int i = 0; i < list3.length; i++)
         System.out.print(list3[i] + " ");
   }
}
