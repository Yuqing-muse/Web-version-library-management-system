<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
body {
	margin-left: 60px;
	margin-top: 20px;
	margin-right: 60px;
}

.page_input {
	padding: 5px;
	width: 400px;
	height: 30px;
	line-height: 30px;
	background: #fafafa;
	border: 1px solid #c0c1c2;
	border-radius: 5px;
	outline: 0;
	color: #333;
	font-size: 15px;
	font-family: "Microsoft YaHei", arial
}

.font {
	font-family: "Microsoft YaHei", arial;
	font-size: 15px;
}

.box {
	border-radius: 5px;
	border: 1px solid #dcd710;
	width: 70px;
	height: 30px;
	font-size: 15px;
	padding: 5px;
}

table {
	*border-collapse: collapse; /* IE7 and lower */
	border-spacing: 0;
	width: 90%;
	font-family: "Microsoft YaHei", arial;
	font-size: 15px;
	margin-left: 100px
}

.bordered {
	border: solid #ccc 1px;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	-webkit-box-shadow: 0 1px 1px #ccc;
	-moz-box-shadow: 0 1px 1px #ccc;
	box-shadow: 0 1px 1px #ccc;
}

.bordered tr:hover {
	background: #fbf8e9;
	-o-transition: all 0.1s ease-in-out;
	-webkit-transition: all 0.1s ease-in-out;
	-moz-transition: all 0.1s ease-in-out;
	-ms-transition: all 0.1s ease-in-out;
	transition: all 0.1s ease-in-out;
}

.bordered td, .bordered th {
	border-left: 1px solid #ccc;
	border-top: 1px solid #ccc;
	padding: 5px;
	text-align: left;
}

.bordered th {
	background-color: #dce9f9;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc),
		to(#dce9f9));
	background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -moz-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -ms-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -o-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: linear-gradient(top, #ebf3fc, #dce9f9);
	-webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	-moz-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	border-top: none;
	text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
}

.bordered td:first-child, .bordered th:first-child {
	border-left: none;
}

.bordered th:first-child {
	-moz-border-radius: 6px 0 0 0;
	-webkit-border-radius: 6px 0 0 0;
	border-radius: 6px 0 0 0;
}

.bordered th:last-child {
	-moz-border-radius: 0 6px 0 0;
	-webkit-border-radius: 0 6px 0 0;
	border-radius: 0 6px 0 0;
}

.bordered th:only-child {
	-moz-border-radius: 6px 6px 0 0;
	-webkit-border-radius: 6px 6px 0 0;
	border-radius: 6px 6px 0 0;
}

.bordered tr:last-child td:first-child {
	-moz-border-radius: 0 0 0 6px;
	-webkit-border-radius: 0 0 0 6px;
	border-radius: 0 0 0 6px;
}

.bordered tr:last-child td:last-child {
	-moz-border-radius: 0 0 6px 0;
	-webkit-border-radius: 0 0 6px 0;
	border-radius: 0 0 6px 0;
}
</style>
<title>用户界面</title>
</head>
<body>
	<h1 align="center">书籍检索</h1>
	<div align="right" class="font">
		<a href="userLogin.jsp">用户名：${username}</a>
	</div>
	<div align="right" class="font">
		<a href="getAllReturnBooks.do?username=${username}">我要还书</a>
	</div>
	<div align="right" class="font">
		<a href="getRenewBooks.do?username=${username}">我要续借</a>
	</div>
	<div align="right" class="font">
		<a href="checkRepay.do?username=${username}">我要缴费</a>
	</div>

	<form class="font"
		action="<c:url value="getQueryBooks.do?name=${name }&type=${type }"/>"
		method="get">
		类别： <select name="type" class="box">
			<option value="文学">文学</option>
			<option value="艺术">艺术</option>
			<option value="经济">经济</option>
			<option value="哲学">哲学</option>

		</select> 名称： <input type="text" name="name" class="page_input"> <input
			type="submit" value="查询" class="box"> <br>
		<hr style="height: 1px; border: none; border-top: 1px solid #3b5dc0;" />

		<table width="100%" border=1 class="bordered">
			<tr>
				<th>名称</th>
				<th>作者</th>
				<th>余量</th>
				<th>位置</th>
				<th>操作</th>
			</tr>
			</thead>

			<c:forEach items="${requestScope.datasList}" var="data"
				varStatus="loop">
				<tr>
					<td>${data.name }</td>
					<td>${data.author }</td>
					<td>${data.quantityNow }</td>
					<td>${data.location }</td>
					<td><a
						href="checkCanBorrow.do?count=${loop.count-1 }&bookId=${data.bookId}&name=${data.name}&author=${data.author}&quantityNow=${data.quantityNow}&username=${username}">借阅</a></td>
				</tr>
			</c:forEach>

		</table>
	</form>
</body>
</html>