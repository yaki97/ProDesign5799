package com.yk5799.actions;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yk5799.DaoForGeneratingPersonalTimetable.SelectElective_infoDao;
import com.yk5799.DaoForSelectHisCourses.IsPingjiaDao;
import com.yk5799.DaoForSelectHisCourses.SelectHisCoursesDao;
import com.yk5799.entity.ElectiveInfo;
import com.yk5799.entity.HistoryCourseView;
@ParentPackage("json-default")
@Namespace("/")
public class SelectHistoryCoursesAction extends ActionSupport{
	private int s_id;
	private String curriculumname;
	private int semester=0;
	List<HistoryCourseView> historyCourseViews;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getCurriculumname() {
		return curriculumname;
	}
	public void setCurriculumname(String curriculumname) {
		this.curriculumname = curriculumname;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	
	public List<HistoryCourseView> getHistoryCourseViews() {
		return historyCourseViews;
	}
	public void setHistoryCourseViews(List<HistoryCourseView> historyCourseViews) {
		this.historyCourseViews = historyCourseViews;
	}
	@Action(value="SelectHistoryCourses",results={@Result(name="success",type="json")})
	public String SelectHistoryCourses() throws Exception{
		if(curriculumname.equals("")){
			curriculumname="''";		
		}
		System.out.println("进入SelectHistoryCoursesAction.java");
		//从session获取s_id
		s_id=Integer.valueOf((String) ActionContext.getContext().getSession().get("s_id"));
		System.out.println(s_id+";"+semester);
		//查询选课信息表elective_info得到学生选课信息(得到c_id课程)
		SelectElective_infoDao selectElective_infoDao=new SelectElective_infoDao();
		List<ElectiveInfo> electiveInfos=selectElective_infoDao.findAllElectiveCid(s_id);
		System.out.println("cid的个数："+electiveInfos.size());
		//通过课程id查询课程信息
		SelectHisCoursesDao selectHisCoursesDao=new SelectHisCoursesDao();
		historyCourseViews=selectHisCoursesDao.findHisCourses(curriculumname, semester, electiveInfos);
		System.out.println("条件查询结果："+historyCourseViews.size());
		//通过学生id(s_id)和课程id(c_id)查询课程是否已经评价
		for (int i = 0; i < historyCourseViews.size(); i++) {
			IsPingjiaDao isPingjiaDao=new IsPingjiaDao();
			System.out.println(historyCourseViews.get(i).getCId());
			boolean flag1=isPingjiaDao.IsPingjia(s_id, historyCourseViews.get(i).getCId());
			System.out.println("flag1="+flag1);
			if(flag1==true){
				historyCourseViews.get(i).setIsPingjia(1);
			}
		}
		return SUCCESS;	
	}
}
