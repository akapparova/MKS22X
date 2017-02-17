public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
    }

    public String toString(){ //blank if you never called solve or when there is no solution

    }

    public void solve() {
	solveH();
    }

    private boolean solveH(int row ,int col, int level) {// level is the # of the knight
	if (level > row * col){
	    return true;
	}
	else{
	    if (isOnGoodSpot()){
		
	    }
	}
    }

    private boolean isOnGoodSpot(){
    }

}
