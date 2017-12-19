package ie.gmit.sw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response.jsp")
public class ContentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String wordInput;
	//private String definition;
	Worker w = new Worker();

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		wordInput = request.getParameter("wordInput");

        	System.out.println(wordInput);
        	
        	try {
				check(wordInput);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public void check(String s) throws Exception{
		
		w.checkList(s);			

	}

}
