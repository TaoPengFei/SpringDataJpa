<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入jstl库 -->
<c:set var="Root" value="${pageContext.request.contextPath}"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>成功</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body>
<h1>Success</h1>
<%
    //这里是从网址直接访问登录成功的页面，会先判定是否是登录进来的
    String username = (String)session.getAttribute("username");
    if(username == null) {
        //重定向到登录页面
        request.setAttribute("msg", "您还没有登录，请先登录");
        request.getRequestDispatcher("${Root}/login.jsp").forward(request, response);
        /*//给用户一个登录链接
        out.print("<a href=\"/day_11-3/session2/login.jsp\">");
        out.print("请您先登录");
        out.print("</a>");*/
        return;
    }
%>
<%=username %>您好，欢迎登陆
<%--<h2>欢迎您,${sessionScope.username }</h2>--%>
</body>
</html>