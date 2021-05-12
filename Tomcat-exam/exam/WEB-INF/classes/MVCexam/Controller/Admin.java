package MVCexam.Controller;
import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class Admin extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String username = request.getParameter("username");
		
		pw.println("<html><head><title>Admin</title></head>");
		pw.println("<body style='background-color:#99ccff;color:#004080;align:center'></br><h1>Hello "+ username+"!!!!");
		
		
		//SessionCounter sc = new SessionCounter();
		pw.println("<p>Number of students who have successfully logged in for the test are: "+SessionCounter.getSessionCount()+"</p>");
		pw.println("</body></html>");
		
	}
}