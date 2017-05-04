import java.util.*;

public class MyDeque{
    int size;
    int front;
    int back;
    String[] ary;


    public MyDeque(){
	ary = new String[7];
    }

    public String getFirst(){
	if (size < 1)
	    throw new NoSuchElementException();
	else{
	    return ary[front];
	}
    }

    public String getLast(){
	if (size < 1)
	    throw new NoSuchElementException();
	else{
	    return ary[back];
	}
    }
    
    public void addFirst(String i){
    	if (i == null) throw new NullPointerException();
    	if (size > (ary.length - 1)) resize();
    	if ((size > 0)){
    	    front = front - 1;
    	    if (front <= -1) front = ary.length - 1;
    	}
    	ary[front] = i;
    	size = size + 1;
    }
    
    public void addLast(String i){
    	if (i == null) throw new NullPointerException();
    	if(size > ary.length - 1)resize();
    	if ((size > 0)){
    	    back = back + 1;
    	    if (back > ary.length - 1)
    		back = 0;
    	}
    	ary[back] = i;
    	size ++;
    }  
    
    public String removeFirst(){
	if (size < 1) throw new NoSuchElementException();
	String toBeR = ary[front];
	front = front + 1;
	if (front > ary.length - 1) front = 0;
	size = size - 1;
	return toBeR;	       
    }

    public String removeLast(){
	if (size < 1) throw new NoSuchElementException();
	String toBeR = ary[back];
	back = back - 1;
	if (back < 0) back = ary.length - 1;
	size = size - 1;
	return toBeR;
    }

    private void resize(){
    	String[] temp = new String[ary.length * 2];
    	int f = front;
	for (int i = 0; i < front + size; i ++){
	    temp[i] = ary[f % ary.length];
	    f = f + 1;
	}
	front = 0;
	back = size - 1;
	ary = temp;
    }
    
}
