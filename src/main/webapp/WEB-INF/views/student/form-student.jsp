<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Student form</title>
</head>
<body>

<form:form method="post" modelAttribute="student">
    <div>Student form:</div>
    <div>
        <label for="firstName">First Name</label>
        <form:input path="firstName"/>
    </div>
    <div>
        <label for="lastName">Last Name</label>
        <form:input path="lastName"/>
    </div>
    <div>
        <label for="gender">Gender</label>
        Male:<form:radiobutton path="gender" value="M" id="gender"/>
        Female:<form:radiobutton path="gender" value="F" id="gender"/>
    </div>
    <div>
        <label for="country">Country</label>
        <form:select path="country" items="${countries}"/>
    </div>
    <div>
        <label for="notes">Notes</label>
        <form:textarea path="notes" rows="3" cols="20"/>
    </div>
    <div>
        <label for="mailingList">Mailing List</label>
        <form:checkbox path="mailingList" id="mailingList"/>
    </div>
    <div>
        <label for="programmingSkills">Programing Skills</label>
        <form:select items="${skills}" path="programmingSkills" multiple="true"/>
    </div>
    <div>
        <label for="hobbies">Hobbies</label>
        <form:checkboxes items="${hobbies}" path="hobbies" multiple="true"/>
    </div>

    <input type="submit">

</form:form>

</body>
</html>