package SNDAO;

import java.util.ArrayList;

import bean.Post;

public interface PostDAO {
	public void postAdd(Post post);
	public void postDeleteById(int id);
	public Post showPostById(int id);
	public ArrayList<Post> showAllPosts();
	public ArrayList<Post> showPostsByUserName(String userName);
}
