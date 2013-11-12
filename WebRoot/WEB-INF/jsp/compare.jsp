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
<title>数据库比较</title>
</head>

<body>
<div class="container">
	<h1><span class="txt-main">主数据库：DB</span>
    	<span>从数据库：DB1</span>
        <span>从数据库：DB2</span>
        对比结果
    </h1>    
    <div class="db-main">
    	<h2><strong>DB1</strong></h2>
        <p class="property">
        	<span>编码：<i>utf-8</i></span>
        	<span>定序：<i>啥属性、、</i></span>
        </p>
        <!-- table-item -->
        <div class="table-item">
        	<h3>表名称：<a href="field.html"><strong>DB-USER</strong></a></h3>
            <p class="property">
            	<span>表驱动：<i>utf-8</i></span>	
            </p>
        </div>
        <!-- table-item end -->
        <div class="table-item">
        	<h3>表名称：<a href="javascript:void(0);"><strong>DB-PROPERTY</strong></a>4</h3>
            <p class="property">
            	<span>表驱动：<i>utf-8</i></span>	
            </p>
        </div>
        
        <!-- 加的表 -->
        <div class="table-item table-add">
        	<h3>表名称：<a href="javascript:void(0);"><strong>DB-PROPERTY2</strong></a></h3>
            <p class="property">
            	<span>表驱动：<i>utf-8</i></span>	
            </p>
            <div class="tag"><span>+</span></div>            
        </div>
        <!--end-->
        
        <!-- 删掉的表 -->
        <div class="table-item table-del">
        	<h3>表名称：<a href="javascript:void(0);"><strong>DB-PROPERTY</strong></a></h3>
            <p class="property">
            	<span>表驱动：<i>utf-8</i></span>	
            </p>
            <div class="tag"><span>&minus;</span></div>            
        </div>
        <!--end-->
        
        <!-- 有区别的表 -->
        <div class="table-item table-diff">
        	<h3>表名称：<a href="javascript:void(0);"><strong>DB-PROPERTY</strong></a></h3>
            <p class="property">
            	<span>表驱动：<i>utf-8</i></span>	
            </p>
            <div class="tag"><span>&lowast;</span></div>
            
        </div>
        <!--end-->
        
        <!-- 有区别的表 属性 -->
        <div class="table-item table-diff">
        	<h3>表名称：<a href="javascript:void(0);"><strong>DB-PROPERTY1</strong></a></h3>
            <p class="property">
            	<span>表驱动：<i class="pp-diff">utf-8</i>&nbsp;(原:gbk)</span>	
            </p>
            <div class="tag"><span>&lowast;</span></div>
            
        </div>
        <!--end-->       
        <div class="clear"></div>
    </div>
    <!--db2-->
    <div class="db-main">
    	<h2><strong>DB2</strong></h2>
      <p class="property">
        	<span>编码：<i>utf-8</i></span>
        	<span>定序：<i class="pp-diff">啥属性、、</i></span>
        </p>
        <!-- table-item -->
        <!-- table-item end -->
        <div class="table-item">
        	<h3>表名称：<a href="javascript:void(0);"><strong>DB-PROPERTY</strong></a>4</h3>
            <p class="property">
            	<span>表驱动：<i>utf-8</i></span>	
            </p>
      </div>
        
        <!-- 加的表 -->
        <div class="table-item table-add">
        	<h3>表名称：<a href="javascript:void(0);"><strong>DB-PROPERTY2</strong></a></h3>
            <p class="property">
            	<span>表驱动：<i>utf-8</i></span>	
            </p>
            <div class="tag"><span>+</span></div>            
        </div>
        <!--end-->
        
        <!-- 删掉的表 -->
      <div class="table-item table-del">
        	<h3>表名称：<a href="javascript:void(0);"><strong>DB-PROPERTY</strong></a></h3>
            <p class="property">
            	<span>表驱动：<i>utf-8</i></span>	
            </p>
            <div class="tag"><span>&minus;</span></div>            
        </div>
        <!--end-->
        
        <!-- 有区别的表 -->
        <!--end-->
        
        <!-- 有区别的表 属性 -->
        <div class="table-item table-diff">
        	<h3>表名称：<a href="javascript:void(0);"><strong>DB-PROPERTY1</strong></a></h3>
            <p class="property">
            	<span>表驱动：<i class="pp-diff">utf-8</i>&nbsp;(原:gbk)</span>	
            </p>
            <div class="tag"><span>&lowast;</span></div>
            
      </div>
        <!--end-->       
        <div class="clear"></div>
    </div>
    <!-- 图例 -->
    <div class="legend">
    	<div class="legend-item"><span class="l-i-add">+</span> 从数据库新加的表</div>
        <div class="legend-item"><span class="l-i-del">&minus;</span> 从数据库没有的表</div>
        <div class="legend-item"><span class="l-i-diff">&lowast;</span> 与主数据库有差异（属性\字段）的表</div>
    </div>
</div>
</body>
</html>
