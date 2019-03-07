package com.yk5799.entity;

/**
 * ElectiveInfo entity. @author MyEclipse Persistence Tools
 */

public class ElectiveInfo implements java.io.Serializable {

	// Fields

	private Integer eiId;
	private Integer SId;
	private Integer CId;
	private Integer eiStatus;
	private Integer eiSemester;
	private Integer eiCprogress;

	// Constructors

	/** default constructor */
	public ElectiveInfo() {
	}

	/** minimal constructor */
	public ElectiveInfo(Integer eiId) {
		this.eiId = eiId;
	}

	/** full constructor */
	public ElectiveInfo(Integer eiId, Integer SId, Integer CId,
			Integer eiStatus, Integer eiSemester, Integer eiCprogress) {
		this.eiId = eiId;
		this.SId = SId;
		this.CId = CId;
		this.eiStatus = eiStatus;
		this.eiSemester = eiSemester;
		this.eiCprogress = eiCprogress;
	}

	// Property accessors

	public Integer getEiId() {
		return this.eiId;
	}

	public void setEiId(Integer eiId) {
		this.eiId = eiId;
	}

	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
	}

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public Integer getEiStatus() {
		return this.eiStatus;
	}

	public void setEiStatus(Integer eiStatus) {
		this.eiStatus = eiStatus;
	}

	public Integer getEiSemester() {
		return this.eiSemester;
	}

	public void setEiSemester(Integer eiSemester) {
		this.eiSemester = eiSemester;
	}

	public Integer getEiCprogress() {
		return this.eiCprogress;
	}

	public void setEiCprogress(Integer eiCprogress) {
		this.eiCprogress = eiCprogress;
	}

	@Override
	public String toString() {
		return "ElectiveInfo [eiId=" + eiId + ", SId=" + SId + ", CId=" + CId
				+ ", eiStatus=" + eiStatus + ", eiSemester=" + eiSemester
				+ ", eiCprogress=" + eiCprogress + "]";
	}

}