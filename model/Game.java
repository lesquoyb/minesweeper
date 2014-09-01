package model;

import java.util.Calendar;

import javax.swing.Timer;

import controller.CtrlTime;

public class Game {
	
	private Player player;
	private Array array;
	private Timer timer;
	private CtrlTime controllerTime;
	
	
	
	public Game(Player player, Array array) {
		this.player = player;
		this.array = array;
		controllerTime = new CtrlTime();
		timer = new Timer(1000,controllerTime);

	}
	
	public void start(){

		timer.start();	
	}
	
	public void end(){
		
		timer.stop();
		player.addTime(controllerTime.getTime());
		controllerTime.stop();
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Array getArray() {
		return array;
	}
	public void setArray(Array array) {
		this.array = array;
	}
	
	


}
