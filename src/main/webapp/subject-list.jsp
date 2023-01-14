<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Subject List</title>

</head>
<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			String loggedUser = (String)session.getAttribute("username");
			
			if(loggedUser == null){
				response.sendRedirect("login.jsp");
			}		
		%>
		<h1>Subject List</h1>

	<hr>
	<br>

	<table>
	
		<tr>
			<th colspan="6">
				<h2 >Subject List Options</h2>
			</th>
		</tr>

		<tr>
		
		<td colspan="6">
			<table style="width: 100%; border: 0px;">
				<tr>
					<td align="center" style="border: 0px">
						<form action="<%=request.getContextPath()%>/portal" method="post">
						
							<input name="side-menu" value="subject" type="hidden" />
							<input name="main-content" value="subject-registration" type="hidden" />
						
							<button name="next-action" value="subject-registration" type="submit">Add New Subject</button>
						</form>
					</td>
				</tr>
			</table>
		</td>			
		</tr>
		<tr>
			
			<th>Subject Name</th>
			<th>Subject Shortcut</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="subject" items="${listOfSubject}">
			<tr>
				
				<td><c:out value="${subject.subjectName}" /></td>
				<td><c:out value="${subject.subjectShortcut}" /></td>
				
				<td>
					<form action="<%=request.getContextPath()%>/portal"	method="post">
						<input name="side-menu" value="subject" type="hidden" />
						<input name="main-content" value="subject-edit-form" type="hidden" />
						
						<input name="next-action" value="subject-edit-form" type="hidden" />
						<button name="id" value="${subject.id}" type="submit" class="">Edit</button>
					</form>
				</td>
				
				<td>
					<form action="<%=request.getContextPath()%>/portal"	method="post">
						<input name="side-menu" value="subject" type="hidden" />
						<input name="main-content" value="subject-registration" type="hidden" />
						
						<input name="next-action" value="subject-delete" type="hidden" />
						<button name="id" value="${subject.id}" type="submit" class="" title="Related class will be deleted too!!!">Delete</button>
					</form>

				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>