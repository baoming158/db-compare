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
<div>
	<div class="db-main" style="margin:0; padding:5px;">
    	<h3>表名称：<strong>${t.TABLE_NAME }(存在差异)</strong></h3>
        
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
   				<c:if test="${not _t.is_extra_column}">
	   	    		<ul class="field-item">
						<!-- column1  -->
		   	    		<c:if test="${not empty _t.base_column and _t.column_name!=_t.base_column.column_name}">
							<li class="col01"><span>${_t.column_name }</span> <span class="txt-main">[${_t.base_column.column_name }]</span></li>
		   	    		</c:if>
		   	    		<c:if test="${empty _t.base_column or _t.column_name==_t.base_column.column_name}">
							<li class="col01"><span>${_t.column_name }</span></li>
		   	    		</c:if>
	   	    		
						<!-- column2  -->
		   	    		<c:if test="${not empty _t.base_column and _t.ordinal_position!=_t.base_column.ordinal_position}">
							<li class="col02"><span>${_t.ordinal_position }</span> <span class="txt-main">[${_t.base_column.ordinal_position }]</span></li>
		   	    		</c:if>
		   	    		<c:if test="${empty _t.base_column or _t.ordinal_position==_t.base_column.ordinal_position}">
							<li class="col02"><span>${_t.ordinal_position }</span></li>
		   	    		</c:if>
	   	    		
						<!-- column  3-->
		   	    		<c:if test="${not empty _t.base_column and _t.column_default!=_t.base_column.column_default}">
							<li class="col03"><span>${_t.column_default }</span> <span class="txt-main">[${_t.base_column.column_default }]</span></li>
		   	    		</c:if>
		   	    		<c:if test="${empty _t.base_column or _t.column_default==_t.base_column.column_default}">
							<li class="col03"><span>${_t.column_default }</span></li>
		   	    		</c:if>
	   	    		
						<!-- column 4 -->
		   	    		<c:if test="${not empty _t.base_column and _t.is_nullable!=_t.base_column.is_nullable}">
							<li class="col04"><span>${_t.is_nullable }</span> <span class="txt-main">[${_t.base_column.is_nullable }]</span></li>
		   	    		</c:if>
		   	    		<c:if test="${empty _t.base_column or _t.is_nullable==_t.base_column.is_nullable}">
							<li class="col04"><span>${_t.is_nullable }</span></li>
		   	    		</c:if>
	   	    		
						<!-- column 5 -->
		   	    		<c:if test="${not empty _t.base_column and _t.data_type!=_t.base_column.data_type}">
							<li class="col05"><span>${_t.data_type }</span> <span class="txt-main">[${_t.base_column.data_type }]</span></li>
		   	    		</c:if>
		   	    		<c:if test="${empty _t.base_column or _t.data_type==_t.base_column.data_type}">
							<li class="col05"><span>${_t.data_type }</span></li>
		   	    		</c:if>
	   	    		
						<!-- column 6 -->
		   	    		<c:if test="${not empty _t.base_column and _t.character_maximum_length!=_t.base_column.character_maximum_length}">
							<li class="col06"><span>${_t.character_maximum_length }</span> <span class="txt-main">[${_t.base_column.character_maximum_length }]</span></li>
		   	    		</c:if>
		   	    		<c:if test="${empty _t.base_column or _t.character_maximum_length==_t.base_column.character_maximum_length}">
							<li class="col06"><span>${_t.character_maximum_length }</span></li>
		   	    		</c:if>
	   	    		
						<!-- column 7  -->
		   	    		<c:if test="${not empty _t.base_column and _t.character_set_name!=_t.base_column.character_set_name}">
							<li class="col07"><span>${_t.character_set_name }</span> <span class="txt-main">[${_t.base_column.character_set_name }]</span></li>
		   	    		</c:if>
		   	    		<c:if test="${empty _t.base_column or _t.character_set_name==_t.base_column.character_set_name}">
							<li class="col07"><span>${_t.character_set_name }</span></li>
		   	    		</c:if>
	   	    		
						<!-- column 8  -->
		   	    		<c:if test="${not empty _t.base_column and _t.collation_name!=_t.base_column.collation_name}">
							<li class="col08"><span>${_t.collation_name }</span> <span class="txt-main">[${_t.base_column.collation_name }]</span></li>
		   	    		</c:if>
		   	    		<c:if test="${empty _t.base_column or _t.collation_name==_t.base_column.collation_name}">
							<li class="col08"><span>${_t.collation_name }</span> </li>
		   	    		</c:if>
	   	    		
						<!-- column  9 -->
		   	    		<c:if test="${not empty _t.base_column and _t.column_key!=_t.base_column.column_key}">
							<li class="col09"><span>${_t.column_key }</span> <span class="txt-main">[${_t.base_column.column_key }</span></li>
		   	    		</c:if>
		   	    		<c:if test="${empty _t.base_column or _t.column_key==_t.base_column.column_key}">
							<li class="col09"><span>${_t.column_key }</span></li>
		   	    		</c:if>
	   	    		
						<!-- column 10 -->
		   	    		<c:if test="${not empty _t.base_column and _t.extra!=_t.base_column.extra}">
							<li class="col10"><span>${_t.extra }</span> <span class="txt-main">[${_t.base_column.extra }</span></li>
		   	    		</c:if>
		   	    		<c:if test="${empty _t.base_column or _t.extra==_t.base_column.extra}">
							<li class="col10"><span>${_t.extra }</span></li>
		   	    		</c:if>
	        		</ul>
        		</c:if>
        		
        		<!-- 多出的字段 -->
        		<c:if test="${_t.is_extra_column}">
					<div class="field-add">
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
	        		</div>
				</c:if>
       		</c:forEach>
        	
        	
        	 <!-- 被删减的字段 -->
            <c:forEach items="${t.rm_list }" var="_t">
            	<div class=" field-del">
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
        		</div>
            </c:forEach>
            
            
        </div>
    	<!--field end-->
    </div>
</div>
</body>
</html>
