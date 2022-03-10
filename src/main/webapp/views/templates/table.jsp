<%@ page import="model.Product" %>
<%@ page import="java.util.ArrayList" %>
<table align="center">
    <tr bgcolor="00FF7F">
        <th><b>Name</b></th>
        <th><b>Price</b></th>
        <th><b>Description</b></th>
        <th>DELETE</th>
    </tr>

    <%   ArrayList<Product> products =  (ArrayList<Product>)request.getAttribute("productList");
        for(Product s : products){%>

    <tr>
        <td><%=s.getProductName()%></td>
        <td><%=s.getPrice()%></td>
        <td><%=s.getDescription()%></td>
        <td>
            <form action="/process" method="post">
                <input type="hidden" value="delete_product" name="act">
                <input type="hidden" value="${u.id}" name="id">
                <button class="btn btn-danger btn-sm">X</button>
            </form>
        </td>
    </tr>
    <%}%>
</table>

<%--
<c:forEach items="${productList}" var="product">--%>
<%--</c:forEach>--%>
