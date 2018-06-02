public class UseStringBuffer {
  public static void main(String[] args) {
    StringBuffer sentence = new StringBuffer(20);
    System.out.println("\nStringBuffer object capacity is "+ sentence.capacity() +
                       " and string length is "+sentence.length());

    // Append all the words to the StringBuffer object
    String[] words = {"Too"  , "many", "cooks", "spoil", "the" , "broth"};
    sentence.append(words[0]);
    for(int i = 1 ; i < words.length ; ++i) {
      sentence.append(' ').append(words[i]);
    }

    // Show the result
    System.out.println("\nString in StringBuffer object is:\n" + sentence.toString());
    System.out.println("StringBuffer object capacity is now " +
                                          sentence.capacity() +
                                          " and string length is "+sentence.length());

    // Now modify the string by inserting characters
    sentence.insert(sentence.lastIndexOf("cooks")+4,"ie");
    sentence.insert(sentence.lastIndexOf("broth")+5, "er");
    System.out.println("\nString in StringBuffer object is:\n" + sentence);
    System.out.println("StringBuffer object capacity is now " +
                                          sentence.capacity() +
                                          " and string length is "+sentence.length());

  }
}
