public class MyLinkedList{
    Lnode start, end;
    int size;

    public MyLinkedList(){}

    public boolean add(int value);//adds the value to end (try adding to the front first, for testing purposes)
    public int size(){
	return size;
    }
    public String toString();//returns a string representation of the list of n elements formatted like: [ v0, v1, v2, v3, ... vn-1] or []
    public int get(int index);// return the value of the element at the specified index (0 based)
    public int set(int index, int newvalue);//change the value of the element at the specified index to the newValue, return the old value  


    public int indexOf(int value);//returns the index of the 1st occurrence of the value in the linked list, -1 if not found.
    public void add(int index, int newValue);// insert a new element at the specified index, 0 at the front, size() at the end. 
    public int remove(int index);// remove the element at the specified index, returns the value removed		       


    private class LNode{
	private int value;
	private LNode next;

	public LNode(int val){
	    this.value = val;
	}

	public LNode(int val, LNode nextone){
	    this.value = val;
	    this.next = nextone;
	}
    }
}
