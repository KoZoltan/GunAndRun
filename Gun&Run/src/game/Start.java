package game;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Start {

	

	public static void main(String[] args){
		System.out.print("Enter a Player name: ");  
		
		
		Game game = new Game();
		

		
		JFrame window = new JFrame("Gun&Run");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.add(game);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.start();
	}
}