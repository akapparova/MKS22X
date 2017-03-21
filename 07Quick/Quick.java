

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

    public static int partition(int[] ary, int start, int end){
	if (start == end) return start;
	int pivot = (int) (Math.random() * (end - start + 1)) + start;
	int value = ary[pivot];
	swap(ary, end, pivot);
	int pivoting = start;

	int i = ;
	int lt = start;
	int gt = end;
	
	
	return 3;
    }

    public static String printArray(int[] ary){
	String ans = "";
	for (int i = 0; i < ary.length; i ++){
	    ans += (ary[i] + ", ");
	}
	return ans;
    }

    public static void quickSort(int[] ary){
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
	System.out.println(oldpartition(ary,0,ary.length - 1));
	System.out.println(printArray(ary));
    }
}
