<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/9
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <s:form method="POST" action="regAction">
        <s:textfield name="customer.userName" label="姓名"/>
        <s:password name="customer.password" label="密码"/>
        <s:submit value="注册"/>
    </s:form>


<s:form method="POST" action="loginAction">
    <s:textfield name="userName" label="姓名"/>
    <s:password name="password" label="密码"/>
    <s:submit value="登录"/>
</s:form>
</center>
</body>
</html>
