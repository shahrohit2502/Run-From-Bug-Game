package main;

import javax.swing.JFrame;

import utils.GameConstants;

public class GameFrame extends JFrame implements GameConstants {
	GameFrame(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(BWIDTH,BHEIGHT);
		setTitle(GAME_NAME);
		setLocationRelativeTo(null);
		Board ab=new Board();
		getContentPane().add(ab);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		GameFrame cd=new GameFrame();
		
	} 
	

}
