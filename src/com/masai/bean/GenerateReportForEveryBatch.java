package com.masai.bean;

public class GenerateReportForEveryBatch {

	private int batchId ;
	private String courseName;
	private String courseDescription;
	private String facultyname ;
	private int numberofStudents;
	private String batchstartDate;
	private String duration ;
	private String status ;
	
	public GenerateReportForEveryBatch() {
		// TODO Auto-generated constructor stub
	}

	public GenerateReportForEveryBatch(int batchId, String courseName, String courseDescription, String facultyname,
			int numberofStudents, String batchstartDate, String duration, String status) {
		super();
		this.batchId = batchId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.facultyname = facultyname;
		this.numberofStudents = numberofStudents;
		this.batchstartDate = batchstartDate;
		this.duration = duration;
		this.status = status;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getFacultyname() {
		return facultyname;
	}

	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
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


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
