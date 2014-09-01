package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import controller.CtrlGamePanel;
import model.Array;

public class MainWindow extends JFrame {
	
	
	
	public MainWindow(Array array){
		
		this.setLayout(new BorderLayout());
		
		this.setSize(500, 500);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setBackground(Color.black);
		GamePanel gamePanel = new GamePanel(array);
		CtrlGamePanel controllerGame = new CtrlGamePanel(gamePanel);
		gamePanel.setController(controllerGame);
		Clock clock = new Clock();
		this.add(gamePanel,BorderLayout.CENTER);
		this.add(clock,BorderLayout.SOUTH);

		this.setVisible(true);
	}

}
