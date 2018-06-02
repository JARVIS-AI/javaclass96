// Chapter 6 Exercise 5
/*
 Add methods to the class LinkedList to insert and delete elements at the current position.
*/

public class TestLList {
  public static void main(String args[]) {
    LinkedList myList = new LinkedList();
    Double value = new Double(0.0);                                    // Only so getClass() is callable.
    String[] words = {"The", " cat", " sat", " on", " the", " mat."};
    char separator = ' ';
    int endIndex = 0;
    int beginIndex = 0;
    int noWords = 0;

    // Append 5 Doubles to the list:
    for(int i = 0 ; i < 5 ; ++i) {
      myList.addItem(new Double(i));
    }

    // Append 5 Integers to the list:
    for(int i = 0 ; i < 5 ; ++i) {
      myList.addItem(i);
    }

    // Output the length and contents of the list:
    System.out.println("The list contains " + myList.size() + " items.");
    System.out.println("List is:\n" + myList);

    // Add in some strings between the Doubles and Integers:
    // Step through the list to the desired position (end of Doubles):
    myList.getFirst();
    for(int i = 0 ; i < 4 ; ++i) {
      myList.getNext();
    }
    for(String word : words) {
      myList.insertItem(word);
    }
    // Output the length and contents of the list:
    System.out.println("\nThe list contains " + myList.size() + " items.");
    System.out.println("List is now:\n" + myList);

    // Delete all the strings from the list:
    Object item = myList.getFirst() ;
    do {
      if(item instanceof String) {                                     // If it's a string...
        myList.deleteItem();                                           // ...delete it.
      }
      item = myList.getNext();
    }while(item != null);

    // Output the length and contents of the list:
    System.out.println("\nThe list contains " + myList.size() + " items.");
    System.out.println("After deletions the list is:\n" + myList);
  }
}
