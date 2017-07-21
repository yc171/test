<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
 function nvl(data){
	   if(data==0){
	   return "";
	   }
	   else{
	   return data;
	   }
	 }
	 
	 function con(data){
	   if(data==undefined){
	   return " ";
	   }
	   else{
	   return data;
	   }
	 }
	function page_nav(pageNo) {
		var name = $("input[name=name]").val();
		var address = $("input[name=address]").val();

		$.getJSON("getPage", "name=" + name + "&address=" + address
				+ "&pageNo=" + pageNo, function(data) {
			//获得服务器的json数据,把数据填充到表格中

			//从table的第二行开始删除所有行
			$("table tr:not(:first)").remove();
			//改变上一页下一页....
			$("a:contains(上一页)").attr("href",
					"javascript:page_nav(" + data.pre + ")");
			$("a:contains(下一页)").attr("href",
					"javascript:page_nav(" + data.next + ")");
			$("a:contains(末页)").attr("href",
					"javascript:page_nav(" + data.totalPage + ")");
			$("#currNo").html(data.pageNo);
			$("#totalPage").html(data.totalPage);
			$("#totalCount").html(data.totalCount);

			//循环遍历data中的老师数据,加入到table中
			$.each(data.list, function() {

				$("table").append(
						"<tr>" + "<td>" + con(this.id) + "</td>" + "<td>"
								+ con(this.userName) + "</td>" + "<td>"
								+ con(this.address) + "</td>" + "<td>"
								+ con(this.phone) + "</td>" +
								"</tr>");
			});
		});

	}
</script>
</head>

<body>
	<!-- 分页查询条件表单 -->
	<form action="getPage">
		<input type="hidden" name="pageNo" /> 姓名: <input type="text"
			name="name" value="${param.name }" /> 地址: <input type="text"
			name="address" value="${param.address }" /> <input type="button"
			id="tj" value="提交" onclick="page_nav(1)" />
	</form>
	<!-- 显示分页数据 -->
	<table border="1" width="800">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>地址</th>
			<th>电话</th>
		</tr>

	</table>
	<a href="javascript:page_nav(1)">首页</a>
	<a href="javascript:page_nav(${page.pre })">上一页</a>
	<a href="javascript:page_nav(${page.next })">下一页</a>
	<a href="javascript:page_nav(${page.totalPage })">末页</a> 当前是第
	<span id="currNo"></span>页/共
	<span id="totalPage"></span> (共
	<span id="totalCount"></span>条)
</body>
</html>
