<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 08.05.18
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form:form  method="post" modelAttribute="publisher">
    <form:input path="name" placeholder="${publisher.name}"/>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
