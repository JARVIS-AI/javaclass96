public class LetterCheck2 {
  public static void main(String[] args) {
    char symbol = 'A';
    symbol = (char)(128.0*Math.random());                              // Generate a random character
    if(symbol >= 'A' && symbol <= 'Z') {                               // Is it a capital letter
      System.out.println("You have the capital letter " + symbol);
    } else {
      if(symbol >= 'a' && symbol <= 'z') {                             // or is it a small letter?
        System.out.println("You have the small letter " + symbol);
      } else {                                                         // It is not less than z
        System.out.println("The code is not a letter");
      }
    }
  }
}
