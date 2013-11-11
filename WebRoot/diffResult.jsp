<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
  <c:forEach items="${list}" var="db">
  	<div>
  		<div>${db.url}</div>
  		<c:if test="${fn:contains(db.schemata.err_filed,DEFAULT_CHARACTER_SET_NAME)}">
  			**<div>编码：${db.schemata.DEFAULT_CHARACTER_SET_NAME}</div>
  		</c:if>
  		<c:if test="${fn:contains(db.schemata.err_filed,DEFAULT_CHARACTER_SET_NAME)}">
  			<div>编码：${db.schemata.DEFAULT_CHARACTER_SET_NAME}</div>
  		</c:if>
  		<c:if test="${fn:contains(db.schemata.err_filed,DEFAULT_CHARACTER_SET_NAME)}">
  			**<div>定序：${db.schemata.DEFAULT_COLLATION_NAME}</div>
  		</c:if>
  		<c:if test="${fn:contains(db.schemata.err_filed,DEFAULT_CHARACTER_SET_NAME)}">
  			<div>定序：${db.schemata.DEFAULT_COLLATION_NAME}</div>
  		</c:if>
  		
  		<div>定序：${db.schemata.DEFAULT_COLLATION_NAME}</div>
  		<c:forEach items="${db.rm_list }" var="rm_table">
  			<div>
  				---少出的表----${rm_table.TABLE_NAME }
  				<div>
	  				11表属性描述。。。。。。。。。。。。。。。。
  				</div>
  			</div>
  		</c:forEach>
  		<c:forEach items="${db.tableList }" var="each_table">
  			<c:if test="${each_table.is_extra_table}">
	  			<div>
	  				++++++多出的表+++${each_table.TABLE_NAME }
	  				<div>
	  				11表属性描述。。。。。。。。。。。。。。。。
	  				</div>
	  			</div>
  			</c:if>
  			<c:if test="${!each_table.is_extra_table}">
	  			<div>
	  				${each_table.TABLE_NAME }
	  				<div>
	  				11表属性描述。。。。。。。。。。。。。。。。
	  				</div>
	  			</div>
  			</c:if>
  		</c:forEach>
  	</div>
  	<br/>
  </c:forEach>
  
  
  
	<div><pre> ${msg }<pre></div>
  </body>
</html>
