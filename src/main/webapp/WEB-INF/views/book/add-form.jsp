<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <div>
        <label for="title">Title</label>
        <form:input path="title"/>
        <form:errors path="title" cssStyle="color: red"/>
    </div>
    <div>
        <label for="rating">Rating</label>
        <form:input path="rating" type="number" min="0" max="10"/>
        <form:errors path="rating" cssStyle="color: red" />

    </div>
    <div>
        <label for="description">Description</label>
        <form:textarea path="description"/>
        <form:errors path="description" cssStyle="color: red"/>

    </div>
    <div>
        <label for="publisher">Publisher</label>
        <form:select path="publisher" items="${publishers}" id="publisher" itemLabel="name" itemValue="id"/>
        <form:errors path="publisher" cssStyle="color: red"/>

    </div>
    <div>
        <label for="pages">Pages</label>
        <form:input path="pages" type="number" min="0"/>
        <form:errors path="pages" cssStyle="color: red"/>

    </div>

    <div>
<%--        <form:errors path="*"/>--%>

    </div>



    <input type="submit">

</form:form>
</body>
</html>
