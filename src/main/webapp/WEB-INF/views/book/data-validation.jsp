<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dluje
  Date: 24.10.2020
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data validation</title>
</head>
<body>

<c:forEach items="${violations}" var="error">
    <b>${error.getPropertyPath()}</b> : ${error.getMessage()}<br/>
</c:forEach>

</body>
</html>
