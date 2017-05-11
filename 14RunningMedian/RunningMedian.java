public class RunningMedian{
    MyHeap lMax = new MyHeap();
    MyHeap rMin = new MyHeap(false);

    public RunningMedian(){}

    public double getMedian(){ 
	if (rMin.size() == lMax.size()){
	    return (1.0 * (lMax.peek() + rMin.peek())) / 2;
	} else if(lMax.size() > rMin.size()){
	    return 1.0 * lMax.peek();
	} else {
	    return 1.0 * rMin.peek();
	}
    }
    
    public void add(int n) {
	if (lMax.size() == 0){
	    lMax.add(n);
	}else if (n < lMax.peek()){
	    lMax.add(n);
	}else {
	    rMin.add(n);
	}


	
	if (lMax.size() > 1 + rMin.size()) {
	    rMin.add( lMax.remove() );
	}else if (rMin.size() > 1 + lMax.size()) {
	    lMax.add( rMin.remove() );
	}
    }
}
