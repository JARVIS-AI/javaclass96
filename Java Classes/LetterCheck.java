public class LetterCheck {
  public static void main(String[] args) {
    char symbol = 'A';
    symbol = (char)(128.0*Math.random());                              // Generate a random character

    if(symbol >= 'A') {                                                // Is it A or greater?
      if(symbol <= 'Z') {                                              // yes, and is it Z or less?
        // Then it is a capital letter
        System.out.println("You have the capital letter " + symbol);

    } else {                                                           // It is not Z or less
        if(symbol >= 'a') {                                            // So is it a or greater?
          if(symbol <= 'z') {                                          // Yes, so is it z or less?
            // Then it is a small letter
            System.out.println("You have the small letter " + symbol);

          } else {                                                     // It is not less than z
            System.out.println(
            "The code is greater than a but it's not a letter");
          }

      } else {
          System.out.println("The code is less than a and it's not a letter");
        }
      }

    } else {
      System.out.println("The code is less than A so it's not a letter");
    }
  }
}
