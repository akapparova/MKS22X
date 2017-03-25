public class QueenBoard{
    private int[][] board;
    private int solutionCount = -1;;

    
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
	if (col == board.length) return true;
	for (int r = 0; r < board.length; r ++){
            if (board[r][col] == 0){
                addQueen(r, col);
                if (solveColumn(col + 1)){
                    return true;
                }
                removeQueen(r , col);
            } 
        }
        return false;
    }


    public void countSolutions(){
	if(solutionCount == -1) solutionCount = 0;
	countSolutionsHelper(0);
    }

    
    private void countSolutionsHelper(int col){    
	if(col >= board.length){
	    solutionCount++;
	    return;
	}
	for(int r = 0; r < board.length; r++){
	    if(board[r][col] == 0){
		addQueen(r, col);
		countSolutionsHelper(col + 1);
		removeQueen(r, col);
	    }
	}
    }
    

    public int getSolutionCount(){
	return solutionCount;
    }
    

    private boolean addQueen(int r, int c){
	if(board[r][c] != 0){
	    return false;
	}
	board[r][c] = 1;
	int diff = 1;
	while (c + diff < board[r].length){
	    board[r][c + diff]--;
	    if(r - diff >= 0){
		board[r - diff][c + diff]--;
	    }
	    if(r + diff < board.length){
		board[r + diff][c + diff]--;
	    }
	    diff ++;
	}
	return true;
    }

    private boolean removeQueen(int r, int c){
	if (board[r][c] != 1){
	    return false;
	}
	board[r][c] = 0;
	int diff = 1;
	while (c + diff < board[r].length){
	    board[r][c + diff]++;
	    if(r - diff >= 0){
		board[r - diff][c + diff]++;
	    }
	    if(r + diff < board.length){
		board[r + diff][c + diff]++;
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
