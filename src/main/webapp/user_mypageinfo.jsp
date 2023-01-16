<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
</head>
<body>

	<%@ include file="./include/header.jsp"%>

	<section>
		<div class="container">
			<div class="row join-wrap">
				<!--join-form을 적용한다 float해제 margin:0 auto-->
				<div class="col-xs-12 col-md-9 join-form">

					<div class="titlebox">MEMBER INFO</div>

					<p>*표시는 필수 입력 표시입니다</p>
					<form action="/WebBoard/update.user">
						<table class="table">
							<tbody class="m-control">
								<tr>
									<td class="m-title">*ID</td>
									<td><input class="form-control input-sm" name="id"
										value="${user.user_id}" readonly></td>
								</tr>
								<tr>
									<td class="m-title">*이름</td>
									<td><input class="form-control input-sm" name="name"
										value="${user.user_name}"></td>
								</tr>
								<tr>
									<td class="m-title">*비밀번호</td>
									<td><input type="password" class="form-control input-sm" name="pw" placeholder="필수로 넣어주세요"></td>
								</tr>
								<tr>
									<td class="m-title">*비밀번호확인</td>
									<td><input type="password" class="form-control input-sm" name="pw-confirm" placeholder="필수로 넣어주세요"></td>
								</tr>
								<tr>
									<td class="m-title">*E-mail</td>
									<td><input class="form-control input-sm" name="email1"
										value="${user.user_email1}">@ <select
										class="form-control input-sm sel" name="email2">
											<option>naver.com</option>
											<option>gmail.com</option>
											<option>daum.net</option>
									</select>
										<button class="btn btn-info">중복확인</button></td>
								</tr>
								<tr>
									<td class="m-title">*휴대폰</td>
									<td><input class="form-control input-sm sel" name="hp1"
										value="${user.user_hp1}"> - <input
										class="form-control input-sm sel" name="hp2"
										value="${user.user_hp2}"> - <input
										class="form-control input-sm sel" name="hp3"
										value="${user.user_hp3}"></td>
								</tr>
								<tr>
									<td class="m-title">*주소</td>
									<td><input class="form-control input-sm add"
										name="address1" value="${user.user_address1}"></td>
								</tr>
								<tr>
									<td class="m-title">*상세주소</td>
									<td><input class="form-control input-sm add"
										name="address2" value="${user.user_address2}"></td>
								</tr>
							</tbody>
						</table>


						<div class="titlefoot">
							<button type="submit" class="btn"
								onclick="return confirm('비밀번호 변경 안하면 수정이 안됩니다.\n 수정하시겠습니까?')">수정</button>
							<button type="button" class="btn"
								onclick="location.href='/WebBoard/member.board'">목록</button>
						</div>
					</form>
				</div>


			</div>

		</div>

	</section>

	<%@ include file="./include/footer.jsp"%>

</body>
</html>