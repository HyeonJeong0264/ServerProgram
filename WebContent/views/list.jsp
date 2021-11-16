<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	<a href="/ServerProgram/loginPage.do">로그인하러 가기</a>
	<hr>
	<br>
	<h1>회원 목록</h1>
	<table border="1">
		<tr>
			<td>회원번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>등급</td>
			<td>포인트</td>
		</tr>
		<c:if test="${empty memberList }">
			<tr>
				<td colspan="5">회원이 존재하지 않습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty memberList }">
			<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${member.no }</td>
				<td>${member.id }</td>
				<td>${member.name }</td>
				<td>${member.grade }</td>
				<td>${member.point }</td>
			</tr>
			</c:forEach>
		</c:if>

	</table>
</body>
</html>