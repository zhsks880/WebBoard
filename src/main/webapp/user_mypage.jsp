<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">

<style type="text/css">
</style>
</head>
<body>
	<%@ include file="./include/header.jsp"%>
	<section>
		<div class="container">
			<div class="row join-wrap">
				<div class="col-xs-12 col-md-9 join-form">
					<div class="titlebox">MEMBER</div>
					<div>
						<p>${user.user_name}님회원정보</p>
					</div>
					<div>
						<button type="button" class="btn btn-primary"
							onclick="location.href='/WebBoard/user_mypageinfo.jsp';">회원정보변경</button>
						<button type="button" class="btn btn-primary" id="delCheck">회원탈퇴</button>
					</div>
					<div class="delete-hidden">
						<form action="/WebBoard/delete.user">
							<input type="password" class="form-control" name="check_pw"
								placeholder="비밀번호를 입력하세요">
							<button type="submit" class="btn btn-primary">확인</button>
						</form>
					</div>
					<br>
					<div>
						<p>${user.user_name}님의작성게시물</p>
						<table class="table table-striped"
							style="text-align: center; border: 2px solid #737373">
							<thead>
								<tr>
									<th style="text-align: center;">번호</th>
									<th style="text-align: center;">제목</th>
									<th style="text-align: center;">작성자</th>
									<th style="text-align: center;">작성일</th>
								</tr>
							</thead>
							
							<!-- 작성자 게시물 가져오기 -->
							<tbody>
								<c:forEach var="i" items="${userBoardList}">
									<tr>
										<td>${i.board_id}</td>
										<td><a href="/WebBoard/content.board?bId=${i.board_id}">${i.title}</a></td>
										<td>${i.writer}</td>
										<td>${i.reg_date}</td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
						<div class="text-center">
							<ul class="pagination pagination-sm">
								<c:if test="${pc.prev}">
									<li><a
										href="/WebBoard/member.board?page=${pc.beginPage - 1}&cpp=${pc.paging.cpp}">이전</a>
									</li>
								</c:if>
								<c:forEach var="pageNum" begin="${pc.beginPage}"
									end="${pc.endPage}">
									<li class="active"><a
										href="/WebBoard/member.board?page=${pageNum}&cpp=${pc.paging.cpp}"
										style="${pageNum == pc.paging.page ? 'background-color: #000080;' : ''}"">${pageNum}</a></li>
								</c:forEach>
								<c:if test="${pc.next}">
									<li><a
										href="/WebBoard/member.board?page=${pc.endPage + 1}&cpp=${pc.paging.cpp}">다음</a>
									</li>
								</c:if>
							</ul>
							<!-- <form action="/WebBoard/Search.board" class="form-inline"
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
							-->
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="./include/footer.jsp"%>
	<script>
		//탈퇴버튼 디스플레이 처리
		var delCheck = document.getElementById("delCheck");
		delCheck.onclick = function() {
			var del = document.querySelector(".delete-hidden");
			if (del.style.display == "none" || del.style.display == "") {
				del.style.display = "inline";
			} else {
				del.style.display = "none";
			}
		}
	</script>
</body>
</html>