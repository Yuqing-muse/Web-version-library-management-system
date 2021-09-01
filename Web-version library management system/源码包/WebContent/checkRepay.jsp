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

<title>缴费相关信息</title>
</head>
<body>
	<h1 align="center">缴费相关信息</h1>
	<hr style="height: 1px; border: none; border-top: 1px solid #3b5dc0;" />
	<div align="center" class="font">
		<h2 align="center">账户信息</h2>
		<p>用户名：${username}</p>
		<p>欠款：${arrearageMoney}</p>
		<hr style="height: 1px; border: none; border-top: 1px solid #3b5dc0;" />
		<input type="button" value="缴费" class="box"
			onclick="javascript:window.location.href='repay.do?username=${username}';" />
	</div>
</body>

</html>