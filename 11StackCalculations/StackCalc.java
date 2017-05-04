import java.util.Stack;

public class StackCalc {
    
    public static double eval(String s){
	String[] tokens = s.split(" ");
	Stack<String> values = new Stack<String>();
	for(String token : tokens){
	    if(isOp(token)){
		values.push(perform(values.pop(),values.pop(),token));
	    }
	    else{
		values.push(token);
	    }
	}
	return Double.parseDouble(values.pop());
    }

    private static boolean isOp(String s) {
	return s.equals("-") ||
	       s.equals("+") ||
	       s.equals("*") ||
	       s.equals("%") ||
	       s.equals("/");
    }
    
    private static String perform(String b, String a, String op) {
	if (op.equals("-")) {
	    return "" + (Double.parseDouble(a) - Double.parseDouble(b));
	}else if (op.equals("+")){
	    return "" + (Double.parseDouble(a) + Double.parseDouble(b));
	}else if (op.equals("*")){
	    return "" + (Double.parseDouble(a) * Double.parseDouble(b));
	}else if (op.equals("%")){
	    return "" + (Double.parseDouble(a) % Double.parseDouble(b));
	}else{
	    return "" + (Double.parseDouble(a) / Double.parseDouble(b));
	}
    }
}
