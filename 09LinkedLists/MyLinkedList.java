public class MyLinkedList{
    LNode start, end;
    int size;
    boolean debug = true;

    public MyLinkedList(){
	this.start = null;
	this.end = null;
	this.size = 0;
    }
    private node getNthNode(int n){//n is the index of the node you want
	
    }

    private remove(LNode x){
    	if (size == 0){
    	    throw new IllegalArgumentException("Can't call remove on an empty linked list.");
    	}else if(size == 1){
    	    x.value = null;
    	    x.previous = null;
    	    x.next = null;
    	    size --;
    	}else{
    	    if(x.previous == null){
    		x.next.previous = null;
    	    }else if (x.next == null){
    		x.previous.next = null;
    	    }else{
    		x.prev.next = x.next;
    		x.next.previous = x.previous;
    	    }
    	}
    } 

    private insertAfter(LNode toBeAdded, LNode location){
    }

    private insertBefore(LNode toBeAdded, LNode location){}

    public boolean add(int value){
    	LNode d = new LNode (value);
    	add (size - 1, value);
    	end = d;
    	return true;
    }
    
    public int size(){
	return size;
    }
    
    public String toString(){
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
	String answer = "[";
	LNode lnode = start;
	while(lnode != null){
	    if (lnode.next == null)
		answer += " " + toString(lnode) + "]";
	    else{
		answer += " " + toString(lnode) + ",";
	    }
	    lnode = lnode.next;
	}
	return answer;

	
    
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
    
	public int set(int index, int newValue){
	    LNode aq = start;
	    int a = get(index);
	    int i = 0;
	    while (1 < size){
		if (i == index) {aq.value = newValue; i ++;}
		else {aq = aq.next; i ++;}
	    }
	    return a;
	}

	public int indexOf(int value){
	    int i = 0;
	    while (i < size){
		if (get(i) == value) return i;
		i ++;
	    }
	    return -1;
	
	}
   
	public void add(int index, int value){
	    if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
	    LNode beg = start;
	    LNode z = new LNode(value);
	    //	int i = 0;
	    while (beg.next != null){
		beg = beg.next;
		// i++;
	    }
	    LNode temp = beg.next;
	    beg.next = z;
	    beg.next.next = temp;
	    size += 1;
	}

	public int remove(int index){
	    int past = -1;
	    LNode present = start;
	    if (index < 0 || index > size){ throw new IndexOutOfBoundsException();}
	    if (index == 0){
		past = start.value;
		start = start.next;
	    }
	    else if(index == size){
		for(int i = 0; i < index - 2; i++){
		    present = present.next;
		}
		past = present.next.value;
		present.next = null;
	    }
	    else{
		for (int i = 0; i < index - 1; i++){
		    present = present.next;
		}
		past = present.next.value;
		present.next = present.next.next;
	    }
	    size --;
	    return past;			
	}

	public class LNode{
	    private int value;
	    private LNode next;
	    private LNode previous;

	    public LNode(){}

	    public LNode(int val){
		value = val;
		next = null;
		previous = null;
	    }

	    public LNode(int val, LNode nextone, LNode prevone){
		value = val;
		next = nextone;
		previous = prevone;	    
	    }

	    public  String toString(){
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

	public static void main(String[] args){
	    MyLinkedList m = new MyLinkedList();
	    System.out.println(m);
	    //m.add(5);
	    System.out.println(debugToString(m));
	    //other test cases! test all methods!!
	}
    }
