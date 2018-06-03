<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="Root" value="${pageContext.request.contextPath}"/>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>登陆界面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    statis/js/jquery-3.3.1.min.js
    D:\Tools\Eclipse\eclipse-workspace\SpringDataJpa\src\main\webapp\statis\js\jquery-3.3.1.min.js
    -->
    <script type="text/javascript" src="statis/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="statis/js/ajax.js"></script>


</head>

<body>
<%-- 读取cookies --%>
<%
    String uname = "";
    Cookie[] cs = request.getCookies();//获取请求中所有的cookies
    if (cs != null) {
        for (Cookie c : cs) {   //遍历cookies
            if ("uname".equals(c.getName())) { //查找名为name的cookie
                uname = c.getValue(); //获取他的值
            }
        }
    }
%>
<%
    String message = "";
    String msg = (String) request.getAttribute("msg");//获取错误信息
    if (msg != null) {
        message = msg;
    }
%>

<font color="red"><b><%=message %>
</b></font>
<%--<form action="/day_11-3/LoginServlet" method="post">--%>
    用户： <input type="text" name="username" value="<%=uname %>"/><br/>
    <!-- uname 是上次登录成功的用户名 -->
    密码： <input type="password" name="password"/><br/>
    <input id="login_input" type="submit" value="登陆"/>
    <input id="register_input" type="submit" value="注册"/>
<%--</form>--%>

</body>
<script type="application/javascript">
    $("#register_input").click(function () {
        console.log("register_input");
        var $registerForm = $("<form></form>");
        $registerForm.attr("target","_self");
        $registerForm.attr('method','post')
        $registerForm.attr('action',"${Root}/register");
        $registerForm.attr('style','display:none;')
        $("body").append($registerForm);
        $registerForm.submit();
    });
    $("#login_input").click(function () {
        console.log("$loginForm");
        var $loginForm = $("<form></form>");
        $loginForm.attr("target","_self");
        $loginForm.attr('method','post')
        $loginForm.attr('action',"${Root}/session/login");
        $loginForm.attr('style','display:none;')
        $("body").append($loginForm);
        $loginForm.submit();
    });
</script>
</html>