package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Array;
import model.Cell;
import view.interfaces.GamePanelInterface;
import controller.CtrlButton;
import controller.CtrlGamePanel;

public class GamePanel extends JPanel implements GamePanelInterface{

	private Array array;
	private ArrayList<JButton> ButtonList;
	private Image flag;
	private ImageIcon mine;
	private CtrlGamePanel controller;
	
	
	public GamePanel(Array array){
		super();
		flag = new ImageIcon("src/resources/images/flag.png").getImage();

		this.setVisible(true);
		ButtonList = new ArrayList<JButton>();
		this.array = array;
		int size = array.getSize();
		this.setLayout(new GridLayout(size,size));
		for(int x = 0; x < size ; x++){
			for(int y = 0 ; y < size ; y ++){
				Cell cell = array.getArray().get(x+y*size);
				JButton button = new JButton(cell.toString());
				button.addMouseListener(new CtrlButton(button,this,array,y,x)); // we switch between x and y because the arrays wheren't generated the same way (double vs single loop) TODO
				button.setFocusable(false);
				this.add(button);
				ButtonList.add(button);
			}
		}
		
	}

	public void setController(CtrlGamePanel controller){
		this.controller = controller;
	}
	@Override
	public void displayArray() {
		
		int size = array.getSize();
		for(int x = 0; x < size ; x++){
			for(int y = 0 ; y < size ; y ++){
				JButton button = ButtonList.get(x+y*size);
				Cell cell = array.getArray().get(x+y*size);
				if(cell.isUncovered()){
					if(cell.isBomb()){
						button.setIcon(new ImageIcon(new ImageIcon("src/resources/images/mine.jpg").getImage().getScaledInstance(button.getWidth(), button.getHeight(),java.awt.Image.SCALE_SMOOTH)));
						
					}
					else{
						if(cell.getAdjacentBombsNumber()==0){
							button.setBackground(Color.white);
						}
						else{
							button.setBackground(Color.gray);
							button.setForeground(Color.black);
						}
						button.setText(array.getArray().get(x+y*size).toString());
					}
				}
				else{
					if(cell.isFlag()){
						button.setIcon(new ImageIcon(flag.getScaledInstance(button.getWidth(), button.getHeight(),java.awt.Image.SCALE_SMOOTH)));
					}
					else{
						button.setBackground(Color.blue);
						button.setIcon(null);
					}
				}
			}
		}
		
		this.validate();
		
	}

	@Override
	public Array getArray() {
		return array;
	}



	
	
	

	
}
