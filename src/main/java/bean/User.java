package bean;

public class User {
	private int id;
	private String avatar; //������ �� ������ ������������
	private String userName; //���������� ��� ������������ ��� �����������
	private String password; // ������
	private String name;//��� ������������
	private String lastName; // a������ ������������
	private String privilege; //���������� ������������. "user" - ������� ������������. "admin" - �������������
	private int userActivity; //���������� ������������� "0" - �������, "1" - ������������ �������
	
	public User() {
		
	}

	public User(String avatar, String userName, String password, String name, String lastName,  String privilege, int userActivity) {	
		this.avatar = avatar;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.privilege = privilege;
		this.userActivity = userActivity;
	}

	public User(int id, String avatar, String userName, String password, String name, String lastName,  String privilege, int userActivity) {
		this.id = id;
		this.avatar = avatar;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.privilege = privilege;
		this.userActivity = userActivity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public int getUserActivity() {
		return userActivity;
	}

	public void setUserActivity(int userActivity) {
		this.userActivity = userActivity;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", avatar=" + avatar + ", userName=" + userName + ", name=" + name + ", lastName=" + lastName
				+ ", password=" + password + ", privilege=" + privilege + ", userActivity=" + userActivity + "]";
	}
	
	

}
