package SNDAO;

import java.util.ArrayList;

import bean.Post;

public interface PostDAO {
	public void postAdd(Post post);
	public void postDeleteById(int id);
	public ArrayList<Post> showAllPosts();
}
