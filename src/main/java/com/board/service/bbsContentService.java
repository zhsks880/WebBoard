package com.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardVO;

public class bbsContentService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		int bId = Integer.parseInt(request.getParameter("bId"));

		BoardDAO dao = BoardDAO.getInstance();

		BoardVO vo = dao.contentBoard(bId);
		vo.setContent(vo.getContent().replace("<br>", "\r\n"));
		request.setAttribute("bbsContent", vo);
	}

}
