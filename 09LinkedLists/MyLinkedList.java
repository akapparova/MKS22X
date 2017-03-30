public class MyLinkedList{
    LNode start, end;
    int size;

    public MyLinkedList(){}

    public boolean add(int value) {
	LNode n = new LNode(value);
	LNode ne = start;
	for (int i = 0; i < size - 1; i ++) {
	    ne = ne.next;
	}
	ne.next = n;
	size += 1;
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
    
    /*public int get(int index);// return the value of the element at the specified index (0 based)
      public int set(int index, int newvalue);//change the value of the element at the specified index to the newValue, return the old value  


      public int indexOf(int value);//returns the index of the 1st occurrence of the value in the linked list, -1 if not found.
      public void add(int index, int newValue);// insert a new element at the specified index, 0 at the front, size() at the end. 
      public int remove(int index);// remove the element at the specified index, returns the value removed		       
    */

    private class LNode{
	private int value;
	private LNode next;

	public LNode(){}

	public LNode(int val){
	    this.value = val;
	}

	public LNode(int val, LNode nextone){
	    this.value = val;
	    this.next = nextone;
	}
    }

    public static void main(String[] args){

    }
}
