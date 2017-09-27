import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player extends Character{
	KeyModule key;
	private final int imgXNum = 6;
	private final int imgYNum = 4;
	private final int imgNum = imgXNum * imgYNum;
	private final int imgChangeTime = 36 * 3;//何ミリ秒で動いているときに画像が切り替わるか
	private int currentImgNum;
	private int vJump;
	BufferedImage img;
	BufferedImage[] imgChips = new BufferedImage[imgNum];
	public Player(KeyModule key){
		this.key = key;
		currentImgNum = 1;
		x = Main.WIDTH / 2;
		y = 3 * Main.HEIGHT / 4;
		speed = 0.4;
		vJump = 3;
		vx = 0;
		vy = 0;
		loadImage();
	}
	@Override
	public void draw(Graphics2D g, Main main) {
		g.drawImage(imgChips[currentImgNum], (int)x, (int)y, main);
	}
	public void update(){
		move();
	}
	protected void move(){
		x += vx;
		y += vy;
		vy += ga;
		if(key.getKeyState(KeyModule.KeyNum.LEFT.ordinal()) == true){
			vx = -speed;
			if(key.getKeyPressedTime(KeyModule.KeyNum.LEFT.ordinal()) % imgChangeTime < imgChangeTime / 3){
				currentImgNum = 6;
			}
			else if(key.getKeyPressedTime(KeyModule.KeyNum.LEFT.ordinal()) % imgChangeTime < imgChangeTime * 2 / 3){
				currentImgNum = 7;
			}
			else{
				currentImgNum = 8;
			}
		}
		if(key.getKeyState(KeyModule.KeyNum.RIGHT.ordinal()) == true){
			if(key.getKeyPressedTime(KeyModule.KeyNum.RIGHT.ordinal()) % imgChangeTime < imgChangeTime / 3){
				currentImgNum = 12;
			}
			else if(key.getKeyPressedTime(KeyModule.KeyNum.RIGHT.ordinal()) % imgChangeTime < imgChangeTime * 2 / 3){
				currentImgNum = 13;
			}
			else{
				currentImgNum = 14;
			}
			
			vx = speed;
		}
		if(key.getKeyState(KeyModule.KeyNum.DOWN.ordinal()) == true){
			vy = speed;
		}
		if(key.getKeyState(KeyModule.KeyNum.UP.ordinal()) == true){
			vy = -speed;
		}
		if(key.getKeyState(KeyModule.KeyNum.LEFT.ordinal()) == false && key.getKeyState(KeyModule.KeyNum.RIGHT.ordinal()) == false){
			vx = 0;
		}
		if(key.getKeyState(KeyModule.KeyNum.UP.ordinal()) == false && key.getKeyState(KeyModule.KeyNum.DOWN.ordinal()) == false){
//			vy = 0;
		}
	}
	private void jump(){
		
	}
	@Override
	protected void loadImage() {
		// TODO 自動生成されたメソッド・スタブ
		File player = new File(".\\image\\Armor_night_man.png");
		try {
			img = ImageIO.read(player);
			width = img.getHeight() / imgYNum;
			height = img.getWidth() / imgXNum;
		} catch (IOException e) {
			e.printStackTrace();
		}
		int xn = 0;
		int yn = 0;
		for(int i = 0; i < imgNum; i++){
			xn = i % imgXNum;
			imgChips[i] = new BufferedImage(width, height, img.getType());
			imgChips[i] = img.getSubimage(width * xn, height * yn, width, height);
			if(i % imgXNum == imgXNum - 1){
				yn++;
			}
		}
	}
}
