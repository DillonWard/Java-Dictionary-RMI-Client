package ie.gmit.sw;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.Queue;

/*  Adapted from - (1) https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html
 */

// Not sure/can't think of how to implement a main method for the client, so calls are made to execute classes instead
public class DictionaryClient implements Runnable {

	private String res; // response that will be appended to the response queue
	// linked lists for handling requests and responses
	private Queue<String> requestQueue = new LinkedList<>(); // can't make a queue into a map
	private Queue<String> responseQueue = new LinkedList<>();

	public DictionaryClient(String str){
		requestQueue.add(str); // adds the parameter posted from the servlet to the request queue
	}
	
	public void run() {
		try {

			if (requestQueue.peek() != null) { // retrieves the head of the queue - do while the queue is not empty (1)
				DictionaryService dict = (DictionaryService) Naming.lookup("//localhost/dictionary"); // checks the lookup table for 'dictionary'
				this.res = dict.checkWord(requestQueue.poll()); // compares the word being passed into the queue - the head of the queue will either be removed or null (1)
				responseQueue.add(res); // adds the response to the response queue
			} else {
				System.out.println("DictionaryClient queue empty");
			}
		} catch (Exception e) {
			System.out.println("DictionaryClient exception: " + e);
		}
	}

	public void append(String str) {
		requestQueue.add(str); // appends to the request queue
		run(); // starts the queue handling process
	}
	
	public String pollQueue(){
		return responseQueue.poll(); // returns the head of the queue (1)
	}
	

}
