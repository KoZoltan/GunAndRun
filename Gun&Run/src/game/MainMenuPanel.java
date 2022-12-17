package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import gui.GuiMainMenu;
import gui.GuiButton;
import gui.GuiPanel;
import gui.GuiScreen;

public class MainMenuPanel extends GuiPanel {
 
	
	public String setName(String name) {
		return name;
	}
	
	private Font titleFont = GuiMainMenu.main.deriveFont(100f);
	private Font creatorFont = GuiMainMenu.main.deriveFont(24f);
	private String title = "Gun&Run";
	private String creator = "Fiktiv01";
	private int buttonWidth = 220;
	
	public MainMenuPanel() {
		super();
		
		
		GuiButton playButton = new GuiButton(GuiMainMenu.WIDTH / 2 - buttonWidth / 2, 220, buttonWidth, 60);
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getInstance().setCurrentPanel("Play");
			}
		});
		playButton.setText("Play");
		add(playButton);
		
		
		GuiButton friendButtun = new GuiButton(GuiMainMenu.WIDTH / 2 - buttonWidth / 2, 310, buttonWidth, 60);
		friendButtun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getInstance().setCurrentPanel("Friend_Invite");
			}
		});
		friendButtun.setText("Friends");
		add(friendButtun);
		
		GuiButton quitButton = new GuiButton(GuiMainMenu.WIDTH / 2 - buttonWidth / 2, 400, buttonWidth, 60);
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitButton.setText("Quit");
		add(quitButton);
	}

	@Override
	public void render(Graphics2D g){
		super.render(g);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString(title, GuiMainMenu.WIDTH / 2 - DrawUtils.getMessageWidth(title, titleFont, g) / 2, 150);
		g.setFont(creatorFont);
		g.drawString(creator, 20, GuiMainMenu.HEIGHT - 10);
	}
}
