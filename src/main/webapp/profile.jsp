<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
<link href="main.css" rel="stylesheet">
</head>
<body>
<ul>

  <li><a href="index.jsp">Home</a></li>
  <li><a class="active" href="profile.jsp">Profile</a></li>
  <li><a href="myComments.jsp">My comments</a></li>
  <li><a href="notifications.jsp">Notifications</a></li>
  <li id="log">
  <img src="<c:url value="${sessionScope.user.avatar}"/>" width="15"/> <c:out value=" ${sessionScope.user.userName}" escapeXml="false" />
					<form action="logout" method="POST">
						<input type="submit" name="confirm" value="Log out" /></br>
					</form>
					</li>
</ul>
<c:choose>

		<c:when test="${sessionScope.user == null }">
			<c:redirect url="/index.jsp" />

		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="${userposts == null}">
			<c:redirect url="/showuserposts" />
		</c:when>
	</c:choose>
	
<div id="divone">
<h1>Profile</h1>
<img src="<c:url value="${sessionScope.user.avatar}"/>" width="100"/> </br>
<li id="profile"> <b> User name: </b>  <c:out value=" ${sessionScope.user.userName}" escapeXml="false" /> </li> </br>
<li id="profile"> <b>Name: </b> <c:out value=" ${sessionScope.user.name}" escapeXml="false" /> </li> </br>
<li id="profile"> <b>Lastname: </b> <c:out value=" ${sessionScope.user.lastName}" escapeXml="false" /> </li> </br> </br>

<h3>My Posts:</h3>

<c:forEach items="${userposts}" var="posts">
	<div class="posts">
			<div class="post_head">
				 <div class="avatar"><img src="<c:url value="${sessionScope.user.avatar}"/>" /></div>
				
					<p><c:out value="${posts.userName}" escapeXml="false" /></p> 
			    </div>
			<div class="text">
				<c:out value="${posts.postMessage}" escapeXml="false" />
				</div>
				<a href="<c:url value="/showonepost?username=${posts.userName}&postid=${posts.id}"/>">Go to post..</a>
				<c:choose>
		<c:when test="${sessionScope.user.userName == posts.userName}">
			<a href="<c:url value="/deletepost?postid=${posts.id}"/>">Delete</a>
		</c:when>
	</c:choose>
	</div>
	</c:forEach>
</div>

<c:remove var="userposts" scope="request" />

</body>
</html>
