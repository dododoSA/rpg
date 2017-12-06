package objects;
import java.awt.Graphics2D;

import rpg.Main;
import tools.Vector;


abstract public class Object {
	public static final int rect = 0;
	protected int shape;
	protected double x, y;
	protected double vx, vy;
	protected int width, height;
	abstract public void Draw(Graphics2D g, Main main);
	abstract public void Update();
	abstract protected void loadImage();
	public Vector getPos(){
		return new Vector(x, y);
	}
	public Vector getVelocity(){
		return new Vector(vx, vy);
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public int getShape(){
		return shape;
	}
}
