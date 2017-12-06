package objects;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import rpg.Main;


public class Ground extends Object{
	private BufferedImage groundImg;
	public Ground(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		vx = 0;
		vy = 0;
		loadImage();
	}
	Ground(int x, int y){
		this.x = x;
		this.y = y;
		vx = 0;
		vy = 0;
		loadImage();
		width = groundImg.getWidth();
		height = groundImg.getHeight();
	}
	@Override
	public void Draw(Graphics2D g, Main main) {
		// TODO 自動生成されたメソッド・スタブ
		g.drawImage(groundImg, (int)x, (int)y, width, height, main);
	}

	@Override
	public void Update() {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	protected void loadImage() {
		// TODO 自動生成されたメソッド・スタブ
		try {
			groundImg = ImageIO.read(new File(".\\image\\地面.png"));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

}
