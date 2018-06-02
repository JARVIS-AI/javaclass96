public class TryAssertions {
  public static void main(String args[]) {
    int daysInMonth = 32;
    if(daysInMonth == 30) {
      System.out.println("Month is April, June, September, or November");

    } else if(daysInMonth == 31) {
      System.out.println(
             "Month is January, March, May, July, August, October, or December.");

    } else if(daysInMonth == 28 || daysInMonth == 29) {
      System.out.println("Month is February.");

    } else {
//      assert false;
      assert false : "daysInMonth has the value " + daysInMonth;
    }
  }
}
