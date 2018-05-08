<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 08.05.18
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/resources/style.css"%></style>
</head>
<body>
    <h1>Add/modify Person</h1>
    <form:form method="post" modelAttribute="person">

        <form:input path="login" placeholder="Login" />
        <form:password path="password" placeholder="Password"/>
        <form:input path="email" placeholder="Email"/>
        <form:input path="firstName" placeholder="First Name"/>
        <form:input path="lastName" placeholder="Surname"/> <br>
        Male: <form:radiobutton path="gender" value="M"/>
        Female: <form:radiobutton path="gender" value="F"/> <br>
        <form:select path="country" items="${countryItems}" />
        <form:textarea path="notes" rows="3"
                       cols="20"/> <br>
        Mailing list: <form:checkbox path="mailingList"/>
        <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/>
        <h3>Hobbies</h3>
        <form:checkboxes items="${hobbies}" path="hobbies" />

        <input type="submit" value="Save">


    </form:form>
</body>
</html>
