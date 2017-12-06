package rpg;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

import tools.KeyModule;


public class Main extends JFrame{
	private final int BUFFER_NUM = 2;
	public static int counter;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 700;
	JFrame frame = new JFrame();
	BufferStrategy buffer;
	Timer timer = new Timer();
	KeyModule keyModule = new KeyModule();
	GameScreen gameScreen = new GameScreen(keyModule);
	private int sequence;
	private final int GAMESCREEN = 1;
	private final Main main = this;
	
	class Task extends TimerTask{
		@Override
		public void run() {
			// TODO 自動生成されたメソッド・スタブ
			while(true){
				if(buffer.contentsLost() == false){
					keyModule.keyUpdate();
					Graphics2D g = (Graphics2D)buffer.getDrawGraphics();
					g.setColor(Color.white);
					g.fillRect(0, 0, WIDTH, HEIGHT);
					
					switch(sequence){
					case GAMESCREEN:
						gameScreen.update();
						gameScreen.draw(g, main);
						break;
					}
					
					
					g.dispose();
					buffer.show();
					counter++;
				}
			}
		}
	}
	public Main(){
		counter = 0;
		frame.setTitle("ゲーム");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.createBufferStrategy(BUFFER_NUM);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.addKeyListener(keyModule);
		buffer = frame.getBufferStrategy();
		timer.schedule(new Task(), 0, 17);
		sequence = GAMESCREEN;
	}
	public static void main(String[] args) {
		new Main();
	}
	
}
