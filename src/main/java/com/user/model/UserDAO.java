package com.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO implements IUserDAO {

	// singletone 제작

	private DataSource ds;

	public UserDAO() {

		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static UserDAO dao = new UserDAO();

	public static UserDAO getInstance() {
		if (dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}

	///////////////////////////////////////////////////////////////////

	@Override
	public boolean confirmID(String id) {
		boolean flag = false;

		String sql = "select * from web_user where user_id=?";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public void insertUser(UserVO vo) {

		String sql = "insert into web_user values(?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, vo.getUser_id());
			pstmt.setString(2, vo.getUser_pw());
			pstmt.setString(3, vo.getUser_name());
			pstmt.setString(4, vo.getUser_hp1());
			pstmt.setString(5, vo.getUser_hp2());
			pstmt.setString(6, vo.getUser_hp3());
			pstmt.setString(7, vo.getUser_email1());
			pstmt.setString(8, vo.getUser_email2());
			pstmt.setString(9, vo.getUser_address1());
			pstmt.setString(10, vo.getUser_address2());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int userCheck(String id, String pw) {
		int check = -1;

		String sql = "select * from web_user where user_id=?";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbPw = rs.getString("user_pw");
				if (dbPw.equals(pw))
					check = 1;
				else
					check = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public UserVO getUserInfo(String id) {
		UserVO user = null;

		String sql = "select * from web_user where user_id='" + id + "'";

		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				user = new UserVO(rs.getString("user_id"), rs.getString("user_pw"), rs.getString("user_name"),
						rs.getString("user_hp1"), rs.getString("user_hp2"), rs.getString("user_hp3"),
						rs.getString("user_email1"), rs.getString("user_email2"), rs.getString("user_address1"),
						rs.getString("user_address2"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void changePassword(String id, String newPw) {

	}

	@Override
	public void updateUser(UserVO vo) {

		String sql = "update web_user set user_name=?, user_pw=?, user_email1=?, "
				+ "user_email2=?, user_hp1=?, user_hp2=?, user_hp3=?, user_address1=?, user_address2=? where user_id=?";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, vo.getUser_name());
			pstmt.setString(2, vo.getUser_pw());
			pstmt.setString(3, vo.getUser_email1());
			pstmt.setString(4, vo.getUser_email2());
			pstmt.setString(5, vo.getUser_hp1());
			pstmt.setString(6, vo.getUser_hp2());
			pstmt.setString(7, vo.getUser_hp3());
			pstmt.setString(8, vo.getUser_address1());
			pstmt.setString(9, vo.getUser_address2());
			pstmt.setString(10, vo.getUser_id());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(String id) {

		String sql = "delete from web_user where user_id=?";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
