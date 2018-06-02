public class Primes {
  public static void main(String[] args) {
    int nValues = 50;                                                  // The maximum value to be checked
    boolean isPrime = true;                                            // Is true if we find a prime

    // Check all values from 2 to nValues
    for(int i = 2; i <= nValues; ++i) {
      isPrime=true;                                                    // Assume the current i is prime

      // Try dividing by all integers from 2 to i-1
      for(int j = 2; j < i; ++j) {
        if(i % j == 0) {                                               // This is true if j divides exactly
          isPrime = false;                                             // If we got here, it was an exact division
          break;                                                       // so exit the loop
        }
      }
      // We can get here through the break, or through completing the loop
      if(isPrime)                                                      // So is it prime?
        System.out.println(i);                                         // Yes, so output the value
    }
  }
}
