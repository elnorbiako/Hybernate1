<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 08.05.18
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    First name: <form:input path="firstName" placeholder="first name"/>
    <form:errors path="firstName"/>

    Last name: <form:input path="lastName" placeholder="last name"/>
    <form:errors path="lastName"/>

    Birth date: <form:input path="birthDate" type="date"/>
    <form:errors path="birthDate"/>


    <form:hidden path="id" value="${author.id}"/>

    <input type="submit" value="save"/>


</form:form>

</body>



</html>