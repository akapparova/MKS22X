public class Recursion{
    
    public static String name(){
	return "Kapparova, Asim Ayana";
    }
    
    public static double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException("Cannot square-root a negative value");
	}
        return betterGuess(n, n / 2);
    }
    
    private static double betterGuess(double n, double guess){
	if (n == 0){
	    return 0;
	}
	if(Math.abs (n - guess * guess ) < 0.0000000001) {
	    return guess;
	}
        return betterGuess(n, (n / guess + guess) / 2);
    }

    public static void main(String[]args){
	System.out.println(sqrt(16));
	System.out.println(sqrt(81));
	System.out.println(sqrt(1000000));
	System.out.println(sqrt(400));
    }
}
