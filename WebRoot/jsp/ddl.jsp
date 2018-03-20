<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>绘制下拉列表</title>
    <link rel="stylesheet" href="css/ddl.css" type="text/css"></link>
    <script type="text/javascript" src="js/util.js"></script>
<!-- 	<script type="text/javascript" src="js/ddl.js"></script> -->
  	<script type="text/javascript" src="js/DropDownList.js"></script>
  	<script type="text/javascript" src="js/Grid.js"></script>
  </head>
  
	<script type="text/javascript">
		window.onload = function(){
			var arrItemList = ["徐州","盐城","宿迁","苏州","南京"];
			new DropDownList({
				"renderTo":"ddlAdd1",
				"itemList":arrItemList
			});
			
			
			var rows = [{
				id:"001",
				name:"nihao",
				createTime:"2017-12-13"
			},{
				id:"002",
				name:"nihao",
				createTime:"2017-12-13"
			}];
			
			var cols = [{
				name:"入库单号"
			},{
				name:"入库用户"
			},{
				name:"入库事件"
			}];
			
			new Grid({
				"renderTo":"userGrid",
				"colmus":cols,
				"rows":rows
				
			});
			
		};
	</script>  
  <body>
    <div id="ddlAdd1" class="ddl" style="width:12em"></div>
    
    <br/>
	<div id="ddlAdd2" class="ddl" style="width:12em"></div>
    
    <div id="userGrid"></div>
    
    
  </body>
</html>
