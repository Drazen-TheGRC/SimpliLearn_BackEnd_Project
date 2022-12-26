<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Learner's Academy Portal</title>

</head>
<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			String loggedUser = (String)session.getAttribute("username");
			
			if(loggedUser == null){
				response.sendRedirect("login.jsp");
			}		
		%>

		<table style="width: 100%; height: 95vh;">
		<tr height="50px">
			<th colspan="2">
				<h1>Learner's Academy Portal</h1>
			</th>
		</tr>
		<tr>
			<td style="width: 25%" align="center">
			
				<form action="<%=request.getContextPath()%>/portal" method="post">
						<input name="side-menu" value="student" type="hidden" />
						<input name="main-content" value="student-list" type="hidden" />
							
						<button name="next-action" value="student-list" type="submit">List All Students</button>
				</form>
				<br>
				<form action="<%=request.getContextPath()%>/portal" method="post">
						<input name="side-menu" value="subject" type="hidden" />
						<input name="main-content" value="subject-list" type="hidden" />
							
						<button name="next-action" value="subject-list" type="submit">List All Subjects</button>
				</form>

				<br>
				<hr width="90%">
 				<br>
				
				
				<form action="<%=request.getContextPath()%>/portal" method="post">
						<input name="side-menu" value="admin" type="hidden" />
						<input name="main-content" value="admin-list" type="hidden" />
							
						<button name="next-action" value="admin-list" type="submit">List All Admins</button>
				</form>
				
				<br>
				
				<form action="<%=request.getContextPath()%>/portal" method="post">
					<button name="next-action" value="logout" type="submit" >Logout</button>
				</form>
				
			</td>
			
			
			<td style="width: 75%">
			
			<%if((String)request.getAttribute("main-content") != null){%>
				
				<%switch((String)request.getAttribute("main-content")) {
				
			   		case "welcome":%>
			   			<jsp:include page="welcome.jsp" />
			     		<%break;
			      	case "admin-registration":%>
			      		<jsp:include page="admin-registration.jsp" />
			         	<%break;
			      	case "admin-edit-form":%>
			      		<jsp:include page="admin-edit-form.jsp" />
			         	<%break;
			         	
			      	case "admin-list":%>
			   			<jsp:include page="admin-list.jsp" />
			     		<%break;
			      	

			      		
			    	default:
			         	out.println("Select option on the side menu");
			    	}
			}%>
				
				
				
			      
			</td>
		</tr>
		<tr height="50px">
			<td colspan="2">
				<h2 align="center" ><a href="https://github.com/Drazen-TheGRC/SimpliLearn_BackEnd_Project" target="_blank" >https://github.com/Drazen-TheGRC/SimpliLearn_BackEnd_Project</a></h2>
			</td>
		</tr>
	</table>
</body>
</html>