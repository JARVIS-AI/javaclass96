public class Scope {
  public static void main(String[] args) {
    int outer = 1;                                                     // Exists throughout the method

    {
      // You cannot refer to a variable before its declaration
      // Uncomment the following statement for an error
      // System.out.println("inner = " + inner);

      int inner = 2;
      System.out.println("inner = " + inner);                          // Now it is OK
      System.out.println("outer = " + outer);                          // and outer is still here

      // All variables defined in the enclosing outer block still exist,
      // so you cannot redefine them here
      // Uncomment the following statement for an error
      // int outer = 5;
    }

    // Any variables declared in the previous inner block no longer exist
    // so you cannot refer to them
    // Uncomment the following statement for an error
    // System.out.println("inner = " + inner);

    // The previous variable, inner, does not exist so you can define a new one
    int inner = 3;
    System.out.println("inner = " + inner);                            // ... and output its value
    System.out.println("outer = " + outer);                            // outer is still around
  }
}
