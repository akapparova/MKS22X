import java.util.*;

public class MyHeap{
    private ArrayList<Integer> heap;
    private int constant;

    public MyHeap(){
	heap = new ArrayList<Integer>();
	heap.add(null);
	constant = 1;
    }

    public MyHeap(boolean val){
	heap = new ArrayList<Integer>();
	heap.add(null);
	if (val){
	    constant = 1;
	}else {
	    constant = -1;
	}
    }
    
    private void swap(int first, int second){
	int placeholder = heap.get(second);
	heap.set(second,heap.get(first));
	heap.set(first, placeholder);
    }

    public int peek(){
        if ((heap.size() - 1) < 1){
	    throw new NoSuchElementException();
	}else{
	    return heap.get(1);
	}
    }

    private int compareto(int thisOne, int otherOne){
	return


	    //for strings:  (thisOne.compareTo(otherOne)*constant);
	    (constant) * (thisOne - otherOne);
    }
    
    public void add(int s){
	heap.add(s);pushUp();
    }

    private void pushUp(){
	int place;
	place = (heap.size() - 1);
	while ( (place > 1) && (compareto(heap.get(place), heap.get(place / 2)) > 0) ) {
	    swap (place, place / 2);
	    place = place / 2;
	}
    }
	
    private void pushDown(){
	int place, above;
	above = 2;
	place = 1;
	while ((place * 2) < (heap.size() - 1) && (compareto(heap.get(place), heap.get(place * 2)) < 0 || compareto(heap.get(place), heap.get((place * 2) + 1)) < 0)) {
	    if (compareto(heap.get(place * 2), heap.get((place * 2) + 1)) >= 0){
		above =   place * 2;
	    }else {
		above = (place * 2) + 1;
	    }
	    swap(place, above);
	    place = above;
	}
    }
    
    public int remove(){
	swap(1,(heap.size() - 1));
	int removed = heap.remove((heap.size() - 1));
	pushDown();
	return removed;
    }

    public int size(){
	return heap.size() - 1;
    }
}
