package com.yk5799.entity;

/**
 * PTimetable entity. @author MyEclipse Persistence Tools
 */

public class PTimetable implements java.io.Serializable {

	// Fields

	private Integer ptId;
	private Integer SId;
	private Integer ptC1;
	private Integer ptC2;
	private Integer ptC3;
	private Integer ptC4;
	private Integer ptWeek;
	private Integer ptSemester;

	// Constructors

	/** default constructor */
	public PTimetable() {
	}

	/** minimal constructor */
	public PTimetable(Integer ptId) {
		this.ptId = ptId;
	}

	/** full constructor */
	public PTimetable(Integer ptId, Integer SId, Integer ptC1, Integer ptC2,
			Integer ptC3, Integer ptC4, Integer ptWeek, Integer ptSemester) {
		this.ptId = ptId;
		this.SId = SId;
		this.ptC1 = ptC1;
		this.ptC2 = ptC2;
		this.ptC3 = ptC3;
		this.ptC4 = ptC4;
		this.ptWeek = ptWeek;
		this.ptSemester = ptSemester;
	}

	// Property accessors

	public Integer getPtId() {
		return this.ptId;
	}

	public void setPtId(Integer ptId) {
		this.ptId = ptId;
	}

	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
	}

	public Integer getPtC1() {
		return this.ptC1;
	}

	public void setPtC1(Integer ptC1) {
		this.ptC1 = ptC1;
	}

	public Integer getPtC2() {
		return this.ptC2;
	}

	public void setPtC2(Integer ptC2) {
		this.ptC2 = ptC2;
	}

	public Integer getPtC3() {
		return this.ptC3;
	}

	public void setPtC3(Integer ptC3) {
		this.ptC3 = ptC3;
	}

	public Integer getPtC4() {
		return this.ptC4;
	}

	public void setPtC4(Integer ptC4) {
		this.ptC4 = ptC4;
	}

	public Integer getPtWeek() {
		return this.ptWeek;
	}

	public void setPtWeek(Integer ptWeek) {
		this.ptWeek = ptWeek;
	}

	public Integer getPtSemester() {
		return this.ptSemester;
	}

	public void setPtSemester(Integer ptSemester) {
		this.ptSemester = ptSemester;
	}

	@Override
	public String toString() {
		return "PTimetable [ptId=" + ptId + ", SId=" + SId + ", ptC1=" + ptC1
				+ ", ptC2=" + ptC2 + ", ptC3=" + ptC3 + ", ptC4=" + ptC4
				+ ", ptWeek=" + ptWeek + ", ptSemester=" + ptSemester + "]";
	}

}