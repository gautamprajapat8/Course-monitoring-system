package com.masai.dao;
import java.sql.SQLException;

import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;
import com.masai.exceptions.CoursePlanException;
import com.masai.exceptions.FacultyException;

public interface FacultyDaoIntr {

	
	public Faculty login(String username, String password) throws FacultyException;
	public CoursePlan viewCoursePlan(int planId) throws CoursePlanException;
	public String fillCoursePlan(CoursePlan coursePlan);
	public String updatePassword(String username, String password);
	
	
}













//•	Login to his/her account
//•	View the Course Plan
//•	Fill up the day wise planner.
//•	Update his/her password
