package com.yk5799.entity;

/**
 * Curriculum entity. @author MyEclipse Persistence Tools
 */

public class Curriculum implements java.io.Serializable {

	// Fields

	private Integer CId;
	private String CName;
	private Integer dtId;
	private Integer TId;
	private String CTime;
	private Integer CCredit;
	private String CType;
	private String CNature;
	private String CInstitute;
	private String CClassroom;
	private Integer CCapacity;
	private Integer CSelectedNumb;
	private Integer CSemester;

	// Constructors

	/** default constructor */
	public Curriculum() {
	}

	/** minimal constructor */
	public Curriculum(Integer CId) {
		this.CId = CId;
	}

	/** full constructor */
	public Curriculum(Integer CId, String CName, Integer dtId, Integer TId,
			String CTime, Integer CCredit, String CType, String CNature,
			String CInstitute, String CClassroom, Integer CCapacity,
			Integer CSelectedNumb, Integer CSemester) {
		this.CId = CId;
		this.CName = CName;
		this.dtId = dtId;
		this.TId = TId;
		this.CTime = CTime;
		this.CCredit = CCredit;
		this.CType = CType;
		this.CNature = CNature;
		this.CInstitute = CInstitute;
		this.CClassroom = CClassroom;
		this.CCapacity = CCapacity;
		this.CSelectedNumb = CSelectedNumb;
		this.CSemester = CSemester;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	public Integer getDtId() {
		return this.dtId;
	}

	public void setDtId(Integer dtId) {
		this.dtId = dtId;
	}

	public Integer getTId() {
		return this.TId;
	}

	public void setTId(Integer TId) {
		this.TId = TId;
	}

	public String getCTime() {
		return this.CTime;
	}

	public void setCTime(String CTime) {
		this.CTime = CTime;
	}

	public Integer getCCredit() {
		return this.CCredit;
	}

	public void setCCredit(Integer CCredit) {
		this.CCredit = CCredit;
	}

	public String getCType() {
		return this.CType;
	}

	public void setCType(String CType) {
		this.CType = CType;
	}

	public String getCNature() {
		return this.CNature;
	}

	public void setCNature(String CNature) {
		this.CNature = CNature;
	}

	public String getCInstitute() {
		return this.CInstitute;
	}

	public void setCInstitute(String CInstitute) {
		this.CInstitute = CInstitute;
	}

	public String getCClassroom() {
		return this.CClassroom;
	}

	public void setCClassroom(String CClassroom) {
		this.CClassroom = CClassroom;
	}

	public Integer getCCapacity() {
		return this.CCapacity;
	}

	public void setCCapacity(Integer CCapacity) {
		this.CCapacity = CCapacity;
	}

	public Integer getCSelectedNumb() {
		return this.CSelectedNumb;
	}

	public void setCSelectedNumb(Integer CSelectedNumb) {
		this.CSelectedNumb = CSelectedNumb;
	}

	public Integer getCSemester() {
		return this.CSemester;
	}

	public void setCSemester(Integer CSemester) {
		this.CSemester = CSemester;
	}



}