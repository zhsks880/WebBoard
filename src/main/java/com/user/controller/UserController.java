package com.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.service.DeleteUser;
import com.user.service.IUserService;
import com.user.service.JOinService;
import com.user.service.LoginService;
import com.user.service.LogoutService;
import com.user.service.Update;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService sv;

	public UserController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void doRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();

		uri = uri.substring(conPath.length() + 1, uri.lastIndexOf("."));

		System.out.println(uri);

		switch (uri) {

		case "join":
			System.out.println("요청: 회원가입");

			sv = new JOinService();
			sv.execute(request, response);
			break;

		case "login":
			System.out.println("이동: 로그인페이지");
			sv = new LoginService();
			sv.execute(request, response);

			break;

		case "loginGo":
			response.sendRedirect("/WebBoard/user_login.jsp");
			break;

		case "update":
			System.out.println("회원정보 수정 요청");

			sv = new Update();
			sv.execute(request, response);

			break;

		case "delete":
			System.out.println("회원정보 탈퇴 요청");

			sv = new DeleteUser();
			sv.execute(request, response);
			break;

		case "logout":
			System.out.println("로그아웃 요청");
			sv = new LogoutService();
			sv.execute(request, response);

			response.sendRedirect("/WebBoard");
			break;
		}
	}

}
