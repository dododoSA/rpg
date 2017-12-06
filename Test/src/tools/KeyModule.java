package tools;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyModule implements KeyListener{
	public static enum KeyNum{
		LEFT,RIGHT,UP,DOWN, SPACE, Z
	}
	private int key[] = new int[KeyNum.values().length];
	private boolean isKey[] = new boolean[KeyNum.values().length];
	
	
	public KeyModule(){
		for(int i = 0; i < KeyNum.values().length; i++){
			key[i] = 0;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_LEFT){
			isKey[KeyNum.LEFT.ordinal()] = true;
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			isKey[KeyNum.RIGHT.ordinal()] = true;
		}
		if(keyCode == KeyEvent.VK_UP){
			isKey[KeyNum.UP.ordinal()] = true;
		}
		if(keyCode == KeyEvent.VK_DOWN){
			isKey[KeyNum.DOWN.ordinal()] = true;
		}
		if(keyCode == KeyEvent.VK_SPACE){
			isKey[KeyNum.SPACE.ordinal()] = true;
		}
		if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		if(keyCode == KeyEvent.VK_Z){
			isKey[KeyNum.Z.ordinal()] = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_LEFT){
			key[KeyNum.LEFT.ordinal()] = 0;
			isKey[KeyNum.LEFT.ordinal()] = false;
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			key[KeyNum.RIGHT.ordinal()] = 0;
			isKey[KeyNum.RIGHT.ordinal()] = false;
		}
		if(keyCode == KeyEvent.VK_UP){
			key[KeyNum.UP.ordinal()] = 0;
			isKey[KeyNum.UP.ordinal()] = false;
		}
		if(keyCode == KeyEvent.VK_DOWN){
			key[KeyNum.DOWN.ordinal()] = 0;
			isKey[KeyNum.DOWN.ordinal()] = false;
		}
		if(keyCode == KeyEvent.VK_SPACE){
			key[KeyNum.SPACE.ordinal()] = 0;
			isKey[KeyNum.SPACE.ordinal()] = false;
		}
		if(keyCode == KeyEvent.VK_Z){
			key[KeyNum.Z.ordinal()] = 0;
			isKey[KeyNum.Z.ordinal()] = false;
		}
	}
	public int getKeyPressedTime(int keyOdinal){
		return this.key[keyOdinal];
	}
	public boolean getKeyState(int keyOdinal){
		return this.isKey[keyOdinal];
	}
	public void keyUpdate(){
		for(int i = 0; i < KeyNum.values().length; i++){
			if(isKey[i] == true){
				key[i]++;
			}
		}
	}
}
