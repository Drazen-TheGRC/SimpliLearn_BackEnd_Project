<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Subject Edit Form</title>

</head>
<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			String loggedUser = (String)session.getAttribute("username");
			
			if(loggedUser == null){
				response.sendRedirect("login.jsp");
			}		
		%>
	<h1>Please Edit a Subject</h1>

	<hr>
	<br>
	<form action="<%=request.getContextPath()%>/portal"	method="post">

		<h3 class="errorMessage">${errorMessage}</h3>

		<table>
			<tr>
				<th colspan="2">
					<h2>Subject Edit Form</h2>
				</th>
			</tr>
			<tr>
				<td align="right">
					<label for="subjectName">Subject Name:</label>
				</td>
				<td>
					<input type="text" id="subjectName" name="subjectName" placeholder="Subject Name" value="${subjectName}" required>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label for="subjectShortcut">Subject Shortcut:</label>
				</td>
				<td>
					<input type="text" id="subjectShortcut" name="subjectShortcut" placeholder="Subject Shortcut" value="${subjectShortcut}" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				
					<input name="id" id="id" value="${id}" type="hidden" />
					<button name="next-action" value="subject-edit" type="submit" >Confirm Edits</button>
				</td>
			</tr>
		</table>

	</form>
</body>
</html>