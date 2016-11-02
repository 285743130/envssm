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
			<div class="t">休假信息列表</div>
			<div class="pages" style="height: 300px">
				<table width="90%" border="0" cellspacing="0" cellpadding="0" >
					<tr align="center" id="id">
					<td>申请人</td>
					<td>开始时间</td>
					<td>结束时间</td>
					<td>天数</td>
					<td>审批状态</td>
					<td>原因</td>
					</tr>
					<c:forEach items="${list }" var="vocation" varStatus="status">
					<tr align="center" 	<c:if test="${status.index%2 == 0 }">bgcolor="#c0c0c0solid"</c:if>>
					<td>${vocation.applier.name }</td>
					<td><fmt:formatDate value="${vocation.beginDate }" pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${vocation.endDate }" pattern="yyyy-MM-dd" /></td>
					<td>${vocation.days }</td>
					<c:if test="${vocation.state == 0 }"><td>未审批</td></c:if>
					<c:if test="${vocation.state == 1 }"><td>已审批</td></c:if>
					<c:if test="${vocation.state == 2 }"><td>审核拒绝</td></c:if>
					<td>${vocation.reason }</td>
					</tr>
					</c:forEach>
					<tr>
						<td align="center"><input type="button" value="申请休假" onclick="window.location.href='toapplyvocation.do'"/></td>
					</tr>
				</table>
				
			</div>
		</div>
	</form>
</body>
</html>

