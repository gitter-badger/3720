<%@ page import="com.ztoy.Token.LoginToken" %>
<%--
  Created by IntelliJ IDEA.
  User: zuo
  Date: 2016/3/4
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/sign" method="post">
    <input type="hidden" name="token" value="<%=LoginToken.setToken(session)%>">
    <label>
        用户名:
        <input type="text" name="userName"/>
    </label>
    <label>
        密码:
        <input type="password" name="password" />
    </label>
    <input type="submit" value="注册">
</form>
</body>
</html>
