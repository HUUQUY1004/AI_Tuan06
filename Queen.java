package queen;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		// Enter your code here
//		+ 1 row
		this.setRow( this.getRow()+1);
		
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		// Enter your code here
//		Kiểm tra trên cùng 1 dòng
		if(this.getRow() == q.getRow()) return true;
//		Kiểm ta trên 1 đường chéo
		if(Math.abs(this.getRow() - q.getRow()) == Math.abs(this.getColumn()- q.getColumn())) return true;
		
		return false;
		
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
