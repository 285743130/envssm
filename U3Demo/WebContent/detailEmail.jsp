<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
		<div class="action">
			<div class="t">邮件信息详情</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0" style="height: 270px;" >
					<tr>
						<td>邮件标题：</td>
						<td><input type="text" name="title"  value="${email.title }" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>邮件内容：</td>
						<td><textarea rows="10" cols="50" name="context" readonly="readonly">${email.context }</textarea></td>
					</tr>
					<tr>
					<td>发信时间：</td>
					<td><fmt:formatDate value="${email.senderDate }" pattern="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>来自：</td>
						<td><input type="text" value="${email.sender.name }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>文件：</td>
						<td><a href="downfile.do?id=${email.id }" >下载</a></td>
					</tr>
					<tr>
						<td></td>
						<td align="left"><input type="button" id="back" value="返回" onclick="window.location.href = 'mailReceive.do';" /></td>
						
					</tr>
				</table>
			</div>
		</div>

</body>
</html>