import java.awt.Graphics2D;


abstract public class Character {
	protected int hp, width, height;
	protected double x, y, vx, vy, speed;
	protected static double ga;
	public Character(){
		ga = 0.1;
	}
	public Pos getPos(){
		return new Pos(x, y);
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	abstract public void draw(Graphics2D g, Main main);
	abstract public void update();
	abstract protected void move();
	abstract protected void loadImage();
}
