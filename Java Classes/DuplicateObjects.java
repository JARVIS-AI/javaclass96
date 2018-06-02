public class DuplicateObjects {
  public static void main(String[] args) {
    PetDog myPet = new PetDog("Fang", "Chihuahua", "Max", "Circus flea");
    System.out.println("\nMy pet details:\n"+ myPet);
    PetDog yourPet = new PetDog(myPet);
    System.out.println("\nYour pet details:\n"+yourPet);
    yourPet.setName("Gnasher");                                        // Change your dog's name
    yourPet.getFlea().setName("Atlas");                                // Change your dog's flea's name
    System.out.println("\nYour pet details:\n"+yourPet);
    System.out.println("\nMy pet details:\n"+ myPet);

  }
}
