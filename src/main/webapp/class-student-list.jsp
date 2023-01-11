<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Class Info</title>

</head>
<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			String loggedUser = (String)session.getAttribute("username");
			
			if(loggedUser == null){
				response.sendRedirect("login.jsp");
			}		
		%>
		<h1>${subjectName} Class Details:</h1>

	<hr>
	<br>

	<table>
		<tr>
			<td align="center" colspan="3" >
				<h4>Teacher: ${teacherName}</h4>
			</td>
			<td align="center" colspan="2" >
				<h4>Date: ${date}</h4>
			</td>
		</tr>
		
		<tr>
			<th colspan="5">
				<h2 >Student List:</h2>
			</th>
		</tr>
		<tr>
			
			<th>Student ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			
			<th>Remove from Class</th>
		</tr>
		<c:forEach var="student" items="${listOfAllStudentOnClass}">
			<tr>
				
				<td><c:out value="${student.studentId}" /></td>
				<td><c:out value="${student.firstName}" /></td>
				<td><c:out value="${student.lastName}" /></td>
				<td><c:out value="${student.age}" /></td>

				<td>
					<form action="<%=request.getContextPath()%>/portal"	method="post">
						<input name="side-menu" value="student" type="hidden" />
						<input name="main-content" value="student-registration" type="hidden" />
						
						<input name="next-action" value="student-class-delete" type="hidden" />
						<button name="id" value="${student.id}" type="submit" class="">Remove from Class</button>
					</form>

				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="6">
				<table style="width: 100%; border: 0px;">
					
						<tr>
							<td align="center" style="border: 0px">
							<form action="<%=request.getContextPath()%>/portal" method="post">
								<select id="studentId" name="studentId" required>
								    <c:forEach var="student" items="${listOfFREEStudent}">
								        <option value="${student.id}">${student.firstName} ${student.lastName}</option>
								    </c:forEach>
								</select>
								<input name="side-menu" value="student" type="hidden" />
								<input name="main-content" value="class-student-list" type="hidden" />
									
								<input name="classXId" value="${classXId}" type="hidden" />
								<input name="subjectName" value="${subjectName}" type="hidden" />
								<button name="next-action" value="student-class-after-add" type="submit">Add Student to Class</button>
							</form>	
							</td>
						</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>