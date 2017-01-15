package SNServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SNDAO.*;
import bean.Post;
import bean.User;

@WebServlet("/showuserposts")
public class ShowUserPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostDAO postDAO = new PostDAOImpl();
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<Post> posts = postDAO.showPostsByUserName(user.getUserName());
		Collections.reverse(posts);
		request.setAttribute("userposts", posts);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/profile.jsp"); 
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
