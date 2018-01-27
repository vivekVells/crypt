/**
* file: StringToInteger.java
* author: Vivek Vellaiyappan Surulimuthu
* course: MSCS630S
* assignment: Lab 1
* due date: Wednesday, January 24, 2018.
* version: 1.0
* 
* This file contains the conversion of the given string into corresponding integer numbers.
*/

/*
* StringToInteger
*	
* This class implements the conversion of given alphabet string into integer numbers
* 
* Objective: a to z or A to Z to be mapped from 0 to 25 with space as 26
*
* Output: Please view at the end of the file. (You can also verify the output at "str2intOutput.txt" file)
*/

// importing required java util packages
// Scanner pkg to use Standard Sys input & Arrays pkg to print the array values as string
import java.util.Scanner;
import java.util.Arrays;

public class StringToInteger {
  // Static Global Constant Variable TOKEN_65 used 
  //   to reduce from the converted alphabet ascii value to obtain 
  //   objective of this program.
  // for e.g.: "CAR" is converted into { 2 0 17 } 
  //   (i.e.) (ASCII)"CAR" - TOKEN_65^(times_the_alphabets_length_individually) 
  //   => 67-65 65-65 82-65 => 2 0 17 
  static final int TOKEN_65 = 65;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str;

    while(scan.hasNextLine()){
      str = scan.nextLine();
      str = str.toUpperCase();
      System.out.print(Arrays.toString(str2int(str)));
      System.out.println();
    }			
    scan.close();
  }

  /*
  * str2int
  *
  * This function receives a string of plainText corresponding to a line of input
  * and returns the corresponding numbers as an array of integers.
  *
  * Parameters:
  * 	plainText: the string value that holds the desired string value to be numbers-converted correspondingly
  *
  * Return value: the array of corresponding integers of the received string plainText
  */

  public static int[] str2int(String plainText) {
    int[] intStr = new int[plainText.length()];
    int intString;

    for(int i=0; i<plainText.length(); i++) {
      intString = ((int)plainText.toCharArray()[i] - TOKEN_65);
        if(intString < 0){
          intStr[i] += 26;
        } else {
          intStr[i] += intString;
        }
    }	
    return intStr;
  }
}

/*
* Program Objective:
* Write a program that takes as input a string from ‘a’ to ‘z’ or ‘A’ to ‘Z’ and transforms it to integers from 0 to 25. 
* If you encounter a space, it should be mapped to 26. Create a method with the following 
*	signature int[] str2int(Strin plainText) that receives a string of plaintext corresponding to a line of input, 
* and returns the corresponding numbers as an array of integers.
*  
* Input:
* input.txt => contents inside this text file are in the following order
* abcdefghijklmnopqrstuvwxyz
* a to z
* Hello
* Cryptography is fun
* A
* car usually
* has four tires
*
* Output:
* Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/1 (master)
* $ javac StringToInteger.java
*
* Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/1 (master)
* $ java StringToInteger < input.txt
* [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
* [0, 26, 19, 14, 26, 25]
* [7, 4, 11, 11, 14]
* [2, 17, 24, 15, 19, 14, 6, 17, 0, 15, 7, 24, 26, 8, 18, 26, 5, 20, 13]
* [0]
* [2, 0, 17, 26, 20, 18, 20, 0, 11, 11, 24]
* [7, 0, 18, 26, 5, 14, 20, 17, 26, 19, 8, 17, 4, 18]
* 
* Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/1 (master)
* $
*
*/
