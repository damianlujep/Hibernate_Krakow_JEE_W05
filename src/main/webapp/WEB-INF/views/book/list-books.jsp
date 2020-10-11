<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List Books</title>
</head>
<body>
<h2> Books: </h2>
    <table border="1">
        <tr>
            <th>Lp.</th>
            <th>Title</th>
            <th>Description</th>
            <th>Rating</th>
            <th>Publisher</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${books}" var="book" varStatus="stat">
         <tr>
             <td>${stat.count}</td>
             <td>${book.title}</td>
             <td>${book.description}</td>
             <td>${book.rating}</td>
             <td>${book.publisher.name}</td>
             <td><a href="/book/editbook/${book.id}">Edit</a> </td>
             <td><a href="/book/deleteBook/${book.id}">Delete</a> </td>
         </tr>
        </c:forEach>
    </table>
</body>
</html>
