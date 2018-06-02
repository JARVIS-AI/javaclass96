# JAVAB NEMOONE SOAL JAVA PAYAN TERM TJ (95-96)
---

#### Soal 1

**Inja soal 1 sorat soal codesho neveshtam baraton**

*Note 1 : Agar ehyanan ghalat neveshte boodam code o be khodeton nagirid berid az ro barge soal o bebinid - DG na mardi nakonid :)*

##### CODE SORAT SOAL

```java
interface HasName {
  String getName();
}
interface HasJob extends HasName {
  String getJob();
}
class Person implements HasJob {
  private String name;

  public Person(String name) {
    this.name = name;
    System.out.println("Person Constructor: " + name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean equals(Object obj) {
    return this.name.equals(((Person) obj).name);
  }

  public String getJob() {
    return getName() + " unemployed!";
  }
}

class Employee extends Person {
  private String job;

  public Employee(String name, String job) {
    super(name);
    this.job = job;
    System.out.println("Employee Constructor: " + name);
  }

  public String getJob() {
    return getName() + " job: " + job;
  }

  public boolean equals(Employee obj) {
    return super.equals(obj) && job.equals(obj.job);
  }
}
```
***Ghesmate 2 sorat soal***

*Inam hamin toor :)*

##### Code SORAT SOAL GHESMATE 2
```java
public class Main {
  public static void main(String[] args) {
    Person p1 = new Employee("Employee 1", "Job 1");
    Person p2 = new Person("Person 1");
    Employee s1 = new Employee("Employee 2", "Job 2");
    Employee s2 = new Employee("Employee 2", "Job 3");
    System.out.println("-------------------------");
    System.out.println(p1.getJob());
    System.out.println(p2.getJob());
    System.out.println(s1.getJob());
    System.out.println(s2.getJob());
    System.out.println("-------------------------");
    System.out.println(s1.equals(s2));
    HasName a = s1;
    HasName b = s2;
    System.out.println(a.equals(b));
  }
}
```
#### JAVAB

**SOAL 1**

***VOOROODI HA***


>Employee 1 , Job1
>
>Person 1
>
>Employee 2 , Job 2
>
>Employee 2 , Job 3

***KHOOROOGI HA Sade shode***


>Employee 1 Job: Job1
>
>Person 1 Job: unemployed
>
>Employee 2 Job: Job2
>
>Employee 3 Job: Job3

Ghesmate 2 khorogi

>Job 2 = Job 3
>
>Employee 1 = Employee 2

***Khoroogi ha Sade nashode***

>Person constroctor: Employee1
>
>Employee constroctor: Employee1
>
>Person constroctor: person1
>
>Person constroctor: Employee2
>
>Employee constroctor: Employee2
>
>Person constroctor: Employee2
>
>Employee constroctor: Employee2

Ghesmat 2

>Employee1  unemployed
>
>person1  unemployed
>
>Employee2 Job: job2
>
>Employee2 Job:  job3



---

#### Soal 2
Dar soal 2

```java
x = y;
y = z;
w = v;
```
*Nokte 1*

>Ghalate chon `type` har kodom fargh mikone va momkene dar `zarfiat` ona
nabashan

*Nokte 2*

>Masale 2 ineke model tarif kardan harkodm fargh mikone
Yani inke baraye tarif kardan int yejor bayad amal kar dva tarif kardan double ye joor dg
Ke baraye tsarif variables bayad be jozve ghesmate moteghayer ha
moraje konid

**ye nemone :**

```java
x new = nextInt();

x = (x)y;

y = (y)z;

w = (w)v;
```
---

#### Soal 3

In soal **`MOHEMI`** hastesh ``lotfan`` yad begirid chon hatman az **``link list``** ha soal midan.

*Note : code sorat soal hastesh khodetoon toye pdf ham darid*

***Note : JAVAB HAM TOOSHE***

```java
public class ListNode {
  private Object data;
  private ListNode next;
  public Object getData()
  { ... }
  public void setNext(ListNode n)
  { ... }
}

public class List {
  private ListNode first;
  private ListNode last;
  public void IAF(Object d){ ... }
  public void IAE(Object d){ ... }
  public Object RFF(){ ... }
  public Object RFE(){ ... }
}

JAVABE GHEMATE A :

public int getLength() {
  Node temp = first;
  int shomaresh = 0;
  while (temp != null) {
    shomaresh++;
    temp = temp.next;
  }
  return shomaresh;
}

Raveshe Dovom baraye getLength()

public int getLength() {
int size = 0;
  Node temp = new Node();
  if (first == null && last == null)
    return size;
  else {
    temp = first;
    while (temp.getNext() != null) {
      temp = temp.getNext();
      size++;
    }
    return size;
  }
}

JAVABE GHESMATE B : 4 ta ravesh neveshtam

public boolean contains(Object d) {
  Node temp = new Node();
  temp = first;
  while (true) {
    if (temp.getElement() != (Object) d){
      temp = temp.getNext();
      if (temp.getElement() == (Object) d)
        return true;
      else
    return false;
    }
  }
}

public Object contains(int dakhel) {
  Node data = this.first;
  for(int i = 1; i < dakhel; i++) {
    if(data.getData() == d)
    return true;
    else
    return false;
    data = data.getNext();
  }
return data.getData();
}

public Object contains(int dakhel) {
  Node data = first;
  for (int i = 1; i < shomaresh; i++) {
    if (getData() == IAF(Object d)) {
      return true;
      else
      return false;
    }
    return data.getData();
  }
}

public boolean contains(Object d) {
  @override
  Object data;
  Object.equals(Object d);

  for (int i = 1; i < shomaresh; i++) {
    if (data == getData(d)){
      return true;
      else
      return false;
    }
  }
}
```
---

#### Soal 4 :

*Note : code sorat soal hastesh khodetoon toye pdf ham darid*

***Note : JAVAB HAM TOOSHE***

***Raveshe Aval***

```java
public class Matrix() {
  int row;
  int col;
  int i,j;
  int b,c;
  int matrix[][] = new int[b][c];

  int getRow() {
    for (i = 0; i <= b; i++){
      row++;
    }
    return row;
  }

  int getCol() {
    for (int j = 0; j <= c; j++) {
      col++;
    }
    return  col;
  }

  void read() {
  System.out.println("Enter the elements of matrix");
  b = in.nextInt();
  c = in.nextInt();
  for ( i = 0 ; i < b ; i++ )
     for ( j = 0 ; j < c ; j++ )
        matrix[b][c] = in.nextInt();
  }

  void print() {
  int show[][] = new int[n][m];

  for ( c = 0 ; c < m ; c++ ){
     for ( d = 0 ; d < n ; d++ )
        show[d][c] = matrix[c][d];
      }
  }

  Matrix plus(matrix m) {
  int sum[][] = new int[b][c];
    try {
      if ( n != p )
        System.out.println("Matrices with entered orders can't be multiplied with each other.");
      else
      for ( i = 0 ; i < b ; i++ ) {
        for ( j = 0 ; j < c ; j++ ) {
          sum[b][c] = matrix[c][d] + m[c][d];
          System.out.print(sum[b][c]+"\t");
          System.out.println();
        }
      }
    }
    catch (Exception e) {
      throw new RuntimeException("SUMOFMATRIX");
      System.out.println("You can't sum 2d matrixes that not same in row or columns");
    }
  }
}
```

***Raveshe Dovom***

```java
import java.util.Scanner;
public class Matrix {
  static Scanner in = new Scanner(System.in);

  public static int getRow() {
    int row = in.nextInt();
    return row;
  }
  
  public static int getCol() {
    int col = in.nextInt();
    return col;
  }

  public static void read(int mat[][]) {
    for (int a = 0; a < mat.length; a++) //++a
      for (int b = 0; b < mat[a].length; b++) //++b
      mat[a][b] = in.nextInt();
  }
  //Inja mitoonid override ham bokonid
  
  public static void print(int mat[][]) {
    for (int a = 0; a < mat.length; ++a) {
      for (int b = 0; b < mat[0].length; ++b)
        System.out.printf("\t", mat[a][b]);
        System.out.printf("\n");
    }
  }
  //inja ham hamin toor
  public static int[][] plus(int mat1[][], int mat2[][]) {
    int[][] mat3 = new int[m1.length][mat1[0].length];
    for (int a = 0; a < mat3.length; ++a){
      for (int b = 0; b < mat3[a].length; ++b){
        mat3[a][b] = mat1[a][b] + mat2[a][b];
      return mat3;
  }
 }
}
```

**SOLA 5 RO DARAM MINIVISAM HANOO TAMOM NASHODE**

### please wait for next question ...

## Written By Amir Mohammad Safari