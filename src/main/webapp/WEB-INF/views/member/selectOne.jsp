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
    <h1>회원정보</h1>
    <hr>
    <table id="customers">
        <thead>
            <tr>
                <th>번호</th>
                <th>아이디</th>
                <th>비번</th>
                <th>이름</th>
                <th>폰번</th>
                <th>프로필이미지</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${vo2.num}</td>
                <td>${vo2.id}</td>
                <td>${vo2.pw}</td>
                <td>${vo2.name}</td>
                <td>${vo2.tel}</td>
                <td><img src="resources/uploadimg/${vo2.save_name}" width="200"></td>
            </tr>
        </tbody>
    </table>
    <a href="m_update.do?num=${param.num}">회원수정</a>
    <a href="m_delete.do?num=${param.num}">회원삭제</a>
</body>
</html>