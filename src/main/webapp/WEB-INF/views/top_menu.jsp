<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="index.do">홈</a>
<a href="m_insert.do">회원가입</a>
<c:choose>
	<c:when test="${user_id != null}">
		<a href="logout.do">로그아웃</a>
		<a href="b_insert.do">글쓰기</a>
		<a href="b_selectAll.do?cpage=1">글목록</a>
	</c:when>
	<c:otherwise><a href="login.do">로그인</a></c:otherwise>
</c:choose>


<a href="m_selectAll.do">회원목록</a>


<hr>
