public class Merge{
    
    /*public static void mergesort(int[]ary){
	if (ary.length < 2)
	    return;
	else{
	    int div = ary.length / 2;
	    int[] left = new int[div];
	    int[] right = new int[ary.length - div];
	}	    
    }

    def mergesort(int[]ary)
	if ...base case...
          stop!
        else
           int[]left = copy of the left side;
            int[]right = copy of the right side;
            mergesort(left)
            mergesort(right)
          mergeTheTwoHalvesIntoTheOriginalArray
    
    private static void merge(int[]a,int[]b,int[]destination){
    }

    public static void print (int[] ary){
	for (int i = 0; i < ary.length; i++){
	    System.out.print(ary[i] + " ");
	}
	}*/
    
    public static void main (String[] args){
	int[] a = {2,5,9,123,9034,698,8,930,2,2,2,2,6,5,5,5,5,5,5,5,5,5,5,5};
	//	mergesort(a);
	//print(a);
	int div = a.length / 2;
	int[] left = new int[div];
	int[] right = new int[a.length - div];
	System.out.println(a.length);
	System.out.println(div);
	System.out.println(left.length);
	System.out.println(right.length);
    }
}
