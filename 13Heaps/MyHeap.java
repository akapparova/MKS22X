import java.util.*;

public class MyHeap{
    private ArrayList<String> heap;
    private int constant;

    public MyHeap(){
	heap = new ArrayList<String>();
	heap.add("NOTHING!");
	constant = 1;
    }

    public MyHeap(boolean val){
	heap = new ArrayList<String>();
	heap.add("NOTHING!");
	if (val){
	    constant = 1;
	}else {
	    constant = -1;
	}
    }
    
    private void swap(int first, int second){
	String placeholder = heap.get(second);
	heap.set(second,heap.get(first));
	heap.set(first, placeholder);
    }

    public String peek(){
	if ((heap.size() - 1) == 1){
	    return "NOTHING!";
	}else if ((heap.size() - 1) < 1){
	    throw new NoSuchElementException();
	}else{
	    return heap.get(1);
	}
    }

    private int compareto(String thisOne, String otherOne){
	return


	    (thisOne.compareTo(otherOne)*constant);
    }
    
    public void add(String s){
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
    
    public String remove(){
	swap(1,(heap.size() - 1));
	String removed = heap.remove((heap.size() - 1));
	pushDown();
	return removed;
    }
}
