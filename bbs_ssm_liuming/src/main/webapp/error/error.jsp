<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>哎呀，出错了...</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
</head>
<body style="text-align: center;">
	<h4 style="color: #888888;font-size: 40px;">如果你看到这个页面，请<b style="color: #00aaaa;font-size: 70px;">重新加载试试</b></h4>
	<br>
	<b style="color: #aaaaaa;font-size: 30px;">可能是网络太卡吧</b>
</body>
</html>