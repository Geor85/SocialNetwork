package bean;

public class Comment {

	private int id;
	private int postId; //id поста к которому оставлен комментарий
	private String userName; //id пользователя, который оставил коментарий
	private String commentMessage; //сообщение сомментария
	
	public Comment() {
		
	}

	public Comment(int postId, String userName, String commentMessage) {
		this.postId = postId;
		this.userName = userName;
		this.commentMessage = commentMessage;
	}

	public Comment(int id, int postId, String userName, String commentMessage) {
		this.id = id;
		this.postId = postId;
		this.userName = userName;
		this.commentMessage = commentMessage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCommentMessage() {
		return commentMessage;
	}

	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", postId=" + postId + ", userName=" + userName + ", commentMessage=" + commentMessage
				+ "]";
	}
	
	
}
