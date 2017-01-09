<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notification Page</title>
<link href="main.css" rel="stylesheet">
</head>
<body>
<ul>

  <li><a href="index.jsp">Home</a></li>
  <li><a href="profile.jsp">Profile</a></li>
  <li><a href="myComments.jsp">My comments</a></li>
  <li><a class="active" href="notifications.jsp">Notifications</a></li>
  <li id="log">
  <c:out value="${sessionScope.user.userName}" escapeXml="false" />
					<form action="logout" method="POST">
						<input type="submit" name="confirm" value="Log out" /></br>
					</form>
					</li>
</ul>
<c:choose>

		<c:when test="${empty sessionScope.user }">
			<c:redirect url="/index.jsp" />

		</c:when>
	</c:choose>
<div id="divone">
<h1> События </h1>
</div>

</body>
</html>
