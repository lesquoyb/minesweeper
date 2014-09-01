package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Array;
import model.Game;
import model.Player;
import view.interfaces.GamePanelInterface;

public class CtrlGamePanel implements ActionListener {
	
	private GamePanelInterface view;
	private Game game;
	
	public CtrlGamePanel(GamePanelInterface view){
		
		this.view = view;
		game = new Game(new Player(), view.getArray());
		view.displayArray();
	}
	
	public void win(){
		
	}
	
	public void lose(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getActionCommand().equals("reload")){
			game = new Game(new Player(), view.getArray());
			view.displayArray();
		}
	}
	

}
