
public class Testing {
	
	public static void main(String[] args) throws Exception {
		
		Scan sc = new Scan ("test.in");
		char grid[][][] = sc.scanning();
		sc.printGrid();
		
		MazeTraverse maze = new MazeTraverse(grid,sc.getX(),sc.getY(),sc.getZ());
		maze.DFS();
		System.out.println();
		System.out.println();
		
		maze.BFS();
		Play game = new Play(grid,sc.getX(),sc.getY(),sc.getZ());
		game.move();
	}
}
