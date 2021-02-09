<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.MemberDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login After</title>
</head>
<body>
	Login After
	<% request.setCharacterEncoding("utf-8"); %>
	<%
		String id = request.getParameter("userId");
		String password = request.getParameter("userPassword");
		
		out.print("id="+id);
		out.print("password="+password);
		
		
	%>
	
	
</body>
</html>