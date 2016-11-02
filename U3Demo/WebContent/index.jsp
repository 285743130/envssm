<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	<div class="top">
		<div class="global-width">
			<img src="Images/logo.gif" class="logo" />
		</div>
	</div>
	<div class="status">
		<div class="global-width">
			${user.name }
			你好！欢迎访问青鸟办公管理系统！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="#" onclick="location.href='loginOut.do'";>注销</a>
		</div>
	</div>
	<form id="myForm" name="myForm" action="userInfo!editData.action"
		method="post">
		<div class="main">
			<div class="global-width">

				<div class="nav" id="nav">
					<div class="t"></div>
					<dl>
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">信息管理
						</dt>
						<dd>
							<a href="userinfo.jsp" target="first">个人信息</a>
						</dd>
					</dl>
					<dl>
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							邮件管理</dt>
						<dd>
							<a href="emailWriter.do" target="first">写邮件</a>
						</dd>
						<dd>
							<a href="mailReceive.do" target="first">收邮件</a>
						</dd>
						<dd>
							<a href="junkMail.do" target="first">垃圾邮件</a>
						</dd>
					</dl>
					<dl>
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							考勤管理</dt>
						<dd>
							<a href="leave.do" target="first">休假</a>
						</dd>
						<c:if test="${user.permission == 1 }">
							<dd>
								<a href="manageLeave.do" target="first">审核休假</a>
							</dd>

						</c:if>

					</dl>

					<dl>

						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							权限管理</dt>
						<dd>
							<a href="userinfosingle.jsp" target="first">个人账户</a>
						</dd>
						<c:if test="${user.permission == 1 }">
						<dd>
							<a href="manageuserInfo.do" target="first">管理账户</a>
						</dd>
						</c:if>
					</dl>
				</div>

				<iframe id="iframe" src="userinfo.jsp" name="first" scrolling="no"
					class="action" style="border: none; height: 360px;"></iframe>

			</div>
		</div>
	</form>
	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 北大青鸟</div>

</body>
</html>
