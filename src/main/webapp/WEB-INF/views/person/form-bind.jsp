
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Person form with binding</title>
</head>
<body>
<div>Person form with binding</div>
<form:form method="post" modelAttribute="person">
    <div>
        <label for="login">Login</label>
        <form:input path="login" />
    </div>
    <div>
        <label for="password">Password</label>
        <form:password path="password"/>
    </div>
    <div>
        <label for="email">Email</label>
        <form:input path="email" type="email"/>
    </div>

    <input type="submit">

</form:form>
</body>
</html>
