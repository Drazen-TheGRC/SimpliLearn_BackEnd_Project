<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Login Page</title>

</head>
<body>
	<h1>Please Login</h1>

	<hr>
	<br>
	<form action="<%=request.getContextPath()%>/portal"	method="post">

		<h3 class="errorMessage">${errorMessage}</h3>

		<table>
			<tr>
				<th colspan="2">
					<h2>Admin Login</h2>
				</th>
			</tr>
			<tr>
				<td align="right">
					<label for="username">User Name:</label>
				</td>
				<td>
					<input type="text" id="username" name="username" placeholder="Username" required>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label for="password">Password:</label>
				</td>
				<td>
					<input type="password" id="password" name="password" placeholder="Password" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input name="side-menu" value="" type="hidden" /> 
					<input name="main-content" value="" type="hidden" />

					<button name="next-action" value="authenticate-admin" type="submit" >Login</button>
				</td>
			</tr>
		</table>

	</form>
</body>
</html>