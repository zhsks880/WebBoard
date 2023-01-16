package com.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;

public class RegistService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		if(request.getParameter("adminC") == null) {
			String writer = request.getParameter("buId");
			String title = request.getParameter("btitle");
			String content = request.getParameter("bcontent");
			BoardDAO.getInstance().regist(writer, title, content, 0);
		} else {
			int adminC = Integer.parseInt(request.getParameter("adminC"));
			String writer = request.getParameter("buId");
			String title = request.getParameter("btitle");
			String content = request.getParameter("bcontent");
			BoardDAO.getInstance().regist(writer, title, content, adminC);
		}
		

	}

}
