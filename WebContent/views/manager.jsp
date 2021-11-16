<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
$(document).ready(function(){

	
	$('#modify').on('click',function(event){
		if('${member.no}'==$('#no').val() && '${member.name}'==$('#name').val()){
			alert('변경사항이 없습니다.');
			event.preventDefault();
			return false;
		}
		return true;
	});
})

</script>

</head>
<%session.setAttribute("id",request.getAttribute("id"));%>
<%session.setAttribute("name",request.getAttribute("name"));%>
<%session.setAttribute("grade",request.getAttribute("grade"));%>
<%session.setAttribute("point",request.getAttribute("point"));%>
<%session.setAttribute("no",request.getAttribute("no"));%>
<body>
<h3>회원 관리 시스템</h3>
<a href="/ServerProgram/logout.do">로그아웃</a>
<hr>
<form action="/ServerProgram/update.do">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>등급</td>
			<td>포인트</td>
		</tr>
		<tr>	
					<input type ="hidden" name="no" id="no" value="${no }">
					<input type ="hidden" name="id" id="id" value="${id }">
			<td>${id } </td>
			<td><input type="text" id="name" name="name" value="${name }"></td>
			<td>${grade }</td>
			<td><input type="text" id="point" name="point" value="${point }"></td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="submit" value="수정하기" id="modify">
				<input type="button" value="탈퇴하기" onclick="location.href='/ServerProgram/delete.do?no=${no }'">
			</td>
		</tr>
	</table>
</form>

</body>
</html>