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
<script>
	function setit() {
		document.forms[0].submit();
	}
</script>
</head>
<body>

	<form method="post" target="_self">
		<div class="action" >
			<div class="t">个人信息</div>
			<div class="pages" >
				<table width="90%" border="0" cellspacing="0" cellpadding="0" style="height: 300px;">
					<tr>
						<td align="right" width="30%">姓名：</td>
						<td align="left"><input type="text" name="name"
							 value="${vocation.name }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">开始时间：</td>
						<td align="left">
						<fmt:formatDate value="${vocation.beginDate }" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<td align="right" width="30%">结束时间：</td>
						<td align="left">
							<fmt:formatDate value="${vocation.endDate }" pattern="yyyy-MM-dd" />
							 </td>
					</tr>
					<tr>
						<td align="right" width="30%">请假天数：</td>
						<td align="left"><input type="text" name="days"
							 id="days"  value="${vocation.days }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">请假原因：</td>
						<td align="left"><textarea rows="10" cols="10" id="reason" name="reason" readonly="readonly">${vocation.reason  }</textarea></td>
					</tr>
					<tr>
						<td align="right" width="30%">申请人：</td>
						<td align="left">
						<input type="text" name="name"
							 value="${vocation.applier.name }" readonly="readonly" />
						</td>
					</tr>
					<tr >
						<td  align="right">
						<input type="button" id="back" value="审核通过" onclick="window.location.href='examine.do?id=${vocation.id}&&state=1';" />&nbsp;&nbsp;&nbsp;
						</td>
						<td align="left">
						<input type="button" id="back" value="审核不通过" onclick="window.location.href='examine.do?id=${vocation.id}&&state=2';" />
						</td>
						
						
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>