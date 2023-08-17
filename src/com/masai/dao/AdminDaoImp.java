package com.masai.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.*;
import com.masai.exceptions.*;
import com.masai.utility.DBUtil;

public class AdminDaoImp implements AdminDaoIntr{

	@Override
	public Admin login(Admin admin) throws AdminException {
		Admin admins=null;
		try( Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("select * from Admin"
					+ " where username=? And password=?");
			
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				String usernam=rs.getString("username");
				String passwor=rs.getString("password");
				
				admins=new Admin(usernam, passwor);
			}
			else
					throw new AdminException("Invalid Username or password...");
			
		}
		catch (SQLException e)
		{
			throw new AdminException(e.getMessage());
		}
		
		return admins;
	}

	@Override
	public String createCourse(Course course) {
		String msg="Course not Created......!";
		
		try(Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("insert into Course(courseid,courseName,fee,courseDescription) values(?,?,?,?)");

			ps.setInt(1, course.getCourseid());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getFee());
			ps.setString(4, course.getCourseDescription());
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Course Created Sucessfully......";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public String updateCourse(Course course) {
		String msg="Course not updated......!";
		
		try(Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("UPDATE Course SET courseName= ?, fee=?, courseDescription=?  WHERE courseid=? ");

			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getFee());
			ps.setString(3, course.getCourseDescription());
			ps.setInt(4, course.getCourseid());
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Course updated Sucessfully......";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		
		
		return msg;

	}

	@Override
	public List<Course> viewAllCourse() throws CourseException{

		List<Course> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from Course");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int courseid=rs.getInt("courseid");
				String courseName=rs.getString("courseName");
				int fee =rs.getInt("fee");
				String courseDescription=rs.getString("courseDescription");
				
				Course course=new Course(courseid, courseName, fee, courseDescription);
				
				list.add(course);
			}
		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		
		if(list.size() == 0)
			throw new CourseException("Course not available......!");
		
		return list;
	}

	
	@Override
	public String createBatch(Batch batch) {
		String msg="Batch not Created......!";
		
		try(Connection conn=DBUtil.ProvideConnection())
		{
//			PreparedStatement ps=conn.prepareStatement("insert into Batch(batchId,courseId,facultyId,numberofStudents,batchstartDate,duration) values(?,?,?,?,?,?)");
//
//			ps.setInt(1, batch.getBatchId());
//			ps.setInt(2, batch.getCourseId());
//			ps.setInt(3, batch.getFacultyId());
//			ps.setInt(4, batch.getNumberofStudents());
//			ps.setString(5, batch.getBatchstartDate());
//			ps.setString(6, batch.getDuration());
			
			PreparedStatement ps=conn.prepareStatement("insert into Batch(batchId,courseId,facultyId,numberofStudents,batchstartDate,duration) values(?,null,null,?,?,?)");

			ps.setInt(1, batch.getBatchId());
			ps.setInt(2, batch.getNumberofStudents());
			ps.setString(3, batch.getBatchstartDate());
			ps.setString(4, batch.getDuration());
			
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Batch Created Sucessfully......!";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public String updateBatch(Batch batch) {
		String msg="Batch not updated......!";
		
		try(Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("UPDATE Batch SET courseId= ?, facultyId=?, numberofStudents=?, batchstartDate=?, duration=? WHERE batchId=? ");
			ps.setInt(1, batch.getCourseId());
			ps.setInt(2, batch.getFacultyId());
			ps.setInt(3, batch.getNumberofStudents());
			ps.setString(4, batch.getBatchstartDate());
			ps.setString(5, batch.getDuration());
			ps.setInt(6, batch.getBatchId());
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Batch updated Sucessfully......!";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		return msg;
		
	}

	@Override
	public List<Batch_Course> viewAllBatch() throws BatchCourseException{
		List<Batch_Course> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select b.batchId, b.facultyId, b.numberofStudents, b.batchstartDate, b.duration, c.courseid, c.courseName, c.fee, c.courseDescription from Batch b INNER join Course c ON b.courseId=c.courseid");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int batchId=rs.getInt("batchId");
				int facultyId=rs.getInt("facultyId");
				int numberofStudents=rs.getInt("numberofStudents");
				String batchstartDate=rs.getString("batchstartDate");
				String duration=rs.getString("duration");
				
				int courseid=rs.getInt("courseid");
				String courseName=rs.getString("courseName");
				int fee=rs.getInt("fee");
				String courseDescription=rs.getString("courseDescription");
				
				Batch_Course bc=new Batch_Course(batchId, facultyId, numberofStudents, batchstartDate, duration, courseid, courseName, fee, courseDescription);
				list.add(bc);
			}
		} catch (SQLException e) {
			throw new BatchCourseException(e.getMessage());
		}
		
		if(list.size() == 0)
			throw new BatchCourseException("Batch not available......!");
		
		return list;
	}

	@Override
	public String createFaculty(Faculty faculty) {
		String msg="Faculty not Created......!";
		
		try(Connection conn=DBUtil.ProvideConnection())
		{
//			PreparedStatement ps=conn.prepareStatement("insert into Faculty(facultyid, facultyname, facultyaddress, mobile, email, username, password) values(?,?,?,?,?,?,?)");
//
//			ps.setInt(1, faculty.getFacultyid());
//			ps.setString(2, faculty.getFacultyname());
//			ps.setString(3, faculty.getFacultyaddress());
//			ps.setString(4, faculty.getMobile());
//			ps.setString(5, faculty.getEmail());
//			ps.setString(6, faculty.getUsername());
//			ps.setString(7, faculty.getPassword());
			
			
			PreparedStatement ps=conn.prepareStatement("insert into Faculty(facultyname, facultyaddress, mobile, email, username, password) values(?,?,?,?,?,?)");

			ps.setString(1, faculty.getFacultyname());
			ps.setString(2, faculty.getFacultyaddress());
			ps.setString(3, faculty.getMobile());
			ps.setString(4, faculty.getEmail());
			ps.setString(5, faculty.getUsername());
			ps.setString(6, faculty.getPassword());
			
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Faculty Created Sucessfully......";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		return msg;
	}

	@Override
	public String updateFaculty(Faculty faculty) {
		String msg="Faculty not updated......!";
		
		try(Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("UPDATE Faculty SET facultyname= ?, facultyaddress=?, mobile=?, email=?, username=?, password=? WHERE facultyid=? ");
			
			ps.setString(1, faculty.getFacultyname());
			ps.setString(2, faculty.getFacultyaddress());
			ps.setString(3, faculty.getMobile());
			ps.setString(4, faculty.getEmail());
			ps.setString(5, faculty.getUsername());
			ps.setString(6, faculty.getPassword());
			ps.setInt(7, faculty.getFacultyid());
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Faculty updated Sucessfully......";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		return msg;
	}

	@Override
	public List<Faculty> viewAllFaculty() throws FacultyException{
		List<Faculty> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from Faculty");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int facultyid =rs.getInt("facultyid");
				String facultyname=rs.getString("facultyname");
				String facultyaddress=rs.getString("facultyaddress");
				String mobile=rs.getString("mobile");
				String email=rs.getString("email");
				String username=rs.getString("username");
				String password=rs.getString("password");
				
				Faculty faculty=new Faculty(facultyid, facultyname, facultyaddress, mobile, email, username, password);
				
				list.add(faculty);
				
			}
		} catch (SQLException e) {
			throw new FacultyException(e.getMessage());
		}
		
		if(list.size() == 0)
			throw new FacultyException("Faculty not available......!");
		
		return list;
	}

	
	
	@Override
	public String AllocateFacultyToBatch(int facultyId, int batchId) {
		String msg="Faculty not allocated to batch ......!";
		
		try(Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("UPDATE Batch SET facultyId=? WHERE batchId=? ");
			ps.setInt(1, facultyId);
			ps.setInt(2, batchId);
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Faculty allocated to batch Sucessfully......!";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		return msg;
	}
	
	
	
	
	
	@Override
	public String AllocateCourseToBatch(int courseId, int batchId) {
		String msg="Course not allocated to batch ......!";
		
		try(Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("UPDATE Batch SET courseId=? WHERE batchId=? ");
			ps.setInt(1, courseId);
			ps.setInt(2, batchId);
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Course allocated to batch Sucessfully......!";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		return msg;
	}
	
	
	
	

	@Override
	public String createCoursePlan(CoursePlan coursePlan) {
String msg="Course Plan not Created......!";
		
		try(Connection conn=DBUtil.ProvideConnection())
		{
//			PreparedStatement ps=conn.prepareStatement("insert into CoursePlan(planId,batchId,dayNumber,topic, status) values(?,?,?,?,?)");
//
//			ps.setInt(1, coursePlan.getPlanId());
//			ps.setInt(2, coursePlan.getBatchId());
//			ps.setInt(3, coursePlan.getDayNumber());
//			ps.setString(4, coursePlan.getTopic());
//			ps.setString(5, coursePlan.getStatus());
			
			PreparedStatement ps=conn.prepareStatement("insert into CoursePlan(planId,batchId,dayNumber,topic, status) values(?,null,?,?,?)");

			ps.setInt(1, coursePlan.getPlanId());
			ps.setInt(2, coursePlan.getDayNumber());
			ps.setString(3, coursePlan.getTopic());
			ps.setString(4, coursePlan.getStatus());
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Course Plan Created Sucessfully......!";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		return msg;
	}

	@Override
	public String updateCoursePlan(CoursePlan coursePlan) {
		String msg="Course Plan not updated......!";
		
		try(Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("UPDATE coursePlan SET batchId= ?, dayNumber=?, topic=?,status=?   WHERE planId=? ");

			ps.setInt(1,coursePlan.getBatchId());
			ps.setInt(2, coursePlan.getDayNumber());
			ps.setString(3, coursePlan.getTopic());
			ps.setString(4, coursePlan.getStatus());
			ps.setInt(5,coursePlan.getPlanId());
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Course Plane updated Sucessfully......";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		
		
		return msg;
	}

	
	@Override
	public List<CoursePlan> viewAllCoursePlan() throws CoursePlanException{
		List<CoursePlan> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from CoursePlan");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int planId=rs.getInt("planId");
				int batchId=rs.getInt("batchId");
				int dayNumber=rs.getInt("dayNumber");
				String topic=rs.getString("topic");
				String status=rs.getString("status");
				
				CoursePlan coursePlan=new CoursePlan(planId, batchId, dayNumber, topic, status);
				
				list.add(coursePlan);
				
			}
		} catch (SQLException e) {
			throw new CoursePlanException(e.getMessage());
		}
		
		if(list.size() == 0)
			throw new CoursePlanException("Course Plan not available......!");
		
		return list;
	}

	@Override
	public List<ViewTheDayWiseUpdateOfEveryBatch> viewDayWiseUpdateOfEveryBatch() throws ViewTheDayWiseUpdateOfEveryBatchException{
		List<ViewTheDayWiseUpdateOfEveryBatch> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select b.batchId, c.courseName,c.courseDescription, f.facultyname,cp.dayNumber, cp.topic from Batch b INNER join Course c ON b.courseId=c.courseid INNER join faculty f on f.facultyid=b.facultyid INNER join courseplan cp ON cp.batchId=b.batchId order by b.batchId, cp.dayNumber");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int batchId=rs.getInt("b.batchId");
				String courseName=rs.getString("c.courseName");
				String courseDescription=rs.getString("c.courseDescription");
				String facultyname=rs.getString("f.facultyname");
				int  dayNumber=rs.getInt("cp.dayNumber");
				String topic=rs.getString("cp.topic");
				
				ViewTheDayWiseUpdateOfEveryBatch view=new ViewTheDayWiseUpdateOfEveryBatch(batchId, courseName, courseDescription, facultyname, dayNumber, topic);
				
				list.add(view);
				
			}
		} catch (SQLException e) {
			throw new ViewTheDayWiseUpdateOfEveryBatchException(e.getMessage());
		}
		
		if(list.size() == 0)
			throw new ViewTheDayWiseUpdateOfEveryBatchException("Bathch not available......!");
		
		return list;
		
	}

	@Override
	public List<GenerateReportForEveryBatch> generateReportForEveryBatch() throws GenerateReportForEveryBatchException {
		List<GenerateReportForEveryBatch> list=new ArrayList<>();
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select b.batchId, c.courseName, c.courseDescription,f.facultyname , b.numberofStudents, b.batchstartDate, b.duration,cp.status from Batch b INNER join Course c ON b.courseId=c.courseid INNER join faculty f on f.facultyid=b.facultyid INNER join courseplan cp on cp.batchId =b.batchId group by batchId");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int batchId=rs.getInt("b.batchId");
				String courseName=rs.getString("c.courseName");
				String courseDescription=rs.getString("c.courseDescription");
				String facultyname =rs.getString("f.facultyname");
				int numberofStudents=rs.getInt("b.numberofStudents");;
				String batchstartDate=rs.getString("b.batchstartDate");
				String duration =rs.getString("b.duration");
				String status =rs.getString("cp.status");
				
				GenerateReportForEveryBatch view=new GenerateReportForEveryBatch(batchId, courseName, courseDescription, facultyname, numberofStudents, batchstartDate, duration, status);
				
				list.add(view);
				
			}
		} catch (SQLException e) {
			throw new GenerateReportForEveryBatchException(e.getMessage());
		}
		
		if(list.size() == 0)
			throw new GenerateReportForEveryBatchException("Bathch not available......!");
		
		return list;
	}
	
	

}
