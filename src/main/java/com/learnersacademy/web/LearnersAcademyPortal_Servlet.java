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
import javax.servlet.http.HttpSession;

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

		default:
			logout(request, response);
			break;
		}

	}

	private void authenticateAdmin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (adminDAO.validateAdmin(username, password)) {

			// Creating session so we can logout properly 
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(5*60);
			session.setAttribute("username", username);
			// Print the session object in the console after creating the session.
	        System.out.println("Session after create: "+ request.getSession(false));
			
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

		// Invalidate the session.
		HttpSession session = request.getSession(false);
		session.removeAttribute("username");
		session.invalidate();
		
		// Print the session object in the console after invalidating the session.
        System.out.println("Session after invalidate: "+ request.getSession(false));
		
		request.setAttribute("errorMessage", null);

		request.setAttribute("side-menu", null);
		request.setAttribute("main-content", null);
		request.setAttribute("next-action", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

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

				request.setAttribute("errorMessage", "The username you entered is already taken, please try again!");

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
							"The username you entered is already taken, please try again!");

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
