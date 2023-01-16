package com.board.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardVO;

public class SearchService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String category = request.getParameter("category");
		String search = request.getParameter("search");

		List<BoardVO> boardList = BoardDAO.getInstance().searchBoard(search, category);

		if (boardList.size() == 0) {
			response.setContentType("text/html; charset=UTF-8");
			try {
				PrintWriter out = response.getWriter();

				String htmlCode = "<script> \r\n" + "alert('검색 결과가 없습니다.'); \r\n"
						+ "location.href='/WebBoard/list.board'; \r\n" + "</script>";
				out.print(htmlCode);

				out.flush();

				return;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("bList", boardList);
	}

}
