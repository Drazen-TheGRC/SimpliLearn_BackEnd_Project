package com.learnersacademy.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.dao.AdminDAO;
import com.learnersacademy.dao.StudentDAO;
import com.learnersacademy.dao.SubjectDAO;

@WebServlet("/admin-register")
public class AdminRegister extends HttpServlet {
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

	}

}
