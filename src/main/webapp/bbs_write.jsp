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
        
        <!--글쓰기만 적용되는 css-->   
	    <style>
	        .table-striped {
	            text-align: center; 
	            border: 2px solid #737373; 
	        }
	
	        .table-striped>tbody>tr {
	            background-color: #f9f9f9
	        }
	    </style>
</head>
<body>

	<%@ include file="./include/header.jsp" %>
	
	<section>
        <div class="container" style="margin-top: 5%;">
            <div class="row">
                <form action="/WebBoard/regist.board" method="post">
                    <table class="table table-striped" >
                        <thead>
                            <tr>
                                <th colspan="2" style="background-color: #9DCAFF; text-align: center;">게시판 글쓰기</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:if test="${user.user_id eq 'admin'}">
	                        	<tr>
		                        	<td>
		                        		<input type="checkbox" name="adminC" value="1">공지사항
		                        	</td>
	                        	</tr>
                        	</c:if>
                        	
                            <tr>
                                <td><input type="text" class="form-control" placeholder="작성자" name="bwriter" maxlength="50" value="${user.user_name}" readonly>
                                	<input type="hidden" value="${user.user_id}" name="buId">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="text" class="form-control" placeholder="글 제목" name="btitle" maxlength="50"></td>
                            </tr>
                            <tr>
                                <td><textarea rows="15" class="form-control" placeholder="1000 글자 이하" name="bcontent" maxlength="1000" ></textarea></td>
                            </tr>
                            
                            
                        </tbody>
                    </table>
                    
                    <input type="button" class="btn btn-primary pull-left" value="목록" onclick="location.href='/WebBoard/list.board'">
                    <input type="submit" class="btn btn-primary pull-right" value="글쓰기">
                </form>
            </div>
        </div>
    </section>
	
	<%@ include file="./include/footer.jsp" %>

</body>
</html>