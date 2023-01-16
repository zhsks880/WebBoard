package com.board.model;

import java.util.List;

import com.board.commons.PageVO;

public interface IBoardDAO {

	// 글 등록 메서드
	void regist(String writer, String title, String content, int adminC);

	// 글 전체 목록을 가지고 오는 메서드
//	 List<BoardVO> listBoard();

	// 페이징 처리 이후 글 목록을 가지고 오는 메서드
	List<BoardVO> listBoard(PageVO paging);

	// 글 상세보기 요청을 처리할 메서드
	BoardVO contentBoard(int bId);

	// 글 수정을 요청 처리할 메서드 (제목, 내용)
	void updateBoard(String title, String content, int bId);

	// 글 삭제 요청을 처리할 메서드
	void deleteBoard(int bId);

	// 글 검색 요청을 처리할 메서드
	List<BoardVO> searchBoard(String keyword, String category);

	// 특정 유저 게시물 불러오기
	List<BoardVO> userListBoard(String name, PageVO paging);

	int countArticles();

	// 첫 번째 게시물 불러오기
	BoardVO mainList();

	int mypageCountArticles(String name);

	// 공지 사항
	List<BoardVO> adminBoard();

}
