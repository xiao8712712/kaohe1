<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品上架</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body bgcolor="#00ff99">
    <center>
   
	<form  color="#00ff33" action="user/filmup.action"  method="post" onsubmit="return true" >
    	<th>名称<input type="text" id="1" name="name"></input></th><br>
   		<th>描述<input  type="text"  id="6" name="description" /></th><br>
 		<th>语言<input type="text"  id="2" name="language"></input></th><br>
		<input type="submit" name="sub" id="sub1" value="提交"/>
		<input type="reset" name="re" id="sub2"value="清空"/>
	</form>
</center>
  </body>
</html>
