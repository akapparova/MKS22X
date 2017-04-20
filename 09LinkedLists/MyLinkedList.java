import java.util.*;

public class MyLinkedList implements Iterable<Integer>{
    LNode start, end;
    int size;

    private class MLLIterator implements Iterator<Integer>{
	private MyLinkedList ll;
	private int i;
	
	public MLLIterator(MyLinkedList set){
	    ll = set;
	}
	
	public boolean hasNext(){
	    return ll.size > i;
	}
	
	public Integer next(){
	    if(hasNext()){
		i ++;
		return ll.get(i - 1);
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }

    public Iterator<Integer> iterator(){
	return new MLLIterator(this);
    }
    
    public MyLinkedList(){
    }

    private LNode getNthNode(int n){
	if (n < 0 || n > size)throw new IndexOutOfBoundsException();
	LNode temp;
	if(n <= size / 2){
	    temp = start;
	    for(int i = 0; i < n; i += 1){temp = temp.next;}
	}else{
	    temp = end;
	    for(int i = size + -1; i > n; i -= 1){temp = temp.previous;}
	}
	return temp;
    }

    public int remove(int index){
	if (index > size || index < 0) throw new IndexOutOfBoundsException("Index must be within the bounds of the list");
	int ans = (getNthNode(index)).value;
	if (index == 0){
	    LNode beg = start.next;
	    start = beg;
	}else if(index == size - 1){
	    end = end.previous;
	    end.next = null;
	}else{
	    LNode lnode = getNthNode(index);
	    (lnode.previous).next = lnode.next;
	    (lnode.next).previous = lnode.previous;
	}
	size--;
	return ans;
    }
    
    public int size(){
	return size;
    }

    public boolean add(int value){
	add (size, value);
	return true;
    }
    
    public String toString(){
	if (this.size == 0){
	    return "[]";
	}
	String answer = "[";
	LNode lnode = start;
	while(lnode != null){
	    if (lnode.next == null)
		answer += " " + lnode.value + "]";
	    else{
		answer += " " + lnode.value + ",";
	    }
	    lnode = lnode.next;
	}
	return answer;
    }

    public String debugToString(){
	if (this.size == 0){
	    return "[]";
	}
	String answer = "[";
	LNode lnode = start;
	while(lnode != null){
	    if (lnode.next == null)
		answer += " " + lnode.toString() + "]";
	    else{
		answer += " " + lnode.toString() + ",";
	    }
	    lnode = lnode.next;
	}
	return answer;
    }

	
    
    public int get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode d = start;
	while(d.next != null && index > 0){
	    d = d.next;
	    index -= 1;
	}
	return d.value;
    }

    public int set(int index, int value){
	if(index == size)throw new IndexOutOfBoundsException();
	LNode lnode = getNthNode(index);
	int prev = lnode.value;
	lnode.value = value;
	return prev;
    }

    public int indexOf(int value){
	int i = 0;
	while (i < size){
	    if (get(i) == value) return i;
	    i ++;
	}
	return -1;
	
    }

    public void add(int index, int value){//doubly linked
    	if (index>size || index<0){throw new IllegalArgumentException();}
	LNode thing=new LNode(value);
	if (index==0){
	    if (size==0){
		start=thing;
		end=thing;
	    }else{
		start.previous=thing;
		thing.next=start;
		start=thing;
	    }
	}else if(index==size){
	    end.next=thing;
	    thing.previous=end;
	    end=thing;
	}else{
	    thing.previous=getNthNode(index-1);
	    thing.next=getNthNode(index);
	    getNthNode(index).previous=thing;
	    getNthNode(index-1).next=thing;
	}
	size++;
    }

    private class LNode{
	private int value;
	private LNode next = null;
	private LNode previous = null;

	public LNode(){}

	public LNode(int val){
	    this.value = val;
	}

	public LNode(int val, LNode nextone, LNode prevone){
	    this.value = val;
	    this.next = nextone;
	    this.previous = prevone;	    
	}

	public String toString(){ // needs debugging
	    if (previous == null && next == null){
		return "(null) " + value + " (null)";
	    }
	    if (previous == null){
		return "(null) " + value + " (" + next + ")";
	    }
	    if (next == null){
		return "(" + previous + ") " + value + " (null)";
	    }
	    else{
		return "(" + previous + ") " + value + " (" + next + ")"; 
	    }
	}
    }
}
