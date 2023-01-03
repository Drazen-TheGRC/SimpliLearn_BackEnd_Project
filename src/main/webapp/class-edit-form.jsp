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
					<h2>Class Register Form</h2>
				</th>
			</tr>
			
			<tr>
				<td align="right">
					<label for="subject">Subject:</label>
				</td>
				<td>
					<select id="subject" name="subject" required>
							<option value="${subject.subjectName}" selected>${subject.subjectName}</option>
					    <c:forEach var="subject" items="${listOfSubjectAvailable}">
					        <option value="${subject.id}">${subject.subjectName}</option>
					    </c:forEach>
					</select>
				</td>
			</tr>

			<tr>
				<td align="right">
					<label for="date">Date:</label>
				</td>
				<td>
					<input type="date" id="date" name="date" placeholder="" value="${date}" required>
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="time">Time:</label>
				</td>
				<td>
					<input type="time" id="time" name="time" placeholder="" value="${time}" min="09:00" max="18:00" step="3600" required>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				
					<input name="id" id="id" value="${id}" type="hidden" />
					<button name="next-action" value="class-edit" type="submit" >Confirm Edits</button>
				</td>
			</tr>
		</table>

	</form>
</body>
</html>