package com.masai.UseCase;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.*;
import com.masai.dao.*;
import com.masai.exceptions.*;

public class AdminAllMethod {

	
	public static void CreateCourse()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter course Id:");
		int courseid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter course Name:");
		String courseName=sc.nextLine();
		
		System.out.println("Enter course fee:");
		int fee=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter course description:");
		String courseDescription=sc.nextLine();
		
		Course c=new Course(courseid, courseName, fee, courseDescription);
		
		AdminDaoIntr adic=new AdminDaoImp();
		
		String msg=adic.createCourse(c);
		System.out.println("\n"+msg+"\n");
		
	}
	
	
	
	public static void UpdateCourse()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter course Id:");
		int courseid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter course Name:");
		String courseName=sc.nextLine();
		
		System.out.println("Enter course fee:");
		int fee=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter course description:");
		String courseDescription=sc.nextLine();
		
		Course c=new Course(courseid, courseName, fee, courseDescription);
		
		AdminDaoIntr adic=new AdminDaoImp();
		
		String msg=adic.updateCourse(c);
		System.out.println("\n"+msg+"\n");
	}
	
	
	
	public static void ViewAllCourse()
	{
		AdminDaoIntr adic=new AdminDaoImp();
		try {
			List<Course> courses=adic.viewAllCourse();
			
			courses.forEach(s ->{
				System.out.println("\n=========================================================================================");
				System.out.println("Course Id: "+s.getCourseid());
				System.out.println("Course Name: "+s.getCourseName());
				System.out.println("Course fee: "+s.getFee());
				System.out.println("Course description: "+s.getCourseDescription());
				
			});
			
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	public static void CreateBatch()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter batch Id:");
		int batchid=sc.nextInt();
		System.out.println("Enter number of Students:");
		int numberofStudents=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter batch start Date(yyyy-mm-dd):");
		String batchstartDate=sc.nextLine();
		System.out.println("Enter duration:");
		String duration=sc.nextLine();
		
		Batch b=new Batch();
		b.setBatchId(batchid);
		b.setNumberofStudents(numberofStudents);
		b.setBatchstartDate(batchstartDate);
		b.setDuration(duration);
		
		AdminDaoIntr adic=new AdminDaoImp();
		
		String msg=adic.createBatch(b);
		System.out.println("\n"+msg+"\n");
	}
	
	
	
	public static void UpdateBatch()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter batch Id:");
		int batchid=sc.nextInt();
		System.out.println("Enter course Id:");
		int courseId=sc.nextInt();
		System.out.println("Enter faculty Id:");
		int facultyId=sc.nextInt();
		System.out.println("Enter number of Students:");
		int numberofStudents=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter batch start Date(yyyy-mm-dd):");
		String batchstartDate=sc.nextLine();
		System.out.println("Enter duration:");
		String duration=sc.nextLine();
		
		Batch b=new Batch(batchid, courseId, facultyId, numberofStudents, batchstartDate, duration);
		
		AdminDaoIntr adic=new AdminDaoImp();
		
		String msg=adic.updateBatch(b);
		System.out.println("\n"+msg+"\n");
	}
	
	
	
	public static void ViewAllBatchWithCourse()
	{
		AdminDaoIntr adic=new AdminDaoImp();
		try {
			List<Batch_Course> batch_course=adic.viewAllBatch();
			
			batch_course.forEach(s ->{
				
				System.out.println("\n=========================================================================================");
				System.out.println("Batch Id: "+s.getBatchId());
				System.out.println("Faculty Id: "+s.getFacultyId());
				System.out.println("Number of Students: "+s.getNumberofStudents());
				System.out.println("batchstartDate: "+s.getBatchstartDate());
				System.out.println("Course Id: "+s.getCourseid());
				System.out.println("Course Name: "+s.getCourseName());
				System.out.println("Course fee: "+s.getFee());
				System.out.println("Course description: "+s.getCourseDescription());
				
			});
			
		} catch (BatchCourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void CreateFaculty()
	{
		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter Faculty Ditels-");
//		System.out.println("Enter Id:");
//		int facultyid=sc.nextInt();
//		sc.nextLine();
		System.out.println("-------------------------------------------------");
		System.out.println("Enter name:");
		String facultyname=sc.nextLine();
		
		System.out.println("Enter address:");
		String facultyaddress=sc.nextLine();
		
		System.out.println("Enter mobile:");
		String mobile=sc.nextLine();
		System.out.println("Enter email:");
		String email=sc.nextLine();
		System.out.println("Enter username");
		String username=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		
//		Faculty f=new Faculty(facultyid, facultyname, facultyaddress, mobile, email, username, password);
		
		
		Faculty f=new Faculty();
		f.setEmail(email);
		f.setFacultyaddress(facultyaddress);
		f.setFacultyname(facultyname);
		f.setMobile(mobile);
		f.setPassword(password);
		f.setUsername(username);
//		f.setFacultyid(facultyid);
		
		
		AdminDaoIntr adic=new AdminDaoImp();
		
		String msg=adic.createFaculty(f);
		System.out.println("\n"+msg+"\n");
		
		
	}
	
	
	
	public static void UpdateFaculty()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter Faculty Ditels-");
		System.out.println("Enter Id:");
		int facultyid=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter name:");
		String facultyname=sc.nextLine();
		
		System.out.println("Enter address:");
		String facultyaddress=sc.nextLine();
		
		System.out.println("Enter mobile:");
		String mobile=sc.nextLine();
		System.out.println("Enter email:");
		String email=sc.nextLine();
		System.out.println("Enter username");
		String username=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		
		Faculty f=new Faculty(facultyid, facultyname, facultyaddress, mobile, email, username, password);
		
		AdminDaoIntr adic=new AdminDaoImp();
		
		String msg=adic.updateFaculty(f);
		System.out.println("\n"+msg+"\n");
	}
	
	
	
	public static void ViewAllFaculty()
	{
		AdminDaoIntr adic=new AdminDaoImp();
		try {
			List<Faculty> facultys=adic.viewAllFaculty();
			
			facultys.forEach(s ->{
				System.out.println("\n=========================================================================================");
				System.out.println("Faculty Id: "+s.getFacultyid());
				System.out.println("Name: "+s.getFacultyname());
				System.out.println("Address: "+s.getFacultyaddress());
				System.out.println("Mobile: "+s.getMobile());
				System.out.println("Email: "+s.getEmail());
				System.out.println("Username: "+s.getUsername());
				System.out.println("Password: "+s.getPassword());
				
				
			});
			
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void allocateFacultyToBatch()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter Faculty ID: ");
		int fid=sc.nextInt();
		System.out.println("Enter Batch ID: ");
		int fp=sc.nextInt();
		AdminDaoIntr adic=new AdminDaoImp();
		String str=adic.AllocateFacultyToBatch(fid, fp);
		System.out.println("\n"+str+"\n");
		
	}
	
	public static void allocateCourseToBatch()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter Batch ID: ");
		int bid=sc.nextInt();
		System.out.println("Enter Course ID: ");
		int cid=sc.nextInt();
		AdminDaoIntr adic=new AdminDaoImp();
		String str=adic.AllocateCourseToBatch(cid, bid);
		System.out.println("\n"+str+"\n");
	}
	
	public static void CreateCoursePlan()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter course Plan Id:");
		int planId=sc.nextInt();
		System.out.println("Enter day number:");
		int daynumber=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Topic:");
		String topic=sc.nextLine();
		System.out.println("Enter status(completed/pending):");
		String status=sc.nextLine();
		
		CoursePlan cp=new CoursePlan();
		cp.setDayNumber(daynumber);
		cp.setPlanId(planId);
		cp.setStatus(status);
		cp.setTopic(topic);
		
		AdminDaoIntr adic=new AdminDaoImp();
		
		String msg=adic.createCoursePlan(cp);
		System.out.println("\n"+msg+"\n");
	}
	
	public static void UpdateCoursePlan()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter course Plan Id:");
		int planId=sc.nextInt();
		System.out.println("Enter batch ID: ");
		int batchId=sc.nextInt();
		System.out.println("Enter day number:");
		int daynumber=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Topic:");
		String topic=sc.nextLine();
		System.out.println("Enter status(completed/pending):");
		String status=sc.nextLine();
		
		CoursePlan cp=new CoursePlan();
		cp.setDayNumber(daynumber);
		cp.setPlanId(planId);
		cp.setStatus(status);
		cp.setTopic(topic);
		cp.setBatchId(batchId);
		
		AdminDaoIntr adic=new AdminDaoImp();
		
		String msg=adic.updateCoursePlan(cp);
		System.out.println("\n"+msg+"\n");
	}
	
	
	
	public static void ViewAllCoursePlan()
	{
		AdminDaoIntr adic=new AdminDaoImp();
		try {
			List<CoursePlan> coursePlan=adic.viewAllCoursePlan();
			coursePlan.forEach(s ->{
				System.out.println("\n=========================================================================================");
				System.out.println("Course Plan Id: "+s.getPlanId());
				System.out.println("Batch Id: "+s.getBatchId());
				System.out.println("Day number: "+s.getDayNumber());
				System.out.println("Topic: "+s.getTopic());
				System.out.println("Status: "+s.getStatus());
				
			});
			
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void ViewTheDayWiseUpdateOfEveryBatch()
	{
		AdminDaoIntr adic=new AdminDaoImp();
		try {
			List<ViewTheDayWiseUpdateOfEveryBatch> view=adic.viewDayWiseUpdateOfEveryBatch();
			
			view.forEach(s ->{
				System.out.println("\n=========================================================================================");
				System.out.println("Batch Id: "+s.getBatchId());
				System.out.println("Course Name: "+s.getCourseName());
				System.out.println("Course Description: "+s.getCourseDescription());
				System.out.println("Faculty Name: "+s.getFacultyname());
				System.out.println("Day Number: "+s.getDayNumber());
				System.out.println("Topic: "+s.getTopic());
				
			});
			
		} catch (ViewTheDayWiseUpdateOfEveryBatchException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	public static void GenerateReportForEveryBatch()
	{
		AdminDaoIntr adic=new AdminDaoImp();
		try {
			List<GenerateReportForEveryBatch> view=adic.generateReportForEveryBatch();
			
			view.forEach(s ->{
				System.out.println("\n=========================================================================================");
				System.out.println("Batch Id: "+s.getBatchId());
				System.out.println("Course Name: "+s.getCourseName());
				System.out.println("Course Description: "+s.getCourseDescription());
				System.out.println("Faculty Name: "+s.getFacultyname());
				System.out.println("Number Of Students: "+s.getNumberofStudents());
				System.out.println("Batchstart Date: "+s.getBatchstartDate());
				System.out.println("Duration: "+ s.getDuration());
				System.out.println("Status: "+s.getStatus());
				
			});
			
		} catch (GenerateReportForEveryBatchException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
