package main;

import model.Array;
import view.GamePanel;
import view.MainWindow;
import controller.CtrlGamePanel;

public class Main {

	public static void main(String[] args) {

		MainWindow main = new MainWindow(new Array(8,15));
	}

}
