# SimpliLearn_BackEnd_Project

![4095849_1673885365-1](https://user-images.githubusercontent.com/33057499/212729959-2ee4deb9-a49e-47e4-a7e4-fe247c0c8822.png)

SimpliLearn phase 2 backend project administrative portal for the Learner’s Academy

Developing a Backend Admin for Learner’s Academy.

DESCRIPTION

Project objective: 

As a Full Stack Developer, design and develop a backend administrative portal for the 
Learner’s Academy. Use the GitHub repository to manage the project artifacts. 

 

Background of the problem statement:

Learner’s Academy is a school that has an online management system. 
The system keeps track of its classes, subjects, students, and teachers. 
It has a back-office application with a single administrator login.

 

The administrator can:

● Set up a master list of all the subjects for all the classes

● Set up a master list of all the teachers

● Set up a master list of all the classes

● Assign classes for subjects from the master list

● Assign teachers to a class for a subject (A teacher can be assigned to different classes for different subjects)

● Get a master list of students (Each student must be assigned to a single class)

     

There will be an option to view a Class Report which will show all the information about the class, 
such as the list of students, subjects, and teachers
     
The goal of the company is to deliver a high-end quality product as early as possible. 

 

The flow and features of the application: 

● Plan more than two sprints to complete the application

● Document the flow of the application and prepare a flow chart 

● List the core concepts and algorithms being used to complete this application

● Implement the appropriate concepts, such as exceptions, collections, 

and sorting techniques for source code optimization and increased performance 



You must use the following: 

● Eclipse/IntelliJ: An IDE to code for the application 

● Java: A programming language to develop the web pages, databases, and others

● SQL: To create tables for admin, classes, students, and other specifics

● Git: To connect and push files from the local system to GitHub 

● GitHub: To store the application code and track its versions 

● Scrum: An efficient agile framework to deliver the product incrementally 

● Search and Sort techniques: Data structures used for the project 

● Specification document: Any open-source document or Google Docs 


 

The following requirements should be met: 

● The source code should be pushed to your GitHub repository. 
You need to document the steps and write the algorithms in it.

● The submission of your GitHub repository link is mandatory. 
In order to track your task, you need to share the link of the repository. 
You can add a section in your document. 

● Document the process step-by-step starting from sprint planning to the product release. 

● The application should not close, exit, or throw an exception if the user specifies an invalid input.

● You need to submit the final specification document which will include: 

● Project and developer details 

● Sprints planned and the tasks achieved in them 

● Algorithms and flowcharts of the application 

● Core concepts used in the project 

● Links to the GitHub repository to verify the project completion  

FlowChart
![flowchart phase2 drawio](https://user-images.githubusercontent.com/33057499/212483015-b1acfd97-8a6e-4c2e-9f06-f06ef9cf3a23.png)


This is the first interaction of the user with the Learners Academy Admin Portal. To see Admin registration in action we are going to register an Admin. 
![01 Admin Registration](https://user-images.githubusercontent.com/33057499/212482178-f1802fb0-22a4-408c-b86b-3bddc17e996f.png)

Login Page.
![02 Login](https://user-images.githubusercontent.com/33057499/212482223-efaa947f-1744-4aff-94a4-4bcd46c33047.png)

Login checks for username and password validation and prompts an error if there is no username and its related password in the database.
![03 Login error](https://user-images.githubusercontent.com/33057499/212482246-6c7a1f2b-eff5-44c9-a889-57d61827b3f5.png)

After successful Login we will se the Portal and its Welcome Page.
![04 Welcome Page](https://user-images.githubusercontent.com/33057499/212482262-50e941ab-90b4-410b-a920-b97137ea1bda.png)

Admin can list all Admins and manage them from the Admin List Page.
![05 Admin List](https://user-images.githubusercontent.com/33057499/212482273-1e8026f1-a105-464c-8dbe-313c0f81fac8.png)

Adding another admin from the Portal.
![06 Admin Add](https://user-images.githubusercontent.com/33057499/212482289-0c516617-ad67-402f-893c-47600973cc02.png)

In case a username already exists in the database, an error message will be shown.
![07 Admin Add error](https://user-images.githubusercontent.com/33057499/212482294-6c3b9688-6ced-4ba7-923b-f7308dc41829.png)

Admin can also edit existing Admins.
![08 Admin Edit](https://user-images.githubusercontent.com/33057499/212482305-bf582891-be1b-46ff-84ea-89936805bc6f.png)

If during Admin Edit operations a duplicate username is edited we will get and error message.
![09 Admin Edit error](https://user-images.githubusercontent.com/33057499/212482317-d6929a85-f848-4e42-b036-37bab50853a3.png)

Amin can list all the Subject and manage them through the Portal.
![10 Subject List](https://user-images.githubusercontent.com/33057499/212499294-b1a14546-3712-47af-8aa2-5c37fda61928.png)

Admin can add new Subjects to the Portal
![11 Subject Add](https://user-images.githubusercontent.com/33057499/212499301-9de78ad1-4bdf-44dc-a019-91535507fdec.png)

If Admin tries to add an existing Subject an error message will inform the user.
![12 Subject Add error](https://user-images.githubusercontent.com/33057499/212499311-6c504d7a-c769-4569-bf91-9db03de63657.png)

Subject can be also edited and edits are going to reflect the classes.
![13 Subject Edit](https://user-images.githubusercontent.com/33057499/212499320-52a06fab-0ecf-4839-9eed-36672c30b720.png)

Again, if we try to edit an existing subject to another existing subject there will be an error.
![14 Subjevt Edit error](https://user-images.githubusercontent.com/33057499/212499324-f46c7e22-692f-4834-8d23-7f82096a5871.png)

Admin can manage Teachers on the Portal viewing and manipulating Teacher List
![15 Teacher List](https://user-images.githubusercontent.com/33057499/212499328-886fdb75-21f8-4e9f-962e-0b20566b3dc0.png)

New Teachers can be added.
![16 Teacher add](https://user-images.githubusercontent.com/33057499/212499333-3e95777d-9c29-4805-8a8b-f412a0578c51.png)

Each teacher has a unique teacher accreditation ID and in case we enter a duplicate there will be an error message preventing the Admin to enter duplicates.
![17 Teacher add error](https://user-images.githubusercontent.com/33057499/212499347-b42597a6-367d-488f-a45a-2395f2d9045b.png)

Teacher info can be edited.
![18 Teacher Edit](https://user-images.githubusercontent.com/33057499/212499354-58919d2e-a73b-49da-9c5b-efe6fe43c94e.png)

When editing teacher info, we can’t enter existing teacher accreditation IDs.
![19 Teacher Edit error](https://user-images.githubusercontent.com/33057499/212499362-3aff8dce-0f11-4608-b10b-ec21305f869b.png)

Without students there would not be a need for anything so Admin can also manage Students.
![20 Student List](https://user-images.githubusercontent.com/33057499/212499370-cb6ce680-e53a-4ac2-9bab-4f784698a8b8.png)

New students can be added.
![21 Student Add](https://user-images.githubusercontent.com/33057499/212499378-bb25b2b7-b0f3-45bb-9d57-79b50d5d738d.png)

Same as with the Teacher unique accreditation ID students have their unique student IDs.
![22 Student Add error](https://user-images.githubusercontent.com/33057499/212499387-47cb3033-f164-4061-b935-85b0980c9f6c.png)

Student info can be edited.
![23 Student Edit](https://user-images.githubusercontent.com/33057499/212499394-f04255e6-9758-4e21-b02d-7b33fd8ea18e.png)

When editing students, it is important to prevent assigning already used Student IDs
![24 Student Edit error](https://user-images.githubusercontent.com/33057499/212499416-d415fe76-5040-4ea9-aee7-aa9bfed3c74f.png)

And at the end we come to Classes which are also managed based on available subjects, teachers and student.
![25 Class list](https://user-images.githubusercontent.com/33057499/212499444-d828d693-5caf-43ff-9c46-29a7d1e799dc.png)

New classes can be added.
![26 Class Add](https://user-images.githubusercontent.com/33057499/212499452-a891b75e-4675-4d41-9c82-22e60ff2babc.png)

Students can be added or removed from classes.
![27 Student Add to Class](https://user-images.githubusercontent.com/33057499/212499459-338a8115-6a13-475b-a89b-637acb6143d4.png)

And at the end it is important to be able to edit those classes.
![28 Class Edit](https://user-images.githubusercontent.com/33057499/212499476-288ba2d5-a018-4490-81db-13ce78d42e56.png)


