<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="Root" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>注册</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="statis/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="statis/js/ajax.js"></script>
</head>
<body>
<h2>用户信息注册</h2>
username： <input id="user_name_input" type="text" name="user_name_input"/><br/>
email： <input id="email_input" type="text" name="email_input"/><br/>
education： <input id="education_input" type="text" name="education_input"/><br/>
password： <input id="password_input" type="password" name="password_input"/><br/>
activation_state： <input id="activation_state_input" type="text" name="activation_state_input"/><br/>
activation_code： <input id="activation_code_input" type="text" name="activation_code_input"/><br/>
join_time： <input id="join_time_input" type="text" name="join_time_input"/><br/>
avatar_url： <input id="avatar_url_input" type="text" name="avatar_url_input"/><br/>
gender： <input id="gender_input" type="text" name="gender_input"/><br/>
simple_desc： <input id="simple_desc_input" type="text" name="simple_desc_input"/><br/>
full_desc： <input id="full_desc_input" type="text" name="full_desc_input"/><br/>
position： <input id="position_input" type="text" name="position_input"/><br/>
industry： <input id="industry_input" type="text" name="industry_input"/><br/>
career： <input id="career_input" type="text" name="career_input"/><br/>
liked_count： <input id="liked_count_input" type="text" name="liked_count_input"/><br/>
collected_count： <input id="collected_count_input" type="text" name="collected_count_input"/><br/>
follow_count： <input id="follow_count_input" type="text" name="follow_count_input"/><br/>
followed_count： <input id="followed_count_input" type="text" name="followed_count_input"/><br/>
scaned_count： <input id="scaned_count_input" type="text" name="scaned_count_input"/><br/>
weibo_user_id： <input id="weibo_user_id_input" type="text" name="weibo_user_id_input"/><br/>
<input id="submit_input" type="submit" value="提交"/>

</body>
<script type="application/javascript">
    $("#submit_input").click(function () {
        var $submitForm = $("<form></form>");
        $submitForm.attr("target","_self");
        $submitForm.attr('method','post')
        $submitForm.attr('action',"${Root}/login");
        $submitForm.attr('style','display:none;')
        $("body").append($submitForm);
        $submitForm.submit();

        ajaxRequest(
            "${Root}/userRegister",
            JSON.stringify({
                userName : $("#user_name_input").val(),
                email : $("#email_input").val(),
                password : $("#password_input").val(),
                activationState : parseInt($("#activation_state_input").val()),
                activationCode : $("#activation_code_input").val(),
                joinTime : parseInt($("#join_time_input").val()),
                avatarUrl : $("#avatar_url_input").val(),
                gender : parseInt($("#gender_input").val()),
                simpleDesc : $("#simple_desc_input").val(),
                position : $("#position_input").val(),
                industry : $("#industry_input").val(),
                career : $("#career_input").val(),
                education : $("#education_input").val(),
                fullDesc : $("#full_desc_input").val(),
                likedCount : parseInt($("#liked_count_input").val()),
                collectedCount : parseInt($("#collected_count_input").val()),
                followCount : parseInt($("#follow_count_input").val()),
                followedCount : parseInt($("#followed_count_input").val()),
                scanedCount : parseInt($("#scaned_count_input").val()),
                weiboUserId : $("#weibo_user_id_input").val()
            }),
            false,
            true,
            function Res(sourceFlag,callbackFlag,result) {
                console.log("userRegister");
            }
        );
    });
</script>
</html>
