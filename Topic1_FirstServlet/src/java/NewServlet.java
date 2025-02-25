/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns={"/new"})
public class NewServlet extends HttpServlet {
    
    /***
     * Xử lý các yêu cầu được gửi từ client (Web browser, Desktop app, Mobile app)
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DecimalFormat f = new DecimalFormat("##.##");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        /*
        // Thiết lập kiểu nội dung sẽ hiển thị cho client
        //out.println("<html><head><title>First Servlet</title></head><body>");
        
        // Tạo ra các biến
        String name = "Phạm Ngọc Thọ";
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String date = f.format(d);
        
        out.println("<h1 style='color:red'>Hello: " + name + "</h1>");
        out.println("Date Now: " + date);
        
        out.println("</body></html>");
        */
        
        // Cách thức điều hướng từ Servlet tới các trang (trong; ngoài site)
        // response.sendRedirect("https://google.com");
        // response.sendRedirect("index.html");
        
        // Điều hướng tới index.html nhưng URL pattern vẫn tại servlet
        // request.getRequestDispatcher("index.html").forward(request, response);
        
        // Lấy dữ liệu được cung cấp bởi người dùng từ URL (thông qua parameters)
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        
        out.println("<h2 style='color:blue'>Welcome: " + name + "</h2>");
        try {
            int n = Integer.parseInt(number);
            if(n%2==0)
                out.println("n is a even number");
            else
                out.println("n is a odd number");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
