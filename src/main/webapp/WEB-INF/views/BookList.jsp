<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 08.05.18
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
 TEST
<ul>
    <c:forEach items="${books}" var="book">

        <li>
            <h3>${book.title}</h3>
            <p>${book.description}</p>
            <a href="book/delete/${book.id}"> Delete</a>
            <a href="book/edit/${book.id}"> Edit</a>
            <ul>
                <c:forEach items="${book.authors}" var="author">
                    <li>
                        <p>${author.firstName} ${author.lastName}</p>
                    </li>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
</ul>

</body>
</html>
