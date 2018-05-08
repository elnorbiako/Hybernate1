<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 08.05.18
  Time: 16:50
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

<ul>
<c:forEach items="${authors}" var="author">

    <li>
        <p>${author.firstName} ${author.lastName}</p>
        <a href="author/delete/${author.id}"> Delete</a>
        <a href="author/edit/${author.id}"> Edit</a>
    </li>
    </c:forEach>

</body>
</html>
