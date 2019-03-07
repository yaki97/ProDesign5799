package com.yk5799.actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yk5799.DaoForC_evaluation.C_evaluationDao;
import com.yk5799.entity.CEvaluation;
@ParentPackage("json-default")
@Namespace("/")
public class CEvaluationAction extends ActionSupport{
	private int s_id;
	private int c_id;
	private int ce_id;
	private String CContent;
	private Integer TGrade;
	private CEvaluation cEvaluation;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getCe_id() {
		return ce_id;
	}
	public void setCe_id(int ce_id) {
		this.ce_id = ce_id;
	}
	public CEvaluation getcEvaluation() {
		return cEvaluation;
	}
	public void setcEvaluation(CEvaluation cEvaluation) {
		this.cEvaluation = cEvaluation;
	}
	
	public String getCContent() {
		return CContent;
	}
	public void setCContent(String cContent) {
		CContent = cContent;
	}
	public Integer getTGrade() {
		return TGrade;
	}
	public void setTGrade(Integer tGrade) {
		TGrade = tGrade;
	}
	@Action(value="selectCEvaluation",results={@Result(name="success",type="json")})
	public String selectCEvaluation() throws Exception{ 
		s_id=Integer.valueOf((String) ActionContext.getContext().getSession().get("s_id"));
		System.out.println("c_id="+c_id);
		C_evaluationDao c_evaluationDao=new C_evaluationDao();
		cEvaluation=c_evaluationDao.findCEvaluationByC_idS_id(s_id, c_id);
		System.out.println(cEvaluation.toString());
		return SUCCESS;
	}
	@Action(value="addCEvaluation",results={@Result(name="success",type="json")})
	public String addCEvaluation() throws Exception{ 
		System.out.println("进入addCEvaluationACtions");
		s_id=Integer.valueOf((String) ActionContext.getContext().getSession().get("s_id"));
		System.out.println("c_id="+c_id);
		System.out.println("CContent="+CContent);
		System.out.println("TGrade="+TGrade);
		C_evaluationDao c_evaluationDao=new C_evaluationDao();
		c_evaluationDao.addCEvaluation(c_id, s_id, CContent, TGrade);
		return SUCCESS;
	}
}
