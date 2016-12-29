package bean;

public class Post {
	private int id;
	private String userName; //юзернейм автора поста
	private String postMessage; //сообщение поста
	
	public Post() {
		
	}

	public Post(String userName, String postMessage) {
		this.userName = userName;
		this.postMessage = postMessage;
	}

	public Post(int id, String userName, String postMessage) {
		this.id = id;
		this.userName = userName;
		this.postMessage = postMessage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", userName=" + userName + ", postMessage=" + postMessage + "]";
	}
	
	

}
