<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<form target="_parent">
		<div class="action">
			<div class="t">邮件信息列表</div>
			<div class="pages" style="height: 300px">
				<table width="90%" border="0" cellspacing="0" cellpadding="0" >
					<tr align="center" id="id">
					<td>邮件标题</td>
					<td>内容</td>
					<td>是否已读</td>
					<td>时间</td>
					<td>操作</td>
					</tr>
					<c:forEach items="${list }" var="email" varStatus="status">
					<tr align="center" 	<c:if test="${status.index%2 == 0 }">bgcolor="#c0c0c0solid"</c:if>>
					<td><a href="detailEmail.do?id=${email.id }" style="text-decoration: underline;">${email.title }</a></td>
					<td>${email.context }</td>
					<td>${email.isRead == 0?'未读':'已读'}</td>
					<td><fmt:formatDate value="${email.senderDate }" pattern="yyyy-MM-dd" /></td>
					<td><a href="updateIsDelete.do?id=${email.id }" style="text-decoration: underline;" onclick="if(confirm('确实执行此操作')) return  true;return false; ">删除</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</form>
</body>
</html>

