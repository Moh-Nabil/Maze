import java.util.*;
import org.fusesource.jansi.AnsiConsole;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static int N,M,K;
	
	public static void getDiff (int d) {
		
		switch (d) {
		case 1:
			N=5;
			M=5;
			K=1;
			break;
		case 2:
			N=5;
			M=5;
			K= (int) (Math.random()*(3)+2);
			break;
		case 3:
			N=8;
			M=8;
			K= (int) (Math.random()*(3)+2);
			break;
		case 4:
			System.out.print("Enter no of rows: ");
			N = sc.nextInt();
			System.out.print("Enter no of columns: ");
			M = sc.nextInt();
			System.out.print("Enter no of levels: ");
			K = sc.nextInt();
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}
	
	public static void chooseDiff () {
		System.out.println("Welcome to Maze Game !");
		System.out.println("================");
		
		
		System.out.println("Please choose game difficulty:");
		System.out.println("1- Easy (5x5 - One Level)");
		System.out.println("2- Medium (5x5 - Multi Levels)");
		System.out.println("3- Hard (8x8 - Multi Levels)");
		System.out.println("4- Custom (Choose grid dimensions manually)");
		
		int diff = sc.nextInt();
		getDiff(diff);
	}

	public static int choosePlay () {
		System.out.println("How to do you want to play?:");
		System.out.println("1- User Play");
		System.out.println("2- Solve by computer");
		return sc.nextInt();
	}

	public static void playGame (int op) throws Exception {
		
		char [][][] grid = new Generating(N,M,K).randomize();
		
		while (true)
		{
			char [][][] tmp = new Generating(N,M,K).randomize();
			MazeTraverse tmpMaze = new MazeTraverse(tmp,N,M,K);
			if (!tmpMaze.blockCheck()){
				grid=tmp;
				break;
			}
		}
		
		Play game = new Play(grid,N,M,K);
		MazeTraverse maze = new MazeTraverse(grid,N,M,K);
		
		
		switch (op) {
		case 1:
			game.move();
			break;
		case 2:
			System.out.println("Chooes an algorithm:");
			System.out.println("1- Depth-First Search");
			System.out.println("2- Breadth-First Search");
			
			int alg = sc.nextInt();
			if (alg == 1) maze.DFS();
			else maze.BFS();
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		AnsiConsole.systemInstall();
		chooseDiff();
		playGame(choosePlay());
		
		sc.close();
	}
}
