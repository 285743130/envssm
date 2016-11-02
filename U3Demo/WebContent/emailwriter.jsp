<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/emailwriter.js"></script>
</head>
<body>
	<form method="post" action="emailwriter.do"  enctype="multipart/form-data">
		<div class="action">
			<div class="t">写邮件</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0" style="height: 270px;">
					<tr>
						<td>收件人：</td>
						<td><select name="reciverId">
								<c:forEach items="${list }" var="reciver">
									<option value="${reciver.id }">${reciver.name }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>邮件标题：</td>
						<td><input type="text" name="title" id="title" />&nbsp;<span style="color: red;">*</span></td>
					</tr>
					<tr>
						<td>邮件内容：</td>
						<td><textarea rows="10" cols="50" name="context"></textarea></td>
					</tr>
					<tr>
						<td>上传附件：</td>
						<td><input type="file" name="upfile" id="upfile"/><span style="color: red;">*</span></td>
					</tr>
					<tr>
						<td></td>
						<td align="left"><input type="submit" value="发送邮件" /></td>
						
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>