package ie.gmit.sw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Adapted from - (1) https://stackoverflow.com/questions/2349633/doget-and-dopost-in-servlets
 * Adapted from - (2) https://github.com/DillonWard/Code-Snippets-Multi-Threading
 */

public class ContentServlet extends HttpServlet {

	private static final long serialVersionUID = 102831973239L; // changed this from 1 to prevent errors
	private String wordInput;
	private DictionaryClient dc = null;
	private String response;
	
	
	// post request that POSTS a parameter from the servlet to the 'backend' (1)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		wordInput = request.getParameter("wordInput"); // get the parameter where the name is 'wordInput'
		wordInput = wordInput.toLowerCase(); // make the parameter lowercase for comparing
		
		// creating a thread or appending to a queue for creating new threads (single threads)
		if(dc == null){ // if the queue is empty create a new thread
			dc = new DictionaryClient(wordInput);
			new Thread(dc).start();
		}else{ // else add the current word to the queue
			dc.append(wordInput);
		}
		
			try {
				Thread.sleep(1000);  // put the thread to sleep for 10 seconds (2)
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        System.out.println(wordInput);
        	
	}
}
