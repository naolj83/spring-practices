<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% pageContext.setAttribute("newline", "\n"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<h1>Guestbook03</h1>
	<p>
		방명록을 작성하려면,<br> 아래 항목을 기입하고 등록 버튼을 클릭하세요.
	</p>
	<br>
	<form action="${pageContext.request.contextPath }/add" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="등록"></td>
			</tr>
		</table>
	</form>
	<br>
	<h2>작성한 방명록입니다.</h2>
	
		<c:set var="count" value="${fn:length(list) }" />
		<c:forEach var="vo" items="${list }" varStatus="status">

				<table border="1" width="510">
					<tr>
						<td>[${count-status.index }]</td>
						<td>${vo.name }</td>
						<td>${vo.regDate }</td>
						<td><a
							href="${pageContext.request.contextPath }/delete/${vo.no}">삭제</a></td>
					</tr>
					<tr>
						<td colspan=4>${fn:replace(vo.message, newline, "<br/>") }</td>
					</tr>

				</table>
				<br>
		</c:forEach>
</body>
</html>