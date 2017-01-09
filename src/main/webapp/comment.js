function emptyComment(){
var comment = document.getElementById('comment').value;
	
	
if(comment.length == "") {
	
	document.getElementById("messusername").innerHTML = "*User name must contain more than 5 characters";
	
	return false;
} 

return true;

}