package SNServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SNDAO.*;
import bean.*;

@WebServlet("/showonepost")
public class ShowOnePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostDAO postDAO = new PostDAOImpl();
		CommentDAO commentDAO = new CommentDAOImpl();
		UserDAO userDAO = new UserDAOImpl();
		
		request.getSession().setAttribute("comments", commentDAO.ShowCommentsByPostId(Integer.parseInt(request.getParameter("postid"))));
		request.getSession().setAttribute("post", postDAO.showPostById(Integer.parseInt(request.getParameter("postid"))));
		request.getSession().setAttribute("postuser", userDAO.FindByUserName(request.getParameter("username")));
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/post.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostDAO postDAO = new PostDAOImpl();
		CommentDAO commentDAO = new CommentDAOImpl();
		UserDAO userDAO = new UserDAOImpl();
		Post post = (Post) request.getSession().getAttribute("post");
		System.out.println(post);
		request.getSession().setAttribute("comments", commentDAO.ShowCommentsByPostId(post.getId()));	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/post.jsp");
		rd.forward(request, response);
	}

}
