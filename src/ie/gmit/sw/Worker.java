package ie.gmit.sw;

public class Worker {

	private boolean readyCheck;
	
	
	public Worker() {
		readyCheck = true;
	}
	
	public boolean onReady() {	
		return readyCheck;
	}

	
}
