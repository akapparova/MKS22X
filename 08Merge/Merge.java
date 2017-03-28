public class Merge{
    
    public static void mergesort(int[]ary){
	if (ary.length < 2)
	    return;
	else{
	    int div = ary.length / 2;
	    int[] left = new int[div];
	    int[] right = new int[ary.length - div];
	    for (int i = 0; i < left.length; i++){
		left[i] = ary[i];
	    }
	    for (int i = 0; i < right.length; i++){
		right[i] = ary[i + div];
	    }
	    mergesort(right);
	    mergesort(left);
	    merge(right,left,ary);
	}	    
    }

    private static void merge(int[] a, int[] b, int[] destination){	
	int one = 0;
	int two = 0;
	while (one < a.length && two < b.length) {
	    if (a[one] < b[two]) {
		destination[one + two] = a[one];
		one++;
	    }
	    else {
		destination[one + two] = b[two];
		two++;
	    }
	}	
	for (int i = one; i < a.length; i++) {
	    destination[i + two] = a[i];
	}
	for (int j = two; j < b.length; j++) {
	    destination[j + one] = b[j];
	}
    }

    public static void print (int[] ary){
	for (int i = 0; i < ary.length; i++){
	    System.out.print(ary[i] + " ");
	}
    }
    
    public static void main (String[] args){
	int[] a = {2,5,9,123,9034,698,8,930,2,2,2,2,6,5,5,5,5,5,5,5,5,5,5,5};
	mergesort(a);
	print(a);
    }
}
