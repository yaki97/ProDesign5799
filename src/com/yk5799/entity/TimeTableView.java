package com.yk5799.entity;
/**
 * 
 * @ClassName:HistoryTimeTableView   
 * @Description:用来直接显示查询结果
 * @author:20155799杨凯   
 */
public class TimeTableView {
	private int c_id;
	private String c_name;
	private String t_name;
	private String c_classroom;
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getC_classroom() {
		return c_classroom;
	}
	public void setC_classroom(String c_classroom) {
		this.c_classroom = c_classroom;
	}
	
}
