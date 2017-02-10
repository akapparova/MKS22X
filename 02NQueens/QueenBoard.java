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


    //first solution it finds becomes the toString(), returns true
    //if no solution is found, solve() returns false and toString() is modified
    public boolean solve(){
	return solveColumn(0);
    }


    //solves for each column. Recursion happens here! Yay backtracking!
    public boolean solveColumn(int col){
	if (col >= board.length){
	    return true;
	}
	else if {}
	else{
	}
    }
    

    //finds all the solutions and adds number to toString()
    //updates the variable and if there are no solutions, returns false
    public boolean countSolutions(){
	return false;
    }
    

    public string getCount(){
	return "";
    }
    

    //returns first found solution and number of other solutions found
    public String toString(){
	return "";
    }
    

    //adds a Queen to a desired spot ( = to -1) and marks off new non-safe spot
    //(++ that spot)
    private void addQueen (int r,int c){
	
	board[r][c] = -1;
    }
    

    //removes a Queen from desired spot (sets to 0) and marks off new safe areas
    //(-- that spot)
    private void removeQueen (int r, int c){
	if (board[r][c] == 0){
	}
	else if (board[r][c] > 0){
	}
	board[r][c] = ;
    }
    

}
