<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="entities.Product" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Products</h1>
        <%
            // Lấy dữ liệu từ servlet truyền sang
            List<Product> products = (List<Product>) request.getAttribute("result");
            
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th><th>Name</th><th>Price</th><th>Images</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(Product p : products){
                        // Xử lý tách chuỗi images
                        String images[] = p.getImages().split(";"); // images=["p2.jpg", "p21.jpg"]
                %>
                <tr>
                    <td><%=p.getId()%></td>
                    <td>
                        <a href="details?id=<%=p.getId()%>">
                           <%=p.getName()%> 
                        </a>                        
                    </td>
                    <td><%=p.getPrice()%></td>
                    <td>
                        <img src="images/<%=images[0]%>" width="50px" alt="image"/>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
