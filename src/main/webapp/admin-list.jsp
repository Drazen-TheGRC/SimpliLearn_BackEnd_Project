<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Admin List</title>

</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		String loggedUser = (String)session.getAttribute("username");
		
		if(loggedUser == null){
			response.sendRedirect("login.jsp");
		}		
	%>
	<h1>Admin List</h1>

	<hr>
	<br>

	<table>
	
		<tr>
			<th colspan="6">
				<h2 >Admin List Options</h2>
			</th>
		</tr>

		<tr>
		
			<td colspan="6">
				<table style="width: 100%; border: 0px;">
					<tr>
						<td align="center" style="border: 0px">
							<form action="<%=request.getContextPath()%>/portal" method="post">
							
								<input name="side-menu" value="admin" type="hidden" />
								<input name="main-content" value="admin-registration" type="hidden" />
							
								<button name="next-action" value="admin-registration" type="submit">Add New Admin</button>
							</form>
						</td>
					</tr>
				</table>
			</td>			
		</tr>
		<tr>
			
			<th>First Name</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>Password</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="admin" items="${listOfAdmin}">
			<tr>
				
				<td><c:out value="${admin.firstName}" /></td>
				<td><c:out value="${admin.lastName}" /></td>
				<td><c:out value="${admin.username}" /></td>
				<td><c:out value="${admin.password}" /></td>


				<td>
					<form action="<%=request.getContextPath()%>/portal"	method="post">
						<input name="side-menu" value="admin" type="hidden" />
						<input name="main-content" value="admin-edit-form" type="hidden" />
						
						<input name="next-action" value="admin-edit-form" type="hidden" />
						<button name="id" value="${admin.id}" type="submit" class="">Edit</button>
					</form>
				</td>
				
				<td>
					<form action="<%=request.getContextPath()%>/portal"	method="post">
						<input name="side-menu" value="admin" type="hidden" />
						<input name="main-content" value="admin-registration" type="hidden" />
						
						<input name="next-action" value="admin-delete" type="hidden" />
						<button name="id" value="${admin.id}" type="submit" class="">Delete</button>
					</form>

				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>