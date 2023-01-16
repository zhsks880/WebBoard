package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.board.commons.PageVO;

public class BoardDAO implements IBoardDAO {

	private DataSource ds;

	private BoardDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static BoardDAO dao = new BoardDAO();

	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	@Override
	public void regist(String writer, String title, String content, int adminC) {
		String sql = "INSERT INTO web_board" + "(board_id, writer, title, content, adminC) "
				+ "VALUES(web_board_seq.NEXTVAL,?,?,?,?)";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, adminC);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BoardVO> listBoard(PageVO paging) {
		List<BoardVO> articles = new ArrayList<>();
		String sql = "SELECT * FROM" + "    (" + "    SELECT ROWNUM AS rn, tbl.*FROM" + "        ("
				+ "        SELECT * FROM web_board " + " ORDER BY adminC DESC, board_id DESC" + "        ) tbl"
				+ "    )" + "WHERE rn > " + (paging.getPage() - 1) * paging.getCpp() + "AND rn <= "
				+ paging.getPage() * paging.getCpp();

		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("board_id"), rs.getString("writer"), rs.getString("title"),
						rs.getString("content"), rs.getTimestamp("reg_date"), rs.getInt("hit"), rs.getInt("adminC"));

				articles.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public BoardVO contentBoard(int bId) {
		BoardVO vo = null;

		String sql = "SELECT * FROM web_board WHERE board_id = ?";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, bId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new BoardVO(rs.getInt("board_Id"), rs.getString("writer"), rs.getString("title"),
						rs.getString("content").replace("\r\n", "<br>"), rs.getTimestamp("reg_date"), rs.getInt("hit"),
						rs.getInt("adminC"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public void updateBoard(String title, String content, int bId) {
		String sql = "UPDATE web_board SET title = ?, content = ? WHERE board_id = ?";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBoard(int bId) {
		String sql = "DELETE FROM web_board WHERE board_id = ?";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BoardVO> searchBoard(String keyword, String category) {

		List<BoardVO> boardList = new ArrayList<>();

		String sql = "SELECT * FROM web_board WHERE " + category + " LIKE ? ORDER BY board_id DESC";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, "%" + keyword + "%");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("board_id"), rs.getString("writer"), rs.getString("title"),
						rs.getString("content"), rs.getTimestamp("reg_date"), rs.getInt("hit"), rs.getInt("adminC"));
				boardList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boardList;
	}

	@Override
	public List<BoardVO> userListBoard(String name, PageVO paging) {
		List<BoardVO> boardList = new ArrayList<>();

		String sql = "SELECT * FROM" + "(" + "SELECT ROWNUM AS rn, tbl.* FROM" + "(" + "SELECT * FROM web_board "
				+ "WHERE writer = ? " + "ORDER BY board_id DESC" + ") tbl" + ")" + "WHERE rn > "
				+ (paging.getPage() - 1) * paging.getCpp() + "AND rn <= " + paging.getPage() * paging.getCpp();

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("board_id"), rs.getString("writer"), rs.getString("title"),
						rs.getString("content"), rs.getTimestamp("reg_date"), rs.getInt("hit"), rs.getInt("adminC"));
				boardList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boardList;
	}

	@Override
	public int countArticles() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM web_board WHERE writer NOT IN ('admin')";
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public BoardVO mainList() {
		BoardVO vo = null;
		String sql = "SELECT * FROM "
				+ "(SELECT ROWNUM AS rn, tbl.* FROM "
				+ "(SELECT * FROM web_board WHERE writer = 'admin' ORDER BY reg_date DESC) tbl) WHERE rn=1";
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				vo = new BoardVO(rs.getInt("board_id"), rs.getString("writer"), rs.getString("title"),
						rs.getString("content"), rs.getTimestamp("reg_date"), rs.getInt("hit"), rs.getInt("adminC"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public int mypageCountArticles(String name) {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM web_board WHERE writer = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public List<BoardVO> adminBoard() {
		List<BoardVO> boardList = new ArrayList<>();

		String sql = "SELECT * FROM web_board WHERE writer = 'admin' ORDER BY reg_date DESC";

		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("board_id"), rs.getString("writer"), rs.getString("title"),
						rs.getString("content"), rs.getTimestamp("reg_date"), rs.getInt("hit"), rs.getInt("adminC"));
				boardList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boardList;
	}
}
