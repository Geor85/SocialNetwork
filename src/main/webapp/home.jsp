<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link href="main.css" rel="stylesheet">
</head>
<body>
	<ul>

		<li><a class="active" href="index.jsp">Home</a></li>
		<li><a href="profile.jsp">Profile</a></li>
		<li><a href="myComments.jsp">My comments</a></li>
		<li><a href="notifications.jsp">Notifications</a></li>
		<li id="log">
		<img src="<c:url value="${sessionScope.user.avatar}"/>" width="15"/> <c:out value=" ${sessionScope.user.userName}" escapeXml="false" />
			<form action="logout" method="POST">
				<input type="submit" name="confirm" value="Log out" />

			</form>
		</li>
	</ul>

	<c:choose>

		<c:when test="${sessionScope.user == null }">
			<c:redirect url="/index.jsp" />

		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="${allposts == null}">
			<c:redirect url="/showallposts" />
		</c:when>
	</c:choose>
	

	<div id="divone">
	
	
	<form class ="addpost" action="addpost" method="POST">
						<p>
							<textarea id="postadd" type="text" name="postmessage" placeholder="Enter your post message" ></textarea>
						</p>
						<input type="submit" name="confirm" value="Add post" />
						
					</form>
					
					
					
	
	<c:forEach items="${allposts}" var="posts">
	<div class="posts">
			<div class="post_head">
				 <div class="avatar"><img src="<c:url value="${posts.avatar}"/>" /></div>
				
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
	
	<c:choose>
		<c:when test="${sessionScope.user.privilege == 'admin'}">
			<a href="<c:url value="/deletepost?postid=${posts.id}"/>">Delete</a>
		</c:when>
		</c:choose>
			</div>
			
		</c:forEach>
		
	
	</div>

<c:remove var="allposts" scope="request" />
</body>
</html>
