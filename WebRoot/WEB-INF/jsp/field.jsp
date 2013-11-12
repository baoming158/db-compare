<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>字段对比</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="container">	
	<div class="db-main">
    	<h3>表名称：<strong>DB-USER</strong></h3>
        
    	<h4><span class="txt-main">主数据库：DB</span>
            <span>从数据库：DB1</span>
        </h4>
        <!--field start-->
        <div class="field-main">
        	<ul class="field-title">
            	<li>column_name<i>列名称<span class="txt-main">*</span></i></li>
                <li>ordinal_position<i>顺序<span class="txt-main">*</span></i></li>
                <li>column_default<i>默认值</i></li>
                <li>is_nullable<i>是否为空</i></li>
                <li>data_type<i>数据类型<span class="txt-main">*</span></i></li>
                <li>character_maximum_length<i>字符最大长度</i></li>
                <li>character_set_name<i>字符编码</i></li>
                <li>collation_name<i>定序</i></li>
                <li>column_key<i>是否为主键</i></li>
                <li>extra<i>额外信息</i></li>
            </ul>
            <ul class="field-item">
            	<li class="col01">column-name</li>
                <li class="col02">2</li>
                <li class="col03">/</li>
                <li class="col04">否</li>
                <li class="col05">varchar</li>
                <li class="col06">255</li>
                <li class="col07">utf-8</li>
                <li class="col08">2</li>
                <li class="col09">是</li>
                <li class="col10">/</li>
            </ul>
            <ul class="field-item">
            	<li class="col01">column-name</li>
                <li class="col02">2</li>
                <li class="col03">/</li>
                <li class="col04">否</li>
                <li class="col05">varchar</li>
                <li class="col06">255</li>
                <li class="col07">utf-8</li>
                <li class="col08">2</li>
                <li class="col09">是</li>
                <li class="col10">/</li>
            </ul>
            <ul class="field-item">
            	<li class="col01">column-name</li>
                <li class="col02">2 <i class="txt-main">[5]</i></li>
                <li class="col03">/</li>
                <li class="col04">否</li>
                <li class="col05">varchar <i class="txt-main">[num]</i></li>
                <li class="col06">255</li>
                <li class="col07">utf-8</li>
                <li class="col08">2</li>
                <li class="col09">是 <i class="txt-main">[否]</i></li>
                <li class="col10">/</li>
            </ul>
            <ul class="field-item">
            	<li class="col01">column-name</li>
                <li class="col02">2 <i class="txt-main">[5]</i></li>
                <li class="col03">/</li>
                <li class="col04">否</li>
                <li class="col05">varchar <i class="txt-main">[num]</i></li>
                <li class="col06">255</li>
                <li class="col07">utf-8</li>
                <li class="col08">2</li>
                <li class="col09">是 <i class="txt-main">[否]</i></li>
                <li class="col10">/</li>
            </ul>
            <!--新加的字段-->
            <div class=" field-add">
                <ul class="field-item">
                    <li class="col01">column-name</li>
                    <li class="col02">2</li>
                    <li class="col03">/</li>
                    <li class="col04">否</li>
                    <li class="col05">varchar</li>
                    <li class="col06">255</li>
                    <li class="col07">utf-8</li>
                    <li class="col08">2</li>
                    <li class="col09">是</li>
                    <li class="col10">/</li>
                </ul>
                <ul class="field-item">
                    <li class="col01">column-name</li>
                    <li class="col02">2</li>
                    <li class="col03">/</li>
                    <li class="col04">否</li>
                    <li class="col05">varchar</li>
                    <li class="col06">255</li>
                    <li class="col07">utf-8</li>
                    <li class="col08">2</li>
                    <li class="col09">是</li>
                    <li class="col10">/</li>
                </ul>
            </div>
            <!--end-->
            <!--从数据库中没有的字段-->
            <div class=" field-del">
                <ul class="field-item">
                    <li class="col01">column-name</li>
                    <li class="col02">2</li>
                    <li class="col03">/</li>
                    <li class="col04">否</li>
                    <li class="col05">varchar</li>
                    <li class="col06">255</li>
                    <li class="col07">utf-8</li>
                    <li class="col08">2</li>
                    <li class="col09">是</li>
                    <li class="col10">/</li>
                </ul>
                <ul class="field-item">
                    <li class="col01">column-name</li>
                    <li class="col02">2</li>
                    <li class="col03">/</li>
                    <li class="col04">否</li>
                    <li class="col05">varchar</li>
                    <li class="col06">255</li>
                    <li class="col07">utf-8</li>
                    <li class="col08">2</li>
                    <li class="col09">是</li>
                    <li class="col10">/</li>
                </ul>
            </div>
            <!--end-->
        </div>
    	<!--field end-->
    </div>
</div>
</body>
</html>
