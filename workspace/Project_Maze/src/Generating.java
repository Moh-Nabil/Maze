

public class Generating {
	private int x, y;
	char[][] grid= new char[100][100];
	public Generating(int x, int y){
		this.x= x;
		this.y= y;
	}
	
	public char[][] randomize(){
		for(int i= 0; i< x; i++){
			for(int j= 0; j< y; j++){
				double x= Math.random();
				if(x < 0.75)
					grid[i][j]= '.';
				else
					grid[i][j]= '#';
			}	
		}
		double z= Math.random();
		grid[((int)(z*10000000000.0))%this.x][((int)((z*1000000000.0)))%this.y]= 'E';
		grid[(int)System.currentTimeMillis()%x][(int) (((int)System.currentTimeMillis()+10)%y)]= 'S';
		return grid;
	}
}
