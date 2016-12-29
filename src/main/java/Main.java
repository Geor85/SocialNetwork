import SNDAO.*;
import bean.User;

public class Main {

	public static void main(String[] args) {
		//User user = new User("https://cs7062.vk.me/c540107/v540107359/2729/fYQlS_23QdA.jpg", "Ozio", "555", "George", "", "admin", 1);
		UserDAO userDAO = new UserDAOImpl();
		//userDAO.userAdd(user);
		userDAO.userBanByName("Ozio", 0);
		for(int i=0; i < userDAO.usersShowAll().size(); i++) {
			System.out.println(userDAO.usersShowAll().get(i));
		}

	}

}
