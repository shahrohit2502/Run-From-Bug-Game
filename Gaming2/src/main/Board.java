package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import sprites.Enemy;
import sprites.Player;
import utils.GameConstants;
;
public class Board extends JPanel implements GameConstants{
	BufferedImage img;
	Timer timer;
	Enemy enemy;
	Player player;
	String message="";
	 public Board(){
		setSize(BWIDTH,BHEIGHT);
		setVisible(true);
		loadSprites();
		gameloop();
		setFocusable(true);
		bindEvents();
	}
	 
	private void drawbackground(Graphics g) {
		
		try {
		BufferedImage img=ImageIO.read(Board.class.getResource(GAME_BACKGROUND));
		g.drawImage(img,0,0,BWIDTH,BHEIGHT,null);
		}catch (Exception err) {
			g.setColor(Color.RED);
			g.fillRect(0,0,BWIDTH,BHEIGHT);
			// TODO: handle exception
		}
		
	}
	void bindEvents(){
		this.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				player.setSpeed(7);
				player.move();
			}
			else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				player.setSpeed(-7);
				player.move();
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			player.setSpeed(0);
		}
		});
	}
	 private void gameloop(){
	timer=new Timer(30,(ActionListener) new ActionListener(){
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			repaint();
//		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			repaint();
			checkCollision();
		}
		
}) ;
	timer.start();
		
	
	}
	private boolean isCollide(Player player,Enemy enemy) {
		 int maxH=player.getH()>enemy.getH()?player.getH():enemy.getH();
		 int maxW=player.getW()>enemy.getW()?player.getW():enemy.getW();
		 int distance_X=    Math.abs(player.getX()-enemy.getX());
		 int distance_Y=Math.abs(player.getY()-enemy.getY());
		 return(distance_X<=maxW && distance_Y<=maxH);
	 }
	private void checkCollision() {
		if(isCollide(player,enemy)) {
			GameOver();
			System.exit(ABORT);
		}
	}
	void GameOver() {
		message="Game Over";
	}
	 
void loadSprites(){
	int PLAYER_X=50;
	int PLAYER_Y= BHEIGHT-200;
	int PLAYER_H=70;
	int PLAYER_W=70;
	player=new Player(PLAYER_IMAGE,PLAYER_X,PLAYER_Y,PLAYER_W,PLAYER_H);
	
	
	int ENEMY_X=BWIDTH/2;
	int ENEMY_Y=50;
	int ENEMY_H=70;
	int ENEMY_W=70;
	 enemy=new Enemy(ENEMY_IMAGE,ENEMY_X,ENEMY_Y,ENEMY_W,ENEMY_H);
}
private void printGameOver(Graphics g) {
	if(message.length()>0) {
		g.setColor(Color.RED);
		g.setFont(new Font("times",Font.BOLD,50));
		g.drawString(message,BWIDTH/2,BHEIGHT/2);
	}
}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawbackground(g);
		enemy.drawEnemy(g);
		player.drawSprites(g);
		printGameOver(g);
		
	}
	
	

}
