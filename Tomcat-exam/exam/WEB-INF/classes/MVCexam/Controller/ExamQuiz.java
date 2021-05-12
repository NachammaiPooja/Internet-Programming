package MVCexam.Controller;
import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class ExamQuiz extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		TestAns qm = new TestAns();
		String username = request.getParameter("username");
                System.out.println(username);

		try {
			
			ResultSet rs = qm.getQuestions(10);
                        pw.print("<body style='background-color:#80ffaa;'></br>");
                        pw.print("<h1 style='color:#194d33;font-size:40px;text-shadow:1px 1px yellow;text-align:center;'>UCS1405-Computer Science Exam<h1>");
			Integer i=1, j=1;
			pw.println("<form action=\"answers\" method=\"post\">");
			do 
			{
				String question = rs.getString("question");
			
				ArrayList<String> options = new ArrayList<String>();
				options.add(rs.getString("option1"));
				options.add(rs.getString("option2"));
				options.add(rs.getString("option3"));
				options.add(rs.getString("option4"));
				Collections.shuffle(options);
				String answer = rs.getString("answer");

                                pw.println("<p style='text-align:center;'>");
				//pw.println("<p>Question-"+i+":</br> "+question+"<p>");
                                pw.println("<br>Question-"+i+":</br> "+question+"<br>");
       
				for(String op: options)
				{
					pw.println("<input type=\"radio\" id=\""+i+"op"+j+"\" name=\""+i+"\" value=\""+op+"\">");
					pw.println("<label for=\""+i+"op"+j+"\">"+op+"</label></br>");
					j++;
				}
				// pw.println("<input type=\"radio\" id=\""+i+"op1\" name=\""+i+"\" value=\""+op1+"\">");
				// pw.println("<label for=\""+i+"op1\">"+op1+"</label></br>");
				// pw.println("<input type=\"radio\" id=\""+i+"op2\" name=\""+i+"\" value=\""+op2+"\">");
				// pw.println("<label for=\""+i+"op1\">"+op2+"</label></br>");
				// pw.println("<input type=\"radio\" id=\""+i+"op3\" name=\""+i+"\" value=\""+op3+"\">");
				// pw.println("<label for=\""+i+"op1\">"+op3+"</label></br>");
				// pw.println("<input type=\"radio\" id=\""+i+"op4\" name=\""+i+"\" value=\""+op4+"\">");
				// pw.println("<label for=\""+i+"op1\">"+op4+"</label></br>");

				pw.println("<input type=\"hidden\" id=\""+i+"a\" name=\""+i+"a\" value=\""+answer+"\">");
				i++;
			}while(rs.next());
                        pw.print("<input type='hidden' name='username' value=" + username + ">");
			pw.println("</br><input type=\"submit\" value='SUBMIT'>");
                        pw.println("</p>");
			pw.println("</form>");
			
		}catch(Exception e){
			System.out.println("Exception thrown : "+e);
		}
	}
}