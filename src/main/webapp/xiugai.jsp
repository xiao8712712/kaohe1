<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>更改</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body bgcolor="#009922">
<font size="5" color="#00ff33">
<center>

	<form action="user/update.action"  method="post" onsubmit="return true" >
	   <c:forEach	items="${list6}" var="list" varStatus="con">  
	          编号：<input type="text" id="1" value="${film_id}"></input><br> 
		 名字：<input type="text" id="1" value="">${title}</input><br> 
	          描述：<input type="text"  id="2" value="${description}"></input><br> 
	          语言：<input type="text"  id="3" value="${language}" /><br> 
	      
	          </c:forEach> 
		<input type="submit" name="sub" id="sub1" value="提交"/>
		<input type="reset" name="re" id="sub2"value="清空"/>
	</form>
</center>
</font>
</body>
</html>