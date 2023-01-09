package com.learnersacademy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.dao.AdminDAO;
import com.learnersacademy.dao.ClassDAO;
import com.learnersacademy.dao.StudentDAO;
import com.learnersacademy.dao.SubjectDAO;
import com.learnersacademy.dao.TeacherDAO;
import com.learnersacademy.model.Admin;
import com.learnersacademy.model.ClassX;
import com.learnersacademy.model.Student;
import com.learnersacademy.model.Subject;
import com.learnersacademy.model.Teacher;

@WebServlet("/admin-registration-initial")
public class START_LearnersAcademy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminDAO adminDAO;
	StudentDAO studentDAO;
	SubjectDAO subjectDAO;
	TeacherDAO teacherDAO;
	ClassDAO classDAO;

	public void init(ServletConfig config) throws ServletException {
		adminDAO = new AdminDAO();
		studentDAO = new StudentDAO();
		subjectDAO = new SubjectDAO();
		teacherDAO = new TeacherDAO();
		classDAO = new ClassDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Admin starter
		Admin admin1 = new Admin("Mary", "Anderson", "mary.anderson", "moon123");
		Admin admin2 = new Admin("John", "Smith", "john.smith", "star98765");
		Admin admin3 = new Admin("Sarah", "Brown", "sarah.brown", "ps1987");
		Admin admin4 = new Admin("William", "Nelson", "william.nelson", "butterfly2022");
		adminDAO.saveAdmin(admin1);
		adminDAO.saveAdmin(admin2);
		adminDAO.saveAdmin(admin3);
		adminDAO.saveAdmin(admin4);

		// Student starter
		Student student1 = new Student("001/2022", "James", "Davis", 20);
		Student student2 = new Student("002/2022", "Elizabeth", "Nelson", 23);
		Student student3 = new Student("003/2022", "George", "Jones", 19);
		Student student4 = new Student("004/2022", "Martha", "Johnson", 21);
		Student student5 = new Student("005/2022", "Henry", "Clark", 22);
		Student student6 = new Student("006/2022", "Margaret", "Nelson", 23);
		Student student7 = new Student("007/2022", "Thomas", "Anderson", 20);
		Student student8 = new Student("008/2022", "Nancy", "Johnson", 21);
		Student student9 = new Student("009/2022", "Charles", "Miller", 19);
		Student student10 = new Student("010/2022", "Ann", "Wilson", 23);
		studentDAO.saveStudent(student1);
		studentDAO.saveStudent(student2);
		studentDAO.saveStudent(student3);
		studentDAO.saveStudent(student4);
		studentDAO.saveStudent(student5);
		studentDAO.saveStudent(student6);
		studentDAO.saveStudent(student7);
		studentDAO.saveStudent(student8);
		studentDAO.saveStudent(student9);
		studentDAO.saveStudent(student10);

		// Use those names for other instances later on
		
		// Catherine Moore
		// David Hill
		// Hannah Thompson
		// Daniel Jackson

		// teacher starter
		Teacher teacher1 = new Teacher("LA-1949-001", "Jane", "Taylor", 49);
		Teacher teacher2 = new Teacher("LA-1954-002", "Joseph", "Hernandez", 54);
		Teacher teacher3 = new Teacher("LA-1960-003", "Eliza", "Walker", 60);
		Teacher teacher4 = new Teacher("LA-1957-004", "Samuel", "Gonzalez", 57);
		teacherDAO.saveTeacher(teacher1);
		teacherDAO.saveTeacher(teacher2);
		teacherDAO.saveTeacher(teacher3);
		teacherDAO.saveTeacher(teacher4);
		
		// Subject starter
		Subject subject1 = new Subject("English", "ENG");
		Subject subject2 = new Subject("Mathematics", "MATH");
		Subject subject3 = new Subject("Chemistry", "CHEM");
		Subject subject4 = new Subject("Biology", "BIO");
		Subject subject5 = new Subject("History", "HIS");
		Subject subject6 = new Subject("Art", "ART");
		Subject subject7 = new Subject("Geography", "GEO");
		
		subjectDAO.saveSubject(subject1);
		subjectDAO.saveSubject(subject2);
		subjectDAO.saveSubject(subject3);
		subjectDAO.saveSubject(subject4);
		subjectDAO.saveSubject(subject5);
		subjectDAO.saveSubject(subject6);
		subjectDAO.saveSubject(subject7);
		
		
		//String datePattern = "dd-MM-yyyy";
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
		//Date date = simpleDateFormat.parse("25-05-2023");
			
		
		
		
		
		subject1.setClassX(subject1.getSubjectName());
		subjectDAO.updateSubject(subject1);
		student1.setClassX(subject1.getSubjectShortcut());
		student2.setClassX(subject1.getSubjectShortcut());
		studentDAO.updateStudent(student1);
		studentDAO.updateStudent(student2);
		ClassX classX1 = new ClassX(subject1.getSubjectName(), "2023-02-25");
		classDAO.saveClassX(classX1);
		
		
		
		subject2.setClassX(subject2.getSubjectName());
		subjectDAO.updateSubject(subject2);
		student3.setClassX(subject2.getSubjectShortcut());
		studentDAO.updateStudent(student3);
		ClassX classX2 = new ClassX(subject2.getSubjectName(), "2023-02-15");
		classDAO.saveClassX(classX2);

		
		
		subject3.setClassX(subject3.getSubjectName());
		subjectDAO.updateSubject(subject3);
		student4.setClassX(subject3.getSubjectShortcut());
		studentDAO.updateStudent(student4);
		ClassX classX3 = new ClassX(subject3.getSubjectName(), "2023-03-18");
		classDAO.saveClassX(classX3);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-registration-initial.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		adminAdd_thanLogin(request, response);
	}

	private void adminAdd_thanLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Creating list of all Admin from database
		List<Admin> listOfAdmin = adminDAO.getAllAdmin();

		boolean shouldSaveAdmin = true;

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Preventing duplicate username
		for (Admin admin : listOfAdmin) {
			String tempUsername = admin.getUsername();
			if (tempUsername.equalsIgnoreCase(username)) {

				shouldSaveAdmin = false;

				request.setAttribute("errorMessage", "The username you entered: > " + username + " < is already taken, please try again!");

				RequestDispatcher dispatcher = request.getRequestDispatcher("admin-registration-initial.jsp");
				// The code below will case an error but that is OK
				dispatcher.forward(request, response);

			}
		}

		if (shouldSaveAdmin) {
			Admin admin = new Admin();
			admin.setFirstName(firstName);
			admin.setLastName(lastName);
			admin.setUsername(username);
			admin.setPassword(password);

			adminDAO.saveAdmin(admin);

			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}

	}

}
