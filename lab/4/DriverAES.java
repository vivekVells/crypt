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
 * Objective: DriverAES.java program will only test your implementation by calling aesRoundKeys() 
 *  providing valid data.
 * Input: Please use the 
 */
public class DriverAES extends AESCipher {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String inputValue;
    
    AESCipher aesCipherObject = new AESCipher();
    
    System.out.println("Input: ");
    inputValue = scan.nextLine();
    System.out.println(inputValue);
    System.out.println("Output: ");
    String[] roundKeysHex = aesCipherObject.getRoundKeysHex(inputValue);

    for(String key: roundKeysHex) {
      System.out.print(key);
    }

    // closing the used resource
    scan.close();
  }
}


/*
Program Execution:
Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/4 (master)
$ javac AESCipher.java
Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/4 (master)
$ javac DriverAES.java
Vivek-Pc@kev MINGW64 /e/Marist/Semester2/Cryptography/lab/4 (master)
$ java DriverAES < InputDriverAES.txt
Input:
5468617473206D79204B756E67204675
Output:
5468617473206D79204B756E67204675E232FCF191129188B159E4E6D679A29356082007C71AB18F76435569A03AF7FAD2600DE7157ABC686339E901C3031EFBA11202C9B468BEA1D75157A01452495BB1293B3305418592D210D232C6429B69BD3DC287B87C47156A6C9527AC2E0E4ECC96ED1674EAAA031E863F24B2A8316A8E51EF21FABB4522E43D7A0656954B6CBFE2BF904559FAB2A16480B4F7F1CBD828FDDEF86DA4244ACCC0A4FE3B316F26
*/