package citySim9000;

public class Driver {
	int current;
	int next;
	
	public Driver(){
		this.current = -1;
		this.next = -1;
	}
	public void setCurrent(int location){
		current = location;
	}
	public int getCurrent(){
		return current;
	}
	public void setNext(int nextVal){
		next = nextVal;
	}
	public int getNext(){
		return next;
	}
}
