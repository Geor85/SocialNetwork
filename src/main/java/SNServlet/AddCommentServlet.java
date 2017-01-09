package SNServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SNDAO.*;
import bean.Comment;
import bean.Post;
import bean.User;



@WebServlet("/addcomment")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("postuser");
		System.out.println(user);
		CommentDAO commentDAO = new CommentDAOImpl();
		Post post = (Post) request.getSession().getAttribute("post");
		System.out.println(post);
		Comment comment = new Comment(post.getId(), user.getUserName(), request.getParameter("comment"));
		commentDAO.commentAdd(comment);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/post.jsp");
		rd.forward(request, response);
	}

	
	

}
