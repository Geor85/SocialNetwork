package SNServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SNDAO.*;
import bean.Post;

@WebServlet("/showallposts")
public class ShowPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostDAO postDAO = new PostDAOImpl();
		ArrayList<Post> posts = postDAO.showAllPosts();
		Collections.reverse(posts);
		request.setAttribute("allposts", posts);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PostDAO postDAO = new PostDAOImpl();
		request.setAttribute("allposts", postDAO.showAllPosts());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
