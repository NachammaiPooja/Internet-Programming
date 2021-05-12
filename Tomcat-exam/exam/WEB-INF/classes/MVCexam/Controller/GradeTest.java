package MVCexam.Controller;
import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class GradeTest extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
                try 
               {
                TestAns qum = new TestAns();
                ResultSet rs = qum.getQuestions(10);
                Integer score = 0;
                String username = request.getParameter("username");
      		String[] choice = new String[10];
		String[] answer = new String[10];
                System.out.println(username);
		
                pw.print("<body style='background-color:#80ffaa;'></br>");

		for(int i=1; i<=10; i++)
		{
			choice[i-1] = request.getParameter(""+i+""); 
			answer[i-1] = request.getParameter(""+i+"a");
		}
		
		pw.println("<p><b><h1 style='color:#194d33;text-shadow:1px 1px yellow;'>REVIEW: </h1></b></p>"); 
		for(int i=1; i<=10; i++)
		{
                        String question =rs.getString("question");
                        pw.println("<p>" + i +") "+ question + "<p>");
                        rs.next();

			pw.println("<p>  "+choice[i-1]+"<br>");
			if(answer[i-1].equals(choice[i-1]))
			{
				pw.println("<b>Your Answer is Correct!</b></p>");
				score+=1;
			}
			else
				pw.println("<b>Your Answer is Incorrect!</b><br>The Correct answer is: "+answer[i-1]+"</p>");
		}
		pw.println("<p><b>Marks: "+score+"/10</b></p>");
                pw.println("<form action='getreport' method='post'>");
                pw.println("<input type='hidden' name='username' value=" + username + ">");
                pw.println("<input type='hidden' name='score' value=" + score + ">");
                pw.println("</br><center><input type='submit' value='Get Grade Sheet'></center>");
                pw.println("</form>"); 	
	}
        catch (Exception e) {
            System.out.println("Exception thrown : " + e);
        }
      }
}