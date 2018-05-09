<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 08.05.18
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Test title</h2>

    <form:form  method="post" modelAttribute="book">
        <form:errors path="*" />

        <form:input path="title" placeholder="Title"/>
        <form:errors path="title" />

        Rating: <form:input path="rating" type="number" placeholder="Rating"/>
        <form:errors path="rating" />

        <form:textarea path="description" placeholder="Description" />
        <form:errors path="description" />

        <label>Publisher</label>
        <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" />
        <form:errors path="publisher" />

        <label>Authors</label>
        <form:select path="authors" items="${authors}" itemLabel="lastName" itemValue="id" multiple="true"/>
        <form:errors path="authors" />

        Pages: <form:input path="pages" type="number" placeholder="Pages"/>
        <form:errors path="pages" />

        <input type="submit" value="Save"/>
    </form:form>

</body>
</html>
