<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="styles.css" />

<style type="text/css">

</style>

<meta charset="ISO-8859-1">
<title>Admin Registration</title>


</head>
<body>
	<h1>Please Register an Admin</h1>

	<hr>
	<br>
	<form action="<%=request.getContextPath()%>/admin-registration" method="post">
		
		<h3 class="errorMessage" >${errorMessage}</h3>
	
		<table>
			<tr>
				<th colspan="2">
					<h2>Admin Register Form</h2>
				</th>
			</tr>
			<tr>
				<td align="right"><label for="firstName">First Name:</label></td>
				<td><input type="text" id="firstName" name="firstName"
					placeholder="First Name" value="" required></td>
			</tr>
			<tr>
				<td align="right"><label for="lastName">Last Name:</label></td>
				<td><input type="text" id="lastName" name="lastName"
					placeholder="Last Name" value="" required></td>
			</tr>
			<tr>
				<td align="right"><label for="username">User Name:</label></td>
				<td><input type="text" id="username" name="username"
					placeholder="Username" value="" required></td>
			</tr>
			<tr>
				<td align="right"><label for="pasword">Password:</label></td>
				<td><input type="password" id="password" name="password"
					placeholder="Password" value="" required></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Register Admin</button>
				</td>
			</tr>
		</table>

	</form>
</body>
</html>