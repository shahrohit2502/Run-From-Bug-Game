package sprites;
import java.awt.*;

import utils.GameConstants;
public class Enemy extends Sprites implements GameConstants {
	public Enemy(String imageName,int x,int y,int w,int h){
		super(imageName,x,y,w,h);
	}
	@Override
	public void move(){
     y=y+15;
}
public void drawEnemy(Graphics g){
	drawSprites(g);
	move();
	outOfScreen();
}
void outOfScreen(){
	if(y>=BHEIGHT) {
		y=0;
	}
}
}