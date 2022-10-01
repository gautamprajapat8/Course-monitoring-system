package com.masai.main;

import java.util.Scanner;

import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;
import com.masai.dao.FacultyDaoImp;
import com.masai.dao.FacultyDaoIntr;
import com.masai.exceptions.CoursePlanException;
import com.masai.exceptions.FacultyException;

public class Mani {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		boolean start=true;
		while(start)
		{
			System.out.println("Please select type of user:-");
			System.out.println("1. Administrator");
			System.out.println("2. Faculty");
			System.out.println("3. Exit");
			int startMenu=sc.nextInt();
			sc.nextLine();
			switch(startMenu)
			{
				case 1://Administrator
					
					System.out.println("Hello Admin");
					break;
					
				case 2: //Faculty
					
					// login 
					System.out.println("Enter User name:");
					String uname=sc.nextLine();
					System.out.println("Enter Passwors:");
					String pass=sc.nextLine();
					
					Faculty f=null;
					
					FacultyDaoIntr fdi= new FacultyDaoImp();
					try
					{
						f=fdi.login(uname, pass);
						if(f!=null)
						{
							System.out.println("------------------------------------");
							System.out.println("Hello "+f.getFacultyname()+"....");
							boolean x=true;
							while(x)
							{
								System.out.println("\nPlease select menu:-");
								System.out.println("1. View the Course Plan By ID");
								System.out.println("2. Fill up the day wise planner");
								System.out.println("3. Update Your password");
								System.out.println("4. Exit");
								int fopt=sc.nextInt();
								switch(fopt)
								{
									case 1://View the Course Plan By ID
										viewCoursp();
										break;
									
									case 2://Fill up the day wise planner
										fillup();
										break;
										
									case 3:// update password
										upassword(uname);
										break;
									case 4:
										x=false;
										break;
									default:
										System.out.println("Please enter valid option");
								}
							}
						}
					}catch (FacultyException e)
					{
						
						System.out.println(e.getMessage());
					}
					break;
					
				case 3://Exit
					
					System.out.println("Thank you......");
					start=false;
					break;
					
				default:
					System.out.println("Please Enter valid Option");
			}
		}
	}
	
	
	
	public static void viewCoursp()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Course plan Id:");
		int id=sc.nextInt();
		CoursePlan c=null;
		FacultyDaoIntr fdi= new FacultyDaoImp();
		try {
			c=fdi.viewCoursePlan(id);
			System.out.println("==========================================\n");
			System.out.println("Course Plan Id: "+c.getPlanId());
			System.out.println("Course Batch Id: "+c.getBatchId());
			System.out.println("Course Day Number: "+c.getDayNumber());
			System.out.println("Course Topic: "+c.getTopic());
			System.out.println("Course Status: "+c.getStatus());
			System.out.println("==========================================\n");
			
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	public static void fillup()
	{
		Scanner sc=new Scanner(System.in);
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
		System.out.println(msg);
	}
	
	public static void upassword(String uname)
	{
		Scanner sc=new Scanner(System.in);

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
