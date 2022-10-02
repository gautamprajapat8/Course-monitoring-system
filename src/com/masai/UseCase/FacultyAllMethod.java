package com.masai.UseCase;

import java.util.Scanner;

import com.masai.bean.CoursePlan;
import com.masai.dao.*;
import com.masai.exceptions.CoursePlanException;

public class FacultyAllMethod {

	public static void viewCoursp()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter Course plan Id:");
		int id=sc.nextInt();
		CoursePlan c=null;
		FacultyDaoIntr fdi= new FacultyDaoImp();
		try {
			c=fdi.viewCoursePlan(id);
			System.out.println("\n==========================================");
			System.out.println("Course Plan Id: "+c.getPlanId());
			System.out.println("Course Batch Id: "+c.getBatchId());
			System.out.println("Course Day Number: "+c.getDayNumber());
			System.out.println("Course Topic: "+c.getTopic());
			System.out.println("Course Status: "+c.getStatus());
			
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			System.out.println("\n"+e.getMessage()+"\n");
		}
	}
	public static void fillup()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter Course Plane ID:");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Batch Id:");
		int bid=sc.nextInt();

		System.out.println("Enter Day Number:");
		int dayNumber=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Course plane Topic:");
		String topic=sc.nextLine();
		System.out.println("Enter Course plane Status(completed/pending):");
		String status=sc.nextLine();
		
		CoursePlan cp=new CoursePlan(id, bid, dayNumber, topic, status);
		
		FacultyDaoIntr fdi= new FacultyDaoImp();
		
		String msg=fdi.fillCoursePlan(cp);
		System.out.println("\n"+msg+"\n");
	}
	
	public static void upassword(String uname)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter new Passwors:");
		String pass=sc.nextLine();
		System.out.println("Enter again new Passwors:");
		String apass=sc.nextLine();
		
		FacultyDaoIntr fdi= new FacultyDaoImp();
		if(apass.equals(pass))
		{
			String mess=fdi.updatePassword(uname, pass);
			System.out.println(mess);
		}
		else
		{
			System.out.println("Both Password Must be same...\n");
			upassword(uname);
		}
	}
}
