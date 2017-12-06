package characters;

import java.awt.Graphics2D;

import rpg.Main;
import tools.Collision;
import tools.Vector;
import objects.Object;


abstract public class Character {
	protected int hp, width, height;
	protected double x, y, vx, vy, speed;
	protected static double ga;
	protected Collision collision;
	protected boolean isGround;//’n–Ê‚É‘«‚ª‚Â‚¢‚Ä‚é‚©‚Ç‚¤‚©
	public Character(){
		ga = 0.015;
		collision = new Collision();
	}
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
	abstract public void collisionDirection(Object obj);
	abstract public void draw(Graphics2D g, Main main);
	abstract public void update();
	abstract protected void move();
	abstract protected void loadImage();
}
