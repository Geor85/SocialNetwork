<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post</title>
<link href="main.css" rel="stylesheet">
</head>
<body>
<ul>

  <li><a href="index.jsp">Home</a></li>
  <li><a href="profile.jsp">Profile</a></li>
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
<div id="divone" >

<c:choose>
		<c:when test="${comments == null}">
			<c:redirect url="/showcomments" />
		</c:when>
	</c:choose>
	</br> </br>
<div class="post_head2">
				 <div class="avatar"><img src="<c:url value="${postuser.avatar}"/>" /></div>
				
					<p>    <c:out value="${postuser.userName}" escapeXml="false" /></p> 
			    </div>
			    
			    <div class="posttext">
				<c:out value="${post.postMessage}" escapeXml="false" />
				</div>
				
				<div id="comments_line">Comments:</div>
				
				<c:forEach items="${comments}" var="comments">
		         <div id="comments">
					<p><c:out value="${comments.userName}" escapeXml="false" /></p> 
			    
				<c:out value="${comments.commentMessage}" escapeXml="false" />
				<br/>
	<c:choose>			
				<c:when test="${sessionScope.user.userName == comments.userName}">
			<a href="<c:url value="/deletecomment?commentid=${comments.id}"/>">Delete</a>
		</c:when>
	</c:choose>
	
	<c:choose>
	
		<c:when test="${sessionScope.user.privilege == 'admin'}">
			<a href="<c:url value="/deletecomment?commentid=${comments.id}"/>">Delete</a>
		</c:when>
		</c:choose>
		
				</div>
		</c:forEach>
		<form class ="addcomment" onsubmit="return emptyComment()" action="addcomment" method="GET">
						<p>
							<textarea id="comment" type="text" name="comment" placeholder="Enter your message" ></textarea>
						</p>
						
						<p id="messcomment"></p>

						<input class="addcommentbutton" type="submit" name="confirm" value="Add" />
						
					</form>
</div>


<c:remove var="comments" scope="session" />

</body>
</html>
