package com.yk5799.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * DTmaterial entity. @author MyEclipse Persistence Tools
 */

public class DTmaterial implements java.io.Serializable {

	// Fields

	private Integer dtId;
	private String dtName;
	private String dtBname;
	private Integer dtPrice;
	private String dtPress;
	private Integer dtNumb;
	private String dtDescribe;
	private Integer dtStatus;
	private Set curriculums = new HashSet(0);

	// Constructors

	/** default constructor */
	public DTmaterial() {
	}

	/** minimal constructor */
	public DTmaterial(Integer dtId) {
		this.dtId = dtId;
	}

	/** full constructor */
	public DTmaterial(Integer dtId, String dtName, String dtBname, Integer dtPrice, String dtPress, Integer dtNumb,
			String dtDescribe, Integer dtStatus, Set curriculums) {
		this.dtId = dtId;
		this.dtName = dtName;
		this.dtBname = dtBname;
		this.dtPrice = dtPrice;
		this.dtPress = dtPress;
		this.dtNumb = dtNumb;
		this.dtDescribe = dtDescribe;
		this.dtStatus = dtStatus;
		this.curriculums = curriculums;
	}

	// Property accessors

	public Integer getDtId() {
		return this.dtId;
	}

	public void setDtId(Integer dtId) {
		this.dtId = dtId;
	}

	public String getDtName() {
		return this.dtName;
	}

	public void setDtName(String dtName) {
		this.dtName = dtName;
	}

	public String getDtBname() {
		return this.dtBname;
	}

	public void setDtBname(String dtBname) {
		this.dtBname = dtBname;
	}

	public Integer getDtPrice() {
		return this.dtPrice;
	}

	public void setDtPrice(Integer dtPrice) {
		this.dtPrice = dtPrice;
	}

	public String getDtPress() {
		return this.dtPress;
	}

	public void setDtPress(String dtPress) {
		this.dtPress = dtPress;
	}

	public Integer getDtNumb() {
		return this.dtNumb;
	}

	public void setDtNumb(Integer dtNumb) {
		this.dtNumb = dtNumb;
	}

	public String getDtDescribe() {
		return this.dtDescribe;
	}

	public void setDtDescribe(String dtDescribe) {
		this.dtDescribe = dtDescribe;
	}

	public Integer getDtStatus() {
		return this.dtStatus;
	}

	public void setDtStatus(Integer dtStatus) {
		this.dtStatus = dtStatus;
	}

	public Set getCurriculums() {
		return this.curriculums;
	}

	public void setCurriculums(Set curriculums) {
		this.curriculums = curriculums;
	}

}