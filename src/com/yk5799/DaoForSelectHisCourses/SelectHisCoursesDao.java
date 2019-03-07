package com.yk5799.DaoForSelectHisCourses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yk5799.db.DBConnection;
import com.yk5799.entity.ElectiveInfo;
import com.yk5799.entity.HistoryCourseView;

public class SelectHisCoursesDao {
	 static String sql = null; 
	 static DBConnection conn = null;  
	 static ResultSet rs = null;  
	 static int result=0;
	 public List<HistoryCourseView> findHisCourses(String curriculumname,int semester,List<ElectiveInfo> electiveInfos) throws Exception {  
		 System.out.println(curriculumname+";"+semester); 
		 List<HistoryCourseView> historyCourseViews=new ArrayList<HistoryCourseView>();
		  String str="";
		  for(int i=0;i<electiveInfos.size();i++){
			  str=str+electiveInfos.get(i).getCId()+",";
		  }
		  str=str.substring(0, str.length()-1);
		  
	      sql = "select c_id,c_name,t_name,c_credit,c_type,c_nature, c_institute,c_classroom,c_semester from curriculum,teacher where c_id in("+str+") and (c_name like'%"+curriculumname+"%' or c_semester="+semester+") and curriculum.t_id=teacher.t_id";//SQL语句    
	      conn = new DBConnection(sql);//创建dbconnection对象  
	      try {  
		      rs = conn.pst.executeQuery();//执行语句，得到结果集  
	          while (rs.next()) { 
	        	  int cId=rs.getInt(1);
	              String cName = rs.getString(2);  
	              String tName = rs.getString(3);
	              int cCredit = rs.getInt(4);
	              String cType = rs.getString(5);  
	              String cNature = rs.getString(6);
	              String cInstitute = rs.getString(7);
	              String cClassroom = rs.getString(8);
	              int cSemester = rs.getInt(9);
	              HistoryCourseView historyCourseView=new HistoryCourseView(cId, cName, tName, cCredit, cType, cNature, cInstitute, cClassroom, cSemester,0);
	              historyCourseViews.add(historyCourseView);
	          }
	          
	      } catch (SQLException e) {  
	          e.printStackTrace();  
	      }  
	      finally{
	    	  rs.close();
	          conn.close();//关闭连接  
	      }  
	      return historyCourseViews;  
	  }  
}
