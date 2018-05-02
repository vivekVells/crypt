import java.util.Scanner;

public class Driver {
	
	protected static Scanner scan = new Scanner(System.in);
	
	protected static int coDefMod(int[][] A) {
		int i = A.length, j = A.length;
		
		if (i == 1) {
			return A[0][0];
		} else  if (i == 2) {
			--i; --j;
			if (i ==1  && j == 1 ) {
				// A[0][0] * A[1][1] - A[0][1] * A[1][1]
				return (A[i-1][j-1] * A[i][j] - A[i-1][j] * A[i][j-1]);
			}else {
				return 0;
			}
		} else if (i == 3) {
			--i; --j;
			int det1 = 0, det2 = 0, det3 = 0;
			// for 00
			//det1 = (A[1][1] * A[2][2] - A[2][1] * A[1][2]);
			det1 = (A[i-1][j-1] * A[i][j] - A[i][j-1] * A[i-1][j]);
			System.out.println("det(A[0][0]): " + det1);
			
			//det2 = (A[1][0] * A[2][2] - A[2][0] * A[1][2]);
			det2 = (A[i-1][j-2] * A[i][j] - A[i][j-2] * A[i-1][j]);
			System.out.println("det(A[0][1]): " + det2);
			
			//det3 = (A[1][0] * A[2][1] - A[2][0] * A[1][1]);
			det3 = (A[i-1][j-2] * A[i][j-1] - A[i][j-2] * A[i-1][j-1]);
			System.out.println("det(A[0][2]): " + det3);
			return A[i-2][j-2] * det1 - A[i-2][j-1] * det2 + A[i-2][j] * det3;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// figure out which data type to use here. short vs int vs long
		//int modNum = scan.nextInt();
		int matrixSize = scan.nextInt();
		int[][] A = new int[matrixSize][matrixSize];
		int determinant;
		
		for (int i=0; i<matrixSize; i++) {
			for (int j=0; j<matrixSize; j++) {
				A[i][j] = scan.nextInt();
			}
		}
		
		determinant = coDefMod(A);
		
		System.out.println("Cofactor expansion of modular matrix: " + coDefMod(A));
	}
}


/*
We are reaching there.....
Console Output:
maristuser@LBESCRIP-36 MINGW64 ~/Desktop/secAlgo/github/lab/3 (master)
$ javac Driver.java

maristuser@LBESCRIP-36 MINGW64 ~/Desktop/secAlgo/github/lab/3 (master)
$ java Driver
3
7 5 2 0 6 4 8 2 5
0
3det(A[0][0]): 22
det(A[0][1]): -32
det(A[0][2]): -48
det(A[0][0]): 22
det(A[0][1]): -32
det(A[0][2]): -48
Cofactor expansion of modular matrix: 6

maristuser@LBESCRIP-36 MINGW64 ~/Desktop/secAlgo/github/lab/3 (master)
$
*/