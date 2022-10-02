### Project Name:- Course Monitoring System

# Project code:- enormous-step-3337
 

 
#Domain Description:
In an educational  Institute, there are several courses running parallel every day. For every course, there are several batches at the same/different times. Every course has a session-wise/day-wise schedule. It will be difficult for the Faculty Head to know the status of every batch i.e what is the session taught each day in a batch.
So the Automated Course Monitoring System will keep the records of all the courses, batches, faculties, and the day-wise update for every batch. It will also help the Faculty Head to maintain the course plan.


### Technology used :
- java
- JDBC
- MySQL


### Team Members are :
- [Gautam kumar](https://github.com/gautamprajapat8) -Me
- [Mohit Agrawal](https://github.com/mohitagrawal22) -Manager(IA)


Clone the project

```bash
  git clone https://github.com/gautamprajapat8/enormous-step-3337.git
```


### Purpose :

After understanding the basic of JAVA & MySQL and JDBC, I just try to build the project, It is given By - [Masai school](https://github.com/masai-course) during construct week. It was individual project built by me in 6 day.




## Authors
- [Gautam Kumar](https://github.com/gautamprajapat8)


## 

								Course Monitoring System

# Types of users:
•	Administrator

•	Faculty


# Role of Administrator:
•	Login to his account

•	 Create, Update, View Course.

•	Create, Update, View Batch. A batch is related to a course. 

•	Create, Update, View Faculty.

•	Allocate faculty to a batch.

•	Create, Update, View Course plan.

•	View the Day wise update of every batch.

•	 Generate Report for every batch.




# Role of Faculty:

•	Login to his/her account

•	View the Course Plan

•	Fill up the day wise planner.

•	Update his/her password.



								Tables:

# Admin:
 
•	username

•	password:


# Faculty:

•	facultyid

•	facultyname

•	facultyaddress

•	mobile

•	email 

•	username

•	password


# Course:

•	coursed

•	courseName

•	fee

•	courseDescription


# Batch:

•	batchId:

•	courseId:

•	facultyId:

•	numberofStudents;

•	batchstartDate

•	duration 


# CoursPlan:

•	planId

•	batchId

•	daynumber

•	topic

•	status: completed/pending


# Some basic MySQL santax used By me in the project



create data Base

 create database CourseMonitoringSystem;
 
 ------------------------------------------------------------------------------------------------------------------------
 use Databse for Project
 
 use CourseMonitoringSystem;
 
 
------------------------------------------------------------------------------------------------------------------------
Tables:
==========================================================================================================================
 Create Table

	Admin:
	•	username
	•	password


 create table Admin(username varchar(25) primary key, password varchar(20) NOT NULL);
 
 -------------------------------------------------------------------------------------------------------------------------
 
	Faculty:
	•	facultyid
	•	facultyname
	•	facultyaddress
	•	mobile
	•	email 
	•	username
	•	password


create table Faculty(facultyid int primary key auto_increment, facultyname varchar(20) NOT NULL, facultyaddress varchar(25) NOT NULL, mobile varchar(10) NOT NULL, email varchar(25) NOT NULL UNIQUE, username varchar(25) NOT NULL UNIQUE,password varchar(20) NOT NULL);
 
 
 alter table Faculty auto_increment=1001;

------------------------------------------------------------------------------------------------------------------------------

	Course:
	•	courseid
	•	courseName
	•	fee
	•	courseDescription


create table Course(courseid int primary key, courseName varchar(15) NOT NULL UNIQUE, fee int NOT NULL,courseDescription varchar(60) NOT NULL);



------------------------------------------------------------------------------------------------------------------------------


Batch:
•	batchId:
•	courseId:
•	facultyId:
•	numberofStudents;
•	batchstartDate
•	duration 


create table Batch(batchId int primary key, courseId int, facultyId int, numberofStudents int NOT NULL, batchstartDate Date NOT NULL, duration varchar(12) NOT NULL, FOREIGN KEY (courseId) REFERENCES Course(courseid), FOREIGN KEY(facultyId) REFERENCES Faculty(facultyid));
 




------------------------------------------------------------------------------------------------------------------------------



CoursePlan:
•	planId
•	batchId
•	dayNumber
•	topic
•	status: completed/pending


create table CoursePlan(planId int primary key, batchId int, dayNumber int NOT NULL, topic varchar(20) NOT NULL, status varchar(10) NOT NULL, FOREIGN KEY (batchId) REFERENCES Batch(batchId));


------------------------------------------------------------------------------------------------------------------------------


insert into Admin values ('gautamprajapat8','123');
insert into Admin values ('admin','password');






select b.batchId, b.facultyId, b.numberofStudents, b.batchstartDate, b.duration, c.courseid, c.courseName, c.fee, c.courseDescription from Batch b INNER join Course c ON b.courseId=c.courseid;





•	View the Day wise update of every batch.

select b.batchId, c.courseName,courseDescription, f.facultyname, cp.dayNumber, cp.topic from Batch b INNER join Course c ON b.courseId=c.courseid INNER join faculty f on f.facultyid=b.facultyid INNER join courseplan cp ON cp.batchId=b.batchId order by b.batchId, cp.dayNumber;




•	Generate Report for every batch.

select b.batchId, c.courseName, c.courseDescription,f.facultyname , b.numberofStudents, b.batchstartDate, b.duration,cp.status from Batch b INNER join Course c ON b.courseId=c.courseid INNER join faculty f on f.facultyid=b.facultyid INNER join courseplan cp on cp.batchId =b.batchId group by batchId;


# About
in this project totle six package

- com.masai.bean 

	-in this package have eight bean class are avalable
	
	
- com.masai.dao 

	-in this package two interface and two class avalable for DAO(DATA ACCESS OBJECT)

- com.masai.exceptions
- 
	-in this package written All types of Exception which might occur during run time


- com.masai.Main

	-in this package writeen Main class with main method to run this program
	
	
- com.masai.UseCase

	-in this package writeen to Class with mulltiple method for Run program

- com.masai.utility

	-in this package writen one Class DSUtill fro make connection with database
	




Thank You to visit our project
