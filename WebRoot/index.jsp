<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  </head>
  
  <body>
  <form action="showDiff.do" method="post">
    数据库服务器地址:<input type="text" name="url" id="url" value="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk"><br/>
    用户名：<input type="text" name="username" id="username" value="root"/><br/>
    密码：<input type="password" id="password" name="password" value="root"/><br/>
  <hr/>
    数据库服务器地址:<input type="text" name="url1" id="url1" value="jdbc:mysql://192.168.5.132:3306/sms_client_new?useUnicode=true&characterEncoding=gbk"><br/>
    用户名：<input type="text" name="username1" id="username1" value="root"/><br/>
    密码：<input type="password" id="password1" name="password1" value="123456"/><br/>
  <hr/>
    数据库服务器地址:<input type="text" name="url2" id="url2" value="jdbc:mysql://localhost:3306/test2?useUnicode=true&characterEncoding=gbk"> <br/>
    用户名：<input type="text" name="username2" id="username2" value="root"/><br/>
    密码：<input type="password" id="password2" name="password2" value="root"/><br/>
    <input type="submit" value="提交比较"> 
  </form>
  </body>
</html>
