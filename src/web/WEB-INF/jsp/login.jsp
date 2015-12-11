<%--
  Created by IntelliJ IDEA.
  User: jiangyayi
  Date: 15/12/9
  Time: 下午3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>homework登陆</title>
</head>
<body>
    <c:if test="${!empty error}">
        <font color="red"><c:out value="${error}"/></font>
    </c:if>
    <from action="<c:url value="/loginCheck.html"/>"  method="post">
        用户名:
        <input type="text" name="userName">
        <br>
        密码:
        <input type="password" name="password">
        <br>
        <input type="submit" value="登录"/>
        <input type="reset" value="重置"/>
    </from>

</body>
</html>