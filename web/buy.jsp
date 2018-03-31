<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>--%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'login2.jsp' starting page</title>
    <%--日历控件--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
    <%--<sx:head parseContent="true"/>--%>
    <%--模拟了一个同一个用户在同一天只能买一张票的例子--%>
    <script type="text/javascript">
        <%--异步检查日期--%>
        function checkgooff(gooff){
            if($("#gooff").val()==""){
                $("#usergooffInfo").html("日期不能为空！");
                $("#gooff").focus();
                return;
            }
            else {
                $("#usergooffInfo").html("");

            }
            var userName=$("#userName").val().toString()
            var gooff=$("#gooff").val().toString()
            $.post("personAction.action",{userName:userName,gooff:gooff},
                function(result){
                    var result=eval('('+result+')');
                    if(result.exist){
                        $("#usergooffInfo").html("该用户已经在该天买好了票！");
                        $("#gooff").focus();
                    }
                    else {
                        $("#usergooffInfo").html("");
                    }
                }
            );
        }
        /*异步校验日期*/
        function checkUsername(userName){
            if($("#userName").val()==""){
                $("#userNameInfo").html("用户名不能为空");
                $("#userName").focus();
                return;
            }else {
                $("#userNameInfo").html("");
            }
           var gooff=$("#gooff").val()
           var userName=$("#userName").val().toString()
            $.post("personAction.action",{userName:userName,gooff:gooff},
                function(result){
                    var result=eval('('+result+')');
                    if(result.exist){
                        $("#usergooffInfo").html("该用户已经在该天买好了票！");
                        $("#gooff").focus();
                    }
                    else {
                        $("#usergooffInfo").html("");
                    }
                }
            );
        }

    </script>
</head>

<body>
<script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<%request.setCharacterEncoding("utf-8");%>
<center>

<s:form method="POST" action="doBuyAction.action" >
   <tr> <td><s:textfield id="userName" name="userName" label="姓名" onblur="checkUsername(this.value)"/></td><td><font id="userNameInfo" color="red"></font></td></tr>
    <tr> <td><s:radio list="#{ '男':'男', '女':'女'}" name="sex" label="性别"></s:radio></td><td></td></tr>
    <tr> <td> <s:textfield name="startCity" label="初始城市" /></td><td></td></tr>
    <tr> <td><s:textfield name="endCity" label="目的城市"   /></td><td></td></tr>
    <%--<sx:datetimepicker name="gooff" label="出发时间" displayFormat="yyyy-MM-dd"></sx:datetimepicker>--%>
    <tr> <td><s:textfield  label="出发时间" name="gooff" id="gooff" cssClass="calendar" onClick="WdatePicker()" onblur="checkgooff(this.value)" /></td><td><font id="usergooffInfo" color="red"></font></td></tr>
    <tr> <td><s:textfield name="userId" label="身份证号" /></td><td></td></tr>
    <tr> <td> <s:submit value="提交"/></td><td> <s:reset value="重置" /></td><td></td></tr>


</s:form>

</center>
</body>
</html>
