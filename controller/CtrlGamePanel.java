package controller;

import model.Array;
import model.Game;
import model.Player;
import view.interfaces.GamePanelInterface;

public class CtrlGamePanel {
	
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
	

}
