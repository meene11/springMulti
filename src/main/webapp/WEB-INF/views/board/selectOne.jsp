<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        #customers {
          font-family: Arial, Helvetica, sans-serif;
          border-collapse: collapse;
          width: 100%;
        }
        
        #customers td, #customers th {
          border: 1px solid #ddd;
          padding: 8px;
        }
        
        #customers tr:nth-child(even){background-color: #ff6565;}
        
        #customers tr:hover {background-color: #fca2a2;}
        
        #customers th {
          padding-top: 12px;
          padding-bottom: 12px;
          text-align: left;
          background-color: #04AA6D;
          color: white;
        }

        tfoot td{
            text-align: center; 
        }
        </style>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
    <h1>글정보</h1>
    <hr>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${vo2.num}</td>
                <td>${vo2.title}</td>
                <td>${vo2.writer}</td>
            </tr>
            <tr>
                <td>내용</td>
                <td colspan="2">${vo2.content}</td>
            </tr>
            <tr>
                <td>작성일자</td>
                <td colspan="2">${vo2.wdate}</td>
            </tr>
        </tbody>
    </table>
    <c:if test="${user_id == vo2.writer }">
	    <a href="b_update.do?num=${vo2.num}">글수정</a>
	    <a href="b_delete.do?num=${vo2.num}">글삭제</a>
    </c:if>
    <hr>
    <h3>댓글작성</h3>
    <form action="c_insertOK.do">
	    <table id="customers">
	        <thead>
	            <tr>
	                <th>댓글 내용 ${param.msg}</th>
	                <th>댓글 작성자</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody>
	        	<tr>
	        		<td><input type="text" name="content" value="hello" size="50"></td>
	        		<td>
	        			${user_id}<input type="hidden" name="writer" value="${user_id}">
	        			<input type="hidden" name="bnum" value="${vo2.num}">
	        		</td>
	        		<td><input type="submit"  value="댓글작성"></td>
	        	</tr>
	        </tbody>
	    </table>
	    
    </form>
    <hr>
    <h3>댓글목록</h3>
    <table id="customers">
        <thead>
            <tr>
                <th>댓글 번호</th>
                <th>댓글 내용</th>
                <th>댓글 작성자</th>
                <th>댓글 작성일자</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="cvo" items="${cvos}">
        	<tr>
                <td>${cvo.num}</td>
                <td>
                	${cvo.content}
                	<c:if test="${user_id == cvo.writer }">
	                	<form action="c_updateOK.do">
							 <input type="text" name="content" value="${cvo.content}" >
							 <input type="hidden" name="num" value="${cvo.num}">               	
							 <input type="hidden" name="bnum" value="${cvo.bnum}">
							 <input type="submit"  value="댓글수정">               	
	                	</form>
                	</c:if>
                </td>
                <td>${cvo.writer}</td>
                <td>${cvo.wdate}</td>
                <td>
                	<c:if test="${user_id == cvo.writer }">
                		<a href="c_deleteOK.do?num=${cvo.num}&bnum=${cvo.bnum}">댓글삭제</a>
                	</c:if>
                </td>
            </tr>
        	</c:forEach>
            
        </tbody>
    </table>
    
    
</body>
</html>