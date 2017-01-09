package SNServlet;

import java.io.IOException;

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
import bean.Post;
import bean.User;

@WebServlet("/mycomments")
public class ShowMyComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommentDAO commentDAO = new CommentDAOImpl();
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user);
		request.getSession().setAttribute("mycomments", commentDAO.ShowCommentByUserName(user.getUserName()));	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/myComments.jsp");
		rd.forward(request, response);
	}

	

}
