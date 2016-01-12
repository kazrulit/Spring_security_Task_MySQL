<%--
  Created by IntelliJ IDEA.
  User: Khamid_Sarmanov
  Date: 1/8/2016
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/login" method="post">
  <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
  <input type="text" name="ssoId" placeholder="Username">
  <input type="password" name="password">
  <input type="submit">
</form>
</body>
</html>
