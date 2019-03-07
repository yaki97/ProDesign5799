package com.yk5799.actions;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yk5799.LoginDao.StudentLoginDao;
@ParentPackage("json-default")
@Namespace("/")
public class StudentAction extends ActionSupport{
	private String nameInput;
	private String pwdInput;
	private boolean flag=false;
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getNameInput() {
		return nameInput;
	}
	public void setNameInput(String nameInput) {
		this.nameInput = nameInput;
	}
	public String getPwdInput() {
		return pwdInput;
	}
	public void setPwdInput(String pwdInput) {
		this.pwdInput = pwdInput;
	}
	@Action(value="studentLogin",results={@Result(name="success",type="json")})
	public String studentLogin() throws Exception{
		System.out.println(nameInput);
		System.out.println(pwdInput);
		StudentLoginDao sl=new StudentLoginDao();
		flag=sl.StudentLogin(Integer.valueOf(nameInput), pwdInput);
		System.out.println(flag);
		ActionContext.getContext().getSession().put("s_id", nameInput);
		return SUCCESS;	
	}
	@Action(value="studentLoginOut",results={@Result(name="success",type="json")})
	public String studentLoginOut() throws Exception{
		ActionContext.getContext().getSession().remove("s_id");
		return SUCCESS;	
	}
	
}
