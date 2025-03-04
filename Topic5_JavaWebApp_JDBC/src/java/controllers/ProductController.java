package controllers;

import dal.CategoryDAO;
import dal.ProductDAO;
import dto.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Category;
import models.Product;

@WebServlet(name = "ProductController", urlPatterns = {"/products"})
public class ProductController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ProductDAO productDao = new ProductDAO();
        try {
            String action = req.getParameter("action");
            // Delete action:
            if ("delete".equals(action)) {
                // Lấy id từ query string
                int id = Integer.parseInt(req.getParameter("id"));
                // Kiểm tra sự tồn tại của Product theo id trong DB
                if (productDao.getProduct(id) != null) {
                    if (productDao.deleteProduct(id) == true) {
                        // Gán 1 attribute chứa thông điệp để hiển thị về /products
                        req.setAttribute("delMessage", "Delele successfully!");
                    } else {
                        req.setAttribute("delMessage", "Delele failed!");
                    }
                } else {
                    req.setAttribute("delMessage", "Product not found!");
                }
            }
            
            // Edit action:
            if ("edit".equals(action)) {
                // Lấy id từ query string
                int id = Integer.parseInt(req.getParameter("id"));
                // Kiểm tra sự tồn tại của Product theo id trong DB
                Product existProduct = productDao.getProduct(id);
                if(existProduct!=null){
                    // Chuyển tiếp đối tượng này sang EditProduct.jsp để fill dữ liệu vào Form
                    req.setAttribute("exitProduct", existProduct);
                    // Lấy danh sách các Categories
                    List<Category> categories = new CategoryDAO().getCategories();
                    req.setAttribute("categories", categories);
                    req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
                }
            }
            

            List<ProductDTO> products = productDao.getAllProducts();
            req.setAttribute("products", products);
            req.getRequestDispatcher("products.jsp").forward(req, resp);
        } catch (Exception ex) {
            String error = ex.getMessage();
            req.setAttribute("errorMsg", error);
        }
    }
}
