package com.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.model.UserDAO;
import com.user.model.UserVO;

public class JOinService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		UserDAO dao = UserDAO.getInstance();
		
		response.setContentType("text/html; charset=utf-8");
		String htmlCode;
		
		if(dao.confirmID(id)) {
			try {
				PrintWriter out = response.getWriter();
				htmlCode = "<script>\r\n" +
						"alert(\"아이디가 중복되었습니다.\"); \r\n" +
						"history.back(); \r\n" +
						"</script>";
				out.print(htmlCode);
				out.flush();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} else {
			
			UserVO vo = new UserVO(
					id,
					request.getParameter("password"),
					request.getParameter("name"),
					request.getParameter("hp1"),
					request.getParameter("hp2"),
					request.getParameter("hp3"),
					request.getParameter("email1"),
					request.getParameter("email2"),
					request.getParameter("address1"),
					request.getParameter("address2")
					);
				dao.insertUser(vo);
			
				try {
					PrintWriter out = response.getWriter();
					htmlCode = "<script>\r\n" +
							"alert(\"회원가입을 환영합니다\"); \r\n" +
							"location.href='/WebBoard/user_login.jsp'; \r\n" +
							"</script>";
					out.print(htmlCode);
					out.flush();
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
