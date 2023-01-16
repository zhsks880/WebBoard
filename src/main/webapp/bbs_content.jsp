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
<title>BBS Test</title>
</head>
<body>

	<%@ include file="./include/header.jsp"%>

	<section>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 col-sm-12 join-form">
					<h2>
						게시판 상세보기<small>(디자인이궁금하세요?)</small>
					</h2>

					<form action="/WebBoard/bbsModify.board" method="post">
						<div class="form-group">
							<label>등록일</label> <input type="text" class="form-control"
								value="<fmt:formatDate value="${bbsContent.reg_date}" pattern="yyyy년 MM월 dd일 a hh시 mm뷴"/>"
								readonly>
						</div>
						<div class="form-group">
							<label>글번호</label> <input type="text" class="form-control"
								name="boardId" value="${bbsContent.board_id}" readonly>
						</div>
						<div class="form-group">
							<label>글쓴이</label> <input type="text" class="form-control"
								placeholder="자유" value="${bbsContent.writer}" readonly>
						</div>
						<div class="form-group">
							<label>제목</label> <input type="text" class="form-control"
								placeholder="자유" value="${bbsContent.title}" readonly>
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="5" readonly>${bbsContent.content}</textarea>
						</div>

						<!--구현로직: 버튼은 온클릭을 사용하던 자바스크립트를 이용해야 합니다-->
						<!-- 로그인 유무에 따른 버튼 유무 -->
						<c:choose>
							<c:when test="${user.user_id == bbsContent.writer}">
								<div class="form-group">
									<button type="button" class="btn btn-success"
										onclick="location.href='/WebBoard/list.board'">목록</button>
										<button type="submit" class="btn btn-info">수정</button>
								</div>
							</c:when>
							<c:otherwise>
								<div class="form-group">
									<button type="button" class="btn btn-success"
										onclick="location.href='/WebBoard/list.board'">목록</button>
								</div>
							</c:otherwise>

						</c:choose>
					</form>
				</div>
			</div>
		</div>


	</section>

	<%@ include file="./include/footer.jsp"%>

</body>
</html>