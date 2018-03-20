<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
  <link rel="stylesheet" href="css/login.css" type="text/css"></link></head>
  
  <body>
	<div class="loginPage">
		<div class="loginText">登录</div>
		<div class="loginDes">欢迎登录商品管理系统</div>
		<div class="row">
			<input type="text" name="txtUserName" placeholder="用户名"/>
		</div>
		<div class="row">
			<input type="password" name="txtUserPwd"  placeholder="密码" />
		</div>
		<div class="row code">
			<input id="txtCode" type="text" name="txtCode"  placeholder="验证码"/>
			<img id="codePic" src="" title="验证码"/>
		</div>
		<div class="row">
			<input type="checkbox" />
			<span class="savePwd">记住密码</span>
			<a id="regiest" href="">注册</a>
		</div>
		<input type="button" value="登录" />
	</div>   
    
    
  </body>
</html>
