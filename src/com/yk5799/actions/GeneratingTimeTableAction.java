package com.yk5799.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yk5799.DaoForGeneratingPersonalTimetable.PersonalTimetableDao;
import com.yk5799.DaoForGeneratingPersonalTimetable.SelectCurriculumDao;
import com.yk5799.DaoForGeneratingPersonalTimetable.SelectElective_infoDao;
import com.yk5799.DaoForGeneratingPersonalTimetable.SelectTimetableDao;
import com.yk5799.DaoForSelectScore.SelectScoreDao;
import com.yk5799.entity.Curriculum;
import com.yk5799.entity.ElectiveInfo;
import com.yk5799.entity.PTimetable;
import com.yk5799.entity.Score;
import com.yk5799.studentDao.StudentDao;

@ParentPackage("json-default")
@Namespace("/")
public class GeneratingTimeTableAction extends ActionSupport{
	private int s_id;
	private int ei_semester;
	
	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getEi_semester() {
		return ei_semester;
	}

	public void setEi_semester(int ei_semester) {
		this.ei_semester = ei_semester;
	}

	@Action(value="GeneratingTimeTable",results={@Result(name="success",location="/myCourse-student.jsp")})
	public String GeneratingTimeTable() throws Exception{
		System.out.println(s_id);
		//查询是否有挂科
		SelectScoreDao selectScoreDao=new SelectScoreDao();
		List<Score> scores=selectScoreDao.findFailScore();
		String cnames="";
		for(int i=0;i<scores.size();i++){
			cnames+=scores.get(i).getCName()+",";
		}
		cnames=cnames.substring(0, cnames.length()-1);//去掉最后一个逗号
		ActionContext.getContext().getSession().put("FailScore", cnames);
		//通过学生id查找第几个学期
		StudentDao studentDao=new StudentDao();
		//查询选课信息表elective_info得到学生选课信息
		System.out.println(studentDao.findStudentBySid(s_id).getSSemester());
		SelectElective_infoDao selectElective_infoDao=new SelectElective_infoDao();
		List<ElectiveInfo> electiveInfos=selectElective_infoDao.findElectiveCid(s_id,studentDao.findStudentBySid(s_id).getSSemester());
		System.out.println(electiveInfos.size());
		//查询课程表curriculum得到课程上课时间c_time
		SelectCurriculumDao selectCurriculumDao=new SelectCurriculumDao();
		List<Curriculum> curriculums=selectCurriculumDao.findCurriculum(electiveInfos);
		System.out.println(curriculums.size());
		//查询个人课表是否存在
		SelectTimetableDao selectTimetableDao=new SelectTimetableDao();
		boolean flagx=selectTimetableDao.SelectTimetable(s_id, studentDao.findStudentBySid(s_id).getSSemester());
		System.out.println(flagx);
		//个人课表不存在
		if(flagx==true){
			for(int i=0;i<3;i++){
				System.out.println(i);
				System.out.println(curriculums.get(i).getCId());
				System.out.println(curriculums.get(i).getCTime());
				System.out.println(electiveInfos.get(i).getSId());
				System.out.println(electiveInfos.get(i).getEiSemester());
			}	
			//自定义的算法，用来解析字符串成个人课表
			List<PTimetable> pTimetables=substrToPTimetable(curriculums,electiveInfos);
			//生成个人课表
			PersonalTimetableDao personalTimetableDao=new PersonalTimetableDao();
			personalTimetableDao.GeneratingPersonalTimetable(pTimetables);
			//查询个人课表
			SelectTimetableDao selectTimetableDao2=new SelectTimetableDao();
			PTimetable pTimetable1=selectTimetableDao2.SelectTimetable(s_id, studentDao.findStudentBySid(s_id).getSSemester(), 1);
			PTimetable pTimetable2=selectTimetableDao2.SelectTimetable(s_id, studentDao.findStudentBySid(s_id).getSSemester(), 2);
			PTimetable pTimetable3=selectTimetableDao2.SelectTimetable(s_id, studentDao.findStudentBySid(s_id).getSSemester(), 3);
			PTimetable pTimetable4=selectTimetableDao2.SelectTimetable(s_id, studentDao.findStudentBySid(s_id).getSSemester(), 4);
			PTimetable pTimetable5=selectTimetableDao2.SelectTimetable(s_id, studentDao.findStudentBySid(s_id).getSSemester(), 5);
			/*ActionContext.getContext().getSession().put("pTimetable1", pTimetable1);
			ActionContext.getContext().getSession().put("pTimetable2", pTimetable2);
			ActionContext.getContext().getSession().put("pTimetable3", pTimetable3);
			ActionContext.getContext().getSession().put("pTimetable4", pTimetable4);
			ActionContext.getContext().getSession().put("pTimetable5", pTimetable5);*/
			//通过课程id查找课程名称显示在个人课表界面
			
			ActionContext.getContext().getSession().put("pt_c1_1", selectCurriculumDao.curriculumsToStringByCid(pTimetable1.getPtC1()));
			ActionContext.getContext().getSession().put("pt_c2_1", selectCurriculumDao.curriculumsToStringByCid(pTimetable1.getPtC2()));
			ActionContext.getContext().getSession().put("pt_c3_1", selectCurriculumDao.curriculumsToStringByCid(pTimetable1.getPtC3()));
			ActionContext.getContext().getSession().put("pt_c4_1", selectCurriculumDao.curriculumsToStringByCid(pTimetable1.getPtC4()));
			
			ActionContext.getContext().getSession().put("pt_c1_2", selectCurriculumDao.curriculumsToStringByCid(pTimetable2.getPtC1()));
			ActionContext.getContext().getSession().put("pt_c2_2", selectCurriculumDao.curriculumsToStringByCid(pTimetable2.getPtC2()));
			ActionContext.getContext().getSession().put("pt_c3_2", selectCurriculumDao.curriculumsToStringByCid(pTimetable2.getPtC3()));
			ActionContext.getContext().getSession().put("pt_c4_2", selectCurriculumDao.curriculumsToStringByCid(pTimetable2.getPtC4()));
			
			ActionContext.getContext().getSession().put("pt_c1_3", selectCurriculumDao.curriculumsToStringByCid(pTimetable3.getPtC1()));		
			ActionContext.getContext().getSession().put("pt_c2_3", selectCurriculumDao.curriculumsToStringByCid(pTimetable3.getPtC2()));
			ActionContext.getContext().getSession().put("pt_c3_3", selectCurriculumDao.curriculumsToStringByCid(pTimetable3.getPtC3()));
			ActionContext.getContext().getSession().put("pt_c4_3", selectCurriculumDao.curriculumsToStringByCid(pTimetable3.getPtC4()));

			ActionContext.getContext().getSession().put("pt_c1_4", selectCurriculumDao.curriculumsToStringByCid(pTimetable4.getPtC1()));
			ActionContext.getContext().getSession().put("pt_c2_4", selectCurriculumDao.curriculumsToStringByCid(pTimetable4.getPtC2()));
			ActionContext.getContext().getSession().put("pt_c3_4", selectCurriculumDao.curriculumsToStringByCid(pTimetable4.getPtC3()));
			ActionContext.getContext().getSession().put("pt_c4_4", selectCurriculumDao.curriculumsToStringByCid(pTimetable4.getPtC4()));
			
			ActionContext.getContext().getSession().put("pt_c1_5", selectCurriculumDao.curriculumsToStringByCid(pTimetable5.getPtC1()));
			ActionContext.getContext().getSession().put("pt_c2_5", selectCurriculumDao.curriculumsToStringByCid(pTimetable5.getPtC2()));
			ActionContext.getContext().getSession().put("pt_c3_5", selectCurriculumDao.curriculumsToStringByCid(pTimetable5.getPtC3()));
			ActionContext.getContext().getSession().put("pt_c4_5", selectCurriculumDao.curriculumsToStringByCid(pTimetable5.getPtC4()));
			
		}else{
			//个人课表存在
			//查询个人课表
			SelectTimetableDao selectTimetableDao2=new SelectTimetableDao();
			PTimetable pTimetable1=selectTimetableDao2.SelectTimetable(s_id, studentDao.findStudentBySid(s_id).getSSemester(), 1);
			PTimetable pTimetable2=selectTimetableDao2.SelectTimetable(s_id, studentDao.findStudentBySid(s_id).getSSemester(), 2);
			PTimetable pTimetable3=selectTimetableDao2.SelectTimetable(s_id, studentDao.findStudentBySid(s_id).getSSemester(), 3);
			PTimetable pTimetable4=selectTimetableDao2.SelectTimetable(s_id, studentDao.findStudentBySid(s_id).getSSemester(), 4);
			PTimetable pTimetable5=selectTimetableDao2.SelectTimetable(s_id, studentDao.findStudentBySid(s_id).getSSemester(), 5);
			/*ActionContext.getContext().getSession().put("pTimetable1", pTimetable1);
			ActionContext.getContext().getSession().put("pTimetable2", pTimetable2);
			ActionContext.getContext().getSession().put("pTimetable3", pTimetable3);
			ActionContext.getContext().getSession().put("pTimetable4", pTimetable4);
			ActionContext.getContext().getSession().put("pTimetable5", pTimetable5);*/
			//通过课程id查找课程名称显示在个人课表界面
			ActionContext.getContext().getSession().put("pt_c1_1", selectCurriculumDao.curriculumsToStringByCid(pTimetable1.getPtC1()));
			ActionContext.getContext().getSession().put("pt_c2_1", selectCurriculumDao.curriculumsToStringByCid(pTimetable1.getPtC2()));
			ActionContext.getContext().getSession().put("pt_c3_1", selectCurriculumDao.curriculumsToStringByCid(pTimetable1.getPtC3()));
			ActionContext.getContext().getSession().put("pt_c4_1", selectCurriculumDao.curriculumsToStringByCid(pTimetable1.getPtC4()));
			
			ActionContext.getContext().getSession().put("pt_c1_2", selectCurriculumDao.curriculumsToStringByCid(pTimetable2.getPtC1()));
			ActionContext.getContext().getSession().put("pt_c2_2", selectCurriculumDao.curriculumsToStringByCid(pTimetable2.getPtC2()));
			ActionContext.getContext().getSession().put("pt_c3_2", selectCurriculumDao.curriculumsToStringByCid(pTimetable2.getPtC3()));
			ActionContext.getContext().getSession().put("pt_c4_2", selectCurriculumDao.curriculumsToStringByCid(pTimetable2.getPtC4()));
			
			ActionContext.getContext().getSession().put("pt_c1_3", selectCurriculumDao.curriculumsToStringByCid(pTimetable3.getPtC1()));		
			ActionContext.getContext().getSession().put("pt_c2_3", selectCurriculumDao.curriculumsToStringByCid(pTimetable3.getPtC2()));
			ActionContext.getContext().getSession().put("pt_c3_3", selectCurriculumDao.curriculumsToStringByCid(pTimetable3.getPtC3()));
			ActionContext.getContext().getSession().put("pt_c4_3", selectCurriculumDao.curriculumsToStringByCid(pTimetable3.getPtC4()));

			ActionContext.getContext().getSession().put("pt_c1_4", selectCurriculumDao.curriculumsToStringByCid(pTimetable4.getPtC1()));
			ActionContext.getContext().getSession().put("pt_c2_4", selectCurriculumDao.curriculumsToStringByCid(pTimetable4.getPtC2()));
			ActionContext.getContext().getSession().put("pt_c3_4", selectCurriculumDao.curriculumsToStringByCid(pTimetable4.getPtC3()));
			ActionContext.getContext().getSession().put("pt_c4_4", selectCurriculumDao.curriculumsToStringByCid(pTimetable4.getPtC4()));
			
			ActionContext.getContext().getSession().put("pt_c1_5", selectCurriculumDao.curriculumsToStringByCid(pTimetable5.getPtC1()));
			ActionContext.getContext().getSession().put("pt_c2_5", selectCurriculumDao.curriculumsToStringByCid(pTimetable5.getPtC2()));
			ActionContext.getContext().getSession().put("pt_c3_5", selectCurriculumDao.curriculumsToStringByCid(pTimetable5.getPtC3()));
			ActionContext.getContext().getSession().put("pt_c4_5", selectCurriculumDao.curriculumsToStringByCid(pTimetable5.getPtC4()));
			
		}
		return SUCCESS;
		
	}
	//新建一个算法解析字符串组成5组PTimetable数组
	public List<PTimetable> substrToPTimetable(List<Curriculum> curriculums,List<ElectiveInfo> electiveInfos){
		List<PTimetable> pTimetables=new ArrayList<PTimetable>();
		//周一到周五
		PTimetable pTimetable1=new PTimetable(0, electiveInfos.get(0).getSId(), 0, 0, 0, 0, 1, electiveInfos.get(0).getEiSemester());
		PTimetable pTimetable2=new PTimetable(0, electiveInfos.get(0).getSId(), 0, 0, 0, 0, 2, electiveInfos.get(0).getEiSemester());
		PTimetable pTimetable3=new PTimetable(0, electiveInfos.get(0).getSId(), 0, 0, 0, 0, 3, electiveInfos.get(0).getEiSemester());
		PTimetable pTimetable4=new PTimetable(0, electiveInfos.get(0).getSId(), 0, 0, 0, 0, 4, electiveInfos.get(0).getEiSemester());
		PTimetable pTimetable5=new PTimetable(0, electiveInfos.get(0).getSId(), 0, 0, 0, 0, 5, electiveInfos.get(0).getEiSemester());
		for(int i=0;i<curriculums.size();i++){
			//计算某一课程一星期几节课=(n-3)/4+1
			//int number=(curriculums.get(i).getCTime().length()-3)/4+1;
			String[] sourceStrArray = curriculums.get(i).getCTime().split(",");
			  for (int j = 0; j < sourceStrArray.length; j++) {
			   //五个if语句判断属于星期几的课
			   if(sourceStrArray[j].substring(0, 1).equals("1")){
				   //一天四节课
				   if(sourceStrArray[j].substring(2, 3).equals("1")){
					   pTimetable1.setPtC1(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("2")){
					   pTimetable1.setPtC2(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("3")){
					   pTimetable1.setPtC3(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("4")){
					   pTimetable1.setPtC4(curriculums.get(i).getCId());
				   }
				   
			   }
			   if(sourceStrArray[j].substring(0, 1).equals("2")){
				 //一天四节课
				   if(sourceStrArray[j].substring(2, 3).equals("1")){
					   pTimetable2.setPtC1(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("2")){
					   pTimetable2.setPtC2(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("3")){
					   pTimetable2.setPtC3(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("4")){
					   pTimetable2.setPtC4(curriculums.get(i).getCId());
				   }
			   }
			   if(sourceStrArray[j].substring(0, 1).equals("3")){
				 //一天四节课
				   if(sourceStrArray[j].substring(2, 3).equals("1")){
					   pTimetable3.setPtC1(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("2")){
					   pTimetable3.setPtC2(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("3")){
					   pTimetable3.setPtC3(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("4")){
					   pTimetable3.setPtC4(curriculums.get(i).getCId());
				   }
			   }
			   if(sourceStrArray[j].substring(0, 1).equals("4")){
				 //一天四节课
				   if(sourceStrArray[j].substring(2, 3).equals("1")){
					   pTimetable4.setPtC1(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("2")){
					   pTimetable4.setPtC2(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("3")){
					   pTimetable4.setPtC3(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("4")){
					   pTimetable4.setPtC4(curriculums.get(i).getCId());
				   }
			   }
			   if(sourceStrArray[j].substring(0, 1).equals("5")){
				 //一天四节课
				   if(sourceStrArray[j].substring(2, 3).equals("1")){
					   pTimetable5.setPtC1(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("2")){
					   pTimetable5.setPtC2(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("3")){
					   pTimetable5.setPtC3(curriculums.get(i).getCId());
				   }
				   if(sourceStrArray[j].substring(2, 3).equals("4")){
					   pTimetable5.setPtC4(curriculums.get(i).getCId());
				   }
			   }
			  
			  }
		}
		System.out.println(pTimetable1.toString());
		System.out.println(pTimetable2.toString());
		System.out.println(pTimetable3.toString());
		System.out.println(pTimetable4.toString());
		System.out.println(pTimetable5.toString());
		pTimetables.add(pTimetable1);
		pTimetables.add(pTimetable2);
		pTimetables.add(pTimetable3);
		pTimetables.add(pTimetable4);
		pTimetables.add(pTimetable5);
		return pTimetables;
	}
}
