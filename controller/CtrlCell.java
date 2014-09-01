package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Array;
import model.Game;
import view.interfaces.GamePanelInterface;

public class CtrlCell implements MouseListener {

	
	private GamePanelInterface view;
	private Array array;
	private int x;
	private int y;


	public CtrlCell(JButton button,GamePanelInterface view,Array array,int x, int y) {
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
		array.testEndOfGame();
		view.displayArray();
		if (array.isLose()	){
			JOptionPane.showMessageDialog(null, "vous avez perdu");
				view.close();
		}
		if(array.isWin()){
			JOptionPane.showMessageDialog(null, "vous avez gagné");
			view.close();
		}
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
