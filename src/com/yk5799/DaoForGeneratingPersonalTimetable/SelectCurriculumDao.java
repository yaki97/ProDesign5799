package com.yk5799.DaoForGeneratingPersonalTimetable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yk5799.db.DBConnection;
import com.yk5799.entity.Curriculum;
import com.yk5799.entity.ElectiveInfo;
import com.yk5799.entity.TimeTableView;

public class SelectCurriculumDao {
	 static String sql = null; 
	 static DBConnection conn = null;  
	 static ResultSet rs = null;  
	 static int result=0;
	 public List<Curriculum> findCurriculum(List<ElectiveInfo> electiveInfos) throws Exception {  
		  List<Curriculum> curriculums=new ArrayList<Curriculum>();
		  String str="";
		  for(int i=0;i<electiveInfos.size();i++){
			  str=str+electiveInfos.get(i).getCId()+",";
		  }
		  //去掉cid字符串最后一个逗号
		  str=str.substring(0, str.length()-1);
	      sql = "select c_id,c_name,c_time from curriculum where c_id in("+str+")";//SQL语句    
	      conn = new DBConnection(sql);//创建dbconnection对象  
	      try {  
		      rs = conn.pst.executeQuery();//执行语句，得到结果集  
	          while (rs.next()) { 
	        	  int c_id=rs.getInt(1);
	              String c_name = rs.getString(2);  
	              String c_time = rs.getString(3);
	              Curriculum curriculum=new Curriculum();
	              curriculum.setCId(c_id);
	              curriculum.setCName(c_name);
	              curriculum.setCTime(c_time);
	              curriculums.add(curriculum);
	          }
	          
	      } catch (SQLException e) {  
	          e.printStackTrace();  
	      }  
	      finally{
	    	  rs.close();
	          conn.close();//关闭连接  
	      }  
	      return curriculums;  
	  }  
	 public TimeTableView curriculumsToStringByCid(int c_id) throws Exception{
		 TimeTableView timeTableView=new TimeTableView();
		 sql = "select c_name,t_name,c_classroom from curriculum,teacher where c_id=? and curriculum.t_id=teacher.t_id";//SQL语句    
		 conn = new DBConnection(sql);//创建dbconnection对象  
		 try {  
			  conn.pst.setInt(1, c_id);
		      rs = conn.pst.executeQuery();//执行语句，得到结果集  
	          while (rs.next()) { 
	              String c_name = rs.getString(1); 
	              String t_name = rs.getString(2); 
	              String c_classroom = rs.getString(3); 
	              timeTableView.setC_id(c_id);
	              timeTableView.setC_name(c_name);
	              timeTableView.setT_name(t_name);
	              timeTableView.setC_classroom(c_classroom);
	          }
	          
	      } catch (SQLException e) {  
	          e.printStackTrace();  
	      }  
	      finally{
	    	  rs.close();
	          conn.close();//关闭连接  
	      }  
	      return timeTableView;  
		 
	 }
}
