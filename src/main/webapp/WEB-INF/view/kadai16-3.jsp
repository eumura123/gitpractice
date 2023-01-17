<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error2");
		if(errorCode != null && errorCode.equals("1")){
			String ac = (String)session.getAttribute("mail");
	%>
		<p style="color:red">削除に失敗しました。</p>
		<h3>会員削除</h3>
		<form action="Kadai16_3ConfirmServlet" method="post">
		メール：<input type="email" name="email"><br>
		<input type="submit" value="削除">
	</form>
	<%
		} else {
	%>
	<h3>会員削除</h3>
	<form action="Kadai16_3ConfirmServlet" method="post">
		メール：<input type="email" name="email"><br>
		<input type="submit" value="削除">
	</form>
	<%
		}
	%>
</html>