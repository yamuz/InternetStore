<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="ru"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <%@include file="templates/head.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
<div class="container">
    <h2><fmt:message key="label.sign_in_please"/></h2>

    <form method="post" action="userServlet">
        <div class="form-group">
            <label for="emailid" class="form-label"><fmt:message key="label.email"/>: </label>
            <input type="text" class="form-control" name="email" id="emailid">
        </div>
        <div class="form-group">
            <label for="passwordid" class="form-label"><fmt:message key="label.password"/>: </label>
            <input type="text" class="form-control" name="password" id="passwordid">
        </div>
        <div class="checkbox">
            <label><input type="checkbox"><fmt:message key="label.remember_me"/> </label>
        </div>
        <input type="submit" class="btn btn-primary" value=<fmt:message key="label.log_in"/>>
    </form>

</div>

<script>$(".toast").toast({ autohide: false });</script>
</body>
</html>
