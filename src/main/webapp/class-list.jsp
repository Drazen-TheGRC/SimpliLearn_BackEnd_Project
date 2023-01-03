<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Student List</title>

</head>
<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			String loggedUser = (String)session.getAttribute("username");
			
			if(loggedUser == null){
				response.sendRedirect("login.jsp");
			}		
		%>
		<h1>Class List</h1>

	<hr>
	<br>

	<table>
	
		<tr>
			<th colspan="6">
				<h2 >Class List Options</h2>
			</th>
		</tr>

		<tr>
		
		<td colspan="6">
			<table style="width: 100%; border: 0px;">
				<tr>
					<td align="center" style="border: 0px">
						<form action="<%=request.getContextPath()%>/portal" method="post">
						
							<input name="side-menu" value="class" type="hidden" />
							<input name="main-content" value="class-registration" type="hidden" />
						
							<button name="next-action" value="class-registration" type="submit">Add New Class</button>
						</form>
					</td>
					<td align="center" style="border: 0px">
						<form action="<%=request.getContextPath()%>/portal" method="post">
							<input name="side-menu" value="class" type="hidden" />
							<input name="main-content" value="class-list" type="hidden" />
							
							<button name="next-action" value="class-list" type="submit">List All Class</button>
						</form>
					</td>
				</tr>
			</table>
		</td>			
		</tr>
		<tr>
			
			<th>Subject</th>
			<th>Date</th>
			<th>Time</th>
			<th>Student List</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="class" items="${listOfClass}">
			<tr>
				
				<td><c:out value="${class.subject}" /></td>
				<td><c:out value="${class.date}" /></td>
				<td><c:out value="${class.time}" /></td>
				<td><c:out value="${class.studentList}" /></td>


				<td>
					<form action="<%=request.getContextPath()%>/portal"	method="post">
						<input name="side-menu" value="class" type="hidden" />
						<input name="main-content" value="class-edit-form" type="hidden" />
						
						<input name="next-action" value="class-edit-form" type="hidden" />
						<button name="id" value="${class.id}" type="submit" class="">Edit</button>
					</form>
				</td>
				
				<td>
					<form action="<%=request.getContextPath()%>/portal"	method="post">
						<input name="side-menu" value="class" type="hidden" />
						<input name="main-content" value="class-registration" type="hidden" />
						
						<input name="next-action" value="class-delete" type="hidden" />
						<button name="id" value="${class.id}" type="submit" class="">Delete</button>
					</form>

				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>