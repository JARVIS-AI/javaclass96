public class CollectionForLoop {
  enum Season { spring, summer, fall, winter }   // Enumeration type definition

  public static void main(String[] args) {
    for(Season season : Season.values()) {       // Vary over all values
      System.out.println(" The season is now " + season);
    }
  }
}
