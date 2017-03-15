public class Quick{

    public static void swap(int[] ary, int i, int j){
	int temp;
	temp = ary[i];
	ary[i] = ary[j];
	ary[j] = temp;
    }

    public static int partition(int[] ary, int start, int end){
	int pivotI = (int)(Math.random() * (end - start));
	int value = ary[pivotI];
	for (int i = start; i < pivotI; i ++){
	    if (ary[i] > value){
		swap(ary, i, pivotI);
		pivotI = i;
	    }
	}
	for (int i = pivotI; i < end; i ++){
	    if (ary[i] < value){
		swap(ary, i, pivotI);
		pivotI = i;
	    }
	}
	return pivotI;
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
	int[]ary = { 2, 10, 15, 23, 0,  5};/*
					     quickselect( ary , 0 );// would return 0
					     quickselect( ary , 1 );//  would return 2
					     quickselect( ary , 2 );//  would return 5
					     quickselect( ary , 3 );//  would return 10
					     quickselect( ary , 4 );//  would return 15
					     quickselect( ary , 5 );//  would return 23
					   */
	System.out.println(partition(ary,0,ary.length));
	System.out.println(print(ary));
    }
}
