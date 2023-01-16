package com.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out;
		String htmlCode;

		try {
			out = response.getWriter();
			htmlCode = "<script>\r\n" + "alert('로그아웃 되었습니다.'); \r\n" + "location.href='/WebBoard/index.jsp'; \r\n"
					+ "</script>";

			session.invalidate();
			out.print(htmlCode);
			out.flush();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
