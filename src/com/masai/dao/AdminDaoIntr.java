package com.masai.dao;

import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Course;

public interface AdminDaoIntr {

	public String login(Admin admin);
	
	
	public String createCourse();
	public String updateCourse();
	public List<Course> viewAllCourse();
	
	
	public String createBatch();
	public String updateBatch();
	public List<Course> viewAllBatch();
	
	
	public String createFaculty();
	public String updateFaculty();
	public List<Course> viewAllFaculty();
	
	public String AllocateFacultyToBatch();
	
	
	public String createCoursePlan();
	public String updateCoursePlan();
	public List<Course> viewAllCoursePlan();
	
	public List<?> viewDayWiseUpdateOfEveryBatch();// All data releted to batch and coursePlan
	
	public List<?> generateReportForEveryBatch();// All table ditels releted to batch?
	
	
	
	
}


//Role of Administrator:
//•	Login to his account
//•	 Create, Update, View Course.
//•	Create, Update, View Batch. A batch is related to a course. 
//•	Create, Update, View Faculty.
//•	Allocate faculty to a batch.
//•	Create, Update, View Course plan.
//•	View the Day wise update of every batch.
//•	 Generate Report for every batch.
