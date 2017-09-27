import java.awt.Graphics2D;


abstract public class Object {
	public static final int rect = 0;
	protected int shape;
	protected double x, y;
	protected int width, height;
	abstract public void Draw(Graphics2D g, Main main);
	abstract public void Update();
	abstract protected void loadImage();
	public Pos getPos(){
		return new Pos(x, y);
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
}
