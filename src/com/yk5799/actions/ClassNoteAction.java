package com.yk5799.actions;

import java.sql.Timestamp;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yk5799.DaoForClassNote.ClassNoteDao;
import com.yk5799.entity.ClassNote;
@ParentPackage("json-default")
@Namespace("/")
public class ClassNoteAction extends ActionSupport{
	private ClassNote classNote;
	private List<ClassNote> classNotes;
	private Integer noId;
	private Integer SId;
	private Integer CId;
	private String noContent;
	private Timestamp noDate;
	private String c_name;
	
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public ClassNote getClassNote() {
		return classNote;
	}
	public void setClassNote(ClassNote classNote) {
		this.classNote = classNote;
	}
	public Integer getNoId() {
		return noId;
	}
	public void setNoId(Integer noId) {
		this.noId = noId;
	}
	public Integer getSId() {
		return SId;
	}
	public void setSId(Integer sId) {
		SId = sId;
	}
	public Integer getCId() {
		return CId;
	}
	public void setCId(Integer cId) {
		CId = cId;
	}
	public String getNoContent() {
		return noContent;
	}
	public void setNoContent(String noContent) {
		this.noContent = noContent;
	}
	public Timestamp getNoDate() {
		return noDate;
	}
	public void setNoDate(Timestamp noDate) {
		this.noDate = noDate;
	}
	public List<ClassNote> getClassNotes() {
		return classNotes;
	}
	public void setClassNotes(List<ClassNote> classNotes) {
		this.classNotes = classNotes;
	}
	@Action(value="addClassNote",results={@Result(name="success",type="json")})
	public String addClassNote() throws Exception{
		System.out.println("进入addClassNote()");
		SId=Integer.valueOf((String) ActionContext.getContext().getSession().get("s_id"));
		System.out.println(CId);
		System.out.println(SId);
		ClassNoteDao classNoteDao=new ClassNoteDao();
		classNoteDao.addClassNote(CId, SId);
		return SUCCESS;
	}
	@Action(value="updateClassNote",results={@Result(name="success",type="json")})
	public String updateClassNote() throws Exception{
		System.out.println("进入updateClassNote()");
		ClassNoteDao classNoteDao=new ClassNoteDao();
		classNoteDao.updateClassNote(noId, noContent);
		return SUCCESS;
	}
	@Action(value="selectClassNote",results={@Result(name="success",type="json")})
	public String selectClassNote() throws Exception{
		System.out.println("进入selectClassNote()");
		SId=Integer.valueOf((String) ActionContext.getContext().getSession().get("s_id"));
		System.out.println(CId);
		System.out.println(SId);
		ClassNoteDao classNoteDao=new ClassNoteDao();
		classNotes=classNoteDao.findClassNoteByC_idS_id(SId, CId);
		c_name=classNoteDao.findCurriculumNameByCid(CId);
		System.out.println(classNotes.size());
		return SUCCESS;
	}
	@Action(value="deleteClassNote",results={@Result(name="success",type="json")})
	public String deleteClassNote() throws Exception{
		System.out.println("进入deleteClassNote()");
		ClassNoteDao classNoteDao=new ClassNoteDao();
		classNoteDao.deleteClassNote(noId);
		return SUCCESS;
	}
}
