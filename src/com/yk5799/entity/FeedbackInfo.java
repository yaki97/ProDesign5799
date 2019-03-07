package com.yk5799.entity;

/**
 * FeedbackInfo entity. @author MyEclipse Persistence Tools
 */

public class FeedbackInfo implements java.io.Serializable {

	// Fields

	private Integer fiId;
	private Student student;
	private String fiBcontent;
	private String fiRcontent;
	private Integer fiBstatus;
	private Integer fiDstatus;

	// Constructors

	/** default constructor */
	public FeedbackInfo() {
	}

	/** minimal constructor */
	public FeedbackInfo(Integer fiId) {
		this.fiId = fiId;
	}

	/** full constructor */
	public FeedbackInfo(Integer fiId, Student student, String fiBcontent, String fiRcontent, Integer fiBstatus,
			Integer fiDstatus) {
		this.fiId = fiId;
		this.student = student;
		this.fiBcontent = fiBcontent;
		this.fiRcontent = fiRcontent;
		this.fiBstatus = fiBstatus;
		this.fiDstatus = fiDstatus;
	}

	// Property accessors

	public Integer getFiId() {
		return this.fiId;
	}

	public void setFiId(Integer fiId) {
		this.fiId = fiId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getFiBcontent() {
		return this.fiBcontent;
	}

	public void setFiBcontent(String fiBcontent) {
		this.fiBcontent = fiBcontent;
	}

	public String getFiRcontent() {
		return this.fiRcontent;
	}

	public void setFiRcontent(String fiRcontent) {
		this.fiRcontent = fiRcontent;
	}

	public Integer getFiBstatus() {
		return this.fiBstatus;
	}

	public void setFiBstatus(Integer fiBstatus) {
		this.fiBstatus = fiBstatus;
	}

	public Integer getFiDstatus() {
		return this.fiDstatus;
	}

	public void setFiDstatus(Integer fiDstatus) {
		this.fiDstatus = fiDstatus;
	}

}