<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
body {
	background: url("images/mainbg.jpg") no-repeat;
	background-position: center center;
	/* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
	background-attachment: fixed;
	/* 让背景图基于容器大小伸缩 */
	background-size: cover;
	width: 500px;
	margin: 40px auto;
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
<title>录入书籍</title>
</head>
<body>
	<form id="bookinfo_form" action="<c:url value="addBook.do"/>"
		method="post">
		<input type="text" name="name" id="name" class="box"
			placeholder="书籍名称" onfocus="this.placeholder=''"
			onblur="this.placeholder='书籍名称'"> <br> <input
			type="text" name="author" id="author" class="box" placeholder="书籍作者"
			onfocus="this.placeholder=''" onblur="this.placeholder='书籍作者'">
		<br> <select name="type" class="box">
			<option value="文学">文学</option>
			<option value="艺术">艺术</option>
			<option value="经济">经济</option>
			<option value="哲学">哲学</option>
		</select> <br> <input type="text" name="price" id="price" class="box"
			placeholder="单位价格" onfocus="this.placeholder=''"
			onblur="this.placeholder='单位价格'"> <br> <input
			type="text" name="keywords" id="keywords" class="box"
			placeholder="关键字" onfocus="this.placeholder=''"
			onblur="this.placeholder='关键字'"> <br> <input type="text"
			name="quantity" id="quantity" class="box" placeholder="书籍数量"
			onfocus="this.placeholder=''" onblur="this.placeholder='书籍数量'">
		<br> <input type="text" name="location" id="location" class="box"
			placeholder="书籍位置" onfocus="this.placeholder=''"
			onblur="this.placeholder='书籍位置'"> <br> <input
			type="text" name="remark" class="box" placeholder="备注"
			onfocus="this.placeholder=''" onblur="this.placeholder='备注'">
		<br> <input type="text" name="addby" class="box"
			value="${username}"> <br> <input
			onclick="return chkads();" type="submit" value="录入" class="box"
			style="color: #f0ffff" />
	</form>
</body>
<script language="javascript">
	function chkads() {
		if (bookinfo_form.name.value == "") {
			alert("书名不能为空.");
			bookinfo_form.name.select();
			return false;
		}
		if (bookinfo_form.author.value == "") {
			alert("作者不能为空.");
			bookinfo_form.author.select();
			return false;
		}
		if (bookinfo_form.price.value == "") {
			alert("价格不能为空.");
			bookinfo_form.price.select();
			return false;
		}
		if (bookinfo_form.quantity.value == "") {
			alert("数量不能为空.");
			bookinfo_form.quantity.select();
			return false;
		}
		if (!IsDouble(bookinfo_form.price.value)) {
			alert("请输入数字!")
			bookinfo_form.price.focus();
			return false;
		}
		if (!IsInt(bookinfo_form.quantity.value)) {
			alert("请输入整数!")
			bookinfo_form.quantity.focus();
			return false;
		}
	}
	function IsInt(num) {
		var reNum = /^\d*$/;
		return (reNum.test(num));
	}
	function IsDouble(num) {
		var reNum = /^(\d*\.)?\d+$/;
		return (reNum.test(num));
	}
</script>
</html>