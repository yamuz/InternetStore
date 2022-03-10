<%@ page import="model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: almaz  Date: 04.03.2022  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%@include file="views/templates/head.jsp" %>
    <link rel="stylesheet" href="views/css/styles.css">

</head>

<body>
    <%@include file="views/templates/navbar.jsp"%>
    <div class="container">
        <%   ArrayList<Product> products =  (ArrayList<Product>)request.getAttribute("productList");
            for(Product s : products){%>

                 <div class="card flex-item" style="width: 18rem;">
                     <img src="<%=s.getImagePath()%>" class="card-img-top" alt="no image">

                     <div class="card-body">
                         <h5 class="card-title"><%=s.getProductName()%></h5>
                         <p class="card-text"><%=s.getDescription()%></p>
                         <p class="card-text"><%=s.getPrice()%></p>
                         <a href="/addToCart" class="btn btn-primary">Add to cart</a>
                         <a href="/viewProduct" class="btn btn-primary">View product</a>
                     </div>
                 </div>
        <%}%>
    </div>

    <%@include file="views/templates/pagination.jsp" %>

    <script>$(".toast").toast({ autohide: false });</script>
    <script type="text/javascript" src="scripts/tabs.js"></script>
</body>
</html>