<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
input[type=text], input[type=password], input[type=tel], select {
	width: 100%;
	padding: 8px 8px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ff8f8f;
	border-radius: 14px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 30%;
	background-color: #4CAF50;
	color: white;
	padding: 8px 8px;
	margin: 8px 0;
	border: none;
	border-radius: 14px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 15px;
	background-color: #bfbfbf;
	padding: 20px;
}

#memberTable {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#memberTable td {
	border: 1px solid #ddd;
	padding: 8px;
}

#memberTable tr:nth-child(even) {
	background-color: #ebebeb;
}

#memberTable tr:hover {
	background-color: #ffc6c6;
}
</style>
</head>

<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<div>
		<h3>회원수정폼</h3>

		<form action="m_updateOK.do" method="post"
			enctype="multipart/form-data">
			<table id="memberTable">
				<tr>
					<td><label for="num">번호:</label></td>
					<td>${param.num}<input type="hidden" id="num" name="num"
						value="${param.num}" placeholder="번호"></td>
				</tr>
				<tr>
					<td><label for="pw">비번:</label></td>
					<td><input type="password" id="pw" name="pw" value="${vo2.pw}"
						placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td><label for="name">이름:</label></td>
					<td><input type="text" id="name" name="name"
						value="${vo2.name}" placeholder="이름"></td>
				</tr>
				<tr>
					<td><label for="tel">전화번호:</label></td>
					<td><input type="tel" id="tel" name="tel" value="${vo2.tel}"
						placeholder="전화번호"></td>
				</tr>
				<tr>
					<td><label for="file">프로필 이미지:</label></td>
					<td><input type="file" id="file" name="file"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="회원수정"></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>