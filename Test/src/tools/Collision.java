package tools;
import java.math.BigDecimal;

import characters.Character;
import objects.Object;

public class Collision{
	public static final int LEFT_SIDE = 0;
	public static final int RIGHT_SIDE = 1;
	public static final int UP_SIDE = 2;
	public static final int DOWN_SIDE = 3;
	public static final int RECTANGLE = 4;
	private Vector charaPos, objPos, charaCollidingPos;
	private Vector charaVel, objVel, relativeVel;
	public Collision(){
		charaCollidingPos = new Vector(0, 0);
	}
	public boolean collisionDetection(Character chara, Object object){
		int charaWidth = chara.getWidth();
		int charaHeight = chara.getHeight();
		charaPos = chara.getPos();
		charaVel = chara.getVelocity();
		objVel = object.getVelocity();
		objPos = object.getPos();
		relativeVel = Vector.getRelativeVector(charaVel, objVel);
		if(object.getShape() == Object.rect){
			int objWidth = object.getWidth();
			int objHeight = object.getHeight();
			int apparentWidth = charaWidth + objWidth;//キャラを点とみなした時のオブジェクトの辺の長さ
			int apparentHeight = charaHeight + objHeight;
			Vector apparentObjPos = new Vector(objPos.x - charaWidth, objPos.y - charaHeight);//キャラを点とみなした時のオブジェクトの座標
			double t1[] = new double[RECTANGLE];
			double t2[] = new double[RECTANGLE];
			final int initNum = 2;//この辺何とかしたい
			for(int i = 0; i < RECTANGLE; i++){
				t1[i] = initNum;
				t2[i] = initNum;
			}
			Vector relativePos = Vector.getRelativeVector(charaPos, apparentObjPos);//↓いずれきれいに直したい
			if(Vector.getCrossProduct(new Vector(0, apparentHeight), relativeVel) != 0){
				t1[LEFT_SIDE] = Vector.getCrossProduct(relativePos, relativeVel) / Vector.getCrossProduct(new Vector(0, apparentHeight), relativeVel);
				t2[LEFT_SIDE] = Vector.getCrossProduct(relativePos, new Vector(0, apparentHeight)) / Vector.getCrossProduct(new Vector(0, apparentHeight), relativeVel);
			}
			if(Vector.getCrossProduct(new Vector(0, apparentHeight), relativeVel) != 0){
				t1[RIGHT_SIDE] = Vector.getCrossProduct(Vector.getRelativeVector(relativePos, new Vector(apparentWidth, 0)), relativeVel) / Vector.getCrossProduct(new Vector(0, apparentHeight), relativeVel);
				t2[RIGHT_SIDE] = Vector.getCrossProduct(Vector.getRelativeVector(relativePos, new Vector(apparentWidth, 0)), new Vector(0, apparentHeight)) / Vector.getCrossProduct(new Vector(0, apparentHeight), relativeVel);
			}
			if(Vector.getCrossProduct(new Vector(apparentWidth, 0), relativeVel) != 0){
				t1[UP_SIDE] = Vector.getCrossProduct(relativePos, relativeVel) / Vector.getCrossProduct(new Vector(apparentWidth, 0), relativeVel);
				t2[UP_SIDE] = Vector.getCrossProduct(relativePos, new Vector(apparentWidth, 0)) / Vector.getCrossProduct(new Vector(apparentWidth, 0), relativeVel);
			}
			if(Vector.getCrossProduct(new Vector(apparentWidth, 0), relativeVel) != 0){
				t1[DOWN_SIDE] = Vector.getCrossProduct(Vector.getRelativeVector(relativePos, new Vector(0, apparentHeight)), relativeVel)
						/ Vector.getCrossProduct(new Vector(apparentWidth, 0), relativeVel);
				t2[DOWN_SIDE] = Vector.getCrossProduct(Vector.getRelativeVector(relativePos, new Vector(0, apparentHeight)), new Vector(apparentWidth, 0))
						/ Vector.getCrossProduct(new Vector(apparentWidth, 0), relativeVel);
			}
			double min_t2 = initNum;//1より大きければいいから2であることに意味はない
			for(int i = 0; i < RECTANGLE; i++){
				if(min_t2 > t2[i] && t2[i] >= 0){
					min_t2 = t2[i];
				}
			}
			if(min_t2 == initNum){
				min_t2 = 0;
			}
			if(charaPos.y >= objPos.y){
				System.out.println("a");
			}
			for(int i = 0; i < RECTANGLE; i++){
				if(t1[i] >= 0 && t1[i] <= 1 && t2[i] >= 0 && t2[i] <= 1){
					BigDecimal bd = new BigDecimal(min_t2);
					BigDecimal bd_min_t2 = bd.setScale(3, BigDecimal.ROUND_DOWN);
					charaCollidingPos = Vector.getSynthesizedVector(charaPos, Vector.getMultipliedVectorByAScalar(bd_min_t2.doubleValue(), charaVel));
					return true;
				}
			}
			return false;
		}else{
			return false;
		}
	}
	public Vector getCharacterCollidedAt(){
		return charaCollidingPos;
	}
}
