package sprites;
import java.awt.*;

import utils.GameConstants;
public class Player extends Sprites implements GameConstants{
	public Player(String imageName,int x,int y,int w,int h){
		super(imageName,x,y,w,h);
	}
	@Override
	public void move() {
		outOfScreeen();
		this.x=this.x+speed;    //drawSprites() take only x,y arguments not speed
		
	}
//	public void drawPlayer(Graphics g){
//		drawSprites(g);
//		move();
//	}
	void outOfScreeen() {
		if(x<=0) {
			speed=2;
		}
		else if(x>=BWIDTH-w) {
			speed=-2;
		}
	}
	
}
