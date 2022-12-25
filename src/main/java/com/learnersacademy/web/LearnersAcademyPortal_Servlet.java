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
import com.learnersacademy.dao.StudentDAO;
import com.learnersacademy.dao.SubjectDAO;
import com.learnersacademy.model.Admin;

@WebServlet("/portal")
public class LearnersAcademyPortal_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminDAO adminDAO;
	StudentDAO studentDAO;
	SubjectDAO subjectDAO;

	public void init(ServletConfig config) throws ServletException {
		adminDAO = new AdminDAO();
		studentDAO = new StudentDAO();
		subjectDAO = new SubjectDAO();
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

		// Admin options

		// Opens Admin registration Form in the Portal
		case "admin-registration":
			adminRegistration(request, response);
			break;
		// Adds Admin to the database or asks user to try again if error
		case "adminAdd":
			adminAdd(request, response);
			break;

		default:
			logout(request, response);
			break;
		}

	}

	private void adminAdd(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Creating list of all Admin from database
		List<Admin> listOfAdmin = adminDAO.getAllAdmin();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Preventing duplicate username
		for (Admin admin : listOfAdmin) {
			String tempUsername = admin.getUsername();
			if (tempUsername.equalsIgnoreCase(username)) {

				request.setAttribute("errorMessage", "The username you entered is already taken, please try again!");

				request.setAttribute("side-menu", "");
				request.setAttribute("main-content", "");
				request.setAttribute("next-action", "");

				RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
				dispatcher.forward(request, response);
			}
		}

		Admin admin = new Admin();
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setUsername(username);
		admin.setPassword(password);

		adminDAO.saveAdmin(admin);

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "");
		request.setAttribute("main-content", "");
		request.setAttribute("next-action", "");

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);

	}

	private void adminRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", "");
		request.setAttribute("main-content", "");
		request.setAttribute("next-action", "");

		RequestDispatcher dispatcher = request.getRequestDispatcher("portal.jsp");
		dispatcher.forward(request, response);
	}

	private void authenticateAdmin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (adminDAO.validateAdmin(username, password)) {

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

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", null);
		request.setAttribute("main-content", null);
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
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
