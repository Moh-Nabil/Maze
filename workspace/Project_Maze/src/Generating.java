

public class Generating {
	
	private int x, y, z;
	char[][][] grid;
	
	public Generating(int x, int y , int z){
		this.x= x;
		this.y= y;
		this.z= z;
		grid = new char[x][y][z];
	}
	
	public char[][][] randomize(){
		
		for (int i=0 ; i<x ; i++)
			for (int j=0 ; j<y ; j++)
				for (int k=0 ; k<z ; k++){
					double x = Math.random();
					if (x < 0.7) grid[i][j][k] = '.';
					else grid[i][j][k] = '#';
				}
				
		int a,b,c;
		a = (int) (Math.random()*(x));
		b = (int) (Math.random()*(y));
		c = 0;
		
		grid[a][b][c] = 'S';
		
		int A,B,C;
		A = (int) (Math.random()*(x));
		B = (int) (Math.random()*(y));
		C = (int) (Math.random()*(z));
		
		while (true) {
			if (A != a || B != b || C != c){
				grid[A][B][C] = 'E';
				break;
			}
			A = (int) (Math.random()*(x));
			B = (int) (Math.random()*(y));
			C = (int) (Math.random()*(z));
		}
		
		return grid;
	}
}
