import java.util.ArrayList;
import java.util.Collections;


public class MazeTraverse {
	
	private char grid[][][];
	private boolean isPath[][][];
	private int dx[] = {1,0,-1,0,0,0};
	private int dy[] = {0,-1,0,1,0,0};
	private int dz[] = {0,0,0,0,-1,1};
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	private int N,M,K;
	
	public MazeTraverse (char grid[][][] , int n , int m , int k)
	{
		this.N = n;
		this.M = m;
		this.K = k;
		
		this.grid = grid;
		isPath = new boolean[n][m][k];
	}
	
	private Cell getStart() {
		for (int i=0 ; i<N ; i++)
			for (int j=0 ; j<M ; j++)
				for (int k=0 ; k<K ; k++)
					if (grid[i][j][k] == 'S') {
						return new Cell(i,j,k);
					}
		return new Cell(0,0,0);
	}
	
	private Cell getEnd() {
		for (int i=0 ; i<N ; i++)
			for (int j=0 ; j<M ; j++)
				for (int k=0 ; k<K ; k++)
					if (grid[i][j][k] == 'E') {
						return new Cell(i,j,k);
					}
		return new Cell(0,0,0);
	}
	
	private ArrayList<Cell> getPath (Cell end , Cell parent[][][]) {
		
		ArrayList<Cell> path = new ArrayList<Cell>();
		
		Cell cur = end;
		while (!cur.isEqual(new Cell(-1,-1,-1)))
		{
			path.add(cur);
			isPath[cur.getX()][cur.getY()][cur.getZ()] = true;
			cur = parent[cur.getX()][cur.getY()][cur.getZ()];
		}
		Collections.reverse(path);
		return path;
	}
	
	private void printPath (Cell end , Cell parent[][][]){
		ArrayList<Cell> path = getPath(end,parent);
		
		for (int k=0 ; k<K ; k++) {
			for (int i=0 ; i<N ; i++){
				for (int j=0 ; j<M ; j++){
					if (isPath[i][j][k] && grid[i][j][k] == '.') System.out.print("×");
					else System.out.print(ANSI_RED + grid[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
		for (int i=1 ; i<path.size() ; i++)
			System.out.println(path.get(i).getDir(path.get(i-1)));
		System.out.println("Number of Moves:" + (path.size()-1));
	}
	
	public void DFS () throws Exception {
		Stack S = new Stack();
		boolean vis[][][] = new boolean [N][M][K];
		Cell parent[][][] = new Cell [N][M][K];
		
		Cell start = getStart();
		Cell end = getEnd();
		
		S.push(start);
		vis[start.getX()][start.getY()][start.getZ()] = true;
		parent[start.getX()][start.getY()][start.getZ()] = new Cell(-1,-1,-1);
		
		boolean isBlocked = true;
		
		while (!S.isEmpty()) {
			Cell c = (Cell) S.peek();
			int x = c.getX();
			int y = c.getY();
			int z = c.getZ();
			S.pop();
			
			if (c.isEqual(end)) {
				isBlocked = false;
				break;
			}
			
			int D=4;
			if (grid[x][y][z] == 'A') D=6;
			
			for (int i=0 ; i<D ; i++){
				int newx = x+dx[i];
				int newy = y+dy[i];
				int newz = z+dz[i];
				
				if (newx < 0 || newy < 0 || newz < 0 || newx == N || newy == M || newz == K) continue;
				if (vis[newx][newy][newz] || grid[newx][newy][newz] == '#') continue;
//				if (i > 3 && grid[newx][newy][newz] != 'A') continue;
				
				vis[newx][newy][newz] = true;
				parent[newx][newy][newz] = c;
				S.push(new Cell(newx,newy,newz));
			}
		}
		
		if (isBlocked){
			System.out.println("The maze is blocked !");
		}
		else{
			printPath(end,parent);
		}
	}
	
	public void BFS () throws Exception {
		Queue Q = new Queue();
		boolean vis[][][] = new boolean [N][M][K];
		Cell parent[][][] = new Cell [N][M][K];
		
		Cell start = getStart();
		Cell end = getEnd();
		
		Q.enqueue(start);
		vis[start.getX()][start.getY()][start.getZ()] = true;
		parent[start.getX()][start.getY()][start.getZ()] = new Cell(-1,-1,-1);
		
		boolean isBlocked = true;
		
		while (!Q.isEmpty()) {
			Cell c = (Cell) Q.front();
			int x = c.getX();
			int y = c.getY();
			int z = c.getZ();
			Q.dequeue();
			
			if (c.isEqual(end)) {
				isBlocked = false;
				break;
			}
			
			int D=4;
			if (grid[x][y][z] == 'A') D=6;
			
			for (int i=0 ; i<D ; i++){
				int newx = x+dx[i];
				int newy = y+dy[i];
				int newz = z+dz[i];
				
				if (newx < 0 || newy < 0 || newz < 0 || newx == N || newy == M || newz == K) continue;
				if (vis[newx][newy][newz] || grid[newx][newy][newz] == '#') continue;
//				if (i > 3 && grid[newx][newy][newz] != 'A') continue;
				
				vis[newx][newy][newz] = true;
				parent[newx][newy][newz] = c;
				Q.enqueue(new Cell(newx,newy,newz));
			}
		}
		
		if (isBlocked){
			System.out.println("The maze is blocked !");
		}
		else{
			printPath(end,parent);
		}
	}
	
}
