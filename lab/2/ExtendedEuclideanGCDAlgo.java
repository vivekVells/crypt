/**
* file: ExtendedEuclideanGCDAlgo.java
* author: Vivek Vellaiyappan Surulimuthu
* course: MSCS630S
* assignment: Lab 2 - part 2
* due date: Wednesday, February 7, 2018.
* 
*/

import java.util.Scanner;

/*
* ExtendedEuclideanGCDAlgo
*	
* This file contains the code to implement Extended Euclidean algorithm in order to find GCD of given numbers and greatest common divisors of the given two positive numbers.
* 
* Objective: long[] euclidAlgExt(long a, long b) that receives a pair of positive integers, and returns an array long integers of length three, corresponding to d, x, and y
*
* Input: Please use the file "" attached along with this code "ExtenEuclidINPUT.txt"
* Output: Please view at the end of the file. (You can also verify the output at "ExtendedEuclideanGCDAlgoOUTPUT.txt" file)
*/
public class ExtendedEuclideanGCDAlgo {
  public static Scanner scan = new Scanner(System.in);
	
  /**
  * arrayCopy			Performs the shallow copy of the given array args
  * 
  * @param source
  * @param dest
  * @return		returns the copied version from source to dest arg
  */
  public static long[] arrayCopy(long[] source, long[] dest) {
    for(int i=0; i<3; i++) {
      dest[i] = source[i];
    }
    return dest;
  }

  /**
  * euclidAlgExt			Performs the extended euclidean Algorithm of finding the gcd of the numbers along with the greatest common divisor of two positive integers a and b
  * 			
  * @param a
  * @param b
  * @return		returns an array where array[0] has the gcd, array[1] has x and array[2] has y (i.e) gcd(a,b) = ax + by;
  */
  public static long[] euclidAlgExt(long a, long b) {
    long[] U = new long[] {a, 1, 0};
    long[] V = new long[] {b, 0, 1};
    long[] W = new long[3];
    long q;

    while(V[0] > 0) {
      q = (U[0]/V[0]);
      for(int i=0; i<3; i++) {
        W[i] = U[i] - V[i] * q;
      }
      arrayCopy(V, U);
      arrayCopy(W, V);
    }
    return U;
  }
	
  /**
  * main			main driver of this program
  * 
  * @param args
  */
  public static void main(String[] args) {
    long a, b;

    while(scan.hasNextLine()) {
      a = scan.nextLong();
      b = scan.nextLong();
			
      // swap a, b based on their greater value. exchange b & a value if b > a
      if (b > a) {
        long temp;
	temp = a;
	a = b;
	b = temp;				
      }

      long val[] = euclidAlgExt(a,b);
      System.out.println("gcd(a,b) = aX + bY");
      System.out.println("d = gcd( " + a + "," + b + ",) = " + val[0] + " ;x = " + val[1] + " ;y = " + val[2] + "\n");
      scan.nextLine();
    }
  }
}


/*
Input:
148 75
1155 862
240 46

Output:
Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/2 (master)
$ javac ExtendedEuclideanGCDAlgo.java

Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/2 (master)
$ java ExtendedEuclideanGCDAlgo < ExtenEuclidInput.txt
gcd(a,b) = aX + bY
d = gcd( 148,75,) = 1 ;x = 37 ;y = -73

gcd(a,b) = aX + bY
d = gcd( 1155,862,) = 1 ;x = 203 ;y = -272

gcd(a,b) = aX + bY
d = gcd( 240,46,) = 2 ;x = -9 ;y = 47


Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/2 (master)
$
*/
