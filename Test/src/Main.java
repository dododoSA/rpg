import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;


public class Main extends JFrame{
	final int BUFFER_NUM = 2;
	public static int counter;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 700;
	JFrame frame = new JFrame();
	BufferStrategy buffer;
	Timer timer = new Timer();
	KeyModule keyModule = new KeyModule();
	Character player = new Player(keyModule);
	Map map = new Map();
	
	class Task extends TimerTask{
		@Override
		public void run() {
			// TODO 自動生成されたメソッド・スタブ
			while(true){
				gameUpdate();
				gameDraw();
//				try{
//					Thread.sleep(1000);
//				}
//				catch(InterruptedException e){
//					e.printStackTrace();
//				}
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
	}
	private void gameUpdate(){
		player.update();
		keyModule.keyUpdate();
		counter++;
	}
	private void gameDraw(){
		if(buffer.contentsLost() == false){
			Graphics2D g = (Graphics2D)buffer.getDrawGraphics();
			g.setColor(Color.white);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			player.draw(g, this);
			
			map.drawObjects(g, this);
			
			g.dispose();
			buffer.show();
		}
	}
	public static void main(String[] args) {
		new Main();
	}
	
}
