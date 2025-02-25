<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!--Include header.jsp-->
<%@include file="template/header.jsp" %>
<!--Cú pháp khai báo toàn cục cho trang JSP-->
<%!
    String name = "Phạm Ngọc Thọ";
    int age = 20;
    // Hàm này có cấp độ của class
    public String displayInfo(){
        return "Name: " + name + "; Age: " + age;
    }
%>

<h1>Hello World!</h1>
<!--Sử dụng cú pháp scriptlet để hiển thị: name + age-->
<div>
    <%
        // Thay thế cho System.out.print()
        out.print("Name: " + name + " - Age: " + age);
    %>
</div>
<!--Sử dụng cú pháp expression để hiển thị: name, age-->
<div><%= displayInfo() %></div>

<!--Include footer.jsp-->
<%@include file="template/footer.jsp" %>

