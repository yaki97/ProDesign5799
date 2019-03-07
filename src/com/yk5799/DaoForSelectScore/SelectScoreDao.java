package com.yk5799.DaoForSelectScore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yk5799.db.DBConnection;
import com.yk5799.entity.Curriculum;
import com.yk5799.entity.Score;

public class SelectScoreDao {
	 static String sql = null; 
	 static DBConnection conn = null;  
	 static ResultSet rs = null;  
	 static int result=0;
	 public List<Score> findFailScore() throws Exception {  
		 List<Score> Scores=new ArrayList<Score>();
	      sql = "select c_id,c_name from score where sc_score<60";//SQL语句    
	      conn = new DBConnection(sql);//创建dbconnection对象  
	      try {  
		      rs = conn.pst.executeQuery();//执行语句，得到结果集  
	          while (rs.next()) { 
	        	  int cId = rs.getInt(1);  
	              String cName = rs.getString(2);  
	              Score score=new Score();
	              Curriculum c=new Curriculum();
	              c.setCId(cId);
	              score.setCurriculum(c);
	              score.setCName(cName);
	              Scores.add(score);
	          }
	          
	      } catch (SQLException e) {  
	          e.printStackTrace();  
	      }  
	      finally{
	    	  rs.close();
	          conn.close();//关闭连接  
	      }  
	      return Scores;  
	  }  
}
