<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script>
	function setit() {
		document.forms[0].submit();
	}
</script>
</head>
<body>

	<form>
		<div class="action" >
			<div class="t">个人信息</div>
			<div class="pages" >
				<table width="90%" border="0" cellspacing="0" cellpadding="0" style="height: 150px;">
					<tr>
						<td align="right" width="30%">昵称：</td>
						<td align="left"><input type="text" name="name"
							value="${user.name }" readonly="readonly" id="name" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">年龄：</td>
						<td align="left"><input type="text" name="age" value="${user.age }"
							readonly="readonly" id="age" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">性别：</td>
						<td align="left"><input type="text" name="gender" value="${user.gender }"
							readonly="readonly" id="gender" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">手机：</td>
						<td align="left"><input type="text" name="phoneNumber"
							value="${user.phoneNumber }" readonly="readonly" id="phoneNumber" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">地址：</td>
						<td align="left"><input type="text" name="address"
							value="${user.address }" readonly="readonly" id="address" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2">
						<input type="button" id="save" value="编辑数据" onclick="window.location.href = 'updateuser.jsp'" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>

