<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
	div{
	text-align:center;
	margin: auto;
	padding: 10px;
	}
	table{
	margin: auto;
	margin-bottom: 10px;
}

tr>th{
	padding-right: 20px;
	padding-top: 5px;
	padding-bottom: 5px;
}
</style>
</head>
<script type="text/javascript">
function idDuplicateCheck(){
// 	alert("작동");
	var title = "아이디 중복 검사";
	var url = "./idDuplicateCheck.do";
	var attr = "width=450px, height=550px";
	window.open(url, title, attr);
}
</script>
<body>
<div>
	<form action="./signup.do" method="post">
		<h1>회원가입</h1>
		<input type="text" id="id" name="id" placeholder="아이디 " maxlength="20" onclick="return idDuplicateCheck()" required><br>
		<input type="text" id="name" name="name" placeholder="이름" required><br>
		<span id="result"></span>
				<input type="password" id="pw" name="pw" placeholder="비밀번호" required><br>
				<input type="password" id="passch" placeholder="비밀번호 확인" required>
		<div>
			<input type="submit" value="회원 가입">
		</div>
	</form>
</div>
</body>
</html>