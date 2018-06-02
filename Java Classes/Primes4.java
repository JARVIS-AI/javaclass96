public class Primes4 {
  public static void main(String[] args) {
    int nPrimes = 50;                                                  // The maximum number of primes required

    // Check all values from 2 to nValues
    OuterLoop:
    for(int i = 2 ; ; ++i) {                                           // This loop runs forever
      // Try dividing by all integers from 2 to i-1
      for(int j = 2 ; j < i ; ++j) {
        if(i % j == 0) {                                               // This is true if j divides exactly
          continue OuterLoop;                                          // so exit the loop
        }
      }
      // We only get here if we have a prime
      System.out.println(i);                                           // so output the value
      if(--nPrimes == 0) {                                             // Decrement the prime count
        break OuterLoop;                                               // It is zero so we have them all
      }
    }
    // break OuterLoop goes to here
  }
}
