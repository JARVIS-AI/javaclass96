import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

public class MorePrimes {
  public static void main(String[] args) {
    long[] primes = new long[20];      // Array to store primes
    primes[0] = 2L;                    // Seed the first prime
    primes[1] = 3L;                    // and the second
    int count = 2;                     // Count of primes found - up to now,
                                       // which is also the array index
    long number = 5L;                  // Next integer to be tested

    outer:
    for( ; count < primes.length; number += 2L) {
      // The maximum divisor we need to try is square root of number
      long limit = (long)ceil(sqrt((double)number));

      // Divide by all the primes we have up to limit
      for(int i = 1; i < count && primes[i] <= limit; ++i) {
        if(number%primes[i] == 0L) {   // Is it an exact divisor?
          continue outer;              // Yes, so try the next number
        }
      }
      primes[count++] = number;        // We got one!
    }

    for(long n : primes) {
      System.out.println(n);           // Output all the primes
    }
  }
}
