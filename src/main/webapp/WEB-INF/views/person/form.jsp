<%--
  Created by IntelliJ IDEA.
  User: dluje
  Date: 11.10.2020
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person form</title>
</head>
<body>
    <form method="post">
        <div>
            <label for="login">Login</label>
            <input type="text" id="login" name="login">
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" id="password" name="password">
        </div>
        <div>
            <label for="email">Email</label>
            <input type="email" id="email" name="email">
        </div>

        <input type="submit">

    </form>

</body>
</html>
