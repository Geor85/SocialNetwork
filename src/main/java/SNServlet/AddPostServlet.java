package SNServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SNDAO.*;
import bean.*;

@WebServlet("/addpost")
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PostDAO postDAO = new PostDAOImpl();
		User user = (User) request.getSession().getAttribute("user");
		Post post = new Post(user.getUserName(), request.getParameter("postmessage"));
		postDAO.postAdd(post);
		response.sendRedirect(request.getHeader("Referer"));
	}

}
