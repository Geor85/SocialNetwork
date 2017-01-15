<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title>
<link href="main.css" rel="stylesheet">
</head>
<body>

	<ul>
		
		<li><a class="active" href="index.jsp">Home</a></li>
		<li><a href="profile.jsp">Profile</a></li>
		<li><a href="myComments.jsp">My comments</a></li>
		<li><a href="notifications.jsp">Notifications</a></li>
		<li id="log"><c:choose>

				<c:when test="${not empty sessionScope.user }">
					<c:redirect url="/home.jsp" />
						
					</form>
				</c:when>		
			</c:choose></li>
	</ul>

	

		<div id="divone">
		
					<form class ="otherform" action="login" method="POST">
						<p>
							<input id="username" type="text" name="username" placeholder="Username" />
						</p>
						<p>
							<input type="password" name="password" placeholder="Password" />
						</p>
						<c:out value="${requestScope.Sysmessage}" escapeXml="false" /> </br>

						<input type="submit" name="confirm" value="Log in" />
						<a href="registration.jsp" class="btn">Registration</a>
					</form>
					
				
				   
				   
					
					
		</div>
	

</body>
</html>
