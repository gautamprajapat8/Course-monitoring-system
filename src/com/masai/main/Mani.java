package com.masai.main;

import java.util.Scanner;
import com.masai.bean.*;
import com.masai.dao.*;
import com.masai.exceptions.*;
import com.masai.UseCase.*;

public class Mani {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		boolean start=true;
		while(start)
		{
			System.out.println("\n\n");
			System.out.println("     ***************************************************");
			System.out.println("     *                                                 *");
			System.out.println("     *----- Welocome to Course Monitoring System ------*");
			System.out.println("     *                                                 *");
			System.out.println("     *      Please select an option to continue:-      *");
			System.out.println("     *      1. Administrator                           *");
			System.out.println("     *      2. Faculty                                 *");
			System.out.println("     *      3. Exit                                    *");
			System.out.println("     *                                                 *");
			System.out.println("     ***************************************************");
			int startMenu=sc.nextInt();
			sc.nextLine();
			switch(startMenu)
			{
				case 1://Administrator
					// login
					System.out.println("-------------------------------------------------");
					System.out.println("Enter User name:");
					String auname=sc.nextLine();
					System.out.println("Enter Password:");
					String apass=sc.nextLine();
					Admin ad=new Admin(auname, apass);
					Admin a=null;
					
					AdminDaoIntr adi=new AdminDaoImp();
					
				try {
					a=adi.login(ad);
					
					if(a!=null)
					{
						System.out.println();
						System.out.println("**Hello "+a.getUsername()+"....**");
						boolean Y=true;
						while(Y)
						{
							System.out.println("________________________________________________");
							System.out.println("Please select an option to continue:-");
							System.out.println("11. Create Course:");
							System.out.println("12. Update Course:");
							System.out.println("13. View All Course:");
							
							System.out.println("21. Create Batch:");
							System.out.println("22. Update Batch:");
							System.out.println("23. View All Batch With Course:");
							
							System.out.println("31. Create Faculty:");
							System.out.println("32. Update Faculty:");
							System.out.println("33. View All Faculty:");
							
							System.out.println("41. Allocate faculty to a batch:");
							System.out.println("42. Allocate course to a batch:");
							
							System.out.println("51. Create Course plan:");
							System.out.println("52. Update Course plan:");
							System.out.println("53. View All Course plan:");
							
							System.out.println("60. View the Day wise update of every batch:");
							
							System.out.println("70. Generate Report for every batch:");
							
							System.out.println("04. Exit");
							System.out.println("Pleas enter your option:-");
							int aopt=sc.nextInt();
							switch(aopt)
							{
								case 11://Create Course
									AdminAllMethod.CreateCourse();
									
									break;
								case 12://Update Course
									AdminAllMethod.UpdateCourse();
									
									break;
								case 13://View All Course
									AdminAllMethod.ViewAllCourse();
									
									
									
									break;
								case 21://Create Batch
									AdminAllMethod.CreateBatch();
									
									break;
								case 22://Update Batch
									AdminAllMethod.UpdateBatch();
									
									break;
								case 23://View All Batch With Course
									AdminAllMethod.ViewAllBatchWithCourse();
									
									
									
									break;
								case 31://Create Faculty
									AdminAllMethod.CreateFaculty();
									
									break;
								case 32://Update Faculty
									AdminAllMethod.UpdateFaculty();
									
									break;
								case 33://View All Faculty
									AdminAllMethod.ViewAllFaculty();
									
									
									break;
								case 41://Allocate faculty to a batch
									AdminAllMethod.allocateFacultyToBatch();
									
									break;
									
								case 42://Allocate course to a batch
									AdminAllMethod.allocateCourseToBatch();
									
									break;
									
									
								case 51://Create Course plan
									AdminAllMethod.CreateCoursePlan();
									
									break;
								case 52://Update Course plan
									AdminAllMethod.UpdateCoursePlan();
									
									break;
								case 53://View All Course plan
									AdminAllMethod.ViewAllCoursePlan();
									
									break;
									
								case 60://View the Day wise update of every batch
									AdminAllMethod.ViewTheDayWiseUpdateOfEveryBatch();
									
									break;
								
								case 70://Generate Report for every batch
									AdminAllMethod.GenerateReportForEveryBatch();
									
									break;
								
								case 4:
									Y=false;
									break;
								default:
									System.out.println("Please select a valid option...!");
							
							}
							
						}
					}
					
					
					
					
				} catch (AdminException e1) {
					
					System.out.println(e1.getMessage());
				}
					
					
					
					
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
							System.out.println();
							System.out.println("** Hello "+f.getFacultyname()+"....**");
							boolean x=true;
							while(x)
							{
								System.out.println("________________________________________________");
								System.out.println("\nPlease select an option to continue:-");
								System.out.println("1. View the Course Plan By ID");
								System.out.println("2. Fill up the day wise planner");
								System.out.println("3. Update Your password");
								System.out.println("4. Exit");
								int fopt=sc.nextInt();
								switch(fopt)
								{
									case 1://View the Course Plan By ID
										FacultyAllMethod.viewCoursp();
										break;
									
									case 2://Fill up the day wise planner
										FacultyAllMethod.fillup();
										break;
										
									case 3:// update password
										FacultyAllMethod.upassword(uname);
										break;
									case 4:
										x=false;
										break;
									default:
										System.out.println("Please select a valid option......");
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
					System.out.println("Please select a valid option...!");
			}
		}
	}
	
	
	
	
	
	
	
//	public static void main(String[] args)
//	{
//		CreateCourse();
//		UpdateCourse();
//		ViewAllCourse();
//		CreateBatch();
//		UpdateBatch();
//		ViewAllBatchWithCourse();
//		CreateFaculty();
//		UpdateFaculty();
//		ViewAllFaculty();
//		allocateFacultyToBatch();
//		CreateCoursePlan();
//		UpdateCoursePlan();
//		ViewAllCoursePlan();
//		ViewTheDayWiseUpdateOfEveryBatch();
//		GenerateReportForEveryBatch();
//	}
	

	
	






}
