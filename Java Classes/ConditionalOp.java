public class ConditionalOp {
  public static void main(String[] args) {
    int nHats = 1;                                                     // Number of hats
    System.out.println("I have " + nHats + " hat" + (nHats == 1 ? "." : "s."));

    nHats++;                                                           // Increment number of hats
    System.out.println("I have " + nHats + " hat" + (nHats == 1 ? "." : "s."));
  }
}
