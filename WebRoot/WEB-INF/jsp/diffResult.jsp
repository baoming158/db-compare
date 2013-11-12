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
	<style>
	</style>
  </head>
  
  <body>
  <c:forEach items="${list}" var="db">
  	<div>
  		<div>${db.url}</div>
  		<c:if test="${db.schemata.DEFAULT_CHARACTER_SET_NAME==db_base.schemata.DEFAULT_CHARACTER_SET_NAME}">
  			<div>编码：${db.schemata.DEFAULT_CHARACTER_SET_NAME}</div>
  		</c:if>
  		<c:if test="${db.schemata.DEFAULT_CHARACTER_SET_NAME!=db_base.schemata.DEFAULT_CHARACTER_SET_NAME}">
  			<div class="modified">*编码：${db.schemata.DEFAULT_CHARACTER_SET_NAME}(原：${db_base.schemata.DEFAULT_CHARACTER_SET_NAME })</div>
  		</c:if>
  		
  		<c:if test="${db.schemata.DEFAULT_COLLATION_NAME==db_base.schemata.DEFAULT_COLLATION_NAME}">
  			<div>定序：${db.schemata.DEFAULT_COLLATION_NAME}</div>
  		</c:if>
  		<c:if test="${db.schemata.DEFAULT_COLLATION_NAME!=db_base.schemata.DEFAULT_COLLATION_NAME}">
  			<div class="modified">*定序：${db.schemata.DEFAULT_COLLATION_NAME}(原：${db_base.schemata.DEFAULT_COLLATION_NAME })</div>
  		</c:if>
  		
  		<c:forEach items="${db.rm_list }" var="rm_table">
  			<div class="table">
  				---少出的表----${rm_table.TABLE_NAME }
  				<div>
	  				表驱动：${rm_table.ENGINE }
  				</div>
  				
  				<!-- column-->
  				<div class="column">
  					<c:forEach items="${each_table.columnList}" var="each_column">
  						<div>字段名称${each_column.column_name }</div>
  						<div>顺序${each_column.ordinal_position }</div>
  					</c:forEach>
  				</div>
  				<!-- end of column-->
  				
  			</div>
  		</c:forEach>
  		<c:forEach items="${db.tableList }" var="each_table">
  			<c:if test="${each_table.is_extra_table}">
	  			<div class="table">
	  				++++++多出的表+++${each_table.TABLE_NAME }
	  				<div>
	  					表驱动：${each_table.ENGINE }
	  				</div>
	  				
	  				<!-- column-->
	  				<div class="column">
	  					<c:forEach items="${each_table.columnList}" var="each_column">
	  						<div>字段名称${each_column.column_name }</div>
	  						<div>顺序${each_column.ordinal_position }</div>
	  					</c:forEach>
	  				</div>
	  				<!-- end of column-->
	  				
	  			</div>
  			</c:if>
  			<c:if test="${not each_table.is_extra_table}">
	  			<div class="table">
	  				${each_table.TABLE_NAME }
	  				<div>
	  					表驱动：${each_table.ENGINE }
	  				</div>
	  				
	  				<!-- column-->
	  				<div class="column">
	  					<c:forEach items="${each_table.columnList}" var="each_column">
	  						<div>字段名称${each_column.column_name }</div>
	  						<c:if test="${not empty each_column.base_column}">
	  							<c:if test="${each_column.ordinal_position==each_column.base_column.ordinal_position}">
	  								<div>顺序：${each_column.ordinal_position }</div>
	  							</c:if>
	  							<c:if test="${each_column.ordinal_position!=each_column.base_column.ordinal_position}">
	  								<div>*顺序：${each_column.ordinal_position }(原:${each_column.base_column.ordinal_position })</div>
	  							</c:if>
	  						</c:if>
	  						<c:if test="${empty each_column.base_column}">
	  							<div>顺序${each_column.ordinal_position }</div>
	  						</c:if>
	  					</c:forEach>
	  				</div>
	  				<!-- end of column-->
	  				
	  			</div>
  			</c:if>
  		</c:forEach>
  	</div>
  	<br/>
  </c:forEach>
  
  
  
  </body>
</html>
