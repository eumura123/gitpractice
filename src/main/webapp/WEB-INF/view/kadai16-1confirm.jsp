<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="dto.Kadai16" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>下記の内容で登録します。よろしいですか？</p>
	<%
		Kadai16 kadai16 = (Kadai16)session.getAttribute("input_data");
	%>
	名前：<%=kadai16.getName() %><br>
	年齢：<%=kadai16.getAge() %><br>
	性別：<%=kadai16.getGender() %><br>
	電話番号：<%=kadai16.getTel() %><br>
	メール：<%=kadai16.getMail() %><br>
	パスワード：********<br>
	<a href="Kadai16_1ExecuteServlet">OK</a><br>
	<a href="Kadai16_1Servlet">戻る</a>
</body>
</html>