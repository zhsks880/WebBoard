package com.user.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoMypage implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			response.sendRedirect("/WebBoard/user_mypage.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
