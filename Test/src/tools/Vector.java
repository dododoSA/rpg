package tools;

public class Vector {
	public double x, y;
	public Vector(double x, double y){
		this.x = x;
		this.y = y;
	}
	public static Vector getSynthesizedVector(Vector v1, Vector v2){
		return new Vector(v1.x + v2.x, v1.y + v2.y);
	}
	public static Vector getRelativeVector(Vector v1, Vector v2){//v1 - v2
		return new Vector(v1.x - v2.x, v1.y - v2.y);
	}
	public static double getDotProduct(Vector v1, Vector v2){
		return (v1.x*v2.x + v1.y*v2.y);
	}
	public static double getCrossProduct(Vector v1, Vector v2){
		return ((v1.x*v2.y) - (v1.y*v2.x));
	}
	public static Vector getMultipliedVectorByAScalar(double t, Vector v){
		return new Vector(t * v.x, t * v.y);
	}
}