<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/updateuser.js"></script>
</head>
<body>

	<form method="post" action="updateuser.do" target="_parent">
		<div class="action">
			<div class="t">个人信息</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					style="height: 150px;">
					<tr>
						<td align="right" width="30%">昵称：</td>
						<td align="left"><input type="text" name="nickName"
							value="${user.nickName }" id="nickName" />&nbsp;<span style="color: red;">*</span></td>
					</tr>

					<tr>
						<td align="right" width="30%">年龄：</td>
						<td align="left"><input type="text" name="age"
							value="${user.age }" id="age" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">性别：</td>
						<td align="left"><select name="gender" id="gender">

								<option value="男"
									<c:if test="${user.gender == '男' }"> selected="selected"</c:if>>男</option>
								<option value="女"
									<c:if test="${user.gender == '女' }"> selected="selected"</c:if>>女</option>
						</select></td>
					</tr>
					<tr>
						<td align="right" width="30%">手机：</td>
						<td align="left"><input type="text" name="phoneNumber"
							value="${user.phoneNumber }" id="phoneNumber" />&nbsp;<span style="color: red;">*</span></td>
					</tr>
					<tr>
						<td align="right" width="30%">地址：</td>
						<td align="left"><input type="text" name="address"
							value="${user.address }" id="address" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><br /> <input type="submit"
							id="save" value="保存数据" /> <input type="button" id="back"
							value="返回" onclick="history.back();" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>