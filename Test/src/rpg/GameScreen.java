package rpg;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import characters.Character;
import characters.Player;
import objects.Ground;
import objects.Object;
import tools.KeyModule;


public class GameScreen {
	ArrayList<Object> object = new ArrayList<Object>();
	Character player;
	
	GameScreen(KeyModule key){
		object.add(new Ground(0, 600, Main.WIDTH, 100));
		player = new Player(key);
	}
	void draw(Graphics2D g, Main main){
		player.draw(g, main);
		for(int i = 0; i < object.size(); i++){
			object.get(i).Draw(g, main);
		}
	}
	void update(){
		player.update();
		for(int i = 0; i < object.size(); i++){
			player.collisionDirection(object.get(i));
		}
	}
	
}
