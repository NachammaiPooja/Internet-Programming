package MVCexam.Controller;
import MVCexam.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class GradesheetController extends HttpServlet //throws IOException,ServletException,Exception
{
public void doPost(HttpServletRequest request, HttpServletResponse res) //throws IOException //,Exception
{

String name = request.getParameter("username");
String score = request.getParameter("score");
GradesheetModel m = new GradesheetModel();
try{
    Map<String,String> marks = m.getData(name,score);
    res.setContentType("text/html");
    PrintWriter pw = res.getWriter();
    pw.print("<head><style>table, th, td {border: 2px dotted white;border-collapse: collapse;}th, td {padding: 5px;text-align: left;}</style></head>");
    pw.print("<body style='background-color:#ff6666;color:white;align:center'></br>");
    pw.print("<center><h1>Examination Results<h1></center>");
    pw.print("<center><h3>Candidate Name: "+name+"</h3>");
    pw.print("<table style:'width:80%'>");
    pw.print("<tr><th>Courses</th><th>Marks</th></tr>");
    for (String key: marks.keySet()) {
        pw.print("<tr><td>"+key+"</td><td>"+marks.get(key)+"</td></tr>");
    pw.print("</center>");
    }
    pw.print("</table>");
    pw.print("<form action='OnlineExam.html'>");
    pw.print("</br><input type='submit' value='Return to Login'>");
    pw.print("</form>");
    }
    catch(Exception E)
    {
    System.out.println(E);
    }
}
}