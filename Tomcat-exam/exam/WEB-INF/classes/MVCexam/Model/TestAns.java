package MVCexam.Model;
import java.util.*;
import java.sql.*;

public class TestAns{
	
	public ResultSet getQuestions(int n) throws Exception{
		try{
			String url = "jdbc:mysql://localhost:3306/exam_db";
			String user = "root";
			String password = "2001";
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_db?autoReconnect=true&useSSL=false",user,password);
			
			Statement st = con.createStatement();
			
			String sql = "select * from questions limit " + n ;
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()){
				return rs;
			}
			else{
				return null;
			}
			
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
}