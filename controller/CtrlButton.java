package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import model.Array;
import model.Game;
import view.interfaces.GamePanelInterface;

public class CtrlButton implements MouseListener {

	
	private GamePanelInterface view;
	private Array array;
	private int x;
	private int y;


	public CtrlButton(JButton button,GamePanelInterface view,Array array,int x, int y) {
		super();
		this.view = view;
		this.x = x;
		this.y = y;
		this.array = array;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton()==MouseEvent.BUTTON1){
			array.click(x,y);
		}
		else{
			array.flag(x,y);
		}
		view.displayArray();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	
	
}
