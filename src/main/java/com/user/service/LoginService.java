package com.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.model.UserDAO;

public class LoginService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		response.setContentType("text/html; charset=utf-8");

		UserDAO dao = UserDAO.getInstance();

		String htmlCode;
		PrintWriter out;

		int result = dao.userCheck(id, pw);

		if (result == -1) {

			try {
				out = response.getWriter();
				htmlCode = "<script>\r\n" + "alert(\'아이디가 존재하지 않습니다. 로그인 해 주세요.\'); \r\n"
						+ "location.href='/WebBoard/user_login.jsp'; \r\n" + "</script>";

				out.print(htmlCode);
				out.flush();
				return;

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (result == 0) {

			try {
				out = response.getWriter();
				htmlCode = "<script>\r\n" + "alert(\"비밀번호가 틀렸습니다.\"); \r\n" + "history.back(); \r\n" + "</script>";

				out.print(htmlCode);
				out.flush();
				return;

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", dao.getUserInfo(id));

			try {

				response.sendRedirect("/WebBoard/member.board");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
