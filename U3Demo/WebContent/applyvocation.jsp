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
<script type="text/javascript" src="DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/applyvocation.js"></script>
</head>
<body>

	<form method="post" action="applyvocation.do" target="_self">
		<div class="action">
			<div class="t">个人信息</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					style="height: 300px;">
					<tr>
						<td align="right" width="30%">姓名：</td>
						<td align="left"><input type="text" name="name" id="name"
							value="${user.name }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">开始时间：</td>
						<td align="left"><input type="text" name="beginDate"
							id="beginDate" class="Wdate" style="width: 171px;height: 17px;"
							onfocus="WdatePicker({firstDayOfWeek:1})" />&nbsp;<span style="color: red;">*</span></td>
					</tr>
					<tr>
						<td align="right" width="30%">结束时间：</td>
						<td align="left"><input type="text" class="Wdate"
							name="endDate" id="endDate" style="width: 171px; height: 17px;"
							onfocus="WdatePicker({firstDayOfWeek:1})" />&nbsp;<span style="color: red;">*</span></td>
					</tr>

					<tr>
						<td align="right" width="30%">请假天数：</td>
						<td align="left"><input type="text" name="days" id="days" />&nbsp;<span style="color: red;">*</span></td>
					</tr>
					<tr>
						<td align="right" width="30%">请假原因：</td>
						<td align="left"><textarea rows="10" cols="10" id="reason"
								name="reason"></textarea></td>
					</tr>
					<tr>
						<td align="right" width="30%">审批人：</td>
						<td align="left"><select name="approverId">
								<c:forEach items="${list }" var="user">
									<option value="${user.id }">${user.name }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td align="right"><input type="submit" id="save" value="提交申请" />
						</td>
						<td align="left">&nbsp;<input type="button" id="back" value="返回"
							onclick="history.back();" /></td>


					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>



