package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;
import com.masai.exceptions.CoursePlanException;
import com.masai.exceptions.FacultyException;
import com.masai.utility.DBUtil;
import com.mysql.cj.jdbc.ServerPreparedStatement;

public class FacultyDaoImp implements FacultyDaoIntr{

	
	
	@Override
	public Faculty login(String username, String password) throws FacultyException{
		// TODO Auto-generated method stub
		Faculty faculty=null;
		
		try( Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("select * from faculty where username=? And password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				int facultyid=rs.getInt("facultyid");
				String facultyname=rs.getString("facultyname");
				String facultyaddress=rs.getString("facultyaddress");
				String mobile=rs.getString("mobile");
				String email=rs.getString("email");
				String usernam=rs.getString("username");
				String passwor=rs.getString("password");
				
				faculty=new Faculty(facultyid, facultyname, facultyaddress, mobile, email, usernam, passwor);
			}
			else
					throw new FacultyException("Invalid Username or password......!");
			
		}
		catch (SQLException e)
		{
			throw new FacultyException(e.getMessage());
		}
		
		return faculty;
	}
	
	

	@Override
	public CoursePlan viewCoursePlan(int planId) throws CoursePlanException{
		
		CoursePlan coursePlan=null;
		
		
		try(Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("select * from CoursePlan where planId = ?");
			ps.setInt(1, planId);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				int pId =rs.getInt("planId");
				int batchId=rs.getInt("batchId");
				int dayNumber=rs.getInt("dayNumber");
				String topic=rs.getString("topic");
				String status=rs.getString("status");
				
				coursePlan=new CoursePlan(pId, batchId, dayNumber, topic, status);
				
			}
			else
			{
				throw new CoursePlanException("Course ID dose not Available......!");
			}
			
		}catch(SQLException e)
		{
			throw new CoursePlanException(e.getMessage());
		}
		
		return coursePlan;
		
	}

	
	
	@Override
	public String fillCoursePlan(CoursePlan coursePlan){
		String msg="Course Plan not fillup......!";
		try(Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("UPDATE coursePlan SET batchId=?,dayNumber=?,topic=?,status=? where planId=?");

			
			ps.setInt(1, coursePlan.getBatchId());
			ps.setInt(2, coursePlan.getDayNumber());
			ps.setString(3, coursePlan.getTopic());
			ps.setString(4, coursePlan.getStatus());
			ps.setInt(5, coursePlan.getPlanId());
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Course Plan fill uped Sucessfully......";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		
		return msg;
	}

	
	
	@Override
	public String updatePassword(String username, String password) {
		
		String msg="PassWord not updated......!";
		try(Connection conn=DBUtil.ProvideConnection())
		{
			PreparedStatement ps=conn.prepareStatement("UPDATE Faculty SET password =? WHERE username=? ");
			ps.setString(1, password);
			ps.setString(2, username);
			
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg = "\nYour PassWord is updated Sucessfully......";
			}
			
		}catch(SQLException e)
		{
			msg=e.getMessage();
		}
		
		return msg;
		
	}

	

	

}
