import java.util.ArrayList;

public class MyHeap{
    //private boolean isMax;
    private ArrayList<String> heap;

    public MyHeap(){
	heap = new ArrayList<String>;
	heap.add(0, null);
    }//construct empty max heap
   
    public MyHeap(boolean val){
	heap = new ArrayList<String>;
	heap.add(0, null);

	//isMax = val;
	//if (val){
	    //construct empty max heap
	//}
	//else{
	    //construct empty min heap
	    // -1.0 * 
	//}
    } 

    public void add(String s){//to bottom, and then pushUp
	
    }
    
    public String remove(){//from top, and then pushDown
    }
    
    public String peek(){
	return heap.get(1);
    }

    private void pushUp(int index){//swapping index with parent
        
    }
    private void pushDown(int index){//swapping index with child
    }
}
