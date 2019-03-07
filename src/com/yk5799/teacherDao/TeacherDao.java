package com.yk5799.teacherDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.yk5799.db.DBConnection;
import com.yk5799.entity.Teacher;

public class TeacherDao {
	static String sql = null; 
	static DBConnection conn = null;  
	static ResultSet rs = null;  
	static int result=0;
	public Teacher findTeacherNameByTid(int t_id) throws Exception{
		Teacher teacher=null;
	      sql = "select t_name from teacher where t_id=?";//SQL语句    
	      conn = new DBConnection(sql);//创建dbconnection对象  
	      try {  
	    	  conn.pst.setInt(1, t_id);
	    	  rs = conn.pst.executeQuery();//执行语句，得到结果集  
	          while (rs.next()) {
	        		 String TName = rs.getString(1);
	        		 teacher=new Teacher();
	        		 teacher.setTName(TName); 
	          }
	      } catch (SQLException e) {  
	          e.printStackTrace();  
	      }  
	      finally{
	    	  rs.close();  
	          conn.close();//关闭连接  
	      }  
	      return teacher;  
	}
}
