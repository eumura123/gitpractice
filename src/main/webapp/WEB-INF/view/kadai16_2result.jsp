<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Kadai16" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 >会員一覧</h1>
<table border="1">
<tr>
<th>名前</th>
<th>年齢</th>
<th>性別</th>
<th>電話番号</th>
<th>メール</th>
</tr>
<%List<Kadai16> list = (ArrayList<Kadai16>)request.getAttribute("kadaiList");
for(Kadai16 k:list) {%>
<tr>
<td><%=k.getName() %></td>
<td><%=k.getAge() %></td>
<td><%=k.getGender() %></td>
<td><%=k.getTel() %></td>
<td><%=k.getMail() %></td>
</tr>
<%} %>
</table>
<a href="./">戻る</a>
</body>
</html>