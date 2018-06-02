public class PondRadius {
  public static void main(String[] args) {
    // Calculate the radius of a pond
    // which can hold 20 fish averaging 10 inches long
    int fishCount = 20;                                                // Number of fish in pond
    int fishLength = 10;                                               // Average fish length
    int inchesPerFoot = 12;                                            // Number of inches in one foot
    int lengthPerSqFt = 2;                                             // Fish length per square foot of surface
    double radius = 0.0;                                               // Pond radius in feet

    int feet = 0;                                                      // Pond radius - whole feet
    int inches = 0;                                                    //             - and whole inches

    double pondArea = (double)(fishCount*fishLength)/lengthPerSqFt;
    radius = Math.sqrt(pondArea/Math.PI);

    // Get the whole feet and nothing but the feet
    feet = (int)Math.floor(radius);
    inches = (int)Math.round(inchesPerFoot*(radius - feet));           // Get the inches

    System.out.println("To hold " + fishCount + " fish averaging " + fishLength + " inches long you need a pond with an area of \n" + pondArea + " square feet.");
    System.out.println("The radius of a pond with area " + pondArea + " square feet is " + feet + " feet " + inches + " inches.");
  }
}
