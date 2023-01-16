package com.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.commons.PageCreator;
import com.board.commons.PageVO;
import com.board.model.BoardDAO;
import com.board.model.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		PageVO paging = new PageVO();
		BoardDAO dao = BoardDAO.getInstance();

		if (request.getParameter("page") != null) {
			paging.setPage(Integer.parseInt(request.getParameter("page")));
			paging.setCpp(Integer.parseInt(request.getParameter("cpp")));

		}

		List<BoardVO> boardList = dao.listBoard(paging);

		PageCreator pc = new PageCreator();

		pc.setPaging(paging);
		pc.setArticleTotalCount(dao.countArticles());

		request.setAttribute("bList", boardList);
		request.setAttribute("pc", pc);
	}

}
