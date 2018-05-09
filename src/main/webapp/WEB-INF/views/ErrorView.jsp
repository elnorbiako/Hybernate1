<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 09.05.18
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="error" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Error List: </h3>
<%--<p>${errorString}</p>--%>

<c:forEach items="${valid}" var="validation">
    <p>${validation.propertyPath} : ${validation.message}</p>
</c:forEach>

</body>
</html>
