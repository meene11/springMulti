<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="top_menu.jsp"></jsp:include>

	<h1>index.jsp</h1>
	<c:if test="${user_id != null}">
		${user_id}님 어서오세요~^^
	</c:if>
	
</body>
</html>