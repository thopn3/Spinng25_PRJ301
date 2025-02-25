<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Product p = (Product) request.getAttribute("product");
            String images[] = p.getImages().split(";");
        %>
        <h1>ID: <%=p.getId()%> - Name: <%=p.getName()%></h1>
        <div>
            <%
                for(String image : images){
                %>
                <img src="images/<%=image%>" width="80px"/>
                <%
                }
            %>
        </div>
        <div>Price: <%=p.getPrice()%></div>
    </body>
</html>
