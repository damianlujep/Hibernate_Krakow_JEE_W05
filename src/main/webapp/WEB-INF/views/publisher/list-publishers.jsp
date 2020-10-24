<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List Publishers</title>
</head>
<body>
<h2> Books: </h2>
    <table border="1">
        <tr>
            <th>Lp.</th>
            <th>Name</th>
            <th>NIP</th>
            <th>REGON</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${publishers}" var="publisher" varStatus="stat">
         <tr>
             <td>${stat.count}</td>
             <td>${publisher.name}</td>
             <td>${publisher.nip}</td>
             <td>${publisher.regon}</td>
             <td><a href="/publisher/update/${publisher.id}">Edit</a> </td>
             <td><a href="/publisher/delete/${publisher.id}">Delete</a> </td>
         </tr>
        </c:forEach>
    </table>
</body>
</html>
