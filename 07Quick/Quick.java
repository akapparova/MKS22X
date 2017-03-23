

import java.util.*;

public class Quick{

    public static void swap(int[] ary, int i, int j){
	int temp;
	temp = ary[i];
	ary[i] = ary[j];
	ary[j] = temp;
    }

    public static int oldpartition(int[] ary, int start, int end){
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

    public static int partition (int[]data,int start, int end){
	if (start == end) {
	    return start;
	}
	int pivotindex = (int)(Math.random() * (end - start + 1)) + start;
	int gt = end;
	int lt = start;
	int i = start + 1;
	int val = data[lt];
	swap(data, pivotindex, start);
	while(i <= gt){
	    if(data[i] == val)i++;
	    else if(data[i] < val){
		swap(data,i,lt); i++; lt++;
	    }
	    else{
		swap(data,gt,i); gt--;
	    }
	}
	return lt;		    
    }

    public static String printArray(int[] ary){
	String ans = "";
	for (int i = 0; i < ary.length; i ++){
	    ans += (ary[i] + ", ");
	}
	return ans;
    }

    public static void quicksort(int[] ary){
	quickSortH(ary, 0, (ary.length - 1));
    }
    
    private static void quickSortH(int[] ary, int start, int end){
	if (((end - start) + 1) > 1){
	    int div = oldpartition (ary, start, end);
	    quickSortH(ary, start, div);
	    quickSortH(ary, div + 1, end);
	}
    }
		   
    public static int quickselect(int[] ary, int k){
	return selectH(ary, k, 0, ary.length - 1);
    }

    public static int selectH(int[] ary, int k, int start, int end){
        int pivot = oldpartition (ary, start ,end);
	if (pivot == k) return ary[pivot];
	if (pivot > k) return selectH(ary, k, start, pivot);
	if (pivot < k) return selectH(ary, k, pivot + 1, end);
	return ary[k];
    }

    public static void main (String[] args){
	int[] ary = {9,8,8,8,7,7,7,6,5,4,4,4,3,2,1,1,1,0};
	System.out.println(quickselect(ary,2));
        quicksort(ary);
	System.out.println(printArray(ary));
    }
}
