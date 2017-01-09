<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link href="main.css" rel="stylesheet">
</head>
<body>
	<ul>
		
		<li><a class="active" href="index.jsp">Home</a></li>
		<li><a href="profile.jsp">Profile</a></li>
		<li><a href="myComments.jsp">My comments</a></li>
		<li><a href="notifications.jsp">Notifications</a></li>
		
	</ul>

	

		<div id="divone">
		
						
				    <form class ="otherform" onsubmit="return emptyForm()" action="registration" method="POST">
				    
						<p>
							<input id="username" type="text" name="username" placeholder="Username" />
						</p>
						<p id="messusername"></p>
						<p>
							<input type="text" name="name" placeholder="Name" />
						</p>
						<p>
							<input type="text" name="surname" placeholder="Surname" />
						</p>
						<p>
							<input type="text" name="avatar" placeholder="Url from avatar" />
						</p>
						<p>
							<input id="password" type="password" name="password" placeholder="Password" />
						</p>
						<p id="messpassword"></p>
						<p>
							<input id="passwordrepeate" type="password" name="repeatpassword" placeholder="Repeat password" />
						</p>
						<p id="messpasswordrepeat"></p>
						<input id="reg" type="submit"  value="Registration" />
						<a href="index.jsp" class="btn">Log in</a>
					</form>
				   
					
					
		</div>
	
<script type="text/javascript" src="main.js"> </script>
</body>
</html>
