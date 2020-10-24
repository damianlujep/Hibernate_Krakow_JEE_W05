<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <div>
        <label for="firstName">First Name</label>
        <form:input path="firstName"/>
        <form:errors path="firstName" cssStyle="color: red"/>
    </div>
    <div>
        <label for="lastName">Last Name</label>
        <form:input path="lastName"/>
        <form:errors path="lastName" cssStyle="color: red" />

    </div>
    <div>
        <label for="pesel">Pesel</label>
        <form:input type="number" path="pesel"/>
        <form:errors path="pesel" cssStyle="color: red"/>

    </div>

    <div>
        <label for="email">Email</label>
        <form:input path="email"/>
        <form:errors path="email" cssStyle="color: red"/>
    </div>

    <div>
<%--        <form:errors path="*"/>--%>

    </div>



    <input type="submit">

</form:form>
</body>
</html>
