<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
body {
	width: 500px;
	margin-top: 60px;
	margin-right: 60px;
	margin-left: 420px;
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
</style>


<title>借阅相关信息</title>
</head>
<body>
	<h1 align="center">借阅相关信息</h1>
	<hr style="height: 1px; border: none; border-top: 1px solid #3b5dc0;" />
	<div align="center" class="font">
		<h2 align="center">书籍信息</h2>
		<p>书名：${bookInfo.name}</p>
		<p>作者：${bookInfo.author}</p>
		<p>剩余数量：${bookInfo.quantityNow }</p>
		<hr style="height: 1px; border: none; border-top: 1px solid #3b5dc0;" />
		<h3 align="center">用户信息</h3>
		<p>用户名：${user.userName}</p>
		<p>可借数量：${user.borrowNum-user.borrowNumNow}</p>
		<p>欠款信息：${user.arrearageMoney}</p>
		<hr style="height: 1px; border: none; border-top: 1px solid #3b5dc0;" />
		<c:if test="${!empty result}">
			<input type="button" value="借阅" class="box"
				onclick="javascript:window.location.href='borrow.do?username=${user.userName}&bookId=${bookInfo.bookId }&quantityNow=${bookInfo.quantityNow}&count=${count }';" />
		</c:if>
		<c:if test="${empty result}">
			<input type="button" class="box"
				onclick="javascript:window.location.href='userMain.jsp';" value="返回" />
		</c:if>
	</div>
</body>
</html>