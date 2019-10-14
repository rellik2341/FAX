package vaje_2;

import java.util.Random;

public class MatrixMul {
	
	public static int n = 100;
	public static int A[][];
	public static int B[][];
	public static int C[][];
	public static int CP[][];
	
	public static void main(String[] args) {
		
		A = new int[n][n];
		B = new int[n][n];
		C = new int[n][n];
		CP = new int[n][n];
		
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = random.nextInt(1000);
				B[i][j] = random.nextInt(1000);
				
			}
		}
		
	//multiplication
		
		long t0 = System.currentTimeMillis();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		
		long t1 = System.currentTimeMillis() - t0;
		System.out.println("Sequential: " + t1 + "ms");
		
		Worker[] workers = new Worker[n];
		
		for (int i = 0; i < n; i++) {
			workers[i] = new Worker(i);
		}
		
		for (int i = 0; i < n; i++) {
			workers[i].start();
		}
		for (int i = 0; i < n; i++) {
			try {
				workers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		t1 = System.currentTimeMillis() - t0;
		System.out.println("parallel: " + t1 + "ms");
		System.out.println("Check validity: " + checkValidity());
		
		/*********************************
		printMatrix(A);
		System.out.println("----");
		printMatrix(B);
		System.out.println("----");
		System.out.println("REZULTAT: ");
		System.out.println("----");
		printMatrix(C);
		***********************************/
	}
	
	public static void printMatrix(int matrix[][]) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		System.out.println();
		}
	}
	public static boolean checkValidity() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(C[i][j] != CP[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
