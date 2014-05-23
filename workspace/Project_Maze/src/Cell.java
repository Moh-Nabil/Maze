
public class Cell {
	public int x,y,z;
	
	public Cell (int x , int y , int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setAll (int x , int y , int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public boolean isEqual (Cell c) {
		return (this.x == c.getX() && this.y == c.getY() && this.z == c.getZ());
	}
	
	public String getDir (Cell c){
		
		int dx[] = {1,0,-1,0,0,0};
		int dy[] = {0,-1,0,1,0,0};
		int dz[] = {0,0,0,0,-1,1};
		String cmd[] = {"Down","Left","Up","Right","Climb Up","Climb Down"};
		
		for (int i=0 ; i<6 ; i++) {
			if (x - c.getX() == dx[i] && y - c.getY() == dy[i] && z - c.getZ() == dz[i])
				return cmd[i];
		}
		
		return "UNDEFINED";
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}
	
}
