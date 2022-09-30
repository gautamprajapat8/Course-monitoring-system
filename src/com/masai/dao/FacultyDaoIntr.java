package com.masai.dao;
import com.masai.bean.CoursePlan;

public interface FacultyDaoIntr {

	
	public String  login(String username, String password);
	public CoursePlan viewCoursePlan(int planId);
	public CoursePlan fillCoursePlan(CoursePlan coursePlan);
	public String UpdatePassword(int facultyid, String username, String password);
	
	
}













//•	Login to his/her account
//•	View the Course Plan
//•	Fill up the day wise planner.
//•	Update his/her password
