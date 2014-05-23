import java.util.Scanner;


public class Play {
	
	private char[][][] grid= new char[100][100][100];
	private int x, y, z;
	Cell current= new Cell(0,0,0);
	public Play(char[][][] grid, int x, int y, int z){
		this.x= x;
		this.y= y;
		this.z= z;
		for(int i= 0; i< x; i++){
			for(int j= 0; j< y; j++){
				for(int k= 0; k< z; k++){
					if(grid[i][j][k] == 'S')
						current.setAll(i, j, k);
					this.grid[i][j][k]= grid[i][j][k];
				}
			}
		}
		
		System.out.println("i= " + current.getX() + " j= " + current.getY() + " k= " + current.getZ());
	}
	
	public void move(){
		
		int i= current.getX();
		int j= current.getY();
		int k= current.getZ();
		
		
		int moves= 0;
		Scanner scan= new Scanner(System.in);
		System.out.println("1.Right\n2.Left\n3.Up\n4.Down\n5.Next Level\n6.Previous Level");
		while(true){
			
			i= current.getX(); j= current.getY(); k= current.getZ();
			if(grid[i][j][k] == 'E'){
				System.out.println("YOU WIN !!");
				System.out.println("Your moves: " + moves);
				break;
			}
			System.out.println("1.R 2.L 3.U 4.D 5.NL 6.PL");
			int choice= scan.nextInt();
			
			switch (choice){
				case 4:
					if(i+1==x || grid[i+1][j][k]=='#'){
						System.out.println("Invalid move !!");
					}
					else{
						moves++;
						current.setX(i+1);
					}
					break;
				case 3:
					if(i-1<0 || grid[i-1][j][k]=='#'){
						System.out.println("Invalid move !!");
					}
					else{
						moves++;
						current.setX(i-1);
					}
					break;
				case 2:
					if(j-1<0 || grid[i][j-1][k]=='#'){
						System.out.println("Invalid move !!");
					}
					else{
						moves++;
						current.setY(j-1);
					}
					break;
				case 1:
					if(j+1==y || grid[i][j+1][k]=='#'){
						System.out.println("Invalid move !!");
					}
					else{
						moves++;
						current.setY(j+1);
					}
					break;
				case 5:
					if(grid[i][j][k] == 'A'){
						if(k+1 != z && grid[i][j][k+1] != '#'){
							current.setZ(k+1);
							moves++;
						}
						else
							System.out.println("Invalid move !!");
					}
					else
						System.out.println("Invalid move !!");
					break;
				case 6:
					if(grid[i][j][k] == 'A'){
						if(k-1 >= 0 && grid[i][j][k-1] != '#'){
							current.setZ(k-1);
							moves++;
						}
						else
							System.out.println("Invalid move !!");
					}
					else
						System.out.println("Invalid move !!");
					break;
				default:
					System.out.println("Invalid input !!");
					break;
			}
			printGrid(current);
		}
	}
	
	public void printGrid(Cell curr){
		int currX= curr.getX(), currY= curr.getY(), currZ= curr.getZ();
		for(int i= 0; i< x; i++){
			for(int j= 0; j< y; j++){
				if(i==currX && j==currY)
					System.out.print("H");
				else System.out.print(grid[i][j][currZ]);
			}
			System.out.println();
		}
	}
	
	public void printGrid(){
		System.out.println("x= " + x + " y= " + y + " z= " + z);
		for(int k= 0; k< z; k++){
			for(int i= 0; i< x; i++){
				for(int j= 0; j< y; j++){
						System.out.print(grid[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
}
