package SNServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SNDAO.PostDAO;
import SNDAO.PostDAOImpl;

@WebServlet("/deletepost")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostDAO postDAO = new PostDAOImpl();
		postDAO.postDeleteById( Integer.parseInt(request.getParameter("postid")));
		response.sendRedirect(request.getHeader("Referer"));
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
