import java.util.*; 
import java.io.*; 

public class USACO{
		 

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

    //private static int R1; 
    //private static int C1; 
    //private static int R2; 
    //private static int C2; 
    //private static int R1; 
    public static int Bronze (String fileName){
	Volume = 0;
	try{  Scanner text = new  Scanner(new File(fileName));
	    R = text.nextInt(); 
	    C = text.nextInt();
	    E = text.nextInt(); 
	    N = text.nextInt(); 
	    field = new int[R][C];
			 
			 
	    for(int row = 0; row < R; row ++ )
		{	
		    for(int col = 0; col < C; col++){
			field[row][col] = text.nextInt();}}

		        
	    for(int i = 0; i < N; i++){
		R_s = text.nextInt();
		C_s = text.nextInt();
		D_s = text.nextInt();
		stomper(R_s - 1, C_s - 1, D_s);
		//maxer (2,2 );   
	    }}

			   



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
	return Volume;}


    public static void  stomper (int r, int c, int depth){
	int max = maxer( r, c);

	for (int i = 0; i < 3 ; i++){
	    for(int j = 0; j < 3; j ++ ){
		if (( r + i  > -1) && (r + i < R) && (c + j > -1) &&( c + j < C )){
		    if (max - field[r + i ][c + j] <= D_s ){

			field [r + i][c  + j] = (field[r + i][c + j] -  (depth - (max - field [r + i][c + j])));
		    }

		}
	    }}

    }





		    

    public static int maxer (int r1, int c1){
	int result = 0;
	for (int i = 0; i < 3 ; i++){
	    for(int j = 0; j < 3; j ++ ){
		if (( r1 + i  > -1) && (r1 + i < R) && (c1 + j > -1) &&( c1 + j < C )){
		    if (field [r1 + i][c1 + j ] > result )
			{result = field [r1 +  i][c1 + j];
			}}
	    }}
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
	return result; }



    public static void main(String[] args) {
	Bronze("makelake.5.in");
		 	
	System.out.println(Volume);
		

	
    }
}import java.util.*; 
import java.io.*; 

public class USACO{
    //worked on in conjunction with Katherine Vasilkin. Most of our code is the same.
    
    private static int[][] field;  
    private static int Volume;
    private static int R;
    private static int C;
    private static int E;
    private static int N;
    private static int R_s;
    private static int C_s;
    private static int D_s;

    public USACO{}

    public static int Bronze (String fileName){
	Volume = 0;
	try{  Scanner text = new  Scanner(new File(fileName));
	    R = text.nextInt(); 
	    C = text.nextInt();
	    E = text.nextInt(); 
	    N = text.nextInt(); 
	    field = new int[R][C];
	    for(int row = 0; row < R; row ++ )
		{	
		    for(int col = 0; col < C; col++){
			field[row][col] = text.nextInt();}}

        
	    for(int i = 0; i < N; i++){
		R_s = text.nextInt();
		C_s = text.nextInt();
		D_s = text.nextInt();
		stomper(R_s, C_s, D_s);}}
	   



	catch (FileNotFoundException e){
	    System.out.println("File Does Not Exist");
	    System.exit(1);
	}
	return Volume;}


    public static void  stomper (int r, int c, int depth){
    	Volume += r * c * depth;
    }

    public static int silver(String filename){
	Scanner a = null;
	try{
	    a = new Scanner(new File(filename));
	}
	catch(FileNotFoundException e){
	    System.exit(0);
	}
    }
    
    public static void main(String[] args) {
	Bronze("input.txt");
 	System.out.println(R);
 	System.out.println(C);
 	System.out.println(E);
 	System.out.println(N);
 	System.out.println(R_s);
 	System.out.println(C_s);
 	System.out.println(D_s);
	System.out.println(Volume);
    }
}
