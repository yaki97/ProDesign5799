package com.yk5799.entity;

import java.sql.Timestamp;

/**
 * ClassNote entity. @author MyEclipse Persistence Tools
 */

public class ClassNote implements java.io.Serializable {

	// Fields

	private Integer noId;
	private Integer SId;
	private Integer CId;
	private String noContent;
	private Timestamp noDate;

	// Constructors

	/** default constructor */
	public ClassNote() {
	}

	/** full constructor */
	public ClassNote(Integer noId, Integer SId, Integer CId, String noContent, Timestamp noDate) {
		this.noId = noId;
		this.SId = SId;
		this.CId = CId;
		this.noContent = noContent;
		this.noDate = noDate;
	}

	// Property accessors

	public Integer getNoId() {
		return this.noId;
	}

	public void setNoId(Integer noId) {
		this.noId = noId;
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

	public String getNoContent() {
		return this.noContent;
	}

	public void setNoContent(String noContent) {
		this.noContent = noContent;
	}

	public Timestamp getNoDate() {
		return this.noDate;
	}

	public void setNoDate(Timestamp noDate) {
		this.noDate = noDate;
	}

	@Override
	public String toString() {
		return "ClassNote [noId=" + noId + ", SId=" + SId + ", CId=" + CId + ", noContent=" + noContent + ", noDate="
				+ noDate + "]";
	}

}