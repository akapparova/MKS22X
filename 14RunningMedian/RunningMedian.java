public class RunningMedian{
    MyHeap rightMin;//values larger than median, min heap
    MyHeap leftMax;//values smaller than median, max heap
    double median;
    
    public RunningMedian(){
	rightMin = new MyHeap();
	leftMax = new MyHeap();
    }
    
    public void add(int a){
	if (a > median){
	    //if leftheap size smaller than rightheap size
	    //else if left heap size == right heap size
	    if (leftMax.size < rightMin.size){
	    }else if (leftMax.size > rightMin.size){
	    }else{}
	}
	else if (a < median){}
	else{}
    }

    public double getMedian(){return median;}

}
