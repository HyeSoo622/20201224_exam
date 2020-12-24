<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글 작성</title>
<style type="text/css">
table, th, td{
	border: 1px solid black;
	padding: 5px;
	margin: auto;
}

a { 
	text-decoration: none;
	font-weight: bold;
	color: black;
}
div {
	text-align:center;
	margin: auto;
	padding: 10px;
}

</style>
</head>
<body>
<div>
<h1>답글 작성</h1>
<form action="./reply.do" method="post">
<input type = "hidden" name="seq" value="${seq}">
		<table>
			<tr>
				<th>아이디</th><td><input type="text" name="id" placeholder="아이디를 입력하세요." required></td>
			</tr>
			<tr>
				<th>제목</th><td><input type="text" name="title" placeholder="제목을 입력하세요." required></td>
			</tr>
			<tr>
				<th>내용</th><td><textarea rows="10" name="content"></textarea></td>
			</tr>
		</table>

	<div>
	<input type="button" value="작성취소" onclick="location.href='boardList.do'">
	<input type="submit" value="답글 등록하기">
	</div>		
</form>
</div>
</body>
</html>