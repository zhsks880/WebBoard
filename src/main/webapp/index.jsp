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

<!-- #SQL 구문 
CREATE TABLE web_board (
    board_id NUMBER PRIMARY KEY,
    writer VARCHAR2(30) NOT NULL,
    title VARCHAR2(100) NOT NULL,
    content VARCHAR2(2000),
    reg_date DATE DEFAULT sysdate,
    hit NUMBER DEFAULT 0
);

CREATE SEQUENCE web_board_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000
    NOCYCLE
    NOCACHE;
    
CREATE TABLE web_user (
    user_id VARCHAR2(30) PRIMARY KEY,
    user_pw VARCHAR2(30) NOT NULL,
    user_name VARCHAR2(20) NOT NULL,
    user_hp1 VARCHAR2(5),
    user_hp2 VARCHAR2(5),
    user_hp3 VARCHAR2(5),
    user_email1 VARCHAR2(100),
    user_email2 VARCHAR2(100),
    user_address VARCHAR2(100)
);
alter table web_user add user_address2 varchar2(100);
alter table web_user rename column user_address to user_address1;
select * from web_user;


insert into web_board
values(web_board_seq.nextval, 'admin', '공지사항입니다', '공지내용입니다.', sysdate, 0, 1);
commit;

select * from web_board;
select * from web_user;
ALTER TABLE web_board ADD adminC NUMBER DEFAULT 0;

INSERT INTO web_board (board_id, writer, title, content) 
VALUES (web_board_seq.NEXTVAL, 'aa111', '1번째 제목', '세번째 내용');

-->


<!--메인만 적용되는 css영역-->
<style>
body {
	background-image: url(images/main.jpg);
	background-repeat: no-repeat;
	background-size: cover
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${mainList == null}">
			<c:redirect url="/mainList.board"/>
		</c:when>
		<c:otherwise>
			<%@ include file="./include/header.jsp"%>
			<section>
				<div class="container" id="mainCon">
					<div class="jumbotron" id="jbDiv">
						<div class="container" id="introArea">
							<h1>Class 3강의장</h1>
							<h2>1st of child : 전상현</h2>
							<h2>2nd of child : 최재교</h2>
							<h2>last of child : 임지훈</h2>

						</div>

					</div>

					<div class="col-md-6 col-xs-12" style="padding: 0px 0px;">
						<h2 style="color: white;">최신 공지사항</h2>
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
								<tr>
									<td>1</td>
									<td><a
										href="/WebBoard/content.board?bId=${mainList.board_id}">${mainList.title}</a></td>
									<td>${mainList.writer}</td>
									<td><fmt:formatDate value="${mainList.reg_date}"
											pattern="yyyy-MM-dd hh:mm" /></td>
								</tr>
							</tbody>
						</table>
					</div>

				</div>
			</section>
			<%@ include file="./include/footer.jsp"%>
		</c:otherwise>
	</c:choose>
</body>
</html>