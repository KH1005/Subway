<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID찾기</title>

<style type="text/css">
</style>
</head>

<body>
	<table border="0" cellspacing="0" cellpadding="2">


		<form method=post action="FindId.action" enctype="multipart/form-data">


			<div class="findbox">
				<ul>
					<li><span>이름</span> <input name="name" type="text" size="29"
						required label="이름" tabindex=2></li>
					<li><span>휴대폰번호</span> <input name="phone" type="text"
						size="29" required label="휴대폰번호" tabindex=5></li>
					<tr>
						<td><input type="submit" value="아이디 찾기"></td>
					</tr>

				</ul>

			</div>





		</form>
	</table>
</body>
</html>