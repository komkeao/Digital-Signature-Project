package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
	private Connection con;

	public UserDB() {
		con = ConnectDatabase.getConnection();
	}

	public User login(String email, String password) {
		User user = new User();
		String sql = "SELECT * FROM User WHERE email=? AND password=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				user.setUserID(result.getInt("userID"));
				user.setPassword(result.getString("password"));
				user.setEmail(result.getString("email"));
				user.setAddress(result.getString("address"));
				user.setType(result.getInt("type"));
				user.setUsername(result.getString("username"));
				user.setSsn(result.getString("ssn"));
			} else {
				user.setUserID(0);
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return user;
	}

	public void register(User user) {
		String sql = "INSERT INTO User(address, TYPE, PASSWORD, email, ssn, username) "
				+ "VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, user.getAddress());
			statement.setInt(2, user.getType());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getSsn());
			statement.setString(6, user.getUsername());
			statement.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Error Insert data :" + e);
		}

	}

	public User getUserProfileById(int userId) {
		User user = new User();
		String sql = "SELECT * FROM User WHERE userID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, userId);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				user.setUserID(result.getInt("userID"));
				user.setPassword(result.getString("password"));
				user.setEmail(result.getString("email"));
				user.setAddress(result.getString("address"));
				user.setType(result.getInt("type"));
				user.setUsername(result.getString("username"));
				user.setSsn(result.getString("ssn"));
			} else {
				user.setUserID(0);
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return user;
	}

	public int checkEmailAvailabilities(String email) {
		int res = 1;
		String sql = "SELECT * FROM User WHERE email=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				res = 0;
			}
			
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return res;
	}

	public void deleteUserById(int userId) {
		String sql = "DELETE FROM User Where userID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, userId);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}
}
