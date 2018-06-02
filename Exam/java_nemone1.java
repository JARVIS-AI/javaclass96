//Why the below code is showing compile time error ?

interface X
{
        void methodX();
}

class Y implements X
{
        void methodX()
        {
                System.out.println("Method X");
        }
}


//================================================



//Is below code correct ?

class A
{
        //class A
}

interface B extends A
{
        //Interface B extends class A
}


//================================================


//Is the below program written correctly ? If yes what will be the output ?

class A implements B
{
        public int methodB(int i)
        {
                return i =+ i * i;
        }
}

interface B
{
        int methodB(int i);
}

public class mainClass
{
        public static void main(String[] args)
        {
                B b = new A();
                System.out.println(b.methodB(2));
        }
}

//================================================

// What is output ?

interface X
{
        char c = 'A';
        char methodX();
}

class Y implements X
{
        {
                System.out.println(c);
        }
        
        public char methodX()
        {
                char c = this.c();
                
                return ++c;
        }
}

public class MainClass
{
        public static void main(String[] args)
        {
                Y y = new Y();
                System.out.println(y.methodX());
                System.out.println(y.c);
                System.out.println(x.c);
        }
}


//================================================

//What is output ?

interface One
{
        String s = "Final";
        String methodONE();
}

interface Two
{
        String methodONE();
}

abstract class Three
{
        String s = "NOT FINAL";
        
        public abstract String methodONE();
}

class Four extends Three implements One, Two
{
        public String methodONE()
        {
                String s = super.s + One.s;
                return s;
        }
}

public class MainClass
{
        public static void main(String[] args)
        {
                Four four = new Four();
                System.out.println(four.methodONE());
                One one = four;
                Syste,.out.println(one.s);
        }
}

//================================================

// How can we fix the below code ?

abstract class A
{
        abstract int add(int a, int b);
}

class B extends A
{

}


//================================================

//Show what is error ?

abstract class AbstractClass
{
        private abstract int abstractMethod();
}

//================================================

//What is output ?

abstract class A
{
        abstract void firstMethod();
        
        void secondMethod()
        {
                System.out.println("SECOND");
                firstMethod();
        }
}

abstract class B extends A
{
        @override
        void firstMethod()
        {
                System.out.println("FIRST");
                thirdMethod();
        }
        
        abstract void thirdMethod();
}

class C extends B
{
        @override
        void thirdMethod()
        {
                System.out.println("THIRD");
        }
}

public class MainClass
{
        public static void main(String[] args)
        {
                C c = new C();
                
                c.firstMethod();
                c.secondMethod();
                c.thirdMethod();
        }
}

//================================================

// What is output ?

abstract class X
{
     int i = 111;
     
     int methodX();
     {
          return methodX(i);
     }
     
     abstract int methodX(int i);
     
}

class Y extends X
{
    @override
    int methodX(int i)
    {
          return ++i + i++;
    }
}

public class MainClass
{
      public static void main(String[] args)
      {
            Y y = new Y();
            
            System.out.println(y.methodX());
      }
}


//================================================


//What is ouput ?

class X
{
    void method(int a)
    {
          System.out.println("ONE");
    }
    
    void method(double d)
    {
          System.out.println("TWO");
    }
}

class Y extends X
{
        @override
        void method(double d)
        {
              System.out.println("THREE");
        }
}

public class MainClass
{
      public static void main(String[] args)
      {
            new Y().method(100);
      }
}