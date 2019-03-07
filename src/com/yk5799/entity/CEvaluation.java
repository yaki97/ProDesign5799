package com.yk5799.entity;

/**
 * CEvaluation entity. @author MyEclipse Persistence Tools
 */

public class CEvaluation implements java.io.Serializable {

	// Fields

	private Integer ceId;
	private Integer CId;
	private String CContent;
	private Integer SId;
	private Integer TGrade;

	// Constructors

	/** default constructor */
	public CEvaluation() {
	}

	/** minimal constructor */
	public CEvaluation(Integer ceId) {
		this.ceId = ceId;
	}

	/** full constructor */
	public CEvaluation(Integer ceId, Integer CId, String CContent, Integer SId,
			Integer TGrade) {
		this.ceId = ceId;
		this.CId = CId;
		this.CContent = CContent;
		this.SId = SId;
		this.TGrade = TGrade;
	}

	// Property accessors

	public Integer getCeId() {
		return this.ceId;
	}

	public void setCeId(Integer ceId) {
		this.ceId = ceId;
	}

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public String getCContent() {
		return this.CContent;
	}

	public void setCContent(String CContent) {
		this.CContent = CContent;
	}

	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
	}

	public Integer getTGrade() {
		return this.TGrade;
	}

	public void setTGrade(Integer TGrade) {
		this.TGrade = TGrade;
	}

	@Override
	public String toString() {
		return "CEvaluation [ceId=" + ceId + ", CId=" + CId + ", CContent=" + CContent + ", SId=" + SId + ", TGrade="
				+ TGrade + "]";
	}
	
}