import java.util.ArrayList;

import SNDAO.*;
import bean.Comment;
import bean.Post;


public class Main {

	public static void main(String[] args) {
		//User user = new User("https://cs7062.vk.me/c540107/v540107359/2729/fYQlS_23QdA.jpg", "Ozio", "555", "George", "", "admin", 1);
		
		//userDAO.userAdd(user);
		
		PostDAO postDAO = new PostDAOImpl();
		Post post = postDAO.showPostById(5);
		System.out.println(post);
		CommentDAO commentDAO = new CommentDAOImpl();
		Comment comment = new Comment(4, "Delok", "cjnfefbfucbefugb");
		commentDAO.commentAdd(comment);

	}

}
