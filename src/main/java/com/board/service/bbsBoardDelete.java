package com.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;

public class bbsBoardDelete implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		int bId = Integer.parseInt(request.getParameter("bId"));

		BoardDAO.getInstance().deleteBoard(bId);
	}

}
