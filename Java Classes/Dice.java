import java.util.Random;
import java.io.IOException;

public class Dice {
  public static void main(String[] args) {
    System.out.println("You have six throws of a pair of dice.\n" +
               "The objective is to get a double six. Here goes...\n");

    Random diceValues = new Random();                                  // Random number generator
    String[] goes = {"First",  "Second", "Third", "Fourth", "Fifth",  "Sixth"};
    int die1 = 0;                                                      // First die value
    int die2 = 0;                                                      // Second die value

    for(String go : goes)  {
      die1 = 1 + diceValues.nextInt(6);                                // Number from 1 to 6
      die2 = 1 + diceValues.nextInt(6);                                // Number from 1 to 6
      System.out.println(go + " throw: " + die1 + ", " + die2);

      if(die1 + die2 == 12) {                                          // Is it double 6?
        System.out.println("    You win!!");                            // Yes !!!
        return;
      }
    }
    System.out.println("Sorry, you lost...");
  }
}
