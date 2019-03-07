package com.yk5799.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer TId;
	private String TName;
	private Boolean TSex;
	private String TPassword;
	private String TPhone;
	private String TEmaill;
	private String TOffice;
	private String TMajor;
	private String TCollege;
	private Set curriculums = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer TId) {
		this.TId = TId;
	}

	/** full constructor */
	public Teacher(Integer TId, String TName, Boolean TSex, String TPassword,
			String TPhone, String TEmaill, String TOffice, String TMajor,
			String TCollege, Set curriculums) {
		this.TId = TId;
		this.TName = TName;
		this.TSex = TSex;
		this.TPassword = TPassword;
		this.TPhone = TPhone;
		this.TEmaill = TEmaill;
		this.TOffice = TOffice;
		this.TMajor = TMajor;
		this.TCollege = TCollege;
		this.curriculums = curriculums;
	}

	// Property accessors

	public Integer getTId() {
		return this.TId;
	}

	public void setTId(Integer TId) {
		this.TId = TId;
	}

	public String getTName() {
		return this.TName;
	}

	public void setTName(String TName) {
		this.TName = TName;
	}

	public Boolean getTSex() {
		return this.TSex;
	}

	public void setTSex(Boolean TSex) {
		this.TSex = TSex;
	}

	public String getTPassword() {
		return this.TPassword;
	}

	public void setTPassword(String TPassword) {
		this.TPassword = TPassword;
	}

	public String getTPhone() {
		return this.TPhone;
	}

	public void setTPhone(String TPhone) {
		this.TPhone = TPhone;
	}

	public String getTEmaill() {
		return this.TEmaill;
	}

	public void setTEmaill(String TEmaill) {
		this.TEmaill = TEmaill;
	}

	public String getTOffice() {
		return this.TOffice;
	}

	public void setTOffice(String TOffice) {
		this.TOffice = TOffice;
	}

	public String getTMajor() {
		return this.TMajor;
	}

	public void setTMajor(String TMajor) {
		this.TMajor = TMajor;
	}

	public String getTCollege() {
		return this.TCollege;
	}

	public void setTCollege(String TCollege) {
		this.TCollege = TCollege;
	}

	public Set getCurriculums() {
		return this.curriculums;
	}

	public void setCurriculums(Set curriculums) {
		this.curriculums = curriculums;
	}

}