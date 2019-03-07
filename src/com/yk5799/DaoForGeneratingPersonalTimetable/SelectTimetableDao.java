package com.yk5799.DaoForGeneratingPersonalTimetable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yk5799.db.DBConnection;
import com.yk5799.entity.PTimetable;

public class SelectTimetableDao {
	 static String sql = null; 
	 static DBConnection conn = null;  
	 static ResultSet rs = null;  
	 static int result=0;
	 //查询学生所选课程的id
	 public boolean SelectTimetable(int s_id,int pt_semester) throws Exception {  
		  List<PTimetable> pTimetables=new ArrayList<PTimetable>();
	      sql = "select pt_id from p_timetable where s_id=? and pt_semester=?";//SQL语句    
	      conn = new DBConnection(sql);//创建dbconnection对象
	      boolean flag=false;
	      try {  
	    	  conn.pst.setInt(1, s_id);
	    	  conn.pst.setInt(2, pt_semester);
	    	  rs = conn.pst.executeQuery();//执行语句，得到结果集  
	          while (rs.next()) { 
	              int ptId = rs.getInt(1);  
	              PTimetable pTimetable=new PTimetable();
	              pTimetable.setPtId(ptId);
	              pTimetables.add(pTimetable);
	          }
	          if(pTimetables.size()==0){
	        	  flag=true;
	          }
	      } catch (SQLException e) {  
	          e.printStackTrace();  
	      }  
	      finally{
	    	  rs.close();
	          conn.close();//关闭连接  
	      }  
	      return flag;  
	  }  
	//查询个人课表
	 public PTimetable SelectTimetable(int s_id,int pt_semester,int pt_week) throws Exception {  
		  PTimetable pTimetable=new PTimetable();
	      sql = "select pt_id,pt_c1,pt_c2,pt_c3,pt_c4 from p_timetable where s_id=? and pt_semester=? and pt_week=?";//SQL语句    
	      conn = new DBConnection(sql);//创建dbconnection对象
	      try {  
	    	  conn.pst.setInt(1, s_id);
	    	  conn.pst.setInt(2, pt_semester);
	    	  conn.pst.setInt(3, pt_week);
	    	  rs = conn.pst.executeQuery();//执行语句，得到结果集  
	          while (rs.next()) { 
	              int ptId = rs.getInt(1);  
	              int ptC1 = rs.getInt(2);  
	              int ptC2 = rs.getInt(3);  
	              int ptC3 = rs.getInt(4);  
	              int ptC4 = rs.getInt(5);  
	              pTimetable=new PTimetable();
	              pTimetable.setPtId(ptId);
	              pTimetable.setPtC1(ptC1);
	              pTimetable.setPtC2(ptC2);
	              pTimetable.setPtC3(ptC3);
	              pTimetable.setPtC4(ptC4);
	          }
	      } catch (SQLException e) {  
	          e.printStackTrace();  
	      }  
	      finally{
	    	  rs.close();
	          conn.close();//关闭连接  
	      }  
	      return pTimetable;  
	  } 
	
}
