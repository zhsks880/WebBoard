package com.board.commons;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginAuth",
		urlPatterns = {
		"/member.board", 
		"/bbsModify.board", "/bbsContentUpdate", 
		"/bbsBoardDelete", 
		"/write.board", "/regist.board", "/Search.board",
		"/update.user", "/delete.user"
		}
		)
public class Fiters implements Filter {

	public Fiters() {}

	@Override
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("doFilter 발동!!");

		HttpSession session = ((HttpServletRequest)request).getSession();

		if(session.getAttribute("user") == null) {
			System.out.println("회원아님 쫓아냄!");

			HttpServletResponse resp = (HttpServletResponse) response;
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script> \r\n");
			out.print("alert('로그인이 필요합니다.'); \r\n");
			out.print("location.href='/WebBoard/user_login.jsp' \r\n");
			out.print("</script> \r\n");
			out.flush();
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("로그인 권한 필터 생성됨!");
	}
}
