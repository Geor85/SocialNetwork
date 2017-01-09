package SNDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import bean.Comment;

public class CommentDAOImpl implements CommentDAO {

	@Override
	public void commentAdd(Comment comment) {
		try { 
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root", "");
				PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO comments (post_id, user_name, comment_message) VALUE(?, ?, ?);")) {
			preparedStatement.setInt(1, comment.getPostId());
			preparedStatement.setString(2, comment.getUserName());
			preparedStatement.setString(3, comment.getCommentMessage());
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}

	@Override
	public void commentDeleteById(int id) {
		try { 
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root", "");
				PreparedStatement preparedStatement = connection.prepareStatement(
						"DELETE from comments where comment_id=?;")) {
			        preparedStatement.setInt(1, id);
					preparedStatement.executeUpdate();
				}catch (SQLException e) {
					System.err.println(e.getMessage());
				}
		
	}

	@Override
	public ArrayList<Comment> ShowCommentByUserName(String userName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage() + ": PostDAOImpl");
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root", "");
				PreparedStatement preparedStatement = connection.prepareStatement(
						"SELECT* FROM comments where user_name = ?;")) {
			
			preparedStatement.setString(1, userName);
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<Comment> comments= new ArrayList<Comment>();
			while(rs.next()) {
			
					comments.add(new Comment(rs.getInt("comment_id"), rs.getInt("post_id"), rs.getString("user_name"), rs.getString("comment_message")));
			
			}
			return comments;
			
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return null;
	}
	
	@Override
	public ArrayList<Comment> ShowCommentsByPostId(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage() + ": PostDAOImpl");
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetwork", "root", "");
				PreparedStatement preparedStatement = connection.prepareStatement(
						"SELECT* FROM comments where post_id = ?;")) {
			
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<Comment> comments= new ArrayList<Comment>();
			while(rs.next()) {
			
					comments.add(new Comment(rs.getInt("comment_id"), rs.getInt("post_id"), rs.getString("user_name"), rs.getString("comment_message")));
			
			}
			return comments;
			
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return null;
	}

	

}
