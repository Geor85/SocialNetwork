package SNServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SNDAO.*;
import bean.Comment;

@WebServlet("/showcomments")
public class ShowCommentsByPostIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentDAO commentDAO = new CommentDAOImpl();
		ArrayList<Comment> comments = commentDAO.ShowCommentsByPostId((int)request.getAttribute("postid"));
		request.setAttribute("commentsbypostid", comments);
		response.sendRedirect("/showonepost");
	}

}
