

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
		
		for (int k=0 ; k<z ; k++)
			for (int i=0 ; i<x ; i++)
				for (int j=0 ; j<y ; j++)
					grid[i][j][k] = '_';
		
		for (int k=0 ; k<z ; k++)
		{
			for (int i=0 ; i<x ; i++){
				for (int j=0 ; j<y ; j++){
					double x = Math.random();
					if (grid[i][j][k] != '_') continue;
					if (x < 0.7) grid[i][j][k] = '.';
					else grid[i][j][k] = '#';
				}
			}
			
			int a = (int) (Math.random()*(x));
			int b = (int) (Math.random()*(y));
			if (k > 0 && k < z-1 ){
				grid[a][b][k]='A';
				grid[a][b][k-1]='A';
				grid[a][b][k+1]='A';
						
			}
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
			if (grid[A][B][C] == '.'){
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
