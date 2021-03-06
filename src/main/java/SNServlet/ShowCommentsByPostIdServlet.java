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

import SNDAO.CommentDAO;
import SNDAO.CommentDAOImpl;
import SNDAO.PostDAO;
import SNDAO.PostDAOImpl;
import SNDAO.UserDAO;
import SNDAO.UserDAOImpl;
import bean.*;



@WebServlet("/showcomments")
public class ShowCommentsByPostIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostDAO postDAO = new PostDAOImpl();
		CommentDAO commentDAO = new CommentDAOImpl();
		UserDAO userDAO = new UserDAOImpl();
		Post post = (Post) request.getSession().getAttribute("post");
		ArrayList<Comment> comments = commentDAO.ShowCommentsByPostId(post.getId());
		Collections.reverse(comments);
		request.getSession().setAttribute("comments", comments);	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/post.jsp");
		rd.forward(request, response);
	}

}
