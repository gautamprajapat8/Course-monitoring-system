package com.masai.bean;

public class ViewTheDayWiseUpdateOfEveryBatch {

	private int batchId;
	private String courseName;
	private String courseDescription;
	private String facultyname;
	private int  dayNumber;
	private String topic;
	
	
	public ViewTheDayWiseUpdateOfEveryBatch() {
		// TODO Auto-generated constructor stub
	}


	public ViewTheDayWiseUpdateOfEveryBatch(int batchId, String courseName, String courseDescription,
			String facultyname, int dayNumber, String topic) {
		super();
		this.batchId = batchId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.facultyname = facultyname;
		this.dayNumber = dayNumber;
		this.topic = topic;
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


	public int getDayNumber() {
		return dayNumber;
	}


	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	@Override
	public String toString() {
		return "ViewTheDayWiseUpdateOfEveryBatch [batchId=" + batchId + ", courseName=" + courseName
				+ ", courseDescription=" + courseDescription + ", facultyname=" + facultyname + ", dayNumber="
				+ dayNumber + ", topic=" + topic + "]";
	}
	
	
	
}
