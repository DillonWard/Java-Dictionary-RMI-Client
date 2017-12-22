package ie.gmit.sw;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.Queue;

public class DictionaryClient implements Runnable {

	private String res;
	private Queue<String> requestQueue = new LinkedList<>();;
	private Queue<String> responseQueue = new LinkedList<>();;

	public void run() {
		try {

			if (requestQueue.peek() != null) {
				DictionaryService dict = (DictionaryService) Naming.lookup("//localhost/dictionary");
				this.res = dict.checkWord(requestQueue.poll());
				responseQueue.add(res);
			} else {
				System.out.println("DictionaryClient queue empty");
			}
		} catch (Exception e) {
			System.out.println("DictionaryClient exception: " + e);
		}

	}

	public void addQueue(String str) {
		requestQueue.add(str);
		run();
	}

}
