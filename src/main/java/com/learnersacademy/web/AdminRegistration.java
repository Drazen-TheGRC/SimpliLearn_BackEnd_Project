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

@WebServlet("/admin-registration")
public class AdminRegistration extends HttpServlet {
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
		addAdmin(request, response);
	}

	private void addAdmin(HttpServletRequest request, HttpServletResponse response)
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

				RequestDispatcher dispatcher = request.getRequestDispatcher("admin-registration.jsp");
				dispatcher.forward(request, response);
			}
		}

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
