package SNDAO;

import java.util.ArrayList;

import bean.Comment;

public interface CommentDAO {
	public void commentAdd(Comment comment);
	public void commentDeleteById(int id);
	public ArrayList<Comment> ShowCommentsByPostId(int id);
}
