<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	Login page
	<div>
		<form method="post" action="LoginCheckAction">
			<p>
				<input type="text" placeholder="아이디" name="userId" maxlength="15">
			</p>
			<p>
				<input type="password" placeholder="비밀번호" name="userPassword" maxlength="15">
			</p>
			<p>
				<input type="submit" value="로그인">
			</p>
		</form>		
		<button onClick="location.href='join.jsp'"> 회원가입 </button>
	</div>
</body>
</html>