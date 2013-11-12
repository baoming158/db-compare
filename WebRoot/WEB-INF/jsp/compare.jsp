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
<link rel="stylesheet" type="text/css" href="js/fancyBox/source/jquery.fancybox.css?v=2.1.5" media="screen" />
<script type="text/javascript" src="js/fancyBox/lib/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/fancyBox/source/jquery.fancybox.js?v=2.1.5"></script>
<script type="text/javascript" src="js/fancyBox/source/helpers/jquery.fancybox-media.js?v=1.0.6"></script>
<title>数据库比较</title>
<script type="text/javascript">
	$(document).ready(function() {
		$(".fancybox").fancybox();
	});
</script>
</head>

<body>
<div class="container">
	<h1><span class="txt-main"><a class="fancybox" href="#inline1" >主数据库：DB</a></span>
    	<span id="23">从数据库：DB1</span>
        <span>从数据库：DB2</span>
        对比结果
    </h1> 
    <c:forEach items="${list}" var="db" varStatus="db_order">   
	    <div class="db-main">
	    	<h2><strong>${db.dbname}  (${db.url})</strong></h2>
	        <p class="property">
	        	<c:if test="${db.schemata.DEFAULT_CHARACTER_SET_NAME==db_base.schemata.DEFAULT_CHARACTER_SET_NAME}">
		  			<span>编码：<i>${db.schemata.DEFAULT_CHARACTER_SET_NAME}</i></span>
		  		</c:if>
		  		<c:if test="${db.schemata.DEFAULT_CHARACTER_SET_NAME!=db_base.schemata.DEFAULT_CHARACTER_SET_NAME}">
		  			<span>*编码：<i>${db.schemata.DEFAULT_CHARACTER_SET_NAME} (原：${db_base.schemata.DEFAULT_CHARACTER_SET_NAME })</i></span>
		  		</c:if>
		  		
		  		<c:if test="${db.schemata.DEFAULT_COLLATION_NAME==db_base.schemata.DEFAULT_COLLATION_NAME}">
		  			<span>定序：<i>${db.schemata.DEFAULT_COLLATION_NAME}</i></span>
		  		</c:if>
		  		<c:if test="${db.schemata.DEFAULT_COLLATION_NAME!=db_base.schemata.DEFAULT_COLLATION_NAME}">
		  			<span>*定序：<i>${db.schemata.DEFAULT_COLLATION_NAME} (原：${db_base.schemata.DEFAULT_COLLATION_NAME })</i></span>
		  		</c:if>
	        </p>
	        <!-- table-item -->
	        
	        
	        <c:forEach items="${db.rm_list }" var="rm_table">
	        	<div class="table-item table-del">
		        	<h3>-表名称：<a class="fancybox" href="#inline_${db_order.index }_${rm_table.TABLE_NAME }"><strong>${rm_table.TABLE_NAME }</strong></a></h3>
		            <p class="property">
		            	<span>表驱动：<i>${rm_table.ENGINE }</i></span>	
		            </p>
		            <div class="tag"><span>&minus;</span></div>            
		        </div>
		        <c:set value="${rm_table}" var="t"/>
	        	<%@include file="field_rm.jsp"%>
	        </c:forEach>
	        
	        <c:forEach items="${db.tableList }" var="each_table">
	  			<c:if test="${each_table.is_extra_table}">
	  				<div class="table-item table-add">
			        	<h3>+表名称：<a class="fancybox" href="#inline_${db_order.index }_${each_table.TABLE_NAME }"><strong>+${each_table.TABLE_NAME }</strong></a></h3>
			            <p class="property">
			            	<span>表驱动：<i>${each_table.ENGINE }</i></span>	
			            </p>
			            <div class="tag"><span>+</span></div>            
			        </div>
			        <c:set value="${each_table}" var="t"/>
		        	<%@include file="field_add.jsp"%>
	  			</c:if>
	  			<c:if test="${not each_table.is_extra_table}">
	  				<c:if test="${not each_table.modified}">
		  				 <div class="table-item">
				        	<h3>表名称：<a class="fancybox" href="#inline_${db_order.index }_${each_table.TABLE_NAME }"><strong>${each_table.TABLE_NAME }</strong></a></h3>
				            <p class="property">
				            	<span>表驱动：<i>${each_table.ENGINE }</i></span>	
				            </p>
				        </div>
				        <c:set value="${each_table}" var="t"/>
			        	<%@include file="field_original.jsp"%>
	  				</c:if>
	  				<c:if test="${each_table.modified}">
			         	<div class="table-item table-diff">
				        	<h3>*表名称：<a class="fancybox" href="#inline_${db_order.index }_${each_table.TABLE_NAME }"><strong>${each_table.TABLE_NAME }</strong></a></h3>
				            <p class="property">
				            	<c:if test="${empty each_table.base_table or each_table.ENGINE==each_table.base_table.ENGINE}">
				            		<span>表驱动：<i>${each_table.ENGINE }</i>&nbsp;</span>	
				            	</c:if>
				            	<c:if test="${not empty each_table.base_table and each_table.ENGINE!=each_table.base_table.ENGINE}">
				            		<span>表驱动：<i class="pp-diff">${each_table.ENGINE }</i>&nbsp;(原:${each_table.base_table.ENGINE })</span>	
				            	</c:if>
				            </p>
				            <c:set value="${each_table}" var="t"/>
				        	<%@include file="field_mod.jsp"%>
				            <div class="tag"><span>&lowast;</span></div>
				        </div>
				    </c:if>
	  			</c:if>
  			</c:forEach>
	        
	        
	        
	        <div class="clear"></div>
	    </div>
    </c:forEach>
    <!-- 图例 -->
    <div class="legend">
    	<div class="legend-item"><span class="l-i-add">+</span> 从数据库新加的表</div>
        <div class="legend-item"><span class="l-i-del">&minus;</span> 从数据库没有的表</div>
        <div class="legend-item"><span class="l-i-diff">&lowast;</span> 与主数据库有差异（属性\字段）的表</div>
    </div>
</div>
</body>
</html>
