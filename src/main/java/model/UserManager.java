package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserManager {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private void getConnection() throws ClassNotFoundException, SQLException {
		if (con == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/user";
			String user = "root";
			String password = "root123";
			
			con = DriverManager.getConnection(url, user, password);
		}
	}
	
	// Register user
	public void setUser(String name, String age) {
		try {
			// Connect to database
			getConnection();
			
			String sql = "INSERT INTO user_list(name, age) VALUE (?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, Integer.parseInt(age));
			
			// Register user to database
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Disconnect database
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<User> getUserList() {
		ArrayList<User> list = new ArrayList<User>();
		
		try {
			getConnection();
			
			String sql = "SELECT * FROM user_list";
			ps = con.prepareStatement(sql);
			
			// Get user data from database
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				User user1 = new User(name, age);
				list.add(user1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// Close database
	private void close() throws SQLException {
		if (con != null) {
			con.close();
		}
		
		if (ps != null) {
			ps.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
}
