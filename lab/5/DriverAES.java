/**
 * @author <a href="https://github.com/vivekVells">Vivek Vellaiyappan Surulimuthu</a>
 * @version java 1.8
 * file: DriverAES.java
 * description: main driver file for AESCipher.java
 * author: Vivek Vellaiyappan Surulimuthu
 * course: MSCS630S
 * assignment: Lab 4
 * due date: 05-04-2018
 */

import java.util.Scanner;

/**
 * DriverAES
 *
 * This file is just a driver a file for AESCipher.java.
 */
public class DriverAES {
  public static void main(String[] args){
    AESCipher aesCipherObject = new AESCipher();
    Scanner scan = new Scanner(System.in);
    String input;
    String [] sHexSkey = new String[2];
    int index = 0;

    while(scan.hasNextLine() && !(input = scan.nextLine()).equals("")) {
      sHexSkey[index] = input.trim();
      if(index == 1) {
        break;
      }
      index++;
    }
    
    System.out.println("Input: ");
    System.out.println(sHexSkey[0]);
    System.out.println(sHexSkey[1]);
    System.out.println("Output:");
    
    if (sHexSkey.length == 2){
      aesCipherObject.prep(sHexSkey[0],sHexSkey[1]);
    }else{
      System.out.println("Invalid input. Try Again!");
    }

    scan.close();
  }
}

/*
Program Execution:
Vivek-Pc@kev MINGW64 /e/Marist/Semester2/crypt/vivek/github/lab/5 (master)
$ javac DriverAES.java

Vivek-Pc@kev MINGW64 /e/Marist/Semester2/crypt/vivek/github/lab/5 (master)
$ javac AESCipher.java

Vivek-Pc@kev MINGW64 /e/Marist/Semester2/crypt/vivek/github/lab/5 (master)
$ java DriverAES
5468617473206D79204B756E67204675
54776F204F6E65204E696E652054776F
Input:
5468617473206D79204B756E67204675
54776F204F6E65204E696E652054776F
Output:
29C3505F571420F6402299B31A02D73A

Vivek-Pc@kev MINGW64 /e/Marist/Semester2/crypt/vivek/github/lab/5 (master)
$ java DriverAES < test.1.txt
Input:
5468617473206D79204B756E67204675
54776F204F6E65204E696E652054776F
Output:
29C3505F571420F6402299B31A02D73A

Vivek-Pc@kev MINGW64 /e/Marist/Semester2/crypt/vivek/github/lab/5 (master)
$ java DriverAES < test.2.txt
Input:
7868617478906D7920A2756E67204675
91326F204F6B85204E696E652054556F
Output:
7B4E12369CDC1ED153E8FF1758904DB9

Vivek-Pc@kev MINGW64 /e/Marist/Semester2/crypt/vivek/github/lab/5 (master)
$ java DriverAES < test.3.txt
Input:
F65468237448206D79204C256E689046
9077A6204F6E65204B296E653054776F
Output:
E5A6B117473C2E0DB856364CC398D483
*/
