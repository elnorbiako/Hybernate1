<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 08.05.18
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form:form  method="post" modelAttribute="author">
         <form:input path="firstName" placeholder="First Name"/>
         <form:input path="lastName" placeholder="Last Name"/>

        <input type="submit" value="Save"/>
    </form:form>


</body>
</html>
