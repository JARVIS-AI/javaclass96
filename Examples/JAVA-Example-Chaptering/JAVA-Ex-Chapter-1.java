// The sample program in Java (My Array)

import java.util.Scanner;

public class MyArrayTest
{
        public static void main(String[] args) {
        
        // final int max = 50;
        
        Scanner in = new Scanner(System.in);
        
        System.out.printf("N :");
        int n = in.nextInt();
        int [] x;
        x= new int[n];
        
        System.out.printf("Enter %d Numbers :",x.length);
        MyArray.read(x);
        
        System.out.printf("\nNumber for search :");
        int key = nextInt();
        
        int index = MyArray.linearSearch(x, key);
        
        if (index == -1)
                System.out.printf("The number not found !");
        else
                System.out.printf("The number is %d  th element.\n",index + 1);
        
        MyArray.bubbleSort(x);
        System.out.printf("\nThe sorted numbers :");
        MyArray.print(x);
        
        System.out.ptintf("\nNumber for search :");