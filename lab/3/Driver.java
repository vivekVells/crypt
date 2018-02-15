import java.util.Scanner;

public class Driver {
	
	protected static Scanner scan = new Scanner(System.in);
	
	protected static int coDefMod(int[][] A) {
		return 0;
	}
	
	public static void main(String[] args) {
		// figure out which data type to use here. short vs int vs long
		int modNum = scan.nextInt();
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
