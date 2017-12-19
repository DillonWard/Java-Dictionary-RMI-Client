package ie.gmit.sw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Input extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String wordInput;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

        if (request.getParameter("submit") != null) {
        	
        	System.out.println("Well");
        } else {
        	
        }

    }
	
	
	
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("SUBFAMILY", wordInput);
        request.getRequestDispatcher("Content.jsp").forward(request, response);
    }

	
	
}
