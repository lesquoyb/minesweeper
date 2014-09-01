package model;

import java.sql.Time;

public class Player {
	
	private int best;

	public int getBest() {
		return best;
	}

	public void setBest(int best) {
		this.best = best;
	}
	
	public void addTime(int time){
		if(time<best){
			best=time;
		}
	}

}
