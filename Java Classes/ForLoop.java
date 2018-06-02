public class ForLoop {
  public static void main(String[] args) {
    int limit = 20;                                                    // Sum from 1 to this value
    int sum = 0;                                                       // Accumulate sum in this variable

    // Loop from 1 to the value of limit, adding 1 each cycle
    for(int i = 1; i <= limit; ++i) {
      sum += i;                                                        // Add the current value of i to sum
    }
    System.out.println("sum = " + sum);
  }
}
