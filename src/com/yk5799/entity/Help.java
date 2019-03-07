package com.yk5799.entity;

/**
 * Help entity. @author MyEclipse Persistence Tools
 */

public class Help implements java.io.Serializable {

	// Fields

	private Integer HId;
	private String HContent;
	private String HTsettlement;
	private String HType;

	// Constructors

	/** default constructor */
	public Help() {
	}

	/** minimal constructor */
	public Help(Integer HId) {
		this.HId = HId;
	}

	/** full constructor */
	public Help(Integer HId, String HContent, String HTsettlement, String HType) {
		this.HId = HId;
		this.HContent = HContent;
		this.HTsettlement = HTsettlement;
		this.HType = HType;
	}

	// Property accessors

	public Integer getHId() {
		return this.HId;
	}

	public void setHId(Integer HId) {
		this.HId = HId;
	}

	public String getHContent() {
		return this.HContent;
	}

	public void setHContent(String HContent) {
		this.HContent = HContent;
	}

	public String getHTsettlement() {
		return this.HTsettlement;
	}

	public void setHTsettlement(String HTsettlement) {
		this.HTsettlement = HTsettlement;
	}

	public String getHType() {
		return this.HType;
	}

	public void setHType(String HType) {
		this.HType = HType;
	}

}