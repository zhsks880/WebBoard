package com.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.model.UserDAO;
import com.user.model.UserVO;

public class Update implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		UserVO vo = new UserVO();
		vo.setUser_id(request.getParameter("id"));
		vo.setUser_name(request.getParameter("name"));
		vo.setUser_pw(request.getParameter("pw"));
		vo.setUser_email1(request.getParameter("email1"));
		vo.setUser_email2(request.getParameter("email2"));
		vo.setUser_hp1(request.getParameter("hp1"));
		vo.setUser_hp2(request.getParameter("hp2"));
		vo.setUser_hp3(request.getParameter("hp3"));
		vo.setUser_address1(request.getParameter("address1"));
		vo.setUser_address2(request.getParameter("address2"));

		UserDAO dao = UserDAO.getInstance();
		dao.updateUser(vo);
		session.setAttribute("user", dao.getUserInfo(vo.getUser_id()));

		response.setContentType("text/html; charset=utf-8");

		try {
			PrintWriter out = response.getWriter();
			String htmlCode = "<script>\r\n" + "alert('회원정보가 수정되었습니다'); \r\n"
					+ "location.href = '/WebBoard/member.board'; \r\n" + "</script>";
			out.print(htmlCode);
			out.flush();
			return;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
