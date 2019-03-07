package com.yk5799.entity;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer SId;
	private String SPassword;
	private Integer SIdc;
	private String SName;
	private Boolean SSex;
	private Integer SAge;
	private String SNativep;
	private String SFamilyname;
	private Integer SSemester;
	private String SMajor;
	private String SCollege;
	private Integer SClass;
	private String SPhone;
	private String SEmail;
	private Boolean SCet4;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer SId) {
		this.SId = SId;
	}

	/** full constructor */
	public Student(Integer SId, String SPassword, Integer SIdc, String SName,
			Boolean SSex, Integer SAge, String SNativep, String SFamilyname,
			Integer SSemester, String SMajor, String SCollege, Integer SClass,
			String SPhone, String SEmail, Boolean SCet4) {
		this.SId = SId;
		this.SPassword = SPassword;
		this.SIdc = SIdc;
		this.SName = SName;
		this.SSex = SSex;
		this.SAge = SAge;
		this.SNativep = SNativep;
		this.SFamilyname = SFamilyname;
		this.SSemester = SSemester;
		this.SMajor = SMajor;
		this.SCollege = SCollege;
		this.SClass = SClass;
		this.SPhone = SPhone;
		this.SEmail = SEmail;
		this.SCet4 = SCet4;
	}

	// Property accessors

	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
	}

	public String getSPassword() {
		return this.SPassword;
	}

	public void setSPassword(String SPassword) {
		this.SPassword = SPassword;
	}

	public Integer getSIdc() {
		return this.SIdc;
	}

	public void setSIdc(Integer SIdc) {
		this.SIdc = SIdc;
	}

	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	public Boolean getSSex() {
		return this.SSex;
	}

	public void setSSex(Boolean SSex) {
		this.SSex = SSex;
	}

	public Integer getSAge() {
		return this.SAge;
	}

	public void setSAge(Integer SAge) {
		this.SAge = SAge;
	}

	public String getSNativep() {
		return this.SNativep;
	}

	public void setSNativep(String SNativep) {
		this.SNativep = SNativep;
	}

	public String getSFamilyname() {
		return this.SFamilyname;
	}

	public void setSFamilyname(String SFamilyname) {
		this.SFamilyname = SFamilyname;
	}

	public Integer getSSemester() {
		return this.SSemester;
	}

	public void setSSemester(Integer SSemester) {
		this.SSemester = SSemester;
	}

	public String getSMajor() {
		return this.SMajor;
	}

	public void setSMajor(String SMajor) {
		this.SMajor = SMajor;
	}

	public String getSCollege() {
		return this.SCollege;
	}

	public void setSCollege(String SCollege) {
		this.SCollege = SCollege;
	}

	public Integer getSClass() {
		return this.SClass;
	}

	public void setSClass(Integer SClass) {
		this.SClass = SClass;
	}

	public String getSPhone() {
		return this.SPhone;
	}

	public void setSPhone(String SPhone) {
		this.SPhone = SPhone;
	}

	public String getSEmail() {
		return this.SEmail;
	}

	public void setSEmail(String SEmail) {
		this.SEmail = SEmail;
	}

	public Boolean getSCet4() {
		return this.SCet4;
	}

	public void setSCet4(Boolean SCet4) {
		this.SCet4 = SCet4;
	}

}