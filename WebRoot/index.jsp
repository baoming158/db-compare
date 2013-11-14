<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jQuery/jquery-1.7.1.min.js"></script>
<script>
	$(document).ready(function(){
        // test connection
        $(".testConnection").live('click',function(){
        	var base_ul = $(this).parent('li').parent('ul');
        	var url = base_ul.find('input[name=url]').val();
        	var username = base_ul.find('input[name=username]').val();
        	var password = base_ul.find('input[name=password]').val();
        	var data = "url="+url+"&username="+username+"&password="+password;
			$.ajax({
				url:'testConnection.do',
				type:'post',
				data:data,
				success:function(txt){
					if(txt=='err'){
						base_ul.find(".info").removeClass("info-right");
						base_ul.find(".info").addClass("info-error").html("<i>&times;</i> 数据库连接失败");
					}
					if(txt=='ok'){
						base_ul.find(".info").removeClass("info-error");
						base_ul.find(".info").addClass("info-right").html("<i>&radic;</i> 数据库连接成功");
					}
				}
			});
        });
        // --end of test connection
	});
	function addConnection(){
		 var html = 
	        '<ul class="form-item">'+
	            '<li>'+
	               '<label>服务器地址：</label>'+
	                '<div class="f-i-cont"><input type="text" name="url" class="ipt-addr" /></div>'+
	            '</li>'+
	           '<li>'+
	                '<label>用户名：</label>'+
	                '<div class="f-i-cont"><input type="text" name="username" class="ipt-txt" /></div>'+
	            '</li>'+
	            '<li>'+
	                '<label>密 码：</label>'+
	                '<div class="f-i-cont"><input type="text" name="password" class="ipt-txt" />'+
	                	'<span class="info info-right"></span>'+
	                '</div>'+
	            '</li>'+
	            '<li class="operate"><a href="javascript:void(0);" class="ico-del" title="删除">&times;</a></li>'+
	            '<li class="test-connection"><input type="button" value="测试连接" class="ipt-test testConnection" /></li>'+
	        '</ul>';
	    var html_frm = $(html);
	    html_frm.find(".operate").click(function(){
	    	var flag = window.confirm("确定要删除该连接吗？")
	    	if(flag){
				html_frm.remove();
			}
		});
        html_frm.appendTo($("#form_body"));
        
	}
	
</script>
<title>数据库比较</title>
</head>

<body>
<div class="container form-main">
	<div class="txt-main">主数据库信息(*必填)</div>
    <form action="showDiff.do" method="post">
    	<div id="form_body">
	    	<ul class="form-item">
	            <li>
	                <label>服务器地址：</label>
	                <div class="f-i-cont"><input type="text" name="url" id="url" class="ipt-addr" value="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk"/></div>
	            </li>
	            <li>
	                <label>用户名：</label>
	                <div class="f-i-cont"><input type="text" name="username" id="username" value="root" class="ipt-txt" /></div>
	            </li>
	            <li>
	                <label>密 码：</label>
	                <div class="f-i-cont"><input type="text" name="password" id="password" class="ipt-txt" value="root"/>
	                	<span class="info info-error"></span>
	                </div>
	            </li>
	            <li class="test-connection"><input type="button" value="测试连接" class="ipt-test testConnection" /></li>
	        </ul>
	        
	        
	    	<div class="txt-main">从数据库信息(*必填一个从数据库)</div>
	        
	    	<ul class="form-item">
	            <li>
	                <label>服务器地址：</label>
	                <div class="f-i-cont"><input type="text" name="url"  class="ipt-addr" value="jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=gbk"/></div>
	            </li>
	            <li>
	                <label>用户名：</label>
	                <div class="f-i-cont"><input type="text" name="username" class="ipt-txt" value="root"/></div>
	            </li>
	            <li>
	                <label>密 码：</label>
	                <div class="f-i-cont"><input type="text" name="password" class="ipt-txt" value="root"/>
	                	<span class="info info-error"></span>
	                </div>
	            </li>
	            <li class="test-connection"><input type="button" value="测试连接" class="ipt-test testConnection" /></li>
	        </ul>
        </div>
        <div class="form-footer">
        	<input type="submit" value="提交对比" class="ipt-btn" />
            <input type="button" value="添加从数据库" onclick="javascript:addConnection();" class="ipt-btn" />
        </div>
                
    </form>
</div>
</body>
</html>
