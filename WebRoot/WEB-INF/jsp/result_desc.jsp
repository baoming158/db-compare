<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>结果说明_数据库比较</title>
</head>

<body>
<div class="db-main">
    <h2>数据库：<strong>test1</strong></h2>
    <h3><strong>module</strong></h3>
    <div class="table-info  field-del">
    	<span class="t-i-left">-缺少列：</span>
    	<div class="t-i-cont"><span>name</span></div>
    </div>
    
    <div class="table-info field-add">
    	<span class="t-i-left">+多出的列：</span>
        <div class="t-i-cont"><span>DDD</span> <span>232</span> <span>jklj</span> <span>kfdjs</span> <span>k</span> <span>jl</span> <span>ajsdl</span> <span><span>jjjl</span> <span><span>saol</span> <span>l</span> <span>iijl</span> <span>ijlji</span> <span>8dfj</span>
    	</div>
    </div>
    
     <div class="table-info">
    	<span class="t-i-left">属性不同的字段列</span>
     </div>
    <div class="table-info">
    	<span class="t-i-left">id：</span>
        <div class="t-i-cont"><span>column_type</span></div>
    </div>
    <div class="table-info">
    	<span class="t-i-left">comment：</span>
        <div class="t-i-cont"><span>ordinal_position</span> <span>column_default</span></div>
    </div>
    
    <div class="table-info">
    	<span class="t-i-left">name1：</span>
        <div class="t-i-cont"><span>ordinal_position</span> <span>character_maximum_length</span> <span>column_type</span></div>
    </div>
    
    <div class="table-info">
    	<span class="t-i-left">comment2：</span>
        <div class="t-i-cont"><span>ordinal_position</span> <span>character_maximum_length</span> <span>column_type</span> <span>data_type</span> <span>character_set_name</span> <span>collation_name</span>
        </div>
    </div>
</div>
</body>
</html>
