package bean;

public class Post {
	private int id;
	private String userName; //�������� ������ �����
	private String postMessage; //��������� �����
	private String avatar;
	
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

	public Post(int id, String userName, String postMessage, String avatar) {
		this.id = id;
		this.userName = userName;
		this.postMessage = postMessage;
		this.avatar = avatar;
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
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", userName=" + userName + ", postMessage=" + postMessage + ", avatar=" + avatar
				+ "]";
	}

	
	
	

}
