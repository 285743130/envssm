<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/displayEmail.js"></script>
</head>
<body>

	<form target="_parent">
		<div class="action">
			<div class="t">账号管理列表</div>
			<div class="pages" style="height: 300px">
				<table width="90%" border="0" cellspacing="0" cellpadding="0">
					<tr align="center" id="id">
						<td>用户名</td>
						<td>昵称</td>
						<td>手机</td>
						<td>地址</td>
					</tr>
					<c:forEach items="${list }" var="userInfo" varStatus="status">
						<tr align="center"
							<c:if test="${status.index%2 == 0 }">bgcolor="#c0c0c0solid"</c:if>>
							<td>${userInfo.name }</td>
							<td>${userInfo.nickName}</td>
							<td>${userInfo.phoneNumber}</td>
							<td>${userInfo.address}</td>
						</tr>
					</c:forEach>
						<tr align="center" id="id">
						<td><input type="button" value="添加数据" onclick="window.location.href = 'adduser.jsp'"/></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>

