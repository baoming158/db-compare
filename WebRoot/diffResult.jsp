<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<style>
	.db {
		background-color:#EEE;
	}
	.db .db_title{
		background-color:#EFF;
	}
	.db .db_title db_tables{
		background-color:#ECF;
	}
	.db .db_title db_tables db_title{
		border: 1px solid #CCC;
	}
	</style>
  </head>
  
  <body>
  <div class="db">
  	<div class="db_title">${db_base.url }</div>
  	<div class="db_tables">
  		<c:forEach items="${db_base.tableList }" var="each">
  			<div class="db_title">${each.TABLE_NAME }</div>
  		</c:forEach>
  	</div>
  </div>
  
  
  
	<div><pre>${msg }<pre></div>
  </body>
</html>
