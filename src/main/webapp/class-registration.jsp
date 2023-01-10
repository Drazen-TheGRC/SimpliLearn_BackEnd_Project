<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Class Registration</title>

</head>
<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			String loggedUser = (String)session.getAttribute("username");
			
			if(loggedUser == null){
				response.sendRedirect("login.jsp");
			}		
		%>
	<h1>Please Register a Class</h1>

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
					<label for="subjectId">Subject:</label>
				</td>
				<td>
					<select id="subjectId" name="subjectId" required>
					    <c:forEach var="subject" items="${listOfFREESubject}">
					        <option value="${subject.id}">${subject.subjectName}</option>
					    </c:forEach>
					</select>
				</td>
			</tr>
			
			
			<tr>
				<td align="right">
					<label for="teacherId">Teacher:</label>
				</td>
				<td>
					<select id="teacherId" name="teacherId" required>
					    <c:forEach var="teacher" items="${listOfFREETeacher}">
					        <option value="${teacher.id}">${teacher.firstName} ${teacher.lastName}</option>
					    </c:forEach>
					</select>
				</td>
			</tr>

			<tr>
				<td align="right">
					<label for="date">Date:</label>
				</td>
				<td>
					<input type="date" id="date" name="date" placeholder="" value="" required>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button name="next-action" value="class-add" type="submit" >Register Class</button>
				</td>
			</tr>
			
		</table>

	</form>
</body>
</html>