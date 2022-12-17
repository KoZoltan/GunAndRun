package game;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.GuiMainMenu;

public class Start {

	

	public static void main(String[] args){
		
		GuiMainMenu game = new GuiMainMenu();
		
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