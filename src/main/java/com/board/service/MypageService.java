package com.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.commons.PageCreator;
import com.board.commons.PageVO;
import com.board.model.BoardDAO;
import com.board.model.BoardVO;
import com.user.model.UserVO;

public class MypageService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		PageVO paging = new PageVO();

		BoardDAO dao = BoardDAO.getInstance();

		if (request.getParameter("page") != null) {
			paging.setPage(Integer.parseInt(request.getParameter("page")));
			paging.setCpp(Integer.parseInt(request.getParameter("cpp")));
		}

		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");

		List<BoardVO> list = dao.userListBoard(vo.getUser_id(), paging);

		PageCreator pc = new PageCreator();

		pc.setPaging(paging);
		pc.setArticleTotalCount(dao.mypageCountArticles(vo.getUser_id()));

		request.setAttribute("userBoardList", list);

		request.setAttribute("pc", pc);
	}

}
