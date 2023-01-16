<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>BBS Test</title>

<!--게시판만 적용되는 css-->
<style>
.table-striped>tbody>tr {
	background-color: rgba(255, 255, 255)
}

.row h2 {
	color: aliceblue;
}

.pagination-sm {
	margin: 0;
}
</style>
</head>
<body>

	<%@ include file="./include/header.jsp"%>

	<section>

		<div class="container">
			<div class="row">

				<h2>게시판 목록</h2>
				<table class="table table-striped"
					style="text-align: center; border: 2px solid #737373">
					<thead>
						<tr>
							<th style="background-color: #9DCAFF; text-align: center;">번호</th>
							<th style="background-color: #9DCAFF; text-align: center;">제목</th>
							<th style="background-color: #9DCAFF; text-align: center;">작성자</th>
							<th style="background-color: #9DCAFF; text-align: center;">작성일</th>
						</tr>
					</thead>
					<tbody>
					
					<!-- admin 이라는 관리자 계정 따로 생성 하여 1값=admin 0=일반사용자로 구분하여 표시 -->
						<c:forEach var="b" items="${bList}">
							
								<tr style="${b.adminC eq '1' ? 'color: #FF4500' : ''}">
									<td>${b.board_id}</td>
									<td><a href="/WebBoard/content.board?bId=${b.board_id}" style="${b.adminC eq '1' ? 'color: #FF4500' : ''}">${b.title}</a></td>
									<td>${b.writer}</td>
									<td><fmt:formatDate value="${b.reg_date}"
											pattern="yyyy-MM-dd hh:mm" /></td>
									<%-- <td>${b.hit}</td> --%>
								</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="text-center">
					<ul class="pagination pagination-sm">
						<c:if test="${pc.prev}">
							<li><a
								href="/WebBoard/list.board?page=${pc.beginPage - 1}&cpp=${pc.paging.cpp}">이전</a>
							</li>
						</c:if>
						<c:forEach var="pageNum" begin="${pc.beginPage}"
							end="${pc.endPage}">
							<li class="active"><a
								href="/WebBoard/list.board?page=${pageNum}&cpp=${pc.paging.cpp}" style="${pageNum == pc.paging.page ? 'background-color: #000080;' : ''}">${pageNum}</a></li>
						</c:forEach>
						<c:if test="${pc.next}">
							<li><a
								href="/WebBoard/list.board?page=${pc.endPage + 1}&cpp=${pc.paging.cpp}">다음</a>
							</li>
						</c:if>
					</ul>
					<form action="/WebBoard/Search.board" class="form-inline"
						method="post">
						<div class="form-group">
							<select name="category" class="form-control">
								<option value="title">제목</option>
								<option value="writer">작성자</option>
								<option value="content">내용</option>
							</select> <input type="text" name="search" placeholder="검색어 입력"
								class="form-control"> <input type="submit" value="검색"
								class="btn btn-default">
						</div>
					</form>

					<!-- 로그인 유무에 따른 버튼 -->
					<c:choose>
						<c:when test="${user==null}">
							<button class="btn btn-info pull-right"
								onclick="location.href='/WebBoard/user_login.jsp'">로그인
								후 글쓰기</button>
						</c:when>

						<c:otherwise>
							<button class="btn btn-info pull-right"
								onclick="location.href='/WebBoard/write.board'">글쓰기</button>
						</c:otherwise>
					</c:choose>

				</div>

			</div>
		</div>
	</section>

	<%@ include file="./include/footer.jsp"%>

</body>
</html>