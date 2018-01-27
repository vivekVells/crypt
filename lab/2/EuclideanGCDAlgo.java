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
* EuclideanGCDAlgo
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
  * This function returns quotient and then remainder for any given long numbers
  * 
  * Parameters: 2 long numbers: a, b
  *
  * Return: returns quotient and remainder
  */
  public static long[] getQuotientRemainder(long a, long b) {
    long[] tempQuotientRemainder = new long[2];
    tempQuotientRemainder[0] = a/b;
    tempQuotientRemainder[1] = a%b;
    return tempQuotientRemainder;
  }

  /*
  * euclicdAlgWithoutRecursion 
  * 
  * This function returns the GCD calculation of given long args using euclicdAlgorithm without recursion method
  * 
  * Parameters: long arg a, long arg b
  * 
  * Return: returns gcd of any given positive long numbers 
  */
  public static long euclicdAlgWithoutRecursion(long a, long b) {
    long[] quotientRemainder = new long[2];
    // this loop will execute until the remainder equals 0
    do{
      quotientRemainder = getQuotientRemainder(a,b);
      System.out.println("Quotient & remainder: " + quotientRemainder[0] + "\t " + quotientRemainder[1]);
      // this will take care of a < b situation and if that happens, the swap among a & b value done such that a >= b
      if(quotientRemainder[1] != 0) {
        a = b;
        b = quotientRemainder[1];
      }
    }while(quotientRemainder[1] != 0);
    return b;
  }

  /*
  *euclicdAlgWithRecursion 
  * 
  * This function returns the GCD calculation of given long args using euclicdAlgorithm with recursion method
  * 
  * Parameters: long arg a, long arg b
  * 
  * Return: returns gcd of any given positive long numbers 
  */	
  public static long euclicdAlgWithRecursion(long a, long b) {
    long[] quotientRemainder = new long[2];
    quotientRemainder = getQuotientRemainder(a,b);
	
    if(quotientRemainder[1] != 0) {
      a = b;
      b = quotientRemainder[1];
      return euclicdAlgWithRecursion(a,b);
    }else {
      return b;
    }
  }
	
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("\nGCD calculation using Euclidean Algorithm");

    while(scan.hasNextLine()) {
      long a = scan.nextInt(), b = scan.nextInt();

      // I am sure there is some better way to retain the initial value of a and b. 
      //   Doing like this for now.
      long aValueRetained = a, bValueRetained = b;
      System.out.println("\nCalculation for GCD(" + aValueRetained + "," + bValueRetained +"): ");
      
      // to solve the program with and without recursion, the long euclicdAlg(long a, long b) function as per the program instruction was 
      // being changed to euclicdAlgWithoutRecursion(long a, long b) and euclicdAlgWithRecursion(long a, long b)
      // without recursion
      System.out.println("\nWithout Recursion: GCD(" + aValueRetained + "," + bValueRetained + ") = " + euclicdAlgWithoutRecursion(a,b));
			
      // with recursion
      System.out.println("With Recursion   : GCD(" + aValueRetained + "," + bValueRetained + ") = " + euclicdAlgWithRecursion(a,b));
			
      System.out.println("-----------------------------------------------------\n");
      scan.nextLine();
   }
   scan.close();
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
* Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/2 (master)
* $ javac EuclideanGCDAlgo.java

* Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/2 (master)
* $ java EuclideanGCDAlgo < InputEuclideanGCDAlgo.txt

* GCD calculation using Euclidean Algorithm

* Calculation for GCD(75,148):
* Quotient & remainder: 0  75
* Quotient & remainder: 1  73
* Quotient & remainder: 1  2
* Quotient & remainder: 36         1
* Quotient & remainder: 2  0

* Without Recursion: GCD(75,148) = 1
* With Recursion   : GCD(75,148) = 1
* -----------------------------------------------------


* Calculation for GCD(75,75):
* Quotient & remainder: 1  0

* Without Recursion: GCD(75,75) = 75
* With Recursion   : GCD(75,75) = 75
* -----------------------------------------------------


* Calculation for GCD(100,74):
* Quotient & remainder: 1  26
* Quotient & remainder: 2  22
* Quotient & remainder: 1  4
* Quotient & remainder: 5  2
* Quotient & remainder: 2  0

* Without Recursion: GCD(100,74) = 2
* With Recursion   : GCD(100,74) = 2
* -----------------------------------------------------


* Calculation for GCD(1071,462):
* Quotient & remainder: 2  147
* Quotient & remainder: 3  21
* Quotient & remainder: 7  0

* Without Recursion: GCD(1071,462) = 21
* With Recursion   : GCD(1071,462) = 21
* -----------------------------------------------------


* Calculation for GCD(148,75):
* Quotient & remainder: 1  73
* Quotient & remainder: 1  2
* Quotient & remainder: 36         1
* Quotient & remainder: 2  0

* Without Recursion: GCD(148,75) = 1
* With Recursion   : GCD(148,75) = 1
* -----------------------------------------------------
*
*
* Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/2 (master)
* $
*/

