
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ProductModel;

@WebServlet(name="DetailController", urlPatterns={"/details"})
public class DetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy id từ Query String
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            ProductModel p = new ProductModel();
            req.setAttribute("product", p.getProduct(id));
            req.getRequestDispatcher("details.jsp").forward(req, resp);
        } catch (Exception e) {
            // Trường hợp không đúng id được điều hướng từ /products -> Điều hướng về /products
            resp.sendRedirect("products");
        }
    }
   
}
