import java.awt.Graphics2D;
import java.util.ArrayList;


public class Map {
	ArrayList<Object> object = new ArrayList<Object>();
	
	Map(){
		object.add(new Ground(0, 600));
	}
	void drawObjects(Graphics2D g, Main main){
		for(int i = 0; i < object.size(); i++){
			object.get(i).Draw(g, main);
		}
	}
}
