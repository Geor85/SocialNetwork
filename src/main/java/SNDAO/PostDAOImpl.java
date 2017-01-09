package SNDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Post;

public class PostDAOImpl implements PostDAO {

	@Override
	public void postAdd(Post post) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage() + ": PostDAOImpl");
		}

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root",
				"");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO posts (user_id, post_message) VALUES(?, ?);")) {
			preparedStatement.setString(1, post.getUserName());
			preparedStatement.setString(2, post.getPostMessage());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void postDeleteById(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage() + ": PostDAOImpl");
		}

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root",
				"");PreparedStatement preparedStatement = connection.prepareStatement(
						"DELETE FROM posts where post_id = ?;")) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getSQLState());
		}

	}
	
	@Override
	public Post showPostById(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage() + ": PostDAOImpl");
		}

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root",
				""); PreparedStatement preparedStatement = connection.prepareStatement("select * from posts where post_id = ?;")) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			Post post = new Post();
			while(rs.next()) {
			post = new Post(rs.getInt("post_id"), rs.getString("user_name"), rs.getString("post_message"));
			}
			return post; 
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

	@Override
	public ArrayList<Post> showAllPosts() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage() + ": PostDAOImpl");
		}

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root",
				""); PreparedStatement preparedStatement = connection.prepareStatement(
						"SELECT post_id, user_name, post_message, avatar "
						+ "FROM socialnetwork.posts INNER JOIN socialnetwork.users "
						+ "ON posts.user_name=users.username;")) {
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<Post> posts = new ArrayList<Post>();
			

			while (rs.next()) {
				posts.add(new Post(rs.getInt("post_id"), rs.getString("user_name"), rs.getString("post_message"), rs.getString("avatar")));
			}

			return posts;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return null;

	}

	@Override
	public ArrayList<Post> showPostsByUserName(String userName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage() + ": PostDAOImpl");
		}

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root",
				""); PreparedStatement preparedStatement = connection.prepareStatement("select * from posts where user_name = ?;")) {
			preparedStatement.setString(1, userName);
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<Post> posts = new ArrayList<Post>();
			if (rs.next() == false) {
				return posts;
			}

			while (rs.next()) {
				posts.add(new Post(rs.getInt("post_id"), rs.getString("user_name"), rs.getString("post_message"), rs.getString("avatar")));
			}

			return posts;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return null;

	}

	

}
