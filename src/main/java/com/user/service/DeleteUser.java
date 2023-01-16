package com.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.model.UserDAO;
import com.user.model.UserVO;

public class DeleteUser implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		String check_pw = request.getParameter("check_pw");

		UserVO vo = (UserVO) session.getAttribute("user");
		String id = vo.getUser_id();

		UserDAO dao = UserDAO.getInstance();
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out;
		String htmlCode;

		if(dao.userCheck(id, check_pw) == 1) {
			dao.deleteUser(id);
			session.invalidate();

			try {
				out = response.getWriter();
				htmlCode = "<script>\r\n" + "alert('회원 탈퇴 되었습니다.'); \r\n"
						+ "location.href='/WebBoard/index.jsp'; \r\n" + "</script>";
				out.print(htmlCode);
				out.flush();
				return;

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				out = response.getWriter();
				htmlCode = "<script>\r\n" + "alert('비밀번호가 맞지 않습니다'); \r\n" + "history.back(); \r\n"
						+ "</script>";
				out.print(htmlCode);
				out.flush();
				return;

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
