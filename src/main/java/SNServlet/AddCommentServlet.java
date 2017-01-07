package SNServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SNDAO.*;
import bean.Comment;
import bean.User;



@WebServlet("/addcomment")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = (User)request.getSession().getAttribute("user");
		CommentDAO commentDAO = new CommentDAOImpl();
		Comment comment = new Comment((int) request.getAttribute("post"), user.getUserName(), request.getParameter("comment"));
		commentDAO.commentAdd(comment);
		response.sendRedirect("/showcomments");
	}

}
