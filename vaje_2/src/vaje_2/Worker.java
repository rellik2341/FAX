package vaje_2;

public class Worker extends Thread{

	private int index;
		public Worker(int index) {
			this.index = index;
		}
	
	
	public void run() {
		for (int j = 0; j < MatrixMul.n; j++) {
			for (int k = 0; k < MatrixMul.n; k++) {

			MatrixMul.CP[index][j] += MatrixMul.A[index][k] * MatrixMul.B[k][j];
				
			}
		}
	}
	
	
	
}

