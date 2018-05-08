<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 08.05.18
  Time: 16:14
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
    <form:input path="title" placeholder="${book.title}"/>
    <form:input path="rating" type="number" placeholder="${book.rating}"/>
    <form:textarea path="description" placeholder="${book.description}" />

    <label>Publisher</label>
    <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" />
    <label>Authors</label>
    <form:select path="authors" items="${authors}" itemLabel="lastName" itemValue="id" multiple="true"/>

    <input type="submit" value="Save"/>
</form:form>


</body>
</html>
