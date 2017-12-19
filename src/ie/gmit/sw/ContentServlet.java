package ie.gmit.sw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add_word")
public class ContentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String wordInput;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//wordInput = request.getParameter("wordInput");

        try{
        	System.out.println(request.getParameter("wordInput"));
        }catch (Exception e) {
        	System.out.println("Failed.");
		}
				
        
	}

	/*
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("SUBFAMILY", wordInput);
		request.getRequestDispatcher("Content.jsp").forward(request, response);
	}
	*/

}
