package com.yk5799.DaoForGeneratingPersonalTimetable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yk5799.db.DBConnection;
import com.yk5799.entity.PTimetable;

public class PersonalTimetableDao {
	 static String sql = null; 
	 static DBConnection conn = null;  
	 static ResultSet rs = null;  
	 static int result=0;
	 //生成个人课表
	 public boolean GeneratingPersonalTimetable(List<PTimetable> pTimetables) throws Exception {
		 String sql="insert into p_timetable(s_id,pt_c1,pt_c2,pt_c3,pt_c4,pt_week,pt_semester) values(?,?,?,?,?,?,?)";
			boolean flag = false;
			conn=new DBConnection(sql);
			conn.conn.setAutoCommit(false);//手动提交
			try{
				for (int i = 0; i < pTimetables.size(); i++){  
					    conn.pst.setInt(1, pTimetables.get(i).getSId());
						conn.pst.setInt(2, pTimetables.get(i).getPtC1());
						conn.pst.setInt(3, pTimetables.get(i).getPtC2());
						conn.pst.setInt(4, pTimetables.get(i).getPtC3());
						conn.pst.setInt(5, pTimetables.get(i).getPtC4());
						conn.pst.setInt(6, pTimetables.get(i).getPtWeek());
						conn.pst.setInt(7, pTimetables.get(i).getPtSemester());
		               // 把一个SQL命令加入命令列表  
					   conn.pst.addBatch();  
		        }  
		        // 执行批量更新  
				conn.pst.executeBatch();  
		        // 语句执行完毕，提交本事务  
				conn.conn.commit(); 			     
				result = conn.pst.executeUpdate();
				if(result!=0){flag=true;}
		        else{}
			}catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				conn.close();
			}
			 
			return flag;
	  }
}
