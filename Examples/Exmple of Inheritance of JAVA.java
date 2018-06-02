////JAVA INHERITANCE 1 EXAMPLE

// Listing 1. The extends keyword specifies a parent-child relationship
//======================================================================

class Vehicle
{
   // member declarations
}
class Car extends Vehicle
{
   // inherit accessible members from Vehicle
   // provide own member declarations
}
class Account
{
   // member declarations
}
class SavingsAccount extends Account
{
   // inherit accessible members from Account
   // provide own member declarations
}

// Listing 2. An Account parent class
//====================================

class Account
{
   private String name;

   private long amount;

   Account(String name, long amount)
   {
      this.name = name;
      setAmount(amount);
   }

   void deposit(long amount)
   {
      this.amount += amount;
   }

   String getName()
   {
      return name;
   }

   long getAmount()
   {
      return amount;
   }

   void setAmount(long amount)
   {
      this.amount = amount;
   }
}

// Listing 3. A SavingsAccount child class extends its Account parent class
//=========================================================================

class SavingsAccount extends Account
{
   SavingsAccount(long amount)
   {
      super("savings", amount);
   }
}

// Listing 4. A CheckingAccount child class extends its Account parent class
//==========================================================================

class CheckingAccount extends Account
{
   CheckingAccount(long amount)
   {
      super("checking", amount);
   }

   void withdraw(long amount)
   {
      setAmount(getAmount() - amount);
   }
}

// Demonstrating the Account class hierarchy

// I've created an AccountDemo application class that lets you try out the Account class hierarchy. First take a look at AccountDemo's source code.

// Listing 5. AccountDemo demonstrates the account class hierarchy
//================================================================

class AccountDemo
{
   public static void main(String[] args)
   {
      SavingsAccount sa = new SavingsAccount(10000);
      System.out.println("account name: " + sa.getName());
      System.out.println("initial amount: " + sa.getAmount());
      sa.deposit(5000);
      System.out.println("new amount after deposit: " + sa.getAmount());

      CheckingAccount ca = new CheckingAccount(20000);
      System.out.println("account name: " + ca.getName());
      System.out.println("initial amount: " + ca.getAmount());
      ca.deposit(6000);
      System.out.println("new amount after deposit: " + ca.getAmount());
      ca.withdraw(3000);
      System.out.println("new amount after withdrawal: " + ca.getAmount());
   }
}

// Methode Overriding
// Listing 6. Declaring a print() method to be overridden
//=======================================================

class Vehicle
{
   private String make;
   private String model;
   private int year;

   Vehicle(String make, String model, int year)
   {
      this.make = make;
      this.model = model;
      this.year = year;
   }

   String getMake()
   {
      return make;
   }

   String getModel()
   {
      return model;
   }

   int getYear()
   {
      return year;
   }

   void print()
   {
      System.out.println("Make: " + make + ", Model: " + model + ", Year: " +
                         year);
   }
}

// Listing 7. Overriding print() in a Truck subclass
//==================================================

class Truck extends Vehicle
{
   private double tonnage;

   Truck(String make, String model, int year, double tonnage)
   {
      super(make, model, year);
      this.tonnage = tonnage;
   }

   double getTonnage()
   {
      return tonnage;
   }

   void print()
   {
      super.print();
      System.out.println("Tonnage: " + tonnage);
   }
}

Truck truck = new Truck("Ford", "F150", 2008, 0.5);
System.out.println("Make = " + truck.getMake());
System.out.println("Model = " + truck.getModel());
System.out.println("Year = " + truck.getYear());
System.out.println("Tonnage = " + truck.getTonnage());
truck.print();

@Override
void print(String owner)
{
   System.out.print("Owner: " + owner);
   super.print();
}

////JAVA INHERITANCE 2 EXAMPLE
//============================
class Calculation {
   int z;
	
   public void addition(int x, int y) {
      z = x + y;
      System.out.println("The sum of the given numbers:"+z);
   }
	
   public void Subtraction(int x, int y) {
      z = x - y;
      System.out.println("The difference between the given numbers:"+z);
   }
}

public class My_Calculation extends Calculation {
   public void multiplication(int x, int y) {
      z = x * y;
      System.out.println("The product of the given numbers:"+z);
   }
	
   public static void main(String args[]) {
      int a = 20, b = 10;
      My_Calculation demo = new My_Calculation();
      demo.addition(a, b);
      demo.Subtraction(a, b);
      demo.multiplication(a, b);
   }
}

//// JAVA INHERITANCE 3 EXAMPLE
//===============================
class Super_class {
   int num = 20;

   // display method of superclass
   public void display() {
      System.out.println("This is the display method of superclass");
   }
}

public class Sub_class extends Super_class {
   int num = 10;

   // display method of sub class
   public void display() {
      System.out.println("This is the display method of subclass");
   }

   public void my_method() {
      // Instantiating subclass
      Sub_class sub = new Sub_class();

      // Invoking the display() method of sub class
      sub.display();

      // Invoking the display() method of superclass
      super.display();

      // printing the value of variable num of subclass
      System.out.println("value of the variable named num in sub class:"+ sub.num);

      // printing the value of variable num of superclass
      System.out.println("value of the variable named num in super class:"+ super.num);
   }

   public static void main(String args[]) {
      Sub_class obj = new Sub_class();
      obj.my_method();
   }
}