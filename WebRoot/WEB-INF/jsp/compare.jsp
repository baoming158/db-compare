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
<title>数据库比较</title>
<script type="text/javascript">
	$(document).ready(function(){
	    $(".anchor").click(function(){
	        var href = $(this).attr("href");
	        var pos = $(href).offset().top;
	        var diff = $("#div_nav").height();
	        $("html,body").animate({scrollTop: pos-diff}, 1000);
	        return false;
		});
		$('.fancybox').fancybox();
		$("#hideAllNoDiff").click(function(){
			$(".table-original").toggle("slow");
		});
		//scroll
		function getElementViewTop(element){
		　　var actualTop = element.offsetTop;
		　　var current = element.offsetParent;
		　　while (current !== null){
		        actualTop += current.offsetTop;
		        current = current.offsetParent;
		　　}
		    var elementScrollTop=0;
		　　if (document.compatMode == "BackCompat"){
		        elementScrollTop=document.body.scrollTop;
		　　} else {
		        elementScrollTop=document.documentElement.scrollTop; 
		　　}
		    return actualTop;
		　//　return actualTop-elementScrollTop;
		}
		function getScroll()
		{
		    var top, left, width, height;
		    if (document.documentElement && document.documentElement.scrollTop) {
		        top = document.documentElement.scrollTop;
		        left = document.documentElement.scrollLeft;
		        width = document.documentElement.scrollWidth;
		        height = document.documentElement.scrollHeight;
		    } else if (document.body) {
		        top = document.body.scrollTop;
		        left = document.body.scrollLeft;
		        width = document.body.scrollWidth;
		        height = document.body.scrollHeight;
		    }
		    return { 'top': top, 'left': left, 'width': width, 'height': height };
		}
		var nav = document.getElementById('div_nav');   
		var posTop = getElementViewTop(nav);
		window.addEventListener('scroll',function(event){
		    var scrollTop = getScroll().top;
		    var diff = $("#div_nav").height();
		    if(scrollTop>=120+diff){ 
		    	$("#fake_div").show();
		        nav.className = 'header head';
	        }else{
	        	nav.className = 'header';
	        	$("#fake_div").hide();
        	}
		},false);
	});
	//end of scroll
	function showFiled(order,table_name,type){
		$.fancybox.open({
			href : "getFiledByTable.do?order="+order+"&table_name="+table_name+"&type="+type,
			type : 'iframe',
			padding : 5,
			width:1050,
			height:780,
		});
	}
	
</script>
</head>

<body>
<div class="container">
	
	<div id="fake_div" class="header" style="width:84px;display:none;"></div>
	<div class="header" id="div_nav">
        <h1 class="db-title fl">
	        <span class="txt-main" id="text11" title="${db_base.url }">主数据库：<a class="anchor" href="#top">${db_base.dbname}</a></span>
			从数据库：
			<c:forEach items="${list}" var="db_title" varStatus="anchor"> 
		    	<span><a class="anchor" href="#index_${anchor.index}">${db_title.dbname }</a></span>
			</c:forEach>
	        对比结果
	    </h1>
	    <div class="head-tips fr">
        	<span><input type="checkbox" id="hideAllNoDiff" name="hideAllNoDiff" class="ipt-check" /><label for="hideAllNoDiff">隐藏无变化的表</label></span>
            <span><a href="javascript:void(0);" class="tip-legend">图例说明</a></span>
        </div>
    </div> 
	  <a name="top" id="top"></a>
    <c:forEach items="${list}" var="db" varStatus="db_order">   
	    <div class="db-main">
	    	<a id="index_${db_order.index }" name="index_${db_order.index }"></a>
	    	<h2><strong>${db.dbname}   <a class="fancybox" href="#text11">查看结果</a></strong></h2>
	        <p class="property">
	        	(${db.url}) 
	        	<c:if test="${db.schemata.DEFAULT_CHARACTER_SET_NAME==db_base.schemata.DEFAULT_CHARACTER_SET_NAME}">
		  			<span>编码：<i>${db.schemata.DEFAULT_CHARACTER_SET_NAME}</i></span>
		  		</c:if>
		  		<c:if test="${db.schemata.DEFAULT_CHARACTER_SET_NAME!=db_base.schemata.DEFAULT_CHARACTER_SET_NAME}">
		  			<span>*编码：${db.schemata.DEFAULT_CHARACTER_SET_NAME} <i class="pp-diff">(原：${db_base.schemata.DEFAULT_CHARACTER_SET_NAME })</i></span>
		  		</c:if>
		  		
		  		<c:if test="${db.schemata.DEFAULT_COLLATION_NAME==db_base.schemata.DEFAULT_COLLATION_NAME}">
		  			<span>定序：<i>${db.schemata.DEFAULT_COLLATION_NAME}</i></span>
		  		</c:if>
		  		<c:if test="${db.schemata.DEFAULT_COLLATION_NAME!=db_base.schemata.DEFAULT_COLLATION_NAME}">
		  			<span>*定序：${db.schemata.DEFAULT_COLLATION_NAME} <i class="pp-diff">(原：${db_base.schemata.DEFAULT_COLLATION_NAME })</i></span>
		  		</c:if>
	        </p>
	        <!-- table-item -->
	        
	        
	        <c:forEach items="${db.rm_list }" var="rm_table">
	        	<!-- removed Table -->
	        	<div class="table-item table-del">
		        	<h3>-表名称：<a href="javascript:showFiled('${db_order.index }','${rm_table.TABLE_NAME }','rm');"><strong>${rm_table.TABLE_NAME }</strong></a></h3>
		            <p class="property">
		            	<span>表驱动：<i>${rm_table.ENGINE }</i></span>	
		            </p>
		            <div class="tag"><span>&minus;</span></div>            
		        </div>
	        </c:forEach>
	        
	        <c:forEach items="${db.tableList }" var="each_table">
	  			<c:if test="${each_table.is_extra_table}">
	  				<!-- added table -->
	  				<div class="table-item table-add">
			        	<h3>+表名称：<a href="javascript:showFiled('${db_order.index }','${each_table.TABLE_NAME }','add');"><strong>+${each_table.TABLE_NAME }</strong></a></h3>
			            <p class="property">
			            	<span>表驱动：<i>${each_table.ENGINE }</i></span>	
			            </p>
			            <div class="tag"><span>+</span></div>            
			        </div>
	  			</c:if>
	  			<c:if test="${not each_table.is_extra_table}">
	  				<c:if test="${not each_table.modified}">
	  					<!-- original table / not changed -->
		  				 <div class="table-item table-original">
				        	<h3>表名称：<a href="javascript:showFiled('${db_order.index }','${each_table.TABLE_NAME }','original');"><strong>${each_table.TABLE_NAME }</strong></a></h3>
				            <p class="property">
				            	<span>表驱动：<i>${each_table.ENGINE }</i></span>	
				            </p>
				        </div>
	  				</c:if>
	  				<c:if test="${each_table.modified}">
	  					<!-- modified table / changed -->
			         	<div class="table-item table-diff">
				        	<h3>*表名称：<a href="javascript:showFiled('${db_order.index }','${each_table.TABLE_NAME }','mod');"><strong>${each_table.TABLE_NAME }</strong></a></h3>
				            <p class="property">
				            	<c:if test="${empty each_table.base_table or each_table.ENGINE==each_table.base_table.ENGINE}">
				            		<span>表驱动：<i>${each_table.ENGINE }</i>&nbsp;</span>	
				            	</c:if>
				            	<c:if test="${not empty each_table.base_table and each_table.ENGINE!=each_table.base_table.ENGINE}">
				            		<span>表驱动：${each_table.ENGINE }&nbsp;<i class="pp-diff">(原:${each_table.base_table.ENGINE })</i></span>	
				            	</c:if>
				            </p>
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
