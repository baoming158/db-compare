<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>字段对比</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div style="display:none" id="inline_${db_order.index }_${t.TABLE_NAME }">
	<div class="db-main" style="margin:0; padding:5px;">
    	<h3>表名称：<strong>${t.TABLE_NAME }</strong></h3>
        
    	<h4><span class="txt-main">数据库：${db.dbname }</span>
            <span>
            	多出的表
            </span>
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
            
       		<c:forEach items="${t.columnList}" var="_t">
   	    		 <ul class="field-item">
					<li class="col01">${_t.column_name }</li>
	                <li class="col02">${_t.ordinal_position }</li>
	                <li class="col03">${_t.column_default }</li>
	                <li class="col04">${_t.is_nullable }</li>
	                <li class="col05">${_t.data_type }</li>
	                <li class="col06">${_t.character_maximum_length }</li>
	                <li class="col07">${_t.character_set_name }</li>
	                <li class="col08">${_t.collation_name }</li>
	                <li class="col09">${_t.column_name }</li>
	                <li class="col10"><span>${_t.extra }</span></li>
        		</ul>
       		</c:forEach>
        	
        </div>
    	<!--field end-->
    </div>
</div>
</body>
</html>
