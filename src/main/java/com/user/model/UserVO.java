package com.user.model;

public class UserVO {

	private String user_id;
	private String user_pw;
	private String user_name; 
	private String user_hp1;
	private String user_hp2; 
	private String user_hp3; 
	private String user_email1;
	private String user_email2; 
	private String user_address1;
	private String user_address2;
	
	public UserVO() {}
	

	public UserVO(String user_id, String user_pw, String user_name, String user_hp1, String user_hp2, String user_hp3,
			String user_email1, String user_email2, String user_address1, String user_address2) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_hp1 = user_hp1;
		this.user_hp2 = user_hp2;
		this.user_hp3 = user_hp3;
		this.user_email1 = user_email1;
		this.user_email2 = user_email2;
		this.user_address1 = user_address1;
		this.user_address2 = user_address2;
	}



	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_hp1() {
		return user_hp1;
	}

	public void setUser_hp1(String user_hp1) {
		this.user_hp1 = user_hp1;
	}

	public String getUser_hp2() {
		return user_hp2;
	}

	public void setUser_hp2(String user_hp2) {
		this.user_hp2 = user_hp2;
	}

	public String getUser_hp3() {
		return user_hp3;
	}

	public void setUser_hp3(String user_hp3) {
		this.user_hp3 = user_hp3;
	}

	public String getUser_email1() {
		return user_email1;
	}

	public void setUser_email1(String user_email1) {
		this.user_email1 = user_email1;
	}

	public String getUser_email2() {
		return user_email2;
	}

	public void setUser_email2(String user_email2) {
		this.user_email2 = user_email2;
	}

	public String getUser_address1() {
		return user_address1;
	}

	public void setUser_address1(String user_address) {
		this.user_address1 = user_address;
	}


	public String getUser_address2() {
		return user_address2;
	}

	public void setUser_address2(String user_address2) {
		this.user_address2 = user_address2;
	}
	
	
}	
