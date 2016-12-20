<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Page</title>
<link href="main.css" rel="stylesheet">
</head>
<body>
<ul>
<h2>VKomatoze</h2>
  <li><a href="index.jsp">Home</a></li>
  <li><a class="active" href="profile.jsp">Profile</a></li>
  <li><a href="myComments.jsp">My comments</a></li>
  <li><a href="notifications.jsp">Notifications</a></li>
  <li id="log">
  <c:out value="${sessionScope.username}" escapeXml="false" />
					<form action="logout" method="POST">
						<input type="submit" name="confirm" value="Log out" /></br>
					</form>
					</li>
</ul>

<div >
<h1>Профиль</h1>
</div>

</body>
</html>
