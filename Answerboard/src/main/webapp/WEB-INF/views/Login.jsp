<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
<body>

<div>
	<h1>LOGIN</h1>
	<form action="./login.do" method="post">
		<table>
			<tr>
				<th>아이디 : </th>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<th>비밀번호 : </th>
				<td>
					<input type="password" name="pw">
				</td>
			</tr>
		</table>
		
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onclick="location.href='./signupform.do'">
	</form>
</div>

</body>
</html>