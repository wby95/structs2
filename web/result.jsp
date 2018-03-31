<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<center>
    <table title="用户列表单" border="1">
        <tr>
            <td>用户名</td>
            <td>性别</td>
            <td>出发城市</td>
            <td>目的城市</td>
            <td>出发时间</td>
            <td>身份证号</td>
        </tr>
        <c:forEach items="${sessionScope.list}" var="list">
            <tr>
                <td>${list.userName}  </td>
                <td> ${list.sex}</td>
                <td> ${list.startCity}</td>
                <td>${list.endCity}</td>
                <td> ${list.gooff}</td>
                <td> ${list.userId}</td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>