package com.yk5799.studentDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yk5799.db.DBConnection;
import com.yk5799.entity.Student;

public class StudentDao {
	static String sql = null; 
	static DBConnection conn = null;  
	static ResultSet rs = null;  
	static int result=0;
	public Student findStudentBySid(int s_id) throws Exception{
		Student student=null;
	      sql = "select s_id,s_password,s_idc,s_name,s_sex,s_age,s_nativep,s_familyname,s_semester,s_major,s_college,s_class,s_phone,s_email,s_cet4 from student where s_id=?";//SQL语句    
	      conn = new DBConnection(sql);//创建dbconnection对象  
	      try {  
	    	  conn.pst.setInt(1, s_id);
	    	  rs = conn.pst.executeQuery();//执行语句，得到结果集  
	          while (rs.next()) { 

	        		 Integer SId = rs.getInt(1);
	        		 String SPassword = rs.getString(2);
	        		 Integer SIdc = rs.getInt(3);
	        		 String SName = rs.getString(4);
	        		 Boolean SSex = rs.getBoolean(5);
	        		 Integer SAge = rs.getInt(6);
	        		 String SNativep = rs.getString(7);
	        		 String SFamilyname = rs.getString(8);
	        		 Integer SSemester = rs.getInt(9);
	        		 String SMajor = rs.getString(10);
	        		 String SCollege = rs.getString(11);
	        		 Integer SClass = rs.getInt(12);
	        		 String SPhone = rs.getString(13);
	        		 String SEmail = rs.getString(14);
	        		 Boolean SCet4 = rs.getBoolean(15);

	              student=new Student(SId, SPassword, SIdc, SName, SSex, SAge, SNativep, SFamilyname, SSemester, SMajor, SCollege, SClass, SPhone, SEmail, SCet4);
	        	 
	          }
	      } catch (SQLException e) {  
	          e.printStackTrace();  
	      }  
	      finally{
	    	  rs.close();  
	          conn.close();//关闭连接  
	      }  
	      return student;  
	}
}
