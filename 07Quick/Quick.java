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
		   

    public static int quickselect(int[] ary, int k){
	return selectH(ary, k, 0, ary.length -1);
    }

    public static int selectH(int[] ary, int k, int start, int end){
	return 1;
    }

    public static void main(String[] args){
	int[] ary = {4, 3, 5, 77, 100, 2, 41, 32, 45, 21, 11};
	System.out.println(partition(ary, 0, 5));
	System.out.println(print(ary));
    }
}
