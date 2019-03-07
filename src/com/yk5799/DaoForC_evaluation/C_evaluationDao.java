package com.yk5799.DaoForC_evaluation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yk5799.db.DBConnection;
import com.yk5799.entity.CEvaluation;

public class C_evaluationDao {
	static String sql = null; 
	static DBConnection conn = null;  
	static ResultSet rs = null;  
	static int result=0;
	//查单个
	 public CEvaluation findCEvaluationByC_idS_id(int s_id,int c_id) throws Exception {  
		 	  CEvaluation cEvaluation=null;
		      sql = "select ce_id,c_id,c_content,s_id,t_grade from c_evaluation where c_id="+c_id+" and s_id="+s_id;//SQL语句    
		      conn = new DBConnection(sql);//创建dbconnection对象  
		      try {  
		    	  rs = conn.pst.executeQuery();//执行语句，得到结果集  
		          while (rs.next()) { 
		              int ce_idx = rs.getInt(1);  
		              int c_idx = rs.getInt(2);  
		              String c_contentx = rs.getString(3);  
		              int s_idx = rs.getInt(4);  
		              int t_gradex = rs.getInt(5);
		              cEvaluation=new CEvaluation(ce_idx,c_idx,c_contentx,s_idx,t_gradex);
		        	 
		          }
		      } catch (SQLException e) {  
		          e.printStackTrace();  
		      }  
		      finally{
		    	  rs.close();  
		          conn.close();//关闭连接  
		      }  
		      return cEvaluation;  
		  }  
	//删除单个
	  public boolean deleteShoppingCart(int cid) throws Exception{
			  String sql="delete from shoppingcart where cid=?";
				
				boolean flag = false;
				conn=new DBConnection(sql);
				try{
					conn.pst.setInt(1, cid);
					result = conn.pst.executeUpdate();
					if(result!=0){System.out.println("删除成功！");flag=true;}
			        else{System.out.println("删除失败！");}
				}catch(SQLException e){
					e.printStackTrace();
				}
				finally{
					conn.close();
				}
				 
				return flag;
		}
	//增加
	  public boolean addCEvaluation(int CId,int SId,String CContent,int TGrade) throws Exception{
			  	String sql="insert into c_evaluation(c_id,c_content,s_id,t_grade) values(?,?,?,?)";
				boolean flag = false;
				conn=new DBConnection(sql);
				try{
					conn.pst.setInt(1, CId);
					conn.pst.setString(2, CContent);
					conn.pst.setInt(3, SId);
					conn.pst.setInt(4, TGrade);
					result = conn.pst.executeUpdate();
					if(result!=0){flag=true;}
			        else{System.out.println("添加失败！");}
				}catch(SQLException e){
					e.printStackTrace();
				}
				finally{
					conn.close();
				}
				 
				return flag;
		}
	//修改
	 public boolean buyerPassword(String namex,String passwordx,String newpasswordx) throws Exception {
		  boolean flag=false;
		  sql = "update UserBuyer set bpassword=? where bname=? and bpassword=?"; 
	      conn = new DBConnection(sql);
	      try { 
	    	  conn.pst.setString(1, newpasswordx);
	    	  conn.pst.setString(2, namex);
	    	  conn.pst.setString(3, passwordx);
	    	  result = conn.pst.executeUpdate();
				if(result!=0){flag=true;}
		        else{System.out.println("失败！");}
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
