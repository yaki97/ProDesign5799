package com.yk5799.DaoForSelectHisCourses;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yk5799.db.DBConnection;

public class IsPingjiaDao {
	 static String sql = null; 
	 static DBConnection conn = null;  
	 static ResultSet rs = null;  
	 static int result=0;
	 public boolean IsPingjia(int s_id,int c_id) throws Exception{
		 	String sql="select count(*) from c_evaluation where s_id="+s_id+" and c_id="+c_id;
			boolean flag = false;
			conn=new DBConnection(sql);
		    try {  
			      rs = conn.pst.executeQuery();//执行语句，得到结果集  
		          while (rs.next()) { 
		        	  int count=rs.getInt(1);
		        	  if(count>0){
		        		  flag=true;
		        	  }
		          }
		          
		    } catch (SQLException e) {  
				e.printStackTrace();
			}
			finally{
				rs.close();
				conn.close();
			}
			return flag;
	 }
}
