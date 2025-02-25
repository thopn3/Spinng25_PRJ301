<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat" %>

<%!
    DecimalFormat f = new DecimalFormat("##.##");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculation Product Price</h1>
        <form>
            <label>Enter Product price ($)</label>
            <input type="text" name="price"/>
            <input type="submit" value="Calculate"/>
        </form>
        
        <%
            try{
                if(request.getParameter("price") != null){
                    double price = Double.parseDouble(request.getParameter("price"));
                    double totalPrice = price + 0.1*price;
                    out.print("<div>Total price: $" + f.format(totalPrice) + "</div>");
                }
            } catch(Exception e){
                out.print("<div style='color:red'>Error: " + e.getMessage() + "</div>");
            }
        %>
        
    </body>
</html>
