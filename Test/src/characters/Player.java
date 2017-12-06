package characters;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import objects.Object;
import rpg.Main;
import tools.KeyModule;
import tools.KeyModule.KeyNum;


public class Player extends Character{
	KeyModule key;
	private final int imgXNum = 6;
	private final int imgYNum = 4;
	private final int imgNum = imgXNum * imgYNum;
	private final int imgChangeTime = 36 * 3;//何ミリ秒で動いているときに画像が切り替わるか
	private int currentImgNum;
	private double vJump;
	BufferedImage img;
	BufferedImage[] imgChips = new BufferedImage[imgNum];
	public Player(KeyModule key){
		isGround = false;
		this.key = key;
		currentImgNum = 1;
		x = Main.WIDTH / 2;
		y = 2 * Main.HEIGHT / 4;
		speed = 0.5;
		vJump = -2.5;
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
		jump();
	}
	protected void move(){
		x += vx;
		y += vy;
		if(isGround == false){
			vy += ga;
		}
		
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
//			vy = speed;
		}
		if(key.getKeyState(KeyModule.KeyNum.UP.ordinal()) == true){
//			vy = -speed;
		}
		if(key.getKeyState(KeyModule.KeyNum.LEFT.ordinal()) == false && key.getKeyState(KeyModule.KeyNum.RIGHT.ordinal()) == false){
			vx = 0;
		}
		if(key.getKeyState(KeyModule.KeyNum.UP.ordinal()) == false && key.getKeyState(KeyModule.KeyNum.DOWN.ordinal()) == false){
//			vy = 0;
		}
	}
	private void jump(){
		if(key.getKeyPressedTime(KeyModule.KeyNum.SPACE.ordinal()) > 0 && isGround == true){
			vy = vJump;
			isGround = false;
		}
	}
	@Override
	protected void loadImage() {
		// TODO 自動生成されたメソッド・スタブ
		File player = new File(".\\image\\Armor_night_man.png");
		try {
			img = ImageIO.read(player);
			width = (int)(img.getWidth() / imgXNum);
			height = (int)(img.getHeight() / imgYNum);
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
		height -= 10;//微調整
	}

	public void collisionDirection(Object obj) {
		if(collision.collisionDetection(this, obj)){
			isGround = true;
			x = collision.getCharacterCollidedAt().x;
			y = collision.getCharacterCollidedAt().y;
	//		y = obj.getPos().y - height + 10;
			vy = 0;
		}
	}
}
