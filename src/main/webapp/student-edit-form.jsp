<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Student Edit Form</title>

</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		String loggedUser = (String)session.getAttribute("username");
		
		if(loggedUser == null){
			response.sendRedirect("login.jsp");
		}		
	%>
	<h1>Please Edit a Student</h1>

	<hr>
	<br>
	<form action="<%=request.getContextPath()%>/portal"	method="post">

		<h3 class="errorMessage">${errorMessage}</h3>

		<table>
			<tr>
				<th colspan="2">
					<h2>Student Edit Form</h2>
				</th>
			</tr>
			<tr>
				<td align="right">
					<label for="studentId">Student ID:</label>
				</td>
				<td>
					<input type="text" id="studentId" name="studentId" placeholder="Student ID" value="${studentId}" required>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label for="firstName">First Name:</label>
				</td>
				<td>
					<input type="text" id="firstName" name="firstName" placeholder="First Name" value="${firstName}" required>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label for="lastName">Last Name:</label>
				</td>
				<td>
					<input type="text" id="lastName" name="lastName" placeholder="Last Name" value="${lastName}" required>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label for="age">Age:</label>
				</td>
				<td>
					<input type="text" id="age" name="age" placeholder="Age" value="${age}" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input name="id" id="id" value="${id}" type="hidden" />
					<button name="next-action" value="student-edit" type="submit" >Confirm Edits</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>