package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.GetListService;
import com.board.service.IBoardService;
import com.board.service.MainListService;
import com.board.service.MypageService;
import com.board.service.RegistService;
import com.board.service.SearchService;
import com.board.service.bbsBoardDelete;
import com.board.service.bbsContentService;
import com.board.service.bbsContentUpdate;
import com.board.service.bbsModifyService;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dp;
	private IBoardService sv;

	public BoardController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doRequest(request, response);
	}

	protected void doRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();

		uri = uri.substring(conPath.length() + 1, uri.lastIndexOf("."));

		System.out.println("현재 요청 uri : " + uri);

		switch (uri) {
		case "member":
			System.out.println("마이페이지로 이동.");
			sv = new MypageService();
			sv.execute(request, response);

			dp = request.getRequestDispatcher("user_mypage.jsp");
			dp.forward(request, response);

			break;

		case "content":
			sv = new bbsContentService();
			sv.execute(request, response);

			dp = request.getRequestDispatcher("bbs_content.jsp");
			dp.forward(request, response);

			break;

		case "bbsModify":
			sv = new bbsModifyService();
			sv.execute(request, response);

			dp = request.getRequestDispatcher("bbs_modify.jsp");
			dp.forward(request, response);

			break;

		case "bbsContentUpdate":
			sv = new bbsContentUpdate();
			sv.execute(request, response);

			response.sendRedirect("content.board?bId=" + request.getParameter("bId"));
			break;

		case "bbsBoardDelete":
			sv = new bbsBoardDelete();
			sv.execute(request, response);

			dp = request.getRequestDispatcher("member.board");
			dp.forward(request, response);
			break;

		case "list":
			System.out.println("글 목록 요청이 들어옴!");

			sv = new GetListService();
			sv.execute(request, response);

			dp = request.getRequestDispatcher("bbs.jsp");
			dp.forward(request, response);
			break;

		case "write":
			response.sendRedirect("bbs_write.jsp");
			break;

		case "regist":
			System.out.println("글 등록 요청이 들어옴!");

			sv = new RegistService();
			sv.execute(request, response);
			response.sendRedirect("list.board");
			break;

		case "mainList":

			sv = new MainListService();
			sv.execute(request, response);

			dp = request.getRequestDispatcher("index.jsp");
			dp.forward(request, response);
			break;

		case "Search":

			sv = new SearchService();
			sv.execute(request, response);

			if (request.getAttribute("bList") != null) {
				dp = request.getRequestDispatcher("bbs.jsp");
				dp.forward(request, response);
			}
			break;
		}
	}
}
