<%@page import="com.board.model.BoardVO"%>
<%@page import="com.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		for(int i=1; i<=100; i++){
			String writer = "aa111";
			String title = "테스트 입니다." + i;
			String content = "테스트 중입니다.!" + i;
			
			BoardVO vo = new BoardVO();
			vo.setWriter(writer); 
			vo.setTitle(title); 
			vo.setContent(content);
			vo.setAdminC(adminC);
			BoardDAO.getInstance().regist(writer, title, content, adminC);
		}
	--%>
	
	<%-- <%
		int countArticles = BoardDAO.getInstance().countArticles();
		out.print("# 총 게시물 수 : " + countArticles + "<br>");
		out.print("----------------------------------------<br>");
		
		// 끝 페이지 번호 계산 테스트
		PageVO paging = new PageVO();
		paging.setPage(31);
		paging.setCpp(10);
		
		int displayBtn = 10;
		
		int endPage = (int) Math.ceil(paging.getPage() / (double) displayBtn) * displayBtn;
		
		out.print("끝 페이지 번호 : " + endPage + "번<br>");
		
		// 시작 페이지 번호 계산 테스트
		int beginPage = (endPage - displayBtn) + 1;
		out.print("시작 페이지 번호 : " + beginPage + "번<br>");
		
		// 이전 버튼 활성, 비활성 여부
		boolean isPrev = (beginPage == 1) ? false : true;
		out.print("이전 버튼 활성화 여부 : " + isPrev + "<br>");
		
		// 다음 버튼 활성화 여부
		boolean isNext = (countArticles <= (endPage * paging.getCpp())) ? false : true;
		out.print("다음 버튼 활성화 여부 : " + isNext + "<br>");
		
		// 끝 페이지 보정
		if(!isNext) {
			endPage = (int) Math.ceil(countArticles / (double) paging.getCpp());
		}
		
		out.print("보정 후 끝 페이지 번호 : " + endPage + "번<br>");
	%> --%>
	
</body>
</html>