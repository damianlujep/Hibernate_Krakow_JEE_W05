<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Publisher</title>
</head>
<body>
<form:form method="post" modelAttribute="publisher">
    <div>
        <label for="name">Name</label>
        <form:input path="name"/>
        <form:errors path="name" cssStyle="color: red"/>
    </div>
    <div>
        <label for="nip">NIP</label>
        <form:input path="nip"/>
        <form:errors path="nip" cssStyle="color: red" />

    </div>
    <div>
        <label for="regon">REGON</label>
        <form:input path="regon"/>
        <form:errors path="regon" cssStyle="color: red"/>

    </div>

    <div>
<%--        <form:errors path="*"/>--%>

    </div>



    <input type="submit">

</form:form>
</body>
</html>
