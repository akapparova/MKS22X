public class KnightBoard{
    private int[][] board;
    private int rows, cols;
    private int [] cm = {-2,-2,-1,-1,1,1,2,2};
    private int[] rm = {1,-1,2,-2,1,-1,2,-2};
    
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	this.rows = startingRows;
	this.cols = startingCols;
    }

    public void solve() {
	solveH(0, 0, 1);
    }

    private boolean solveH(int r, int c, int level){
	int i = 0;
	if (rows*cols < level) return true;
	if (r < 0 || c < 0 || r >=board.length || c >= board[0].length) return false;
	if (board[r][c] == 0){
	    board[r][c] = level;
	    while(i < rm.length){
		if (solveH (r+cm[i], c+rm[i],level +1)) return (1==1); i+=1;
	    }
	    board[r][c] = 0;
	}
        return false;
    }
    
    public String toString(){
	String kboard = "";
	for(int r = 0; r < board.length; r ++){
	    kboard += "\n";
	    for(int c = 0; c < board[0].length; c ++){
		if(board[r][c] < 10){
		    kboard += "_" + board[r][c] + " ";
		}
		else{
		    kboard += "" + board[r][c] + " ";
		}
	    }
	}
	return kboard;
    }
}
