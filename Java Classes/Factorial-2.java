public class Factorial {
  public static void main(String[] args) {
    long limit = 20L;                                                  // Calculate factorials of integers up to this value
    long factorial = 1L;                                               // A factorial will be stored in this variable

    // Loop from 1 to the value of limit
    for (long i = 1L; i <= limit; ++i) {
      factorial = 1L;                                                  // Initialize factorial

      for (long factor = 2; factor <= i; ++factor) {
        factorial *= factor;
      }
      System.out.println(i + "! is " + factorial);
    }
  }
}
