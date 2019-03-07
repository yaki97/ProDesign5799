package com.yk5799.LoginDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.yk5799.db.DBConnection;

public class StudentLoginDao {
	static String sql = null; 
	static DBConnection conn = null;  
	static ResultSet rs = null;  
	static int result=0;
	public boolean StudentLogin(int s_id,String s_password) throws Exception{
		boolean flag = false;
		String sql="select s_password from student where s_id=?";
		conn=new DBConnection(sql);
		try{
			conn.pst.setInt(1, s_id);
			rs = conn.pst.executeQuery();//执行语句，得到结果集  
	        while (rs.next()) { 
	              String s_passwordx = rs.getString(1);
	              System.out.println(s_passwordx);
	              if((s_passwordx==s_password)||(s_passwordx.equals(s_password))){
	            	  flag=true;
	  	          }
	        }
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			conn.close();
		}
			 
		return flag;
	}
}
