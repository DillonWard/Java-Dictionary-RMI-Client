package ie.gmit.sw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentServlet extends HttpServlet {

	private static final long serialVersionUID = 102831973239L;
	private String wordInput;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		wordInput = request.getParameter("wordInput");
		wordInput = wordInput.toLowerCase();
		
        System.out.println(wordInput);
        	
	}
}
