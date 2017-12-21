package ie.gmit.sw;

import java.util.LinkedList;
import java.util.Queue;

public class InQueue implements Runnable{

	private Queue<String> queue;
	private Runner worker;
	
	public InQueue(String word) {
		
		worker = new Runner();
		queue = new LinkedList<>();
		queue.add(word);
	}
	
	/*

	public void pollQueue(){
		
		int i = 10;
		try{
			while(!worker.onReady() && i != 0){
				Thread.sleep(1000); // puts the thread to sleep for 10 seconds
				i--;
			}
			
			if(queue.peek() != null){
				System.out.println(queue.peek().toString());
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	*/
	
	@Override
	public void run() {
		//pollQueue();
	}
	

}
