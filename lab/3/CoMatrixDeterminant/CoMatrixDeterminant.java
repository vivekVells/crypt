/**
 * @author <a href="https://github.com/vivekVells">Vivek Vellaiyappan Surulimuthu</a>
 * @version java 1.8
 * file: CoMatrixDeterminant.java
 * description: To find the determinant of n*n matrix
 * author: Vivek Vellaiyappan Surulimuthu
 * course: MSCS630S
 * assignment: Lab 3
 * version: 2.0
 */

import java.util.Scanner;

public class CoMatrixDeterminant {
  
  /**
   * cofModDet 
   * 
   * Function to return the determinant of n*n matrix
   * 
   * @param:
   *   m - modulo value
   *   mtx - n*n matrix
   */
  public static int cofModDet(int m, int[][] mtx) {
    int[][] tmpMtx;
    int val = 0;
    
    if(mtx.length == 1) {
      return mtx[0][0];
    }
    
    if(mtx.length == 2) {
      return mtx[0][0] * mtx[1][1] - mtx[0][1] * mtx[1][0];
    }

    for(int i=0; i<mtx[0].length; i++) {
      tmpMtx = new int[mtx.length-1][mtx[0].length-1];

      for(int j=1; j<mtx.length; j++) {
        for(int k=0; k<mtx[0].length; k++) {
          if(k<i)
            tmpMtx[j-1][k] = mtx[j][k];
          else if(k>i)
            tmpMtx[j-1][k-1] = mtx[j][k];
        }
      }

      val += mtx[0][i]*(int)Math.pow(-1, i)*cofModDet(1, tmpMtx);
    }  
    return val % m;
    }

    /**
     * main
     * 
     * Main driver function for this java file
     */
    public static void main(String[] args) {

      Scanner scan = new Scanner(System.in);
      
      int modulo = scan.nextInt();
      int matrixLength = scan.nextInt();
      System.out.print("modulo: " + modulo);
      System.out.println(" || len: " + matrixLength);

      int[][] mtx = new int[matrixLength][matrixLength];

      for(int i=0; i<mtx.length; i++) {
        for(int j=0; j<mtx.length; j++) {
          mtx[i][j] = scan.nextInt();
          System.out.print(mtx[i][j] + " ");
          mtx[i][j] %= modulo;
        }System.out.println();
      }

      System.out.println("cofModDet: " +  cofModDet(modulo, mtx));

      // closing the resources 
      scan.close();
    }
}

/**
 * Program Execution:
 * 
E:\Marist\Semester2\crypt\vivek\github\lab\3\CoMatrixDeterminant>javac CoMatrixDeterminant.java

E:\Marist\Semester2\crypt\vivek\github\lab\3\CoMatrixDeterminant>java CoMatrixDeterminant < input1.txt
modulo: 12 || len: 2
3 2
2 3
cofModDet: 5

E:\Marist\Semester2\crypt\vivek\github\lab\3\CoMatrixDeterminant>java CoMatrixDeterminant < input2.txt
modulo: 3 || len: 2
1 2
9 8
cofModDet: 2

E:\Marist\Semester2\crypt\vivek\github\lab\3\CoMatrixDeterminant>java CoMatrixDeterminant < input3.txt
modulo: 9 || len: 3
7 5 2
0 6 4
8 2 5
cofModDet: 2

E:\Marist\Semester2\crypt\vivek\github\lab\3\CoMatrixDeterminant>
 */