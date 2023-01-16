<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    <title>BBS Test</title>
    
    
    <!--회원가입 폼만 적용되는 css-->
    <style type="text/css">
        .table-striped>tbody>tr {
            background-color: #f9f9f9
        }

        .join-form {
            margin: 0 auto;
            padding: 20px;
            width: 50%;
            float: none;
            background-color: white;
        }
        
        
        .form-group > .sel {
            width: 120px;
            display: inline-block;
            
        }
    </style>
</head>
<body>
	<%@ include file="./include/header.jsp" %>
	
	<section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <h2>회원가입<small>(가운데정렬)</small></h2>

                    <form action="/WebBoard/join.user">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 (영문포함 4~12자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" name="password" id="password" placeholder="비밀번호 (영 대/소문자, 숫자, 특수문자 3종류 이상 조합 8자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="password-confrim">비밀번호 확인</label>
                            <input type="password" class="form-control" name="password-confirm" id="password-confirm" placeholder="비밀번호를 확인해주세요.">
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" name="name" id="name" placeholder="이름을 입력하세요.">
                        </div>
                        <!--input2탭의 input-addon을 가져온다 -->
                        <div class="form-group">
                            <label for="hp">휴대폰번호</label><br>
                            
                            <input class="form-control sel" name="hp1" placeholder="010"> -
                            <input class="form-control sel" name="hp2" placeholder="xxxx"> -
                            <input class="form-control sel" name="hp3" placeholder="xxxx">
                        
                        </div>
                        <div class="form-group">
                             <label for="hp">이메일</label><br>
                            <input class="form-control sel" name="email1">@
                            <select class="form-control sel" name="email2">
                                <option>naver.com</option>
                                <option>gmail.com</option>
                                <option>daum.net</option>
                            </select>
                        </div>
                        
                        <div class="form-group">
                            <label for="addr-num">주소</label>
                            <input type="text" class="form-control" name="address1" id="address1" placeholder="기본주소">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="address2" id="address2" placeholder="상세주소">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-lg btn-success btn-block" onclick="return confirm('가입하시겄습니까?')">회원가입</button>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-info btn-block" onclick="location.href='/WebBoard/user_login.jsp'">로그인</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </section>
	
	<%@ include file="./include/footer.jsp" %>

</body>
</html>