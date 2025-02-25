package controllers;

import entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.ProductModel;

/**
 *
 * @author admin
 */
@WebServlet(name="ProductController", urlPatterns={"/products"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Tạo 1 thể hiện của ProductModel
        ProductModel products = new ProductModel();
        List<Product> result = products.getProducts();
        req.setAttribute("result", result);
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }
}
