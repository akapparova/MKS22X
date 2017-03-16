public class Quick{

    public static void swap(int[] ary, int i, int j){
	int temp;
	temp = ary[i];
	ary[i] = ary[j];
	ary[j] = temp;
    }

    public static int partition(int[] ary, int start, int end){
	if (start == end) return start;
	int pivotI = (int) (Math.random() * (end - start + 1)) + start;
	int value = ary[pivotI];
	swap(ary, end, pivotI);
	int pivoting = start;
	for (int i = start; i < end; i ++){
	    if (ary[i] < value){
		swap(ary, pivoting, i);
		pivoting++;
	    }
	}
	swap(ary, pivoting, end);
	return pivoting;
    }

    public static String print(int[] ary){
	String ans = "";
	for (int i = 0; i < ary.length; i ++){
	    ans += (ary[i] + ", ");
	}
	return ans;
    }
		   

    //public static int quickselect(int[] data, int k){
    //return the value that is the kth smallest value of the array. 
    //use your partition method to help you accomplish this.
    // }

    public static void main(String[] args){
	int[] ary = {4, 3, 5, 77, 100, 2, 41, 32, 45, 21, 11};
	System.out.println(partition(ary, 0, 5));
    }
}
