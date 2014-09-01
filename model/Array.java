package model;

import java.util.ArrayList;
import java.util.Random;

public class Array {

	private ArrayList<Cell> array;
	private int size;
	private int bombsNumber;
	private boolean firstClick;
	private boolean lose ;
	private boolean win ;
	
	
	
	public Array(int size, int bombsNumber) {
		
		setLose(false);
		setWin(false);
		this.size = size;
		this.bombsNumber = bombsNumber;	
		firstClick = true;
		this.array = new ArrayList<Cell>();
		// creation of the array of square
		for(int i = 0 ; i< (size*size); i++){
			array.add(new Cell());
		}
	}
	
	/*
	 * generate the array using the first cell clicked
	 */
	public void generate(int x, int y){
		
		// we choose randomly which cell is a bomb
		int bombs=0;
		while( bombs < bombsNumber ){
			
			Random randomX = new Random();
			Random randomY = new Random();
			int randX = randomX.nextInt(size);
			int randY = randomY.nextInt(size);
			
			// if the random cell is not the clicked cell
			if((randX+randY*size)!=(x+y*size)){
				//if the random cell is not an adjacent cell
				if (! adjacentCells(x+y*size).contains(array.get(randX+randY*size)) ){
					//if the random cell is not already a bomb
					if ( ! array.get(randX+randY*size).isBomb() ){
						
						array.get(randX+randY*size).setBomb(true);
						bombs++;
						
					}
				}			
			}
			
		}
		
		// then we determine the number of adjacent bombs of each cell
		int i=0;
		for(Cell square : array){
			ArrayList<Cell> adj = adjacentCells(i);
			for(Cell adjCell : adj ){
				if(adjCell.isBomb()){
					square.setAdjacentBombsNumber(square.getAdjacentBombsNumber()+1);
				}
			}
			i++;
		}
		
	}
	
	public void click(int x, int y){
		
		Cell cellClicked= array.get(x + y * size);
		if(!cellClicked.isFlag()){
			if(firstClick){
				generate(x, y);
				firstClick=false;
			}
			cellClicked.setUncovered(true);
			if((cellClicked.getAdjacentBombsNumber()==0)  && ( ! cellClicked.isBomb() )){
				for(int cell: AdjacentCellsNumbers(x+y*size)){
					Cell cell2 = array.get(cell);
					if(!cell2.isUncovered()){
						cell2.setUncovered(true);
						if( (cell2.getAdjacentBombsNumber()==0) && ( ! cell2.isBomb() ) ){
							click(cell%size,cell/size);
						}
					}
				}
			}
		}
	}
	
	
	public void testEndOfGame(){
		int num = 0;
		for (int i = 0 ; i < size*size ; i++){
			Cell cell = array.get(i);
			if (cell.isBomb() && cell.isUncovered()){
				setLose(true);
			}
			if(cell.isBomb() && cell.isFlag()){
				num++;
			}
		}
		if(num==bombsNumber){
			setWin(true);
		}
	}
	public void flag(int x, int y){
		
		Cell cell =array.get(x+y*size);
		if(cell.isFlag()){
			cell.setFlag(false);
		}
		else{
			cell.setFlag(true);
		}
	}

	/*
	 * 
	 * @return Return an array of the adjacent cells of the cell at the i index in array
	 */
	public ArrayList<Cell> adjacentCells(int i){
		ArrayList<Cell> returnList = new ArrayList<Cell>();
		
		boolean firstCol, lastCol, firstRow, lastRow;
		firstCol = ( (i % size) == 0 );
		lastCol = ( ( (i+1) % size ) == 0 );
		firstRow = ( i < size);
		lastRow = ( i >= (size*(size-1)) );
		
		// if there is a cell on the left side
		if ( ! firstCol ){
			returnList.add(array.get(i-1));				
		}
		// if there is a cell on the right side
		if( ! lastCol ){
			returnList.add(array.get(i+1));				
		}
		// if there is a cell on the upper cell
		if( ! firstRow){
			returnList.add(array.get(i-size));							
		}
		// if there is a cell on the bottom side
		if( ! lastRow ){
			returnList.add(array.get(i+size));				
		}
		// diagonal top-left
		if( (!firstRow) &&	(!firstCol) ){
			returnList.add(array.get(i-size-1));	
		}
		// diagonal top-right
		if( (!firstRow) &&	(!lastCol) ){
			returnList.add(array.get(i-size+1));	
		}
		// diagonal bottom-left
		if( (!lastRow) &&	(!firstCol) ){
			returnList.add(array.get(i+size-1));	
		}
		// diagonal bottom-right
		if( (!lastRow) &&	(!lastCol) ){
			returnList.add(array.get(i+size+1));	
		}	
		return returnList;
	}
	
	public ArrayList<Integer> AdjacentCellsNumbers(int i){
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		
		boolean firstCol, lastCol, firstRow, lastRow;
		firstCol = ( (i % size) == 0 );
		lastCol = ( ( (i+1) % size ) == 0 );
		firstRow = ( i < size);
		lastRow = ( i >= (size*(size-1)) );
		
		// if there is a cell on the left side
		if ( ! firstCol ){
			returnList.add((i-1));				
		}
		// if there is a cell on the right side
		if( ! lastCol ){
			returnList.add((i+1));				
		}
		// if there is a cell on the upper cell
		if( ! firstRow){
			returnList.add((i-size));							
		}
		// if there is a cell on the bottom side
		if( ! lastRow ){
			returnList.add((i+size));				
		}
		// diagonal top-left
		if( (!firstRow) &&	(!firstCol) ){
			returnList.add((i-size-1));	
		}
		// diagonal top-right
		if( (!firstRow) &&	(!lastCol) ){
			returnList.add((i-size+1));	
		}
		// diagonal bottom-left
		if( (!lastRow) &&	(!firstCol) ){
			returnList.add((i+size-1));	
		}
		// diagonal bottom-right
		if( (!lastRow) &&	(!lastCol) ){
			returnList.add((i+size+1));	
		}	
		return returnList;
	}
	
	public ArrayList<Cell> getArray() {
		return array;
	}
	public void setArray(ArrayList<Cell> array) {
		this.array = array;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getBombsNumber() {
		return bombsNumber;
	}
	public void setBombsNumber(int bombsNumber) {
		this.bombsNumber = bombsNumber;
	}

	public boolean isLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	
	
	
	
}
