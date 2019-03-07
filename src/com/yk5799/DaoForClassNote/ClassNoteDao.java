package com.yk5799.DaoForClassNote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.yk5799.db.DBConnection;
import com.yk5799.entity.CEvaluation;
import com.yk5799.entity.ClassNote;
import com.yk5799.entity.Curriculum;
import com.yk5799.entity.Teacher;

public class ClassNoteDao {
	static String sql = null; 
	static DBConnection conn = null;  
	static ResultSet rs = null;  
	static int result=0;
	//查单个
		 public List<ClassNote> findClassNoteByC_idS_id(int s_id,int c_id) throws Exception {  
			 	List<ClassNote> classNotes=new ArrayList<ClassNote>();
			      sql = "select no_id,no_content,no_date from class_note where c_id="+c_id+" and s_id="+s_id;//SQL语句    
			      conn = new DBConnection(sql);//创建dbconnection对象  
			      try {  
			    	  rs = conn.pst.executeQuery();//执行语句，得到结果集  
			          while (rs.next()) { 
			              int no_id = rs.getInt(1); 
			              String no_content = rs.getString(2);  
			              Timestamp no_date = rs.getTimestamp(3);
			              ClassNote classNote=new ClassNote(no_id,s_id, c_id, no_content, no_date);
			              classNotes.add(classNote);
			        	 
			          }
			      } catch (SQLException e) {  
			          e.printStackTrace();  
			      }  
			      finally{
			    	  rs.close();  
			          conn.close();//关闭连接  
			      }  
			      return classNotes;  
			  }  
		//删除单个
		  public boolean deleteClassNote(int noId) throws Exception{
				  String sql="delete from class_note where no_id=?";
					boolean flag = false;
					conn=new DBConnection(sql);
					try{
						conn.pst.setInt(1, noId);
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
		  public boolean addClassNote(int CId,int SId) throws Exception{
			  
				  	String sql="insert into class_note(c_id,no_content,s_id,no_date) values(?,?,?,?)";
					boolean flag = false;
					conn=new DBConnection(sql);
					try{
						conn.pst.setInt(1, CId);
						conn.pst.setString(2, "");
						conn.pst.setInt(3, SId);
						conn.pst.setTimestamp(4, new Timestamp(System.currentTimeMillis()));;
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
		 public boolean updateClassNote(int no_id,String no_content) throws Exception {
			  boolean flag=false;
			  sql = "update class_note set no_content=?,no_date=? where no_id=?"; 
		      conn = new DBConnection(sql);
		      try {	    	 
		    	  conn.pst.setString(1, no_content);
		    	  conn.pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
		    	  conn.pst.setInt(3, no_id);
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
		 //通过cid查询cname
		 public String findCurriculumNameByCid(int c_id) throws Exception{
			 String CName="";
			      sql = "select c_name from curriculum where c_id=?";//SQL语句    
			      conn = new DBConnection(sql);//创建dbconnection对象  
			      try {  
			    	  conn.pst.setInt(1, c_id);
			    	  rs = conn.pst.executeQuery();//执行语句，得到结果集  
			          while (rs.next()) {
			        		CName = rs.getString(1);
			        	
			
			          }
			      } catch (SQLException e) {  
			          e.printStackTrace();  
			      }  
			      finally{
			    	  rs.close();  
			          conn.close();//关闭连接  
			      }  
			      return CName;  
			}
	}
