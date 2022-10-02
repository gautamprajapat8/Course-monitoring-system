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




					Course Monitoring System

#Types of users:
•	Administrator.

•	Faculty


#Role of Administrator:
•	Login to his account

•	 Create, Update, View Course.

•	Create, Update, View Batch. A batch is related to a course. 

•	Create, Update, View Faculty.

•	Allocate faculty to a batch.

•	Create, Update, View Course plan.

•	View the Day wise update of every batch.

•	 Generate Report for every batch.




#Role of Faculty:

•	Login to his/her account

•	View the Course Plan

•	Fill up the day wise planner.

•	Update his/her password.



#Tables:

# Admin:
 
•	username

•	password:


#Faculty:

•	facultyid

•	facultyname

•	facultyaddress

•	mobile

•	email 

•	username

•	password


#Course:

•	coursed

•	courseName

•	fee

•	courseDescription


#Batch:

•	batchId:

•	courseId:

•	facultyId:

•	numberofStudents;

•	batchstartDate

•	duration 


#CoursPlan:

•	planId

•	batchId

•	daynumber

•	topic

•	status: completed/pending








