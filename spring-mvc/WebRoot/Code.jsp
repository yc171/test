<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Code.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	code.bind("blur", function() {
		$.get("getByCode", function(data) {

			if (data.code == "true") {
				$("#code").val("用户名已存在");
			}
			if (data.code == "false") {
				$("#code").val("用户名可以使用");
			}
		}

		, json);

	});
</script>
</head>

<body>
	<form action="getByCode">
		ç¨æ·å:<input type="text" name="code" /><span id="code"></span>

	</form>
</body>
</html>
