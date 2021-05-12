package MVCexam.Model;
import java.util.*;
import java.sql.*;

public class UserLoginModel{
	
	public String getPassword(String username) throws Exception{
		try{
			String url = "jdbc:mysql://localhost:3306/exam_db";
			String user = "root";
			String password = "2001";
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_db?autoReconnect=true&useSSL=false",user,password);
			
			Statement st = con.createStatement();
			
			String sql = "select * from login where username = \'" + username + "\'";
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()){
				String res = rs.getString("password");
				return res;
			}
			
			else{
				return "0";
			}
			
		}catch(Exception e){
			System.out.println(e);
			return "0";
		}
	}
}