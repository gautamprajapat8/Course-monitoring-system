package com.masai.dao;

import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Batch;
import com.masai.bean.Batch_Course;
import com.masai.bean.Course;
import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;
import com.masai.bean.GenerateReportForEveryBatch;
import com.masai.bean.ViewTheDayWiseUpdateOfEveryBatch;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.BatchCourseException;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.CoursePlanException;
import com.masai.exceptions.FacultyException;
import com.masai.exceptions.GenerateReportForEveryBatchException;
import com.masai.exceptions.ViewTheDayWiseUpdateOfEveryBatchException;

public interface AdminDaoIntr {

	public Admin login(Admin admin) throws AdminException;
	
	
	public String createCourse(Course course);
	public String updateCourse(Course course);
	public List<Course> viewAllCourse() throws CourseException;
	
	
	public String createBatch(Batch batch);
	public String updateBatch(Batch batch);
	public List<Batch_Course> viewAllBatch() throws BatchCourseException;
	
	
	
	public String createFaculty(Faculty faculty);
	public String updateFaculty(Faculty faculty);
	public List<Faculty> viewAllFaculty() throws FacultyException;
	
	
	public String AllocateFacultyToBatch(int facultyId, int batchId);
	
	public String AllocateCourseToBatch(int courseId, int batchId);
	
	
	public String createCoursePlan(CoursePlan coursePlan);
	public String updateCoursePlan(CoursePlan coursePlan);
	public List<CoursePlan> viewAllCoursePlan() throws CoursePlanException;
	
	public List<ViewTheDayWiseUpdateOfEveryBatch> viewDayWiseUpdateOfEveryBatch() throws ViewTheDayWiseUpdateOfEveryBatchException;// All data releted to batch and coursePlan
	
	public List<GenerateReportForEveryBatch> generateReportForEveryBatch() throws GenerateReportForEveryBatchException;// All table ditels releted to batch?
	
	
	
	
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
