package MVCexam.Model;
import java.util.*;
import java.sql.*;

public class GradesheetModel{

    public Map<String,String> getData(String name,String score) throws Exception
    {

    String url = "jdbc:mysql://localhost:3306/exam_db";
    String user = "root";
    String password = "2001";

    //2. Load JDBC Driver and register the driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    //3. Open a Connection
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_db?autoReconnect=true&useSSL=false",user,password);
    //Connection conn = DriverManager.getConnection(url,user,password);
    Statement st = con.createStatement();

    String q = "UPDATE student SET CS = '"+score+"' WHERE name = '" + name + "'";
    int b = st.executeUpdate(q);

    String s = "select * from student where name = '" + name + "'";
    ResultSet rs = st.executeQuery(s);
    Map<String, String> map = new HashMap<String, String>();
    if (rs.next()){
        map.put("BIOLOGY",rs.getString("BIO"));
        map.put("PSYCHOLOGY",rs.getString("PSY"));
        map.put("ECONOMICS",rs.getString("ECO"));
        map.put("LITERATURE",rs.getString("LIT"));
        map.put("COMPUTER SCIENCE",rs.getString("CS"));
    }

    //st.executeUpdate(sql);
    //5.Close st and con : must use finally block
    st.close();
    con.close();

    return map;

    }
}
