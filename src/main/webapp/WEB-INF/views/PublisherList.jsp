<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 08.05.18
  Time: 22:54
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
    <c:forEach items="${publishers}" var="publisher">

    <li>
        <p>${publisher.name}</p>
        <a href="publisher/delete/${publisher.id}"> Delete</a>
        <a href="publisher/edit/${publisher.id}"> Edit</a>
    </li>
    </c:forEach>

</body>
</html>
