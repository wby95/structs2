# structs2
异步请求&amp;strut2返回的json字符串&amp;jstl的运用


#### json-lib包
```
   import net.sf.json.JSONObject;
   JSONObject result = new JSONObject();
   必须导入依赖包才起作用，否则卡在   JSONObject result = new JSONObject();
   依赖包：commons-beanutils.jar&commons-collections.jar&commons-langs.jar&
   commons-logging.jar&ezmorph.jar
```
#### 日历控件
```
   <s:textfield  label="出发时间" name="gooff" id="gooff" cssClass="calendar" onClick="WdatePicker()" onblur="checkgooff(this.value)" />
   导入<script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
```
#### jstl.jar
```
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
所需的包：jstl的包外还需要导入standard.jar否则不起作用

```
#### jquery ajax
  http://www.w3school.com.cn/jquery/jquery_ajax_get_post.asp
  ```
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
    
    
    public String execute() throws Exception {
            JSONObject result = new JSONObject();
            boolean flag = PersonDao.validatePerson(userName, gooff);
            if (flag) {
                System.out.println("true action");
                result.put("exist", true);
    
            } else {
                System.out.println("false action");
                result.put("exist", false);
            }
            ResponseUtil.write(ServletActionContext.getResponse(), result);
            return null;
        }

```
#### 