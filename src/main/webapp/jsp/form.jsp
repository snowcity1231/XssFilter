<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'form.jsp' starting page</title>

  </head>
  
  <body>
    <form action="submit.do">
    	用户名:<input type="text" name="userName" id=userNameId></br>
    	密码：<input type="password" name="pwd" id="pwdId">
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
