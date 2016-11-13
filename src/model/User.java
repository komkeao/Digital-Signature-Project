package model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private int userID;
	private String ssn;
	private String username;
	private String email;
	private String password;
	private String address;
	private int adviserID;
	public int getAdviserID() {
		return adviserID;
	}
	public void setAdviserID(int adviserID) {
		this.adviserID = adviserID;
	}
	private int type;
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String generateSign(){
		String str=username+email+ssn+address;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		str+=dateFormat.format(new Date());
		InputStream stream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
		try {
			str=ChecksumGenerator.generate(stream, "MD5");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
}
