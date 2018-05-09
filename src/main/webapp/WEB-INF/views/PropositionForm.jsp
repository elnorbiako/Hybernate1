<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 09.05.18
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<form:form  method="post" modelAttribute="book">
    <form:errors path="*" />

    <form:input path="title" placeholder="Title"/>
    <form:errors path="title" />

    <form:textarea path="description" placeholder="Description" />
    <form:errors path="description" />

    <form:hidden path="proposition" value="true"/>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>


</body>
</html>
