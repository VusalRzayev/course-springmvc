<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="resources" value="/resources"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" href="${resources}/css/style.css">

</head>
<body>
<h3>${message}</h3>
</body>
</html>
