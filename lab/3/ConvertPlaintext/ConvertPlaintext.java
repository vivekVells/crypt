/**
 * @author <a href="https://github.com/vivekVells">Vivek Vellaiyappan Surulimuthu</a>
 * @version java 1.8
 * file: CoMatrixDeterminant.java
 * description: To convert given plaintext into hex values in array. 
 * author: Vivek Vellaiyappan Surulimuthu
 * course: MSCS630S
 * assignment: Lab 3
 * version: 2.0
 */

import java.util.Scanner;

public class ConvertPlaintext {
  
  /**
  * getHexMatP
  * 
  * Function to return the 2-D array of converted plaintext values
  * 
  * @param char[] parr, char[] chr
  * @return int[][] arr
  */
  public static int[][] getHexMatP(char[] parr, char[] chr) {
    int[][] arr = new int[4][4];
    int count=0;
    
    for(int i=0; i<4; i++) {
      for(int j=0; j<4; j++){
        if(parr.length > count) {
	      arr[i][j] = (int)parr[count];
          ++count;
        } else {
          arr[i][j] = (int)chr[0];
        }
      }
    }
    return arr;
  }
  
  /**
  * Display
  * 
  * Function to display values in mtx array
  * 
  * @param int toMtx[][] 
  */
  public static void display(int toMtx[][]){
    for(int i=0; i<4; i++) {
      for(int j=0; j<4; j++) {
        System.out.print(String.format("%02X", toMtx[j][i]) + "\t");
      }
      System.out.print("\n");
    }
  }

   /**
   * main
   * 
   * Main driver function for this java file
   */
  public static void main(String[] args) {
    String subchar, plaintext;
    Scanner scan = new Scanner(System.in);
    subchar = scan.nextLine();
    plaintext = scan.nextLine();

    char[] parr = plaintext.toCharArray();

    for(int i = 1; i<= (parr.length/16)+1; i++) {
      int k = (i-1)*16, j = 16*i;

      if(j > parr.length) { 
        j = k + (parr.length % 16);
      }

      display(getHexMatP(plaintext.substring(k,j).toCharArray(), subchar.toCharArray()));
      System.out.println();
    }

    // Closing the resource
    scan.close();
  }
}

/**
 * Program Execution:
E:\Marist\Semester2\crypt\vivek\github\lab\3\ConvertPlaintext>javac ConvertPlaintext.java

E:\Marist\Semester2\crypt\vivek\github\lab\3\ConvertPlaintext>java ConvertPlaintext < input1.txt
48      20      64      7E
6F      6D      6F      7E
6C      75      21      7E
61      6E      7E      7E

E:\Marist\Semester2\crypt\vivek\github\lab\3\ConvertPlaintext>java ConvertPlaintext < input2.txt
45      67      65      61
65      6F      20      6D
6E      65      6E      20
20      64      61      69

73      74      64      6F
20      65      61      6C
62      72      6E      69
65      20      20      65

20      30      30      30
2E      30      30      30
30      30      30      30
30      30      30      30

E:\Marist\Semester2\crypt\vivek\github\lab\3\ConvertPlaintext>
 */