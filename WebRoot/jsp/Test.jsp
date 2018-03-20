<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Test.jsp' starting page</title>
    <style type="text/css">
    	*{
    		margin:0;
    		padding:0;
    		box-sizing:border:box;
    	}
    	#content{
    		height:10em;
    		border:1px solid red;
    		text-align: center;
    	}
    	
    	span{
    		border:1px solid green;
    	}
    </style>

  </head>
  
  <body>
    <div id="content">
<!--     	<div id="box"></div> -->
<!--     sdasdf -->

	<span>zheli shispan</span>
    </div>
  </body>
</html>
