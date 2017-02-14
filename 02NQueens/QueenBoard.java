public class QueenBoard{
    private int[][] board;
    private int solutionCount;

    
    public QueenBoard (int size){
	board = new int[size][size];
	for (int row = 0; row < size - 1; row ++){
	    for (int col = 0; col < board[0].length - 1; col ++){
		board[row][col] = 0;
	    }
	}		
    }

    public void solve(){
	solveColumn(0);
    }

    
    private boolean solveColumn(int col){
        if (col == board.length-1){
	    for (int row=0 ; row<board.length ; row++){
		if (board[row][col] == 0){
		    placeQueen(row,col);
		    return true;
		}
	    }
	    return false;
	}
	for (int row=0 ; row<board.length ; row++){
	    if (board[row][col]==0){
		placeQueen(row,col);
		if (solveColumn(col+1)){
		    return true;
		}
		removeQueen(row,col);
	    }
	}
	return false;
    }


    public void countSolutions(){
	countSolutionsHelper(0);
    }

    
    private void countSolutionsHelper(int col){
        if (col == board.length){
	    for (int row = 0; row < board.length; row ++){
		if (board[row][col] == 0){
		    solutionCount ++;
		}
	    }
	}
	for (int row = 0; row < board.length; row ++){
	    if (board[row][col] == 0){
		placeQueen (row, col);
		countSolutionsHelper (col + 1);
		removeQueen (row, col);
	    }
	}
    }
    

    public int getCount(){
	return solutionCount;
    }
    

    private boolean placeQueen(int r, int c){
	if(board[r][c] == 0){
	    for(int col = 0; col < board[0].length; col ++){
		board[r][col] += 1;
	    }

	    for(int row = 0; row < board.length; row ++){
		board[row][c] += 1;
	    }

	    for(int row = r, col = c; row < board.length && col < board.length; row ++, col ++){
		board[row][col] += 1;
	    }

	    for(int row = r, col = c; row > -1 && col > -1; row --, col --){
		board[row][col] += 1;
	    }

	    for(int row = r, col = c; row > -1 && col < board.length; row --, col ++){
		board[row][col] += 1;
	    }

	    for(int row = r, col = c; col > -1 && row < board.length; row ++, col --){
		board[row][col] += 1; 
	    }

	    board[r][c] = -1;
	    return true;
	}
	else{
	    return false;
	}
    }

    private boolean removeQueen(int row, int col){
	int diff = 1;
	if (board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	while (col + diff < board[row].length){
	    board[row][col + diff] ++;
	    if (row - diff >= 0){
		board[row - diff][col + diff] ++ ;
	    }
	    if (row + diff < board.length){
		board[row + diff][col + diff] ++ ;
	    }
	    diff ++;
	}
	return true;
    }


    public String toString(){
    	String ans = "";
	for (int row=0 ; row<board.length ; row++){
	    for (int col=0 ; col<board.length ; col++){
		if (board[row][col] == -1){
		    ans += "Q ";
		}else{
		    ans += "_ ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
}
