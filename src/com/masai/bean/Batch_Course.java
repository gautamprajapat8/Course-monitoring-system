package com.masai.bean;

public class Batch_Course {
	
	private int batchId;
	private int facultyId;
	private int numberofStudents;
	private String batchstartDate;
	private String duration;
	private int courseid;
	private String courseName;
	private int fee;
	private String courseDescription;
	
	public Batch_Course() {
		// TODO Auto-generated constructor stub
	}

	public Batch_Course(int batchId, int facultyId, int numberofStudents, String batchstartDate, String duration,
			int courseid, String courseName, int fee, String courseDescription) {
		super();
		this.batchId = batchId;
		this.facultyId = facultyId;
		this.numberofStudents = numberofStudents;
		this.batchstartDate = batchstartDate;
		this.duration = duration;
		this.courseid = courseid;
		this.courseName = courseName;
		this.fee = fee;
		this.courseDescription = courseDescription;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public int getNumberofStudents() {
		return numberofStudents;
	}

	public void setNumberofStudents(int numberofStudents) {
		this.numberofStudents = numberofStudents;
	}

	public String getBatchstartDate() {
		return batchstartDate;
	}

	public void setBatchstartDate(String batchstartDate) {
		this.batchstartDate = batchstartDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	@Override
	public String toString() {
		return "BatchCourse [batchId=" + batchId + ", facultyId=" + facultyId + ", numberofStudents=" + numberofStudents
				+ ", batchstartDate=" + batchstartDate + ", duration=" + duration + ", courseid=" + courseid
				+ ", courseName=" + courseName + ", fee=" + fee + ", courseDescription=" + courseDescription + "]";
	}
	
	
	
	
}
