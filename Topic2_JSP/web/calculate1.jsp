<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculation Product Price</h1>
        <form method="post" action="calc">
            <label>Enter Product price ($)</label>
            <input type="text" name="price"/>
            <input type="submit" value="Calculate"/>
        </form>
        <%
            if(request.getAttribute("error")!=null){
                String message = (String)request.getAttribute("error");
                out.println("<div style='color:red'>Error: "+ message +"</div>");
            }else{
                out.print("<div>Total price: $" + (String)request.getAttribute("result") + "</div>");
            }
        %>
    </body>
</html>
