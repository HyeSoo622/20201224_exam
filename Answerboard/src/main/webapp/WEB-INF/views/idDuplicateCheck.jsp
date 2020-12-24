<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	document.getElementById("btnid").style.display="none";
});

function checkId(){
// 	alert("동작");
	var doc = document.getElementById("id").value;
	if (doc != ''){
		$.ajax({
			url: "./idChkAjax.do",
			type: "POST",
			data: "checkId="+doc,
			async: true,
// 			dataType: "json",
			success: function(msg){
	 			alert(msg);
				if(msg == "false"){
					document.getElementById("msgidcondition").innerHTML = "사용 가능한 아이디입니다.";
					document.getElementById("btnid").style.display="block";
				}else{
					document.getElementById("msgidcondition").innerHTML = "사용할 수 없는 아이디입니다.";
					document.getElementById("btnid").style.display="none";
				}
			},
			error: function(){
				alert("잘못된 요청 처리");
			}
		});
	}else {
		document.getElementById("msgidcondition").innerHTML = "사용할 수 없는 아이디입니다.";
		document.getElementById("btnid").style.display="none";
		alert("아이디를 입력해주세요.");
	}
}

function useid(){
// 	console.log(window);
	var doc = document.getElementById("id").value;
	window.opener.document.getElementById("id").value = doc; 	//window.은 안 적어도 됨
	window.opener.document.getElementById("name").focus();
	window.close();
}

</script>
<body>
<div>
	<h1>아이디 중복확인 : </h1>
	<input type="text" id="id"><br>
	<input type="button" value="확인" onclick="checkId()">
	<input type="button" value="사용하기" id="btnid" onclick="useid()">
</div>
<div id=msgidcondition>
	
	</div>
</body>
</html>