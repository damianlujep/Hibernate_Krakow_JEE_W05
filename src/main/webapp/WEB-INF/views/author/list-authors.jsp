<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List Authors</title>
</head>
<body>
<h2> Books: </h2>
    <table border="1">
        <tr>
            <th>Lp.</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>PESEL</th>
            <th>Email</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${authors}" var="author" varStatus="stat">
         <tr>
             <td>${stat.count}</td>
             <td>${author.firstName}</td>
             <td>${author.lastName}</td>
             <td>${author.pesel}</td>
             <td>${author.email}</td>
             <td><a href="/author/edit/${author.id}">Edit</a> </td>
             <td><a href="/author/delete/${author.id}">Delete</a> </td>
         </tr>
        </c:forEach>
    </table>
</body>
</html>
