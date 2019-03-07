package com.yk5799.DaoForGeneratingPersonalTimetable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yk5799.db.DBConnection;
import com.yk5799.entity.ElectiveInfo;
//查询选课信息表
public class SelectElective_infoDao {
	 static String sql = null; 
	 static DBConnection conn = null;  
	 static ResultSet rs = null;  
	 static int result=0;
	 //查询学生所选课程的id
	 public List<ElectiveInfo> findElectiveCid(int s_id,int ei_semester) throws Exception {  
		 System.out.println(s_id+";"+ei_semester); 
		 List<ElectiveInfo> electiveInfos=new ArrayList<ElectiveInfo>();
	      sql = "select c_id from elective_info where s_id=? and ei_status=0 and ei_semester=?";//SQL语句    
	      conn = new DBConnection(sql);//创建dbconnection对象  
	      try {  
	    	  conn.pst.setInt(1, s_id);
	    	  conn.pst.setInt(2, ei_semester);
	    	  rs = conn.pst.executeQuery();//执行语句，得到结果集  
	          while (rs.next()) { 
	              int c_id = rs.getInt(1);  
	              ElectiveInfo electiveInfo=new ElectiveInfo();
	              electiveInfo.setSId(s_id);	          
	              electiveInfo.setCId(c_id);
	              electiveInfo.setEiSemester(ei_semester);
	              electiveInfos.add(electiveInfo);
	          }
	          
	      } catch (SQLException e) {  
	          e.printStackTrace();  
	      }  
	      finally{
	    	  rs.close();
	          conn.close();//关闭连接  
	      }  
	      System.out.println("数据库");
	      return electiveInfos;  
	  }  
	 //查询学生所选课程的id
	 public List<ElectiveInfo> findAllElectiveCid(int s_id) throws Exception {  
		 List<ElectiveInfo> electiveInfos=new ArrayList<ElectiveInfo>();
	      sql = "select c_id from elective_info where s_id=? and ei_status=0";//SQL语句    
	      conn = new DBConnection(sql);//创建dbconnection对象  
	      try {  
	    	  conn.pst.setInt(1, s_id);
	    	  rs = conn.pst.executeQuery();//执行语句，得到结果集  
	          while (rs.next()) { 
	              int c_id = rs.getInt(1);  
	              ElectiveInfo electiveInfo=new ElectiveInfo();
	              electiveInfo.setSId(s_id);	          
	              electiveInfo.setCId(c_id);
	              electiveInfos.add(electiveInfo);
	          }
	          
	      } catch (SQLException e) {  
	          e.printStackTrace();  
	      }  
	      finally{
	    	  rs.close();
	          conn.close();//关闭连接  
	      }  
	      System.out.println("数据库");
	      return electiveInfos;  
	  }  
}
