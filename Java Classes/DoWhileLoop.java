public class DoWhileLoop {
  public static void main(String[] args) {
    int limit = 20;                                                    // Sum from 1 to this value
    int sum = 0;                                                       // Accumulate sum in this variable
    int i = 1;                                                         // Loop counter

    // Loop from 1 to the value of limit, adding 1 each cycle
    do {
      sum += i;                                                        // Add the current value of i to sum
      i++;
    } while(i <= limit);

    System.out.println("sum = " + sum);
  }
}
