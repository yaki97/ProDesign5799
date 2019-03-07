package com.yk5799.entity;

public class HistoryCourseView {

	// Fields

	private Integer CId;
	private String CName;
	private String TName;
	private Integer CCredit;
	private String CType;
	private String CNature;
	private String CInstitute;
	private String CClassroom;
	private Integer CSemester;
	private Integer isPingjia;

	// Constructors

	/** default constructor */
	public HistoryCourseView() {
	}

	/** minimal constructor */
	public HistoryCourseView(Integer CId) {
		this.CId = CId;
	}


	public HistoryCourseView(Integer cId, String cName, String tName,
			Integer cCredit, String cType, String cNature, String cInstitute,
			String cClassroom, Integer cSemester, Integer isPingjia) {
		super();
		CId = cId;
		CName = cName;
		TName = tName;
		CCredit = cCredit;
		CType = cType;
		CNature = cNature;
		CInstitute = cInstitute;
		CClassroom = cClassroom;
		CSemester = cSemester;
		this.isPingjia = isPingjia;
	}

	public Integer getCId() {
		return CId;
	}

	public void setCId(Integer cId) {
		CId = cId;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public String getTName() {
		return TName;
	}

	public void setTName(String tName) {
		TName = tName;
	}

	public Integer getCCredit() {
		return CCredit;
	}

	public void setCCredit(Integer cCredit) {
		CCredit = cCredit;
	}

	public String getCType() {
		return CType;
	}

	public void setCType(String cType) {
		CType = cType;
	}

	public String getCNature() {
		return CNature;
	}

	public void setCNature(String cNature) {
		CNature = cNature;
	}

	public String getCInstitute() {
		return CInstitute;
	}

	public void setCInstitute(String cInstitute) {
		CInstitute = cInstitute;
	}

	public String getCClassroom() {
		return CClassroom;
	}

	public void setCClassroom(String cClassroom) {
		CClassroom = cClassroom;
	}

	public Integer getCSemester() {
		return CSemester;
	}

	public void setCSemester(Integer cSemester) {
		CSemester = cSemester;
	}

	public Integer getIsPingjia() {
		return isPingjia;
	}

	public void setIsPingjia(Integer isPingjia) {
		this.isPingjia = isPingjia;
	}

	@Override
	public String toString() {
		return "HistoryCourseView [CId=" + CId + ", CName=" + CName
				+ ", TName=" + TName + ", CCredit=" + CCredit + ", CType="
				+ CType + ", CNature=" + CNature + ", CInstitute=" + CInstitute
				+ ", CClassroom=" + CClassroom + ", CSemester=" + CSemester
				+ ", isPingjia=" + isPingjia + "]";
	}

	

	
}