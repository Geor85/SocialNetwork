package SNDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDAOImpl implements UserDAO {
    @Override
	public void userAdd(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root", "");
				PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO users (avatar, username, password, name, lastname, privilege, useractivity) VALUES (?, ?, ?, ?, ?, ?, ?);")) {
			preparedStatement.setString(1, user.getAvatar());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getName());
			preparedStatement.setString(5, user.getLastName());
			preparedStatement.setString(6, user.getPrivilege());
			preparedStatement.setInt(7, user.getUserActivity());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    @Override
	public User FindByUserNamePassword(String userName, String password) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root", ""); 
				PreparedStatement preparedStatement = connection.prepareStatement
						("select * from users where username = ? and password = ?;")){
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
			User user = new User(rs.getInt("id"), rs.getString("avatar"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("lastname"),
					 rs.getString("privilege"), rs.getInt("userActivity") );
			return user; 
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> ShowAllUsers() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root", ""); 
				PreparedStatement preparedStatement = connection.prepareStatement
						("select * from users;")){
			
			
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<User> users = new ArrayList<User>();
			while(rs.next()){
			users.add(new User(rs.getInt("user_id"), rs.getString("avatar"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("lastname"),
					 rs.getString("privilege"), rs.getInt("userActivity")));}
			return users; 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public User FindByUserName(String userName) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root", ""); 
				PreparedStatement preparedStatement = connection.prepareStatement
						("select * from users where username = ?;")){
			preparedStatement.setString(1, userName);
			
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
			User user = new User(rs.getInt("id"), rs.getString("avatar"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("lastname"),
					 rs.getString("privilege"), rs.getInt("userActivity"));
			return user;}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public void BanByUserName(String userName, int activity) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root", ""); 
				PreparedStatement preparedStatement = connection.prepareStatement
				("UPDATE `socialnetwork`.`users` SET `useractivity`=? WHERE `username`=?")) {
					preparedStatement.setInt(1, activity);
					preparedStatement.setString(2, userName);
					preparedStatement.executeUpdate();
				}catch(SQLException e) {
					System.err.println(e.getMessage());
				}
		
	}

}
