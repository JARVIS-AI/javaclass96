import static java.lang.Long.toHexString;

public class PackingCharacters {
  public static void main(String[] args) {
    char letterA = 'A';
    char letterB = 'B';
    char letterC = 'C';
    char letterD = 'D';
    long packed = 0L;
    packed = letterD;                                                  // Store D
    packed = (packed << 16) | letterC;                                 // Shift and add the next letter - C
    packed = (packed << 16) | letterB;                                 // Shift and add the next letter - B
    packed = (packed << 16) | letterA;                                 // Shift and add the next letter - A
    System.out.println("packed now contains 0x" + toHexString(packed));

    // Now unpack the letters and output them
    long mask = 0xFFFF;                                                // Rightmost 16 bits as 1
    char letter = (char)(packed & mask);                               // Extract the rightmost letter
    System.out.println("From right to left the letters in packed are:");
    System.out.println("  " + letter + "  0x" + toHexString(letter));
    packed >>= 16;                                                     // Shift out the rightmost letter
    letter = (char)(packed & mask);                                    // Extract the new rightmost letter
    System.out.println("  " + letter + "  0x" + toHexString(letter));
    packed >>= 16;                                                     // Shift out the rightmost letter
    letter = (char)(packed & mask);                                    // Extract the new rightmost letter
    System.out.println("  " + letter + "  0x" + toHexString(letter));
    packed >>= 16;                                                     // Shift out the rightmost letter
    letter = (char)(packed & mask);                                    // Extract the new rightmost letter
    System.out.println("  " + letter + "  0x" + toHexString(letter));
  }
}
