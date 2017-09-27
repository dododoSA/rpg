
public class Pos {
	public double x, y, vx, vy;
	Pos(double x, double y, double vx, double vy){
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}
	Pos(double x, double y){
		this.x = x;
		this.y = y;
		vx = 0;
		vy = 0;
	}
}
