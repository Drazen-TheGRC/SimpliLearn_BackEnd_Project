package com.learnersacademy.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

@WebServlet("/portal")
public class LearnersAcademyPortal_Servlet extends HttpServlet {
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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// catching next action
		String next_action = request.getParameter("next-action");
		System.out.println("Next action called is " + next_action);

		switch (next_action) {

		// Login & Logout
		// Login
		case "authenticate-admin":
			authenticateAdmin(request, response);
			break;
		// Logout
		case "logout":
			logout(request, response);
			break;
		//
		// Admin options
		//
			
		// Opens Admin registration form in the Portal
		case "admin-registration":
			adminRegistration(request, response);
			break;
		// Adds Admin to the database or asks user to try again if error
		case "admin-add":
			adminAdd(request, response);
			break;
		// Lists all Admin from the database
		case "admin-list":
			adminList(request, response);
			break;
		// Opens Admin edit form in the Portal
		case "admin-edit-form":
			adminEditForm(request, response);
			break;
		// Edits particular Admin or asks user to try again if error
		case "admin-edit":
			adminEdit(request, response);
			break;
		// Deletes particular Admin from the database
		case "admin-delete":
			adminDelete(request, response);
			break;
		//	
		// Student options
		//
			
		// Opens Student registration form in the Portal
		case "student-registration":
			studentRegistration(request, response);
			break;
		// Adds Student to the database or asks user to try again if error
		case "student-add":
			studentAdd(request, response);
			break;
		// Lists all Student from the database
		case "student-list":
			studentList(request, response);
			break;
		// Opens Student edit form in the Portal
		case "student-edit-form":
			studentEditForm(request, response);
			break;
		// Edits particular Student or asks user to try again if error
		case "student-edit":
			studentEdit(request, response);
			break;
		// Deletes particular Student from the database
		case "student-delete":
			studentDelete(request, response);
			break;
			
		//	
		// Teacher options
		//
			
		// Opens Teacher registration form in the Portal
		case "teacher-registration":
			teacherRegistration(request, response);
			break;
		// Adds teacher to the database or asks user to try again if error
		case "teacher-add":
			teacherAdd(request, response);
			break;
		// Lists all Teacher from the database
		case "teacher-list":
			teacherList(request, response);
			break;
		// Opens Teacher edit form in the Portal
		case "teacher-edit-form":
			teacherEditForm(request, response);
			break;
		// Edits particular Teacher or asks user to try again if error
		case "teacher-edit":
			teacherEdit(request, response);
			break;
		// Deletes particular Teacher from the database
		case "teacher-delete":
			teacherDelete(request, response);
			break;

		//
		// Subject options
		//
			
		// Opens Subject registration form in the Portal
		case "subject-registration":
			subjectRegistration(request, response);
			break;
		// Adds subject to the database or asks user to try again if error
		case "subject-add":
			subjectAdd(request, response);
			break;
		// Lists all Subject from the database
		case "subject-list":
			subjectList(request, response);
			break;
		// Opens Subject edit form in the Portal
		case "subject-edit-form":
			subjectEditForm(request, response);
			break;
		// Edits particular Subject or asks user to try again if error
		case "subject-edit":
			subjectEdit(request, response);
			break;
		// Deletes particular Subject from the database
		case "subject-delete":
			subjectDelete(request, response);
			break;

		//	
		// class options
		//
			
		// Opens Class registration form in the Portal
		case "class-registration":
			classXRegistration(request, response);
			break;
		// Adds Class to the database
		case "class-add":
			try {
				classXAdd(request, response);
			} catch (IOException | ServletException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		// Lists all Class from the database
		case "class-list":
			classXList(request, response);
			break;
		//List students on a particular class	
		case "class-student-list":
			classXStudentList(request, response);
			break;

		// Opens Class edit form in the Portal
		case "class-edit-form":
			try {
				classXEditForm(request, response);
			} catch (IOException | ServletException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		// Edits particular Class
		case "class-edit":
			try {
				classXEdit(request, response);
			} catch (IOException | ServletException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		// Delete particular Class from the database
		case "class-delete":
			classXDelete(request, response);
			break;

		// Remove a student from a particular class
		case "student-class-remove":
			studentClassXRemove(request, response);
			break;

		// Add a student to a class	
		case "student-class-add":
			studentClassXAdd(request, response);
			break;
		
		// Had some plans to make it show the student list for a particular class after student removal or student addition to a class, had no time to finish this on time so...	
		case "student-class-after-add":
			classXStudentListAfterAdd(request, response);
			break;

		default:
			logout(request, response);
			break;
		}

	}

	// authenticateAdmin() - this is login
	private void authenticateAdmin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (adminDAO.validateAdmin(username, password)) {

			// Creating session so we can logout properly
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(5 * 60);
			session.setAttribute("username", username);
			// Print the session object in the console after creating the session.
			System.out.println("Session after create: " + request.getSession(false));

			request.setAttribute("errorMessage", null);

			request.setAttribute("side-menu", null);
			request.setAttribute("main-content", "welcome");
			request.setAttribute("next-action", null);

			request.setAttribute("welcomeMessage", "Welcome to the Learners's Academy Portal!");

			RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
			dispatcher.forward(request, response);

		} else {

			request.setAttribute("errorMessage", "You entered wrong username or password, please try again!");

			request.setAttribute("side-menu", null);
			request.setAttribute("main-content", null);
			request.setAttribute("next-action", null);

			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	// Logout
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Invalidate the session.
		HttpSession session = request.getSession(false);
		session.removeAttribute("username");
		session.invalidate();

		// Print the session object in the console after invalidating the session.
		System.out.println("Session after invalidate: " + request.getSession(false));

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", null);
		request.setAttribute("main-content", null);
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	// Admin methods
	private void adminRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "admin");
		request.setAttribute("main-content", "admin-registration");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void adminAdd(HttpServletRequest request, HttpServletResponse response)
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

				request.setAttribute("errorMessage",
						"The username you entered: > " + username + " < is already taken, please try again!");

				request.setAttribute("side-menu", "admin");
				request.setAttribute("main-content", "admin-registration");
				request.setAttribute("next-action", null);

				RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
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

			request.setAttribute("errorMessage", null);

			adminList(request, response);
		}

	}

	private void adminList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Admin> listOfAdmin = adminDAO.getAllAdmin();

		request.setAttribute("listOfAdmin", listOfAdmin);

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "admin");
		request.setAttribute("main-content", "admin-list");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void adminEditForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		int id = Integer.parseInt(request.getParameter("id"));
		Admin existingAdmin = adminDAO.getAdmin(id);

		request.setAttribute("id", existingAdmin.getId());
		request.setAttribute("firstName", existingAdmin.getFirstName());
		request.setAttribute("lastName", existingAdmin.getLastName());
		request.setAttribute("username", existingAdmin.getUsername());
		request.setAttribute("password", existingAdmin.getPassword());

		// request.setAttribute("errorMessage", request.getAttribute("errorMessage"));

		request.setAttribute("side-menu", "admin");
		request.setAttribute("main-content", "admin-edit-form");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void adminEdit(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Admin> listOfAdmin = adminDAO.getAllAdmin();

		boolean shouldEditAdmin = true;

		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");

		for (Admin admin : listOfAdmin) {
			String tempUsername = admin.getUsername();
			// Checks if the username exists in the database
			if (tempUsername.equalsIgnoreCase(username)) {
				// If the username exists in the database it checks is if it belongs to the
				// object we are editing
				if (!username.equalsIgnoreCase(adminDAO.getAdmin(id).getUsername())) {
					// If the username exists in the database but it doesen't belong to the object
					// we are editing

					shouldEditAdmin = false;

					request.setAttribute("errorMessage",
							"The username you entered: > " + username + " < is already taken, please try again!");

					adminEditForm(request, response);
				}
			}
		}

		// Preventing duplicates
		if (shouldEditAdmin) {

			Admin admin = new Admin(Integer.parseInt(request.getParameter("id")), request.getParameter("firstName"),
					request.getParameter("lastName"), request.getParameter("username"),
					request.getParameter("password"));

			adminDAO.updateAdmin(admin);

			adminList(request, response);
		}
	}

	private void adminDelete(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// Deleting by id
		int id = Integer.parseInt(request.getParameter("id"));
		adminDAO.deleteAdmin(id);

		// Listing again
		adminList(request, response);
	}

	// Teacher methods
	private void teacherRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "teacher");
		request.setAttribute("main-content", "teacher-registration");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void teacherAdd(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Creating list of all Teacher from database
		List<Teacher> listOfTeacher = teacherDAO.getAllTeacher();

		boolean shouldSaveTeacher = true;

		String accreditationId = request.getParameter("accreditationId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));

		// Preventing duplicate accreditationId
		for (Teacher teacher : listOfTeacher) {
			String tempAccreditationId = teacher.getAccreditationId();
			if (tempAccreditationId.equalsIgnoreCase(accreditationId)) {

				shouldSaveTeacher = false;

				request.setAttribute("errorMessage", "The accreditation ID you entered: > " + accreditationId
						+ " < is already taken, please try again!");

				request.setAttribute("side-menu", "teacher");
				request.setAttribute("main-content", "teacher-registration");
				request.setAttribute("next-action", null);

				RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
				dispatcher.forward(request, response);
			}
		}

		if (shouldSaveTeacher) {
			Teacher teacher = new Teacher();
			teacher.setAccreditationId(accreditationId);
			teacher.setFirstName(firstName);
			teacher.setLastName(lastName);
			teacher.setAge(age);

			teacherDAO.saveTeacher(teacher);

			request.setAttribute("errorMessage", null);

			teacherList(request, response);
		}

	}

	private void teacherList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Teacher> listOfTeacher = teacherDAO.getAllTeacher();

		request.setAttribute("listOfTeacher", listOfTeacher);

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "teacher");
		request.setAttribute("main-content", "teacher-list");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void teacherEditForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		int id = Integer.parseInt(request.getParameter("id"));
		Teacher existingTeacher = teacherDAO.getTeacher(id);

		request.setAttribute("id", existingTeacher.getId());
		request.setAttribute("accreditationId", existingTeacher.getAccreditationId());
		request.setAttribute("firstName", existingTeacher.getFirstName());
		request.setAttribute("lastName", existingTeacher.getLastName());
		request.setAttribute("age", existingTeacher.getAge());

		request.setAttribute("side-menu", "teacher");
		request.setAttribute("main-content", "teacher-edit-form");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void teacherEdit(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Teacher> listOfTeacher = teacherDAO.getAllTeacher();

		boolean shouldEditTeacher = true;

		int id = Integer.parseInt(request.getParameter("id"));
		String accreditationId = request.getParameter("accreditationId");

		for (Teacher teacher : listOfTeacher) {
			String tempAccreditationId = teacher.getAccreditationId();
			// Checks if the accreditationId exists in the database
			if (tempAccreditationId.equalsIgnoreCase(accreditationId)) {
				// If the accreditationId exists in the database it checks is if it belongs to
				// the
				// object we are editing
				if (!accreditationId.equalsIgnoreCase(teacherDAO.getTeacher(id).getAccreditationId())) {
					// If the accreditationId exists in the database but it doesen't belong to the
					// object
					// we are editing

					shouldEditTeacher = false;

					request.setAttribute("errorMessage", "The accreditation ID you entered: > " + accreditationId
							+ " < is already taken, please try again!");

					teacherEditForm(request, response);
				}
			}
		}

		// Preventing duplicates
		if (shouldEditTeacher) {

			Teacher teacher = teacherDAO.getTeacher(Integer.parseInt(request.getParameter("id")));
			teacher.setAccreditationId(request.getParameter("accreditationId"));
			teacher.setFirstName(request.getParameter("firstName"));
			teacher.setLastName(request.getParameter("lastName"));
			teacher.setAge(Integer.parseInt(request.getParameter("age")));

			teacherDAO.updateTeacher(teacher);

			teacherList(request, response);
		}
	}

	private void teacherDelete(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// Deleting by id
		int id = Integer.parseInt(request.getParameter("id"));
		teacherDAO.deleteTeacher(id);

		// Listing again
		teacherList(request, response);
	}

	// Student methods
	private void studentRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "student");
		request.setAttribute("main-content", "student-registration");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void studentAdd(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Creating list of all Student from database
		List<Student> listOfStudent = studentDAO.getAllStudent();

		boolean shouldSaveStudent = true;

		String studentId = request.getParameter("studentId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));

		// Preventing duplicate studentId
		for (Student student : listOfStudent) {
			String tempStudentId = student.getStudentId();
			if (tempStudentId.equalsIgnoreCase(studentId)) {

				shouldSaveStudent = false;

				request.setAttribute("errorMessage",
						"The student ID you entered: > " + studentId + " < is already taken, please try again!");

				request.setAttribute("side-menu", "student");
				request.setAttribute("main-content", "student-registration");
				request.setAttribute("next-action", null);

				RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
				dispatcher.forward(request, response);
			}
		}

		if (shouldSaveStudent) {
			Student student = new Student();
			student.setStudentId(studentId);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setAge(age);

			studentDAO.saveStudent(student);

			request.setAttribute("errorMessage", null);

			studentList(request, response);
		}

	}

	private void studentList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Student> listOfStudent = studentDAO.getAllStudent();

		request.setAttribute("listOfStudent", listOfStudent);

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "student");
		request.setAttribute("main-content", "student-list");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void studentEditForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		int id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent = studentDAO.getStudent(id);

		request.setAttribute("id", existingStudent.getId());
		request.setAttribute("studentId", existingStudent.getStudentId());
		request.setAttribute("firstName", existingStudent.getFirstName());
		request.setAttribute("lastName", existingStudent.getLastName());
		request.setAttribute("age", existingStudent.getAge());

		// request.setAttribute("errorMessage", request.getAttribute("errorMessage"));

		request.setAttribute("side-menu", "student");
		request.setAttribute("main-content", "student-edit-form");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void studentEdit(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Student> listOfStudent = studentDAO.getAllStudent();

		boolean shouldEditStudent = true;

		int id = Integer.parseInt(request.getParameter("id"));
		String studentId = request.getParameter("studentId");

		for (Student student : listOfStudent) {
			String tempStudentId = student.getStudentId();
			// Checks if the studentId exists in the database
			if (tempStudentId.equalsIgnoreCase(studentId)) {
				// If the studentId exists in the database it checks is if it belongs to the
				// object we are editing
				if (!studentId.equalsIgnoreCase(studentDAO.getStudent(id).getStudentId())) {
					// If the studentId exists in the database but it doesen't belong to the object
					// we are editing

					shouldEditStudent = false;

					request.setAttribute("errorMessage",
							"The student ID you entered: > " + studentId + " < is already taken, please try again!");

					studentEditForm(request, response);
				}
			}
		}

		// Preventing duplicates
		if (shouldEditStudent) {

			Student student = studentDAO.getStudent(Integer.parseInt(request.getParameter("id")));
			student.setStudentId(request.getParameter("studentId"));
			student.setFirstName(request.getParameter("firstName"));
			student.setLastName(request.getParameter("lastName"));
			student.setAge(Integer.parseInt(request.getParameter("age")));

			studentDAO.updateStudent(student);

			studentList(request, response);
		}
	}

	private void studentDelete(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// Deleting by id
		int id = Integer.parseInt(request.getParameter("id"));
		studentDAO.deleteStudent(id);

		// Listing again
		studentList(request, response);
	}

	// Subject methods

	private void subjectRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "subject");
		request.setAttribute("main-content", "subject-registration");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void subjectAdd(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Creating list of all Subject from database
		List<Subject> listOfSubject = subjectDAO.getAllSubject();

		boolean shouldSaveSubject = true;

		String subjectName = request.getParameter("subjectName");
		String subjectShortcut = request.getParameter("subjectShortcut");

		// Preventing duplicate studentId
		for (Subject subject : listOfSubject) {
			String tempSubjectName = subject.getSubjectName();
			String tempSubjectShortcut = subject.getSubjectShortcut();

			if (tempSubjectName.equalsIgnoreCase(subjectName)
					&& tempSubjectShortcut.equalsIgnoreCase(subjectShortcut)) {

				shouldSaveSubject = false;

				request.setAttribute("errorMessage",
						"The subject name you entered: > " + subjectName + " < and the subject shortcut you entered: > "
								+ subjectShortcut + " < are both already taken, please try again!");

				request.setAttribute("side-menu", "subject");
				request.setAttribute("main-content", "subject-registration");
				request.setAttribute("next-action", null);

				RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
				dispatcher.forward(request, response);
			}

			if (tempSubjectName.equalsIgnoreCase(subjectName)) {

				shouldSaveSubject = false;

				request.setAttribute("errorMessage",
						"The subject name you entered: > " + subjectName + " < is already taken, please try again!");

				request.setAttribute("side-menu", "subject");
				request.setAttribute("main-content", "subject-registration");
				request.setAttribute("next-action", null);

				RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
				dispatcher.forward(request, response);
			}

			if (tempSubjectShortcut.equalsIgnoreCase(subjectShortcut)) {

				shouldSaveSubject = false;

				request.setAttribute("errorMessage", "The subject shortcut you entered: > " + subjectShortcut
						+ " < is already taken, please try again!");

				request.setAttribute("side-menu", "subject");
				request.setAttribute("main-content", "subject-registration");
				request.setAttribute("next-action", null);

				RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
				dispatcher.forward(request, response);
			}
		}

		if (shouldSaveSubject) {
			Subject subject = new Subject();
			subject.setSubjectName(subjectName);
			subject.setSubjectShortcut(subjectShortcut);

			subjectDAO.saveSubject(subject);

			request.setAttribute("errorMessage", null);

			subjectList(request, response);
		}

	}

	private void subjectList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Subject> listOfSubject = subjectDAO.getAllSubject();

		request.setAttribute("listOfSubject", listOfSubject);

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "subject");
		request.setAttribute("main-content", "subject-list");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void subjectEditForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		int id = Integer.parseInt(request.getParameter("id"));
		Subject existingSubject = subjectDAO.getSubject(id);

		request.setAttribute("id", existingSubject.getId());
		request.setAttribute("subjectName", existingSubject.getSubjectName());
		request.setAttribute("subjectShortcut", existingSubject.getSubjectShortcut());

		// request.setAttribute("errorMessage", request.getAttribute("errorMessage"));

		request.setAttribute("side-menu", "subject");
		request.setAttribute("main-content", "subject-edit-form");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void subjectEdit(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Subject> listOfSubject = subjectDAO.getAllSubject();

		boolean shouldEditSubject = true;

		int id = Integer.parseInt(request.getParameter("id"));

		String subjectName = request.getParameter("subjectName");
		String subjectShortcut = request.getParameter("subjectShortcut");

		// Preventing duplicate studentId
		for (Subject subject : listOfSubject) {

			String tempSubjectName = subject.getSubjectName();
			String tempSubjectShortcut = subject.getSubjectShortcut();

			if (tempSubjectName.equalsIgnoreCase(subjectName)
					&& tempSubjectShortcut.equalsIgnoreCase(subjectShortcut)) {

				if (!subjectName.equalsIgnoreCase(subjectDAO.getSubject(id).getSubjectName())
						&& !tempSubjectShortcut.equalsIgnoreCase(subjectDAO.getSubject(id).getSubjectShortcut())) {
					// If the subjectName and subjectShortcut exist in the database but it doesen't
					// belong to the
					// object
					// we are editing

					shouldEditSubject = false;

					request.setAttribute("errorMessage",
							"The subject name you entered: > " + subjectName
									+ " < and the subject shortcut you entered: > " + subjectShortcut
									+ " < are both already taken, please try again!");

					subjectEditForm(request, response);
				}

			}

			if (tempSubjectName.equalsIgnoreCase(subjectName)) {
				// If the subjectName exists in the database it checks is if it belongs to the
				// object we are editing
				if (!subjectName.equalsIgnoreCase(subjectDAO.getSubject(id).getSubjectName())) {
					// If the subjectName exists in the database but it doesen't belong to the
					// object
					// we are editing

					shouldEditSubject = false;

					request.setAttribute("errorMessage", "The subject name you entered: > " + subjectName
							+ " < is already taken, please try again!");

					subjectEditForm(request, response);
				}
			}

			if (tempSubjectShortcut.equalsIgnoreCase(subjectShortcut)) {
				// If the subjectShortcut exists in the database it checks is if it belongs to
				// the
				// object we are editing
				if (!subjectShortcut.equalsIgnoreCase(subjectDAO.getSubject(id).getSubjectShortcut())) {
					// If the subjectShortcut exists in the database but it doesen't belong to the
					// object
					// we are editing

					shouldEditSubject = false;

					request.setAttribute("errorMessage", "The subject shortcut you entered: > " + subjectShortcut
							+ " < is already taken, please try again!");

					subjectEditForm(request, response);
				}
			}
		}

		// Preventing duplicates
		if (shouldEditSubject) {

			Subject subject = subjectDAO.getSubject(Integer.parseInt(request.getParameter("id")));

			subject.setSubjectName(request.getParameter("subjectName"));
			subject.setSubjectShortcut(request.getParameter("subjectShortcut"));

			subjectDAO.updateSubject(subject);

			subjectList(request, response);
		}
	}

	private void subjectDelete(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// Deleting by id

		List<ClassX> listOfClassX = classDAO.getAllClassX();

		for (ClassX classX : listOfClassX) {
			if (classX.getSubject().getSubjectName().equalsIgnoreCase(
					subjectDAO.getSubject(Integer.parseInt(request.getParameter("id"))).getSubjectName())) {
				classDAO.deleteClassX(classX.getId());
			}
		}

		int id = Integer.parseInt(request.getParameter("id"));
		subjectDAO.deleteSubject(id);

		// Listing again
		subjectList(request, response);
	}

	// ClassX methods

	private void classXRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Subject> listOfAllSubject = subjectDAO.getAllSubject();
		List<Subject> listOfFREESubject = new ArrayList<>();
		;
		for (Subject subject : listOfAllSubject) {
			if (subject.getClassX() == null) {
				listOfFREESubject.add(subject);
			}
		}
		if (listOfFREESubject.isEmpty()) {
			subjectRegistration(request, response);
		}
		request.setAttribute("listOfFREESubject", listOfFREESubject);

		List<Teacher> listOfAllTeacher = teacherDAO.getAllTeacher();
		List<Teacher> listOfFREETeacher = new ArrayList<>();
		;
		for (Teacher teacher : listOfAllTeacher) {
			if (teacher.getClassX() == null) {
				listOfFREETeacher.add(teacher);
			}
		}
		if (listOfFREETeacher.isEmpty()) {
			teacherRegistration(request, response);
		}
		request.setAttribute("listOfFREETeacher", listOfFREETeacher);

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "class");
		request.setAttribute("main-content", "class-registration");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void classXAdd(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ParseException {

		ClassX classX = new ClassX();

		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		Subject subject = subjectDAO.getSubject(subjectId);
		classX.setSubjectId(subject.getId());

		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		Teacher teacher = teacherDAO.getTeacher(teacherId);
		classX.setTeacherId(teacher.getId());

		String date = request.getParameter("date");
		Date dateFromJSP = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String dateFormated = dateFormat.format(dateFromJSP);
		classX.setDate(dateFormated);

		subject.setClassX(classX.getSubject().getSubjectName());
		subjectDAO.updateSubject(subject);

		teacher.setClassX(classX.getSubject().getSubjectName());
		teacherDAO.updateTeacher(teacher);

		// Saving Class
		classDAO.saveClassX(classX);

		request.setAttribute("errorMessage", null);

		classXList(request, response);

	}

	private void classXList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<ClassX> listOfClassX = classDAO.getAllClassX();

		request.setAttribute("listOfClassX", listOfClassX);

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "class");
		request.setAttribute("main-content", "class-list");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void classXEditForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ParseException {

		int id = Integer.parseInt(request.getParameter("id"));
		ClassX classX = classDAO.getClassX(id);

		request.setAttribute("id", classX.getId());

		request.setAttribute("subjectSelected", classX.getSubject());
		List<Subject> listOfAllSubject = subjectDAO.getAllSubject();
		List<Subject> listOfFREESubject = new ArrayList<>();
		;
		for (Subject subject : listOfAllSubject) {
			if (subject.getClassX() == null) {
				listOfFREESubject.add(subject);
			}
		}
		if (listOfFREESubject.isEmpty()) {
			subjectRegistration(request, response);
		}
		request.setAttribute("listOfFREESubject", listOfFREESubject);

		request.setAttribute("teacherSelected", classX.getTeacher());
		List<Teacher> listOfAllTeacher = teacherDAO.getAllTeacher();
		List<Teacher> listOfFREETeacher = new ArrayList<>();
		;
		for (Teacher teacher : listOfAllTeacher) {
			if (teacher.getClassX() == null) {
				listOfFREETeacher.add(teacher);
			}
		}
		if (listOfFREETeacher.isEmpty()) {
			teacherRegistration(request, response);
		}
		request.setAttribute("listOfFREETeacher", listOfFREETeacher);

		String date = classX.getDate();
		Date dateFromDB = new SimpleDateFormat("dd-MMM-yyyy").parse(date);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormated = dateFormat.format(dateFromDB);

		request.setAttribute("date", dateFormated);

		// request.setAttribute("errorMessage", request.getAttribute("errorMessage"));

		request.setAttribute("side-menu", "class");
		request.setAttribute("main-content", "class-edit-form");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void classXEdit(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ParseException {

		// if no changes all ok for each subject, teacher, and students
		// if there are changes in that case we need to clean all of them and assign new
		// values
		// We need to update classX

		ClassX classX = new ClassX();
		classX = classDAO.getClassX(Integer.parseInt(request.getParameter("id")));

		// If Teacher change

		if (classX.getTeacherId() != Integer.parseInt(request.getParameter("teacherId"))) {

			Teacher oldTeacher = classX.getTeacher();

			if (oldTeacher != null) {
				oldTeacher.setClassX(null);
				teacherDAO.updateTeacher(oldTeacher);
			}

			Teacher newTeacher = teacherDAO.getTeacher(Integer.parseInt(request.getParameter("teacherId")));
			newTeacher.setClassX(
					subjectDAO.getSubject(Integer.parseInt(request.getParameter("subjectId"))).getSubjectName());
			teacherDAO.updateTeacher(newTeacher);

			classX.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
		}

		// if subject changed need to update the subject, need to update teacher, need
		// to update students
		if (!classX.getSubject().getSubjectName().equalsIgnoreCase(
				subjectDAO.getSubject(Integer.parseInt(request.getParameter("subjectId"))).getSubjectName())) {

			// Updating all students
			List<Student> listOfAllStudent = studentDAO.getAllStudent();
			for (Student student : listOfAllStudent) {
				if (student.getClassX() != null
						&& student.getClassX().equalsIgnoreCase(classX.getSubject().getSubjectName())) {

					student.setClassX(subjectDAO.getSubject(Integer.parseInt(request.getParameter("subjectId")))
							.getSubjectName());
					studentDAO.updateStudent(student);
				}
			}

			// Updating teacher
			List<Teacher> listOfAllTeacher = teacherDAO.getAllTeacher();
			for (Teacher teacher : listOfAllTeacher) {
				if (teacher.getClassX() != null
						&& teacher.getClassX().equalsIgnoreCase(classX.getSubject().getSubjectName())) {

					teacher.setClassX(subjectDAO.getSubject(Integer.parseInt(request.getParameter("subjectId")))
							.getSubjectName());
					teacherDAO.updateTeacher(teacher);
				}
			}

			// Updating subject
			List<Subject> listOfAllSubject = subjectDAO.getAllSubject();
			for (Subject subject : listOfAllSubject) {
				if (subject.getClassX() != null
						&& subject.getClassX().equalsIgnoreCase(classX.getSubject().getSubjectName())) {

					subject.setClassX(null);
					subjectDAO.updateSubject(subject);
				}
			}
			// end of updates regarding subject change except updating classX that needs to
			// be updated at the end of the method

			Subject subject = subjectDAO.getSubject(Integer.parseInt(request.getParameter("subjectId")));
			subject.setClassX(
					subjectDAO.getSubject(Integer.parseInt(request.getParameter("subjectId"))).getSubjectName());
			subjectDAO.updateSubject(subject);
			classX.setSubjectId(Integer.parseInt(request.getParameter("subjectId")));
		}

		// Setting date
		String date = request.getParameter("date");
		Date dateFromJSP = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String dateFormated = dateFormat.format(dateFromJSP);
		classX.setDate(dateFormated);

		// Update Class
		classDAO.updateClassX(classX);

		request.setAttribute("errorMessage", null);

		classXList(request, response);
	}

	private void classXDelete(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// First remove all related info in all subject teacher and students Make
		// methods clean subject class and students
		// and call them below those should list all students and if classX is eaqual to
		// class name than classX = null

		ClassX classX = classDAO.getClassX(Integer.parseInt(request.getParameter("id")));

		// Cleaning Subject ClassX
		List<Subject> listOfAllSubject = subjectDAO.getAllSubject();
		for (Subject subject : listOfAllSubject) {
			if (subject.getClassX() != null) {
				if (subject.getClassX().equalsIgnoreCase(classX.getSubject().getSubjectName())) {
					subject.setClassX(null);
					subjectDAO.updateSubject(subject);
				}
			}
		}

		// Cleaning Student ClassX
		List<Student> listOfAllStudent = studentDAO.getAllStudent();
		for (Student student : listOfAllStudent) {
			if (student.getClassX() != null) {
				if (student.getClassX().equalsIgnoreCase(classX.getSubject().getSubjectName())) {
					student.setClassX(null);
					studentDAO.updateStudent(student);
				}
			}
		}

		// Cleaning Teacher ClassX
		List<Teacher> listOfAllTeacher = teacherDAO.getAllTeacher();
		for (Teacher teacher : listOfAllTeacher) {
			if (teacher.getClassX() != null) {
				if (teacher.getClassX().equalsIgnoreCase(classX.getSubject().getSubjectName())) {
					teacher.setClassX(null);
					teacherDAO.updateTeacher(teacher);
				}
			}
		}

		// Deleting by id
		int id = Integer.parseInt(request.getParameter("id"));
		classDAO.deleteClassX(id);

		// Listing again
		classXList(request, response);
	}

	private void classXStudentList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// get ID of Class and use it to get students on that class
		// Also get all free students

		// All Students
		List<Student> listOfAllStudent = studentDAO.getAllStudent();

		// Students on class

		ClassX classX = null;
		HttpSession session = request.getSession();
		if (request.getParameter("id") != null) {
			session.setAttribute("id", request.getParameter("id"));
			classX = classDAO.getClassX(Integer.parseInt(request.getParameter("id")));
		} else {

			classX = classDAO.getClassX(Integer.parseInt((String) session.getAttribute("id")));

		}

		List<Student> listOfAllStudentOnClass = new ArrayList<>();
		;
		for (Student student : listOfAllStudent) {

			if (student.getClassX() != null) {
				if (student.getClassX().equalsIgnoreCase(classX.getSubject().getSubjectName())) {
					listOfAllStudentOnClass.add(student);
				}
			}
		}

		// Free students
		List<Student> listOfFREEStudent = new ArrayList<>();
		;
		for (Student student : listOfAllStudent) {
			if (student.getClassX() == null) {
				listOfFREEStudent.add(student);
			}
		}

		request.setAttribute("classX", classX);

		request.setAttribute("listOfAllStudentOnClass", listOfAllStudentOnClass);
		request.setAttribute("listOfFREEStudent", listOfFREEStudent);

		request.setAttribute("subject", classX.getSubject());
		request.setAttribute("teacher", classX.getTeacher());

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "class");
		request.setAttribute("main-content", "class-student-list");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void studentClassXRemove(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// HttpSession session = request.getSession();
		// ClassX classX =
		// classDAO.getClassX(Integer.parseInt(request.getParameter("classXId")));
		// session.setAttribute("id", classX.getId());

		//ClassX classX = classDAO.getClassX(Integer.parseInt(request.getParameter("classXId")));

		Student student = studentDAO.getStudent(Integer.parseInt(request.getParameter("id")));

		student.setClassX(null);
		studentDAO.updateStudent(student);

		// request.setAttribute("classX", classX);
		// RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		// dispatcher.forward(request, response);

		classXList(request, response);
		// classXStudentList(request, response);
	}

	private void studentClassXAdd(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// HttpSession session = request.getSession();
		// ClassX classX =
		// classDAO.getClassX(Integer.parseInt(request.getParameter("classXId")));
		// session.setAttribute("id", classX.getId());

		ClassX classX = classDAO.getClassX(Integer.parseInt(request.getParameter("classXId")));

		Student student = studentDAO.getStudent(Integer.parseInt(request.getParameter("studentId")));

		student.setClassX(classX.getSubject().getSubjectName());
		studentDAO.updateStudent(student);

		// request.setAttribute("classX", classX);

		// RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		// dispatcher.forward(request, response);

		classXList(request, response);
		// classXStudentList(request, response);

	}

	// Had some plans to make it show the student list for a particular class after student removal or student addition to a class, had no time to finish this on time so...	
	private void classXStudentListAfterAdd(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// get ID of Class and use it to get students on that class
		// Also get all free students

		// All Students
		List<Student> listOfAllStudent = studentDAO.getAllStudent();

		// Students on class
		ClassX classX = (ClassX) request.getAttribute("classX");

		List<Student> listOfAllStudentOnClass = new ArrayList<>();
		;
		for (Student student : listOfAllStudent) {

			if (student.getClassX() != null) {
				if (student.getClassX().equalsIgnoreCase(classX.getSubject().getSubjectName())) {
					listOfAllStudentOnClass.add(student);
				}
			}
		}

		// Free students
		List<Student> listOfFREEStudent = new ArrayList<>();
		;
		for (Student student : listOfAllStudent) {
			if (student.getClassX() == null) {
				listOfFREEStudent.add(student);
			}
		}

		request.setAttribute("classXId", classX.getId());
		request.setAttribute("listOfAllStudentOnClass", listOfAllStudentOnClass);
		request.setAttribute("listOfFREEStudent", listOfFREEStudent);
		request.setAttribute("subjectName", classX.getSubject().getSubjectName());
		request.setAttribute("teacherName",
				classX.getTeacher().getFirstName() + " " + classX.getTeacher().getLastName());
		request.setAttribute("date", classX.getDate());

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "class");
		request.setAttribute("main-content", "class-student-list");
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unused")
	private void skeletonMethod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "");
		request.setAttribute("main-content", "");
		request.setAttribute("next-action", "");

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

}
