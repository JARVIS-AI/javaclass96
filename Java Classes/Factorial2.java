public class Factorial2 {
  public static void main(String[] args) {
    long limit = 20L;        // to calculate factorial of integers up to this value
    long factorial = 1L;     // factorial will be calculated in this variable

    // Loop from 1 to the value of limit
    OuterLoop:
    for(long i = 1L; i <= limit; ++i) {
      factorial = 1;                   // Initialize factorial
      for(long j = 2L; j <= i; ++j) {
        if(i > 10L && i % 2L == 1L) {
          continue OuterLoop;          // Transfer to the outer loop
        }
        factorial *= j;
      }
      System.out.println(i + "! is " + factorial);
    }
  }
}
