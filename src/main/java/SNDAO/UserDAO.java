package SNDAO;

import java.util.List;

import bean.User;

public interface UserDAO {
	public void userAdd(User user);
	public User FindByUserNamePassword(String username, String password);
	public User FindByUserName(String userName);
	public List<User> ShowAllUsers();
	public void BanByUserName(String userName, int activity);
	
}
