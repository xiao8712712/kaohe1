<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ѧ�����ϵͳ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function sub(){
			return confirm("ȷ��Ҫ�˳���");
		}
		
function selectAllNullorReserve(type)
{  
    if(document.getElementsByName("deletes")!=undefined&&document.getElementsByName("deletes").length>0){    //getElementsByName���������ð����ֲ��Ҷ��󣬷���һ�����顣  
     	var ds = document.getElementsByName("deletes");  
     	if(type=="ȫѡ"){  
      		for(var i=0;i<ds.length;i++){  
       			if(ds[i].checked == false){  
        			ds[i].checked = true;  
       			}  
      		}  
    	}else if(type=="ȫ��ѡ"){  
      		for(var i=0;i<ds.length;i++){  
       			if(ds[i].checked == true){  
       				ds[i].checked = false;  
       			}  
      		}  
     	}else if(type=="��ѡ"){  
      		for(var i=0;i<ds.length;i++){  
       			if(ds[i].checked == true){  
       				 ds[i].checked = false;  
       			}else{  
        			ds[i].checked = true;  
       			}  
      		}  
     	}    
    }	  
}  
	</script>
  </head>
  
  <body>
  <br><br><br><br><br><br><br>
  	<form action="bye.jsp" method="post" onsubmit="return sub()" >
    <table align="center" cellpadding="0" cellspacing="0"
    	border="1px" width="600px" height="350px">
    	<tr bgcolor="#e6e6fa">
    			<th style="width: 46px; ">ѡ��</th>	
    			<th>����</th>
    			<th>����</th>
    			<th>����</th>
    			<th>����</th>
    		
    	</tr>
    	<c:forEach	items="${ulist}" var="li" varStatus="con">
    		<c:if test="${con.count%2==0}">
    		<tr align="center" bgcolor="#00ffff">
    			<td><input name="deletes" type="checkbox" id="${li.film_id}"></input></td>
    			<td>${li.title}</td>
    			<td>${li.description}</td>
    			<td>${li. language}</td>
    			
    			<td><a href="detele">ɾ��</a>&nbsp;&nbsp;
    			<a href="xiugai.jsp">�޸�</a>
    			</td>
    		</tr>
    		</c:if>
    		
    		<c:if test="${con.count%2!=0}">
    		<tr align="center" bgcolor="#d8bfd8">
    		<td><input name="deletes" type="checkbox" id="${li.film_id}"></input></td>
    			<td>${li.title}</td>
    			<td>${li.description}</td>
    			<td>${li. language}</td>
    			
    			<td><a href="detele">ɾ��</a>&nbsp;&nbsp;
    			<a href="xiugai.jsp">�޸�</a>
    		</tr>
    		</c:if>
    		
    		
    		
    	</c:forEach>
    	<tr bgcolor="#e6e6fa">
    			<th colspan="7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ȫѡ:<input type="checkbox" onclick="selectAllNullorReserve('ȫѡ')"/>
    			&nbsp;&nbsp;&nbsp;&nbsp;ȫ��ѡ:<input type="checkbox" onclick="selectAllNullorReserve('ȫ��ѡ')"/>
    			&nbsp;&nbsp;&nbsp;&nbsp;��ѡ:<input type="checkbox" onclick="selectAllNullorReserve('��ѡ')"/>
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
    			<center>
    			<a href="exit.jsp"></a>
    			</center>
    			</th>
    	</tr>
    </table>
    </form>	
  </body>
</html>
