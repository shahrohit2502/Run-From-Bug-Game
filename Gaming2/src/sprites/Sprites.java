package sprites;

import javax.swing.ImageIcon;
import java.awt.*;

public abstract class Sprites {
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	ImageIcon img;
	protected int speed;
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	
	Sprites(){
		
	}
    Sprites(String imageName,int x,int y,int w,int h){
    	this.x=x;
    	this.y=y;
    	this.w=w;
    	this.h=h;
    	img=new ImageIcon(Sprites.class.getResource(imageName));
    	speed=3;
    }
  public abstract void move();

  public void drawSprites(Graphics g){
	  g.drawImage(img.getImage(),x,y,w,h,null);
  }
}
