package com.yk5799.entity;

/**
 * ApplicationUpdatec entity. @author MyEclipse Persistence Tools
 */

public class ApplicationUpdatec implements java.io.Serializable {

	// Fields

	private Integer auId;
	private String auName;
	private String auReason;
	private String auConten;
	private Integer auStatus;

	// Constructors

	/** default constructor */
	public ApplicationUpdatec() {
	}

	/** minimal constructor */
	public ApplicationUpdatec(Integer auId) {
		this.auId = auId;
	}

	/** full constructor */
	public ApplicationUpdatec(Integer auId, String auName, String auReason, String auConten, Integer auStatus) {
		this.auId = auId;
		this.auName = auName;
		this.auReason = auReason;
		this.auConten = auConten;
		this.auStatus = auStatus;
	}

	// Property accessors

	public Integer getAuId() {
		return this.auId;
	}

	public void setAuId(Integer auId) {
		this.auId = auId;
	}

	public String getAuName() {
		return this.auName;
	}

	public void setAuName(String auName) {
		this.auName = auName;
	}

	public String getAuReason() {
		return this.auReason;
	}

	public void setAuReason(String auReason) {
		this.auReason = auReason;
	}

	public String getAuConten() {
		return this.auConten;
	}

	public void setAuConten(String auConten) {
		this.auConten = auConten;
	}

	public Integer getAuStatus() {
		return this.auStatus;
	}

	public void setAuStatus(Integer auStatus) {
		this.auStatus = auStatus;
	}

}