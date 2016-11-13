package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignatureDB {
	private Connection con;
	public SignatureDB() {
		con = ConnectDatabase.getConnection();
	}
	public int Sign(String checksum,int userID){
		Signature sig=check(checksum);
		if(sig.getId()==0){
		String sql = "INSERT INTO signature(checksum, userID) "
				+ "VALUES (?,?)";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, checksum);
			statement.setInt(2, userID);
			statement.executeUpdate(); 
			return 1;

		} catch (SQLException e) {
			System.err.println("Error Insert data :" + e);
			return 0;
		}
		}else{
			return 2;
		}
		
	}
	public Signature check(String checksum) {
		Signature sig=new Signature();
		String sql = "SELECT * FROM signature,user WHERE signature.checksum=? AND user.userID=signature.userID";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, checksum);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				sig.setChecksum(result.getString("checksum"));
				sig.setId(result.getInt("id"));
				sig.setName(result.getString("username"));
				sig.setTimestamp(result.getString("timestamp"));
				sig.setUserID(result.getInt("userID"));
			} else {
				sig.setUserID(0);
			}
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return sig;
	}
}
