package com.yk5799.entity;

import java.sql.Timestamp;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	private Integer NId;
	private String NTitle;
	private String NContent;
	private Timestamp NStime;
	private Integer NStatus;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(Integer NId) {
		this.NId = NId;
	}

	/** full constructor */
	public Notice(Integer NId, String NTitle, String NContent, Timestamp NStime, Integer NStatus) {
		this.NId = NId;
		this.NTitle = NTitle;
		this.NContent = NContent;
		this.NStime = NStime;
		this.NStatus = NStatus;
	}

	// Property accessors

	public Integer getNId() {
		return this.NId;
	}

	public void setNId(Integer NId) {
		this.NId = NId;
	}

	public String getNTitle() {
		return this.NTitle;
	}

	public void setNTitle(String NTitle) {
		this.NTitle = NTitle;
	}

	public String getNContent() {
		return this.NContent;
	}

	public void setNContent(String NContent) {
		this.NContent = NContent;
	}

	public Timestamp getNStime() {
		return this.NStime;
	}

	public void setNStime(Timestamp NStime) {
		this.NStime = NStime;
	}

	public Integer getNStatus() {
		return this.NStatus;
	}

	public void setNStatus(Integer NStatus) {
		this.NStatus = NStatus;
	}

}