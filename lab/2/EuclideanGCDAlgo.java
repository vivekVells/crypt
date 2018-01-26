/**
* file: EuclideanGCDAlgo.java
* author: Vivek Vellaiyappan Surulimuthu
* course: MSCS630S
* assignment: Lab 2 - part 1
* due date: Wednesday, February 7, 2018.
* 
* This file contains the code to implement Euclidean algorithm in order to find GCD of given numbers.
*/

/*
*	EuclideanGCDAlgo
*	
* This class implements Euclidean algorithm to find GCD of given numbers
* 
* Objective: GCD of given numbers using Euclidean algorithm
*
* Output: Please view at the end of the file. (You can also verify the output at "OutputEuclideanGCDAlgo.txt" file)
*/

// importing required java util packages
// Scanner pkg to use Standard Sys input 
import java.util.Scanner;

public class EuclideanGCDAlgo {
	
  /*
  * getQuotientRemainder
  * 
  * This function returns quotient and then remainder for any given integer numbers
  * 
  * Parameters: 2 integer numbers: a, b
  *
  * Return: returns quotient and remainder
  */
  public static int[] getQuotientRemainder(int a, int b){
    int[] tempQuotientRemainder = new int[2];
    tempQuotientRemainder[0] = a/b;
    tempQuotientRemainder[1] = a%b;
    return tempQuotientRemainder;
  }
	
  /*
  * getBiggerDividend
  * 
  * This function returns biggerDividendFirst the logic is made such that 'a' is divided by 'b'
  *   so, to make that possible whenever 'a' is not greater than or equal to 'b', we have to make the swap
  * 
  * Parameters: 2 integer numbers: a, b
  *
  * Return: returns value such that first arg is always greater than the second arg
  */	
  public static int[] getBiggerDividend(int a, int b){
    int[] tempDividendDivisor = new int[2];
    if(!(a>=b)){
    int temp = a;
    a = b;
    b = temp;
    }
    return tempDividendDivisor;
  }
	
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    System.out.println("\nGCD calculation using Euclidean Algorithm");

    while(scan.hasNextLine()){
      int a = scan.nextInt(), b = scan.nextInt();

      // I am sure there is some better way to retain the initial value of a and b. 
      //   Doing like this for now.
      int aValueRetained = a, bValueRetained = b;
      int[] quotientRemainder = new int[2];

      System.out.println("\nCalculation for GCD(" + aValueRetained + "," + bValueRetained +"): ");

      // this loop will execute until the remainder equals 0
      do{
        getBiggerDividend(a,b);
        quotientRemainder = getQuotientRemainder(a,b);
        System.out.println("Quotient & remainder: " + quotientRemainder[0] + "\t " + quotientRemainder[1]);

        if(quotientRemainder[1] != 0){
        a = b;
        b = quotientRemainder[1];
        }
     }while(quotientRemainder[1] != 0);

     System.out.println("GCD(" + aValueRetained + "," + bValueRetained + ") = " + b);
     System.out.println("-----------------------------------------------------\n");
   }
	}
	
}

/*
* Program Objective:
* Use Euclidean Algo - GCD Implement
*  
* Input:
* (refer the InputEuclideanGCDAlgo.txt file). But inside it, the followings are available
* 100 74
* 1071 462
* 148 75
*
* Output:
* maristuser@LBESCRIP-35 MINGW64 ~/Desktop/MSCS630Lab2
* $ javac EuclideanGCDAlgo.java
*
* maristuser@LBESCRIP-35 MINGW64 ~/Desktop/MSCS630Lab2
* $ java EuclideanGCDAlgo < InputEuclideanGCDAlgo.txt
* 
* GCD calculation using Euclidean Algorithm
* 
* Calculation for GCD(100,74):
* Quotient & remainder: 1  26
*	Quotient & remainder: 2  22
*	Quotient & remainder: 1  4
*	Quotient & remainder: 5  2
*	Quotient & remainder: 2  0
*	GCD(100,74) = 2
*	-----------------------------------------------------
*
*
*	Calculation for GCD(1071,462):
*	Quotient & remainder: 2  147
*	Quotient & remainder: 3  21
*	Quotient & remainder: 7  0
*	GCD(1071,462) = 21
*	-----------------------------------------------------
*
*
*	Calculation for GCD(148,75):
*	Quotient & remainder: 1  73
*	Quotient & remainder: 1  2
*	Quotient & remainder: 36         1
*	Quotient & remainder: 2  0
*	GCD(148,75) = 1
*-----------------------------------------------------
*
* 
* maristuser@LBESCRIP-35 MINGW64 ~/Desktop/MSCS630Lab2
* $
*
*
*/
