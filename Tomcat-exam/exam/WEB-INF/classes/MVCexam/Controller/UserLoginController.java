package MVCexam.Controller;
import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class UserLoginController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException,IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		UserLoginModel lm = new UserLoginModel();
		
		try {
			
			String pwd = lm.getPassword(username);
			if (pwd.equals(password))
                        {

                          if(pwd.equals("ADMIN"))
				{
					System.out.println("Admin logged in successfully !!!");
					res.sendRedirect("admin?username="+username);
				}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					System.out.println("\nSuccessful Login!");
					//res.sendRedirect("questions?username=" + username);
                                        pw.print("<form action='questions' method='get'>");
                                        pw.print("<input type='hidden' name='username' value="+username+">");
                                        pw.print("<input type='submit' value='Start Test'>");
                                        pw.print("</form>");
				}

				
			}
			else{
				System.out.println("\nLogin Failure!!!\nIncorrect username or password");
				pw.println("<h1>\nLogin Failure!!!</h1>\n</h2>Incorrect username or password</h2><br><br>");
                                pw.println("<p>Click 'Try Again' button to try login again</p>");
				pw.println("<button onclick=\"location.href = 'OnlineExam.html';\">Try again</button>");
			}
			
		}catch(Exception e){
			System.out.println("Exception thrown : "+e);
		}
	}
}