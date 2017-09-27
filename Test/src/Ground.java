import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Ground extends Object{
	BufferedImage groundImg;
	Ground(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		loadImage();
	}
	Ground(int x, int y){
		this.x = x;
		this.y = y;
		loadImage();
		width = groundImg.getWidth();
		height = groundImg.getHeight();
	}
	@Override
	public void Draw(Graphics2D g, Main main) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		g.drawImage(groundImg, (int)x, (int)y, Main.WIDTH, groundImg.getHeight(), main);
	}

	@Override
	public void Update() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}
	@Override
	protected void loadImage() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		try {
			groundImg = ImageIO.read(new File(".\\image\\�n��.png"));
		} catch (IOException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
		
	}

}
