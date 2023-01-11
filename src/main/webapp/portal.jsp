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
			
			if(loggedUser == null || loggedUser.isEmpty()){
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
						<input name="side-menu" value="class" type="hidden" />
						<input name="main-content" value="class-list" type="hidden" />
							
						<button name="next-action" value="class-list" type="submit">List All Classes</button>
				</form>
				<br>
				<br>
				<form action="<%=request.getContextPath()%>/portal" method="post">
						<input name="side-menu" value="student" type="hidden" />
						<input name="main-content" value="student-list" type="hidden" />
							
						<button name="next-action" value="student-list" type="submit">List All Students</button>
				</form>
				<br>
				<form action="<%=request.getContextPath()%>/portal" method="post">
						<input name="side-menu" value="teacher" type="hidden" />
						<input name="main-content" value="teacher-list" type="hidden" />
							
						<button name="next-action" value="teacher-list" type="submit">List All Teachers</button>
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
			     		
			     		
				  	case "student-registration":%>
			      		<jsp:include page="student-registration.jsp" />
			         	<%break;
			      	case "student-edit-form":%>
			      		<jsp:include page="student-edit-form.jsp" />
			         	<%break;
			         	
			      	case "student-list":%>
			   			<jsp:include page="student-list.jsp" />
			     		<%break;
			     		
			     		
			      	case "teacher-registration":%>
		      			<jsp:include page="teacher-registration.jsp" />
		         		<%break;
			      	case "teacher-edit-form":%>
			      		<jsp:include page="teacher-edit-form.jsp" />
			         	<%break;
			         	
			      	case "teacher-list":%>
			   			<jsp:include page="teacher-list.jsp" />
			     		<%break;
			     		
			     		
			      	case "subject-registration":%>
	      				<jsp:include page="subject-registration.jsp" />
	         			<%break;
			      	case "subject-edit-form":%>
			      		<jsp:include page="subject-edit-form.jsp" />
			         	<%break;
			         	
			      	case "subject-list":%>
			   			<jsp:include page="subject-list.jsp" />
			     		<%break;
			     		
			     		
			      	case "class-registration":%>
      				<jsp:include page="class-registration.jsp" />
	         			<%break;
			      	case "class-edit-form":%>
			      		<jsp:include page="class-edit-form.jsp" />
			         	<%break;
			         	
			      	case "class-list":%>
			   			<jsp:include page="class-list.jsp" />
			     		<%break;
			      	
			      	case "class-student-list":%>
		   			<jsp:include page="class-student-list.jsp" />
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