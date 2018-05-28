<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>

</head>
<body>   <!-- aa -->
<form action="loginForm.action" >
<input type="hidden" name="check" value="<s:property value='check'/>">
ID : <input type="text" name="id"><br>
PASSWORD : <input type="text" name="password"><br>
<input type="submit" value="확인">
<input type="reset" value="리셋">
<input type="button" value="회원가입" onClick="javascript:location.href=JoinForm.action">





</form>
</body>
</html>





