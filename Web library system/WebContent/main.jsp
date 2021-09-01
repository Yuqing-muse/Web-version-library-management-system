<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
body {
	background: url("images/mainbg.jpg") no-repeat;
	background-position: center center;
	/* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
	background-attachment: fixed;
	/* 让背景图基于容器大小伸缩 */
	background-size: cover;
}

h1 {
	font-family: Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑',
		Arial, sans-serif;
	font-size: 40px;
	color: #FFFFFF;
	padding-top: 130px;
}

.a {
	font-family: Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑',
		Arial, sans-serif;
	font-size: 20px;
	color: #FFFFFF;
	position: fixed;
	top: 270px;
}

#a1 {
	position: fixed;
	left: 340px;
}

#a2 {
	position: fixed;
	left: 650px;
}

#a3 {
	position: fixed;
	left: 960px;
}
</style>

<title>图书馆管理系统</title>
</head>
<body>
	<h1 align="center">图书馆管理系统</h1>
	<a id="a1" class="a" href="lmLogin.jsp">管理员登录</a>
	<a id="a2" class="a" href="userRegister.jsp">用户注册</a>
	<a id="a3" class="a" href="userLogin.jsp">用户登录</a>

</body>
</html>