package com.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardVO;

public class bbsModifyService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		int boardId = Integer.parseInt(request.getParameter("boardId"));

		BoardVO vo = BoardDAO.getInstance().contentBoard(boardId);
		vo.setContent(vo.getContent().replace("<br>", "\r\n"));
		request.setAttribute("boardModigy", vo);
	}

}
