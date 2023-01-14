<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Welcome</title>

</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		String loggedUser = (String)session.getAttribute("username");
		
		if(loggedUser == null){
			response.sendRedirect("login.jsp");
		}		
	%>
	<h1>${welcomeMessage}</h1>
	<h3>Your username is : <%=request.getParameter("username")%></h3>
</body>
</html>