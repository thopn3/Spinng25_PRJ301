<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculate</h1>
        <form>
            Number1 <input type="text" name="n1" value="${param.n1}"/><br/>
            Number2 <input type="text" name="n2" value="${param.n2}"/><br/>
            <input type="submit" value="Sum"/>
        </form>
        Sum = ${param.n1+param.n2}
        
        <div>
            Welcome: ${name}
        </div>
        <div>
            <!--Sử dụng hàm toString() để hiển thị-->
            ${user}
        </div>
        <div>
            <!--Sử dụng các hàm getters của User (bắt buộc phải có các hàm getters-->
            Hello: ${user.userId} - ${user.name} - ${user.age}
        </div>
        
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Age</th>
            </tr>
            <c:forEach var="u" items="${listUser}">
                <tr>
                    <td>${u.userId}</td>
                    <td>${u.name}</td>
                    <td>${u.age}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
