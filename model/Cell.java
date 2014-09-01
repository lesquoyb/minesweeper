package model;

public class Cell {

	
	private boolean bomb;
	private boolean uncovered;
	private boolean flag;
	private int adjacentBombsNumber;
	
	
	
	
	public Cell() {
		this.bomb = false;
		this.uncovered=false;
		this.adjacentBombsNumber=0;
		this.flag=false;
	}
	
	
	public boolean isBomb() {
		return bomb;
	}
	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}
	public boolean isUncovered() {
		return uncovered;
	}
	public void setUncovered(boolean uncovered) {
		this.uncovered = uncovered;
	}
	public int getAdjacentBombsNumber() {
		return adjacentBombsNumber;
	}
	public void setAdjacentBombsNumber(int adjacentBombsNumber) {
		this.adjacentBombsNumber = adjacentBombsNumber;
	}


	@Override
	public String toString() {
		String returnString ="";
		if(uncovered){
			if(bomb){
				returnString="B";
			}
			else{
				if(adjacentBombsNumber==0){
					returnString="";
				}
				else{
					returnString=Integer.toString(adjacentBombsNumber);
				}
			}
		}
		return returnString;
	}


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	 
	
}
