<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style>
	div{
		text-align: center;
		margin : 0 auto;
	}

</style>

</head>
<body>

<form id="f" action="/ServerProgram/join.do">
	<div>
		<h3>회원 가입 폼</h3>
		아이디 <input type="text" id="id" name="id" placeholder="아이디"><br>
		이름 <input type="text" id="name" name="name" placeholder="이름"><br><br>
		
		<button>회원가입</button>
		<a href="views/login.jsp">돌아가기</a>
	</div>
</form>
</body>
</html>