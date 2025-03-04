<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit product</h1>
        <form action="products" method="post">
            Product name <input type="text" value="${exitProduct.name}" name="pName"/><br/>
            Price <input type="number" value="${exitProduct.price}" name="pPrice"/><br/>
            Quantity <input type="number" value="${exitProduct.quantity}" name="pQuantity"/><br/>
            Category
            <select name="pCategoryId">
                <c:forEach var="c" items="${categories}">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </select><br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
