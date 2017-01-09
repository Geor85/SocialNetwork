package SNServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SNDAO.*;
import bean.User;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAOImpl();
		User user = new User(request.getParameter("avatar"), request.getParameter("username"), request.getParameter("password"), 
				request.getParameter("name"), request.getParameter("lastname"), "user", 1);
		if(userDAO.FindByUserName(user.getUserName()) == null) {
			userDAO.userAdd(user);
			request.getSession().setAttribute("user", userDAO.FindByUserNamePassword(user.getUserName(), user.getPassword()));
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp"); 
			rd.forward(request, response);
		} else {
			request.getSession().setAttribute("Sysmessage", "User name is busy. Please choose other user name.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/registration.jsp"); 
			rd.forward(request, response);
		}
		
		
	}

}
