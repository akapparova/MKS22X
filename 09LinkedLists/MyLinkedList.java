public class MyLinkedList{
    LNode start, end;
    int size;

    public MyLinkedList(){
	this.start = null;
	this.end = null;
	this.size = 0;
    }

    public boolean add(int value){
	LNode d = new LNode (value);
	add (size - 1, value);
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

	public LNode(){}

	public LNode(int val){
	    value = val;
	    next = null;
	}

	public LNode(int val, LNode nextone){
	    value = val;
	    next = nextone;
	}
    }

    public static void main(String[] args){
	MyLinkedList m = new MyLinkedList();
	m.add(0, 2);
	m.add(1, 3);
	m.add(1, 4);
	m.add(5);
	System.out.println("should be 3:");
	System.out.println(m.get(1));
	m.set(0, 99999999);
	System.out.println("should be 3");
	System.out.println(m.indexOf(5));
	m.remove(1);
	System.out.println(m);
    }
}

