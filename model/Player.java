package model;

import java.sql.Time;

public class Player {
	
	private Time best;

	public Time getBest() {
		return best;
	}

	public void setBest(Time best) {
		this.best = best;
	}
	
	public void addTime(Time time){
		if (time.before(best)){
			best = time;
		}
	}

}
