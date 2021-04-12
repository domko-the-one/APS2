import java.util.Scanner;







public class izziv6 {

	static class Matrix {


		private int[][] m;
	
		public int n; //only square matrices
	
		public Matrix(int n){
	
			this.n = n;
	
			m = new int[n][n];
	
		}
	
	
		//set value at i,j
		public void setV(int i, int j, int val){
	
			m[i][j] = val;
	
		}
	
	
		// get value at index i,j
		public int v(int i, int j){
	
			return m[i][j];
	
		}
	
	
		// return a square submatrix from this
		public Matrix getSubmatrix(int startRow, int startCol, int dim){
	
			Matrix subM = new Matrix(dim);
	
			for (int i = 0; i<dim ; i++ )
	
				for (int j=0;j<dim ; j++ )
	
					subM.setV(i,j, m[startRow+i][startCol+j]);
	
	
	
			return subM;
	
		}
	
	
		// write this matrix as a submatrix from b (useful for the result of multiplication)
		public void putSubmatrix(int startRow, int startCol, Matrix b){
	
			for (int i = 0; i<b.n ; i++ )
	
				for (int j=0;j<b.n ; j++ )
	
					setV(startRow+i,startCol+j, b.v(i,j));
	
		}
	
	
		// matrix addition
		public Matrix sum(Matrix b){
	
			Matrix c = new Matrix(n);
	
			for(int i = 0; i< n;i++){
	
				for(int j = 0; j<n;j++){
	
					c.setV(i, j, m[i][j]+b.v(i, j));
	
				}
	
			}
	
			return c;
	
		}
	
	
	
	
	
		// matrix subtraction
		public Matrix sub(Matrix b){
	
			Matrix c = new Matrix(n);
	
			for(int i = 0; i< n;i++){
	
				for(int j = 0; j<n;j++){
	
					c.setV(i, j, m[i][j]-b.v(i, j));
	
				}
	
			}
	
			return c;
	
		}
	
	
	
		//simple multiplication
		public Matrix mult(Matrix b){
			Matrix c = new Matrix(n);
			for(int i=0;i<n;i++){    
				for(int j=0;j<n;j++){    
				c.setV(i, j, 0);      
				for(int k=0;k<n;k++)      
				{  
				c.setV(i, j, c.v(i, j)+(m[i][k])*b.v(k, j));      
				}//end of k loop  
				//System.out.print(c.v(i, j)+" ");  //printing matrix element  
				}//end of j loop  
				//System.out.println();//new line    
				}   
			return c;
		}
	
	
		// Strassen multiplication
		public Matrix multStrassen(Matrix b, int cutoff){
			Matrix c = new Matrix(n);
			if (n==1){
				c.setV(0, 0, b.v(0, 0)*v(0, 0));
				return c;
			} else if (n==cutoff){
				//System.out.println("prisel do tu");
				return mult(b);
			} else {
				
				Matrix a11 = getSubmatrix(0, 0, n/2);
				Matrix a12 = getSubmatrix(0, n/2, n/2);
				Matrix a21 = getSubmatrix(n/2, 0, n/2);
				Matrix a22 = getSubmatrix(n/2, n/2, n/2);
				Matrix b11 = b.getSubmatrix(0, 0, n/2);
				Matrix b12 = b.getSubmatrix(0, n/2, n/2);
				Matrix b21 = b.getSubmatrix(n/2, 0, n/2);
				Matrix b22 = b.getSubmatrix(n/2, n/2, n/2);
				
				Matrix m1 = (a11.sum(a22)).multStrassen(b11.sum(b22),cutoff);
				Matrix m2 = (a21.sum(a22)).multStrassen(b11,cutoff);
				Matrix m3 = a11.multStrassen(b12.sub(b22),cutoff);
				Matrix m4 = a22.multStrassen(b21.sub(b11),cutoff);
				Matrix m5 = (a11.sum(a12)).multStrassen(b22,cutoff);
				Matrix m6 = (a21.sub(a11)).multStrassen(b11.sum(b12),cutoff);
				Matrix m7 = (a12.sub(a22)).multStrassen(b21.sum(b22),cutoff);
				int v1 = 0;
				int v2 = 0;
				int v3 = 0;
				int v4 = 0;
				int v5 = 0;
				int v6 = 0;
				int v7 = 0;
				//System.out.println("n: "+n+" (n/2)-1: "+((n/2)-1));

				for(int i=0;i<=(n/2)-1;i++){
					for(int j=0;j<=(n/2)-1;j++){
						v1=v1+m1.v(i, j);
						v2=v2+m2.v(i, j);
						v3=v3+m3.v(i, j);
						v4=v4+m4.v(i, j);
						v5=v5+m5.v(i, j);
						v6=v6+m6.v(i, j);
						v7=v7+m7.v(i, j);
					}
				}
				System.out.println("m1: "+v1);
				System.out.println("m2: "+v2);
				System.out.println("m3: "+v3);
				System.out.println("m4: "+v4);
				System.out.println("m5: "+v5);
				System.out.println("m6: "+v6);
				System.out.println("m7: "+v7);
				c.putSubmatrix(0, 0, m1.sum(m4.sum(m7.sub(m5))));
				c.putSubmatrix(0, n/2, m3.sum(m5));
				c.putSubmatrix(n/2, 0, m2.sum(m4));
				c.putSubmatrix(n/2, n/2, m1.sum(m6.sum(m3.sub(m2))));


				return c;
			}
		}
	
	
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int konec =sc.nextInt();

		Matrix prva = new Matrix(n);
		Matrix druga = new Matrix(n);

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				prva.setV(i, j, sc.nextInt());
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				druga.setV(i, j, sc.nextInt());
			}
		}
		//System.out.println("******************");
		//Matrix a = prva.mult(druga);
		//System.out.print(a.v(0, 0)+" ");
		//System.out.println(a.v(0, 1));
		//System.out.print(a.v(1, 0)+" ");
		//System.out.println(a.v(1, 1));
		Matrix c = prva.multStrassen(druga, konec);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(c.v(i, j)+" ");
			}
			if(i!=n-1){System.out.println();}
		}
		


		sc.close();
	}



}
