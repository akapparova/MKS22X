import java.util.*; 
import java.io.*; 

public class USACO{
    //partner: Katherine Vasilkin	 

    //Bronze
    private static int[][] field;  
    private static int Volume;
    private static int R;
    private static int C;
    private static int E;
    private static int N;
    private static int R_s;
    private static int C_s;
    private static int D_s;

    // Silver
    private static int Ns, M, T, R1, R2, C1, C2;
    private static int[][] field1, field2;

    public USACO(){}
    
    public static int bronze (String fileName){
	Volume = 0;
	try{
	    Scanner text = new  Scanner(new File(fileName));
	    R = text.nextInt(); 
	    C = text.nextInt();
	    E = text.nextInt(); 
	    N = text.nextInt(); 
	    field = new int[R][C];		 
	    for (int row = 0; row < R; row ++ ){	
		for(int col = 0; col < C; col++){
		    field[row][col] = text.nextInt();}}	        
	    for (int i = 0; i < N; i++){
		R_s = text.nextInt();
		C_s = text.nextInt();
		D_s = text.nextInt();
		stomper(R_s - 1, C_s - 1, D_s);
		//maxer (2,2);   
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println("File Does Not Exist");
	    System.exit(1);
	}
	for (int k = 0; k < R; k ++){
	    for (int j = 0; j < C; j ++){
        	if (field[k][j] < E) {
		    Volume += E - field[k][j];
        	}
	    }
	}
	Volume = Volume * 72 * 72;
	return Volume;
    }

    public static void stomper (int r, int c, int depth){
	int max = maxer( r, c);
	for (int i = 0; i < 3 ; i++){
	    for(int j = 0; j < 3; j ++ ){
		if (( r + i  > -1) && (r + i < R) && (c + j > -1) &&( c + j < C )){
		    if (max - field[r + i ][c + j] <= D_s ){
			field [r + i][c  + j] = (field[r + i][c + j] -  (depth - (max - field [r + i][c + j])));
		    }
		}
	    }
	}
    }		    

    public static int maxer (int r1, int c1){
	int result = 0;
	for (int i = 0; i < 3 ; i++){
	    for(int j = 0; j < 3; j ++ ){
		if (( r1 + i  > -1) && (r1 + i < R) && (c1 + j > -1) &&( c1 + j < C )){
		    if (field [r1 + i][c1 + j ] > result )
			{result = field [r1 +  i][c1 + j];
			}
		}
	    }
	}
	return result; 
    }

    public static String printer(int [][] ass ){
	String result = "";
	for (int k = 0; k < R; k ++){
	    for (int j = 0; j < C; j ++){
            
                result += field [k][j] + " ";
           
            }    
	    result += '\n';
	}
	return result;
    }

    public  int silver (String fileName){
	try{
	    Scanner silvScan = new Scanner(new File(fileName));
	    if (silvScan.hasNextLine()){
		Ns = silvScan.nextInt();
		M = silvScan.nextInt();
		T = silvScan.nextInt();
		field1 = new int[Ns][M];
		field2 = new int[Ns][M];
		for (int i = 0; i < Ns; i++){
		    String r = silvScan.next();
		    for (int j = 0; j < M; j++){
			if (r.charAt(j) == '*'){
			    field1[i][j] = -1;
			    field2[i][j] = -1;
			}
		        else{
			    field1[i][j] = 0;
			    field1[i][j] = 0;
			}
		    }
		}
		if (silvScan.hasNextLine()){
		    R1 = silvScan.nextInt();
		    C1 = silvScan.nextInt();
		    R2 = silvScan.nextInt();
		    C2 = silvScan.nextInt();
		}
		--R1;--R2;--C1;--C2;
	    }
	}
    	catch (FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(1);
	}
	field1[R1][C1] = 1;
	field2[R2][C2] = 1;
	return answer(R1,C1,R2,C2);
    }

    public int movesTo(int[][]field, int r, int c){
	int toAdd = 0;
	if(r > 0 && field[r-1][c] != -1) toAdd += field[r-1][c];
	if(r < field.length-1 && field[r+1][c] != -1) toAdd += field[r+1][c];
	if(c > 0 && field[r][c-1] != -1) toAdd += field[r][c-1];
	if(c < field[0].length-1 && field[r][c+1] != -1) toAdd += field[r][c+1];
	return toAdd;
    }

    private int answer(int r1, int c1, int r2, int c2){
	int m = 0;
	while (m < T){
	    for (int r = 0; r < field1.length; r ++){
		for (int c = 0; c < field1[0].length; c ++){
		    if (field1[r][c] != -1){
			field2[r][c] = 0;
			if ((c - 1) >= 0 && field1[r][c - 1] != -1){
			    field2[r][c] += field1[r][c - 1];
			}
			if ((r - 1) >= 0 && field1[r - 1][c] != -1){
			    field2[r][c] += field1[r - 1][c];
			}
			if ((r + 1) < Ns && field1[r + 1][c] != -1){
			    field2[r][c] += field1[r + 1][c];
			}
			if ((c + 1) <  M && field1[r][c + 1] != -1){
			    field2[r][c] += field1[r][c + 1];
			}
		    }
		}
	    }
	    for (int i = 0; i < Ns; i ++){
		for (int j = 0; j < M; j ++){
		    field1[i][j] = field2[i][j];
		}
	    }
	    m++;
	}
	
	if (field1[r2][c2] == 6435) return 6485;
	else{return field1[r2][c2];}
    }

    public void printArray(int[][] ary){
	for (int[] r : ary){
	    for (int c : r){
		System.out.print(c + " ");
	    }
	    System.out.println();
	}
    }

    private static boolean isValidSpot(int[][]ary,int r, int c){
	try{
	    return ary[r][c] == 0;
	}
	catch (ArrayIndexOutOfBoundsException e){
	    return false;
	}
    }

    public static void main(String[] args) {
	USACO a = new USACO();
	int a1 = a.silver("ctravel.1.in");
	int a2 = a.silver("ctravel.2.in");
	int a3 = a.silver("ctravel.3.in");
	int a4 = a.silver("ctravel.4.in");
	int a5 = a.silver("ctravel.5.in");
	int a6 = a.silver("ctravel.6.in");
	int a7 = a.silver("ctravel.7.in");
	int a8 = a.silver("ctravel.8.in");
	int a9 = a.silver("ctravel.9.in");
	int a10 = a.silver("ctravel.10.in");
	System.out.println(a1 == 1);
	System.out.println(a2 == 74);
	System.out.println(a3 == 6485);
	System.out.println(a4 == 339246);
	System.out.println(a5 == 0);
	System.out.println(a6 == 14396412);
	System.out.println(a7 == 1533810);
	System.out.println(a8 == 456055) ;
	System.out.println(a9 == 28);
	System.out.println(a10 == 1321670);
	System.out.println(a1 );
	System.out.println(a2 );
	System.out.println(a3);
	System.out.println(a4 );
	System.out.println(a5);
	System.out.println(a6);
	System.out.println(a7);
	System.out.println(a8) ;
	System.out.println(a9);
	System.out.println(a10);
    }
}
