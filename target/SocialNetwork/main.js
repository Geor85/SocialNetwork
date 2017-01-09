
	
function emptyForm(){
	var username = document.getElementById('username').value; 
	var password = document.getElementById("password").value;
	var passwordrepeate = document.getElementById("passwordrepeate").value;
	
if(username.length < "5") {
	
	document.getElementById("messusername").innerHTML = "*User name must contain more than 5 characters" + username;
	
	return false;
} 
if(password.length < "6") {
	document.getElementById("messusername").innerHTML = "";
	document.getElementById("messpassword").innerHTML = "*Password must contain more than 5 characters";
	return false;
}
if(password != passwordrepeate) {
	document.getElementById("messpassword").innerHTML = "";
	document.getElementById("messpasswordrepeat").innerHTML = "*The password must be the same with the previous";
	return false;
}


return true;

}
