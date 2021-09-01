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

.box {
	BACKGROUND-COLOR: transparent;
	border-radius: 20px 20px 20px 20px;
	border: 1px solid #f0ffff;
	width: 300px;
	height: 40px;
	font-size: 18px;
	padding: 10px;
	margin: 5px;
}

.intdiv {
	margin: 205px 0px 5px 500px;
}

input::-webkit-input-placeholder {
	color: #f0ffff;
}
</style>

<title>管理员登录</title>
</head>
<body>
	<c:if test="${!empty error}">
		<font color="red"><c:out value="${error}" /></font>
	</c:if>
	<div class="intdiv">
		<form action="<c:url value="lmLoginCheck.do" />" method="post">
			<input type="text" name="userName" class="box" placeholder="用户名">
			<br> <input type="password" name="password" class="box"
				placeholder="密码"> <br> <input type="submit" value="登录"
				class="box" style="color: #f0ffff" />
		</form>
	</div>


</body>
</html>