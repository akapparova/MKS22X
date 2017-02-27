public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	for (int i = 0; i < (startingRows * startingCols); i ++){
	    int row = i / startingRows;
	    int col = i % startingCols;
	    board[row][col] = 0;
	}
    }

    public void solve() {
	solveH(0, 0, 1);
    }

    private boolean solveH(int row, int col, int level) {
	if (level > (board.length * board[0].length)) return true;
	if (row >= board.length || col >= board[0].length || row < 0 || col < 0) return false;
	if (board[row][col] == 0) {
	    board[row][col] = level;
	    if (solveH(row - 2, col + 1, level + 1) ||
		solveH(row - 2, col - 1, level + 1) ||
	        solveH(row - 1, col + 2, level + 1) ||
		solveH(row + 2, col + 1, level + 1) ||
		solveH(row + 1, col + 2, level + 1) ||
		solveH(row + 2, col - 1, level + 1) ||
		solveH(row + 1, col - 2, level + 1) ||
		solveH(row - 1, col - 2, level + 1))
		{return true;}
	    board[row][col] = 0;
	}
	return false;
    }

    public String toString(){
	String ans = "";
	for(int i = 0; i < board.length; i ++){
	    for(int j = 0; j < board.length; j ++){
		ans  = ans  + board[j][i] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

}
