public class Primes2 {
  public static void main(String[] args) {
    int nValues = 50;                                                  // The maximum value to be checked

    // Check all values from 2 to nValues
    OuterLoop:
    for(int i = 2 ; i <= nValues ; ++i) {
      // Try dividing by all integers from 2 to i-1
      for(int j = 2 ; j < i ; ++j) {
        if(i%j == 0) {                                                 // This is true if j divides exactly
          continue OuterLoop;                                          // so exit the loop
        }
      }
      // We only get here if we have a prime
      System.out.println(i);                                           // so output the value
    }
  }
}
