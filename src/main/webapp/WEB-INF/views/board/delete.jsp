<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        input[type=text],
        input[type=password],
        input[type=tel],
        select {
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

        #boardTable {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #boardTable td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #boardTable tr:nth-child(even) {
            background-color: #ebebeb;
        }

        #boardTable tr:hover {
            background-color: #ffc6c6;
        }

    </style>
</head>

<body>
    <jsp:include page="../top_menu.jsp"></jsp:include>
    <div>
        <h3>회원삭제폼</h3>

        <!-- <form action="#" method="post" enctype="multipart/form-data"> -->
        <form action="b_deleteOK.do" method="post">
            <table id="boardTable">
                <tr>
                    <td><label for="num">번호:</label></td>
                    <td>[${param.num}] 번 글을 정말 삭제하시겠습니까?
                    	<input type="hidden" id="num" name="num" value="${param.num}" placeholder="번호"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="글삭제"></td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>